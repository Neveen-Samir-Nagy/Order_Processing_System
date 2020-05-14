CREATE DEFINER=`root`@`localhost` PROCEDURE `confirm_order`(in i char(15))
BEGIN
DELETE FROM orders
WHERE ISBN = i;
END