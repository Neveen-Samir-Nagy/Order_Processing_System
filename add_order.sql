CREATE DEFINER=`root`@`localhost` PROCEDURE `add_order`(in i char(15), in q int(11))
BEGIN
insert into orders values(i,q);
END