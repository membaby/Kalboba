-- When entry is deleted, the corrsponding verified bit in the account record is checked,
-- if it is verified, the corresponding user class is created, otherwise, account record is deleted.
DELIMITER //
CREATE TRIGGER TR_Verify_Or_Delete
AFTER DELETE ON verification
FOR EACH ROW
BEGIN
	DECLARE class ENUM('Admin', 'Manager', 'Staff', 'Adopter');
    -- Verification is deleted after the user is successfuly verified
	IF (SELECT verified FROM user_account WHERE id = OLD.account_id) = TRUE THEN
		SET class = (SELECT user_class FROM user_account WHERE id = OLD.account_id);
		IF class = 'Admin' THEN INSERT INTO sys_admin (id) VALUES (OLD.account_id);
        ELSEIF class = 'Manager' THEN INSERT INTO manager (id) VALUES (OLD.account_id);
        ELSEIF class = 'Staff' THEN INSERT INTO staff (id) VALUES (OLD.account_id);
        ELSEIF class = 'Adopter' THEN INSERT INTO adopter (id) VALUES (OLD.account_id);
        END IF;
	-- Verification is deleted due to timeout
	ELSE
		DELETE FROM user_account WHERE id = OLD.account_id;
	END IF;
END //