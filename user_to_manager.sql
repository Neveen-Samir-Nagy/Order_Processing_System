CREATE DEFINER=`root`@`localhost` PROCEDURE `user_to_manager`(in user_name varchar(30))
BEGIN
	UPDATE users
    SET users.type = true
    WHERE users.userName = user_name;
END