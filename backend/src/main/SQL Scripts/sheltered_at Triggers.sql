-- Inserting a record into this table deletes records with same pet_id in adopted_by 
-- and sets this pet's adoption status to false.
DELIMITER //
CREATE TRIGGER TR_Remove_Adopted
BEFORE INSERT ON sheltered_at
FOR EACH ROW
BEGIN
	DELETE FROM adopted_by WHERE pet_id = NEW.pet_id;
	UPDATE pet SET adopted = FALSE WHERE id = NEW.pet_id;
END //