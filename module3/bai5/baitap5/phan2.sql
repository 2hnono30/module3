delimiter //
CREATE PROCEDURE addProduct(
IN ID int,
in productName varchar(200),
in productPrice float,
in productAmount int,
in productDescription varchar(200),
in productStatus boolean,
out Smessage varchar(200)
)
BEGIN
declare flag boolean;
set flag = true;
if(exists(select id from products where products.id = ID)) then 
	set Smessage = 'id da ton tai';
    set flag = false;
	end if;
if(not exists(select id from products where products.id = ID)) then 
	INSERT INTO `demo`.`products` (`productCode`,`productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`)
    VALUES ((select concat('c',ID)),productName , productPrice, productAmount,productDescription, productStatus);
    set Smessage = 'them thanh cong';
    end if;
END;//