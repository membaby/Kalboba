DELIMITER //
CREATE TRIGGER TR_Verify_Or_Delete
BEFORE DELETE ON verification
FOR EACH ROW
BEGIN
	DECLARE class TINYINT;
    -- Verification is deleted after the user is successfuly verified
	IF (SELECT verified FROM user_account WHERE id = OLD.account_id) = TRUE THEN
		SET class = (SELECT user_class FROM user_account WHERE id = OLD.account_id);
		IF class = 0 THEN INSERT INTO sys_admin (id) VALUES (OLD.account_id);
        ELSEIF class = 1 THEN INSERT INTO manager (id) VALUES (OLD.account_id);
        ELSEIF class = 2 THEN INSERT INTO staff (id) VALUES (OLD.account_id);
        ELSEIF class = 3 THEN INSERT INTO adopter (id) VALUES (OLD.account_id);
        END IF;
	-- Verification is deleted due to timeout
	ELSE
		DELETE FROM user_account WHERE id = OLD.account_id;
	END IF;
END //