-- On updating status to Accepted (completed) or Rejected, record is moved to closed table.
DELIMITER //
CREATE TRIGGER TR_Close_Adoption_Applications
AFTER UPDATE ON adoption_application_open
FOR EACH ROW
BEGIN
	IF NEW.app_status IN ('Accepted (completed)', 'Rejected') THEN
		INSERT INTO adoption_application_closed SELECT * FROM NEW; -- Not sure about this syntax
        DELETE FROM adoption_application_open WHERE pet_id = NEW.pet_id AND shelter_id = NEW.shelter_id AND adopter_id = NEW.adopter_id;
    END IF;
END //