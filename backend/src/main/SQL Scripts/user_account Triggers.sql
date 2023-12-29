-- When inserting a new record, verification record is added.
DELIMITER //
CREATE TRIGGER TR_Add_Verification
AFTER INSERT ON user_account
FOR EACH ROW
BEGIN
	INSERT INTO verification VALUES (NEW.id, CURRENT_TIMESTAMP, (SELECT LEFT(UUID(), 10)));
END //