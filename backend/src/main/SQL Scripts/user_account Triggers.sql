-- When inserting a new record, verification record is added.
DELIMITER //
CREATE TRIGGER TR_Add_Verification
AFTER INSERT ON user_account
FOR EACH ROW
BEGIN
	INSERT INTO verification (account_id, otp) VALUES (NEW.id, (SELECT LEFT(UUID(), 10)));
END //