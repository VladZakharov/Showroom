CREATE PROCEDURE addCust
	@fn varchar(255), @mn varchar(255), @ln varchar(255), @mobile varchar(255)
AS
BEGIN
	INSERT into CustomerInfo (mobile) OUTPUT inserted.id values (@mobile);
	INSERT into customers (firstName, lastName, middleName, info_id) OUTPUT inserted.id
		values (@fn, @mn, @ln, SCOPE_IDENTITY());
END