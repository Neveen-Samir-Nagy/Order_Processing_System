CREATE DEFINER=`root`@`localhost` PROCEDURE `add_author`(in i char(15), in au_name varchar(30))
BEGIN
insert into authors values (i, au_name);
END