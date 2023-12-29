-- --------------------------- Admin --------------------------- --

DELIMITER //
CREATE TRIGGER TR_Admin_Exclusive_Id
AFTER INSERT ON sys_admin
FOR EACH ROW
BEGIN
	DECLARE inserted_id INT;
    SET inserted_id = NEW.id;
	DELETE FROM manager WHERE id = inserted_id;
    DELETE FROM staff WHERE id = inserted_id;
    DELETE FROM adopter WHERE id = inserted_id;
END //
DELIMITER ;

-- --------------------------- Manager --------------------------- --

DELIMITER //
CREATE TRIGGER TR_Manager_Exclusive_Id
AFTER INSERT ON manager
FOR EACH ROW
BEGIN
	DECLARE inserted_id INT;
    SET inserted_id = NEW.id;
	DELETE FROM sys_admin WHERE id = inserted_id;
    DELETE FROM staff WHERE id = inserted_id;
    DELETE FROM adopter WHERE id = inserted_id;
END //
DELIMITER ;

-- --------------------------- Staff --------------------------- --

DELIMITER //
CREATE TRIGGER TR_Staff_Exclusive_Id
AFTER INSERT ON staff
FOR EACH ROW
BEGIN
	DECLARE inserted_id INT;
    SET inserted_id = NEW.id;
	DELETE FROM sys_admin WHERE id = inserted_id;
    DELETE FROM manager WHERE id = inserted_id;
    DELETE FROM adopter WHERE id = inserted_id;
END //
DELIMITER ;

-- --------------------------- Adopter --------------------------- --

DELIMITER //
CREATE TRIGGER TR_Adopter_Exclusive_Id
AFTER INSERT ON adopter
FOR EACH ROW
BEGIN
	DECLARE inserted_id INT;
    SET inserted_id = NEW.id;
	DELETE FROM sys_admin WHERE id = inserted_id;
    DELETE FROM manager WHERE id = inserted_id;
    DELETE FROM staff WHERE id = inserted_id;
END //
DELIMITER ;