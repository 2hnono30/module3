delimiter //
CREATE PROCEDURE editProduct(
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
if(not exists(select id from products where products.id = ID)) then 
	set Smessage = 'id khong ton tai';
    set flag = false;
	end if;
if( exists(select id from products where products.id = ID)) then 
	UPDATE `demo`.`products` SET `productName` = productName, `productPrice` = productPrice, `productAmount` = productAmount, `productDescription` = productDescription,`productStatus` = productStatus  WHERE (products.id = ID);
    set Smessage = 'sua thanh cong';
    end if;
END;//