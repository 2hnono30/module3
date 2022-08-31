delimiter //
CREATE PROCEDURE information(
IN ID int
)
BEGIN
declare flag boolean;
declare Smessage varchar(200);
set Smessage = '';
set flag = true;
if(not exists(select id from products where `id` = ID)) then 
	set Smessage = 'id khong ton tai';
    set flag = false;
	end if;
if(exists(select id from products where id = ID)) then 
	select * from products where products.id = ID;
    end if;
END;//