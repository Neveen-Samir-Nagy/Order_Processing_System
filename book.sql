-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BookStore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BookStore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BookStore` ;
USE `BookStore` ;

-- -----------------------------------------------------
-- Table `BookStore`.`PUBLISHER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookStore`.`PUBLISHER` (
  `Publisher_Name` VARCHAR(30) NOT NULL,
  `Address` VARCHAR(50) NOT NULL,
  `Phone` CHAR(15) NOT NULL,
  PRIMARY KEY (`Publisher_Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookStore`.`BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookStore`.`BOOK` (
  `ISBN` CHAR(15) NOT NULL,
  `Title` VARCHAR(30) NOT NULL,
  `Category` ENUM('Science', 'Art', 'Religion', 'History', 'Geography') NOT NULL,
  `Publisher_Name` VARCHAR(30) NOT NULL,
  `Publication_Year` YEAR(4) NOT NULL,
  `Selling_Price` INT NOT NULL,
  `Quantity` INT NOT NULL,
  `Threshold` INT NOT NULL,
  PRIMARY KEY (`ISBN`, `Publisher_Name`),
  INDEX `fk_BOOK_PUBLISHER_idx` (`Publisher_Name` ASC) VISIBLE,
  CONSTRAINT `fk_BOOK_PUBLISHER`
    FOREIGN KEY (`Publisher_Name`)
    REFERENCES `BookStore`.`PUBLISHER` (`Publisher_Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookStore`.`AUTHORS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookStore`.`AUTHORS` (
  `ISBN` CHAR(15) NOT NULL,
  `Author_Name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ISBN`, `Author_Name`),
  CONSTRAINT `fk_AUTHORS_BOOK`
    FOREIGN KEY (`ISBN`)
    REFERENCES `BookStore`.`BOOK` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookStore`.`ORDERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookStore`.`ORDERS` (
  `ISBN` CHAR(15) NOT NULL,
  `Quantity` INT NOT NULL,
  PRIMARY KEY (`ISBN`),
  INDEX `fk_ORDER_BOOK1_idx` (`ISBN` ASC) VISIBLE,
  CONSTRAINT `fk_ORDER_BOOK`
    FOREIGN KEY (`ISBN`)
    REFERENCES `BookStore`.`BOOK` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookStore`.`USERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookStore`.`USERS` (
  `UserName` VARCHAR(30) NOT NULL,
  `Password` VARCHAR(50) NOT NULL,
  `FirstName` VARCHAR(15) NOT NULL,
  `LastName` VARCHAR(15) NOT NULL,
  `Email` VARCHAR(30) NOT NULL,
  `Phone` CHAR(15) NULL,
  `Shipping_Address` VARCHAR(50) NOT NULL,
  `tp` ENUM('Customer', 'Manager') NOT NULL,
  PRIMARY KEY (`UserName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookStore`.`SALES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BookStore`.`SALES` (
  `Purchase_id` INT NOT NULL AUTO_INCREMENT,
  `ISBN` CHAR(15) NOT NULL,
  `Customer_name` VARCHAR(30) NOT NULL,
  `Purchase_date` DATE NOT NULL,
  INDEX `fk_SALES_USERS1_idx` (`Customer_name` ASC) VISIBLE,
  INDEX `fk_SALES_BOOK_idx` (`ISBN` ASC) VISIBLE,
  PRIMARY KEY (`Purchase_id`),
  CONSTRAINT `fk_SALES_BOOK`
    FOREIGN KEY (`ISBN`)
    REFERENCES `BookStore`.`BOOK` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SALES_USERS`
    FOREIGN KEY (`Customer_name`)
    REFERENCES `BookStore`.`USERS` (`UserName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `BookStore` ;

-- -----------------------------------------------------
-- procedure AddBook
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `AddBook` (IN ISBN CHAR(15),IN Title VARCHAR(30) ,
							IN Category ENUM('Science', 'Art', 'Religion', 'History', 'Geography'),
                            IN Publisher_Name VARCHAR(30),IN Publication_Year YEAR(4),
                            IN Selling_Price INT, IN Quantity INT, IN Threshold INT)
BEGIN
INSERT INTO BOOK VALUES (ISBN,Title,Category,Publisher_Name,Publication_Year, 
						 Selling_Price,Quantity,Threshold);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure AddPublisher
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `AddPublisher`(IN p_name VARCHAR(30), IN p_address VARCHAR(50), IN p_phone CHAR(15))
BEGIN
if (not exists(SELECT * FROM PUBLISHER WHERE Publisher_Name=p_name))
	then
    INSERT INTO PUBLISHER (Publisher_Name,Address,Phone) values (p_name,p_address,p_phone);
end if;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure comp_trans
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `comp_trans` (IN bookId CHAR(15),IN numberOfBooks INT)
BEGIN
UPDATE BOOK 
SET Quantity = Quantity - numberOfBooks
WHERE ISBN = bookId;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure ModifyBook
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `ModifyBook` ( IN current_ISBN CHAR(15),IN p_ISBN CHAR(15),IN p_Title VARCHAR(30) ,
								IN p_Category ENUM('Science', 'Art', 'Religion', 'History', 'Geography'),
								IN p_Publisher_Name VARCHAR(30),IN p_Publication_Year YEAR(4),
								IN p_Selling_Price INT, IN p_Quantity INT, IN p_Threshold INT)
BEGIN
UPDATE BOOK 
SET  ISBN = p_ISBN,
	 Title = p_Title,
     Category = p_Category,
     Publisher_Name = p_Publisher_Name,
     Publication_Year = p_Publication_Year,
     Selling_Price = p_Selling_Price,
     Quantity = p_Quantity,
     Threshold = p_Threshold
WHERE ISBN = current_ISBN;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure confirm_order
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `confirm_order`(in i char(15))
BEGIN
DELETE FROM orders
WHERE ISBN = i;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_author
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `add_author`(in i char(15), in au_name varchar(30))
BEGIN
insert into authors values (i, au_name);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure add_order
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `add_order`(in i char(15), in q int(11))
BEGIN
if ((SELECT EXISTS(SELECT * FROM orders WHERE ISBN = i))  = 1 )
    then
	update orders 
	set orders.Quantity = orders.Quantity + q
	where orders.isbn = i;
else
	insert into orders values(i,q);
end if;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Search_Book
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `Search_Book`(in ISBN char(15),
                                in Title varchar(30),
                                in Category enum('Science','Art','Religion','History','Geography'),
                                in Publisher_name varchar(30),
                                in Author_Name varchar(30))
BEGIN
select authors.ISBN,Title,authors.Author_Name,Category,Publisher_Name,Publication_Year,Selling_Price,Quantity,Threshold
from book left join authors on book.ISBN = authors.ISBN
		  where (ISBN is null or book.ISBN = ISBN)
			and (Title is null or book.Title = Title)
            and (Category is null or book.Category = Category)
            and (Publisher_name is null or book.Publisher_Name = Publisher_name)
            and (Author_Name is null or authors.Author_Name = Author_Name);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Sign_IN
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `Sign_IN`(in UserName VARCHAR(30),
											 in Password varchar(50),
                                             in tp ENUM('Customer','Manager'))
BEGIN
 select * from Users where (users.UserName = UserName)
						and (users.Password = Password)
                        and (users.tp = tp);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Sign_UP
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `Sign_UP`(in UserName varchar(30),
							in Password varchar(50),
							in firstName varchar(15),
                            in lastName varchar(15),
                            in email varchar(30),
                            in phone char(15),
                            in shipping_address varchar(50),
                            in tp ENUM('Customer','Manager'))
BEGIN
insert into users (UserName, Password, FirstName, LastName, Email, Phone, Shipping_Address, tp) 
values (UserName, Password, firstName, lastName, email, phone, shipping_address, tp);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Update_User
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `Update_User`(in UserName varchar(30),
                                                  in Password varchar(50),
                                                  in FirstName varchar(15),
                                                  in lastName varchar(15),
                                                  in email varchar(30),
                                                  in phone char(15),
												  in shipping_address varchar(50),
												  in tp ENUM('Customer','Manager'),
                                                  in current_name varchar(30))
BEGIN
update users set  users.UserName = UserName,
				  users.Password = Password,
                  users.FirstName = FirstName,
                  users.LastName = lastName,
                  users.Email = email,
                  users.Phone = phone,
                  users.Shipping_Address = shipping_address,
                  users.tp = tp
where users.UserName = current_name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure user_to_manager
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `user_to_manager`(in user_name varchar(30))
BEGIN
	UPDATE users
    SET users.tp = 'Manager'
    WHERE users.userName = user_name;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure insert_sales
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `insert_sales` (in bookId char(15) , in costumerName varchar(30) , in price int , in buy_date date )
BEGIN
insert into SALES (ISBN, Customer_name, Purchase_date) values (bookId, costumerName, buy_date);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure Delete_old_sales
-- -----------------------------------------------------

DELIMITER $$
USE `BookStore`$$
CREATE PROCEDURE `Delete_old_sales` ()
BEGIN
DELETE FROM SALES WHERE Purchase_date < DATE_SUB(NOW(), INTERVAL 3 MONTH);
END$$

DELIMITER ;
USE `BookStore`;

DELIMITER $$
USE `BookStore`$$
CREATE DEFINER = CURRENT_USER TRIGGER `BookStore`.`BOOK_BEFORE_UPDATE` BEFORE UPDATE ON `BOOK` FOR EACH ROW
BEGIN
DECLARE q INT;
SELECT new.Quantity into q;

IF (q < 0) THEN
    signal sqlstate '45000' set message_text = 'Error: the quantity of the book in stock cannot be negative';
END IF;
END$$

USE `BookStore`$$
CREATE DEFINER = CURRENT_USER TRIGGER `BookStore`.`BOOK_AFTER_UPDATE` AFTER UPDATE ON `BOOK` FOR EACH ROW
BEGIN
DECLARE q INT;
DECLARE thr INT;
SELECT new.Quantity into q;
SELECT new.Threshold into thr;
IF (q < thr) THEN
    INSERT INTO ORDERS VALUES (new.ISBN, thr);
END IF;
END$$

USE `BookStore`$$
CREATE DEFINER = CURRENT_USER TRIGGER `BookStore`.`ORDERS_BEFORE_DELETE` BEFORE DELETE ON `ORDERS` FOR EACH ROW
BEGIN
UPDATE BOOK 
SET Quantity = Quantity + old.Quantity 
WHERE ISBN = old.ISBN;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
