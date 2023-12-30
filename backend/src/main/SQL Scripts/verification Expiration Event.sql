-- Needs enabling the event scheduler in mySQL
DELIMITER //
CREATE EVENT E_Account_Expiration
ON SCHEDULE EVERY 3 HOUR
DO
BEGIN
	DELETE FROM verification WHERE time_stamp < CURRENT_TIMESTAMP;
END //