SET GLOBAL event_scheduler = ON;
delimiter |
CREATE EVENT old_sales
    ON SCHEDULE EVERY 1 MONTH
    COMMENT 'Delete rows older than 3 months in SALES table'
    DO
      BEGIN
       CALL Delete_old_sales();
      END |
delimiter ;