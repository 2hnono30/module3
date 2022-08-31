delimiter //
CREATE PROCEDURE removeById(
IN ID int,
out Smessage varchar(200)
)
BEGIN
declare flag boolean;
set flag = true;
if(not exists(select id from products where products.id = ID)) then 
	set Smessage = 'id khong ton tai';
    set flag = false;
	end if;
if( exists(select id from products where products.id = ID)) then 
	DELETE FROM `demo`.`products` WHERE (products.id = ID);
    set Smessage = 'xoa thanh cong';
    end if;
END;//