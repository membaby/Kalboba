-- Whenever inserting a record here, find the record in sheltered_at table which has matching
-- pet_id and null end_date and set end_date to current date.
-- Also, set the pet adoption status to true, and if it is already true, reject operation.
DELIMITER //
CREATE TRIGGER TR_On_Adoption
BEFORE INSERT ON adopted_by
FOR EACH ROW
BEGIN
	-- Check adoption status
    IF (SELECT adopted FROM pet WHERE id = NEW.pet_id) = TRUE THEN
		SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = "Pet is already adopted.";
	ELSE
		UPDATE pet SET adopted = 1 WHERE id = NEW.pet_id;
    END IF;
    -- End the sheltering period at the current shelter
    UPDATE sheltered_at SET end_date = CURRENT_DATE WHERE pet_id = NEW.pet_id AND end_date IS NULL;
    IF ROW_COUNT() != 1 THEN
		SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = "Pet was not at a shelter.";
    END IF;
END //

DROP TRIGGER TR_On_Adoption