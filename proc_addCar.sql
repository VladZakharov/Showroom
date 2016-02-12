CREATE PROCEDURE addCar
	@brand_id bigint, @color_id bigint, @cond_id bigint,
	@year int, @price int, @acc float, @ev int, @hp int, @ts int, @extras varchar(255)
AS
BEGIN
	INSERT into cars (extras, grad_year, price, brand_id, condition_id) OUTPUT inserted.id
		values (@extras, @year, @price, @brand_id, @cond_id);
	INSERT into CarSpecifications (acceleration, engineVolume, horsePowers, topSpeed, car_id, color_id)
		values (@acc, @ev, @hp, @ts, SCOPE_IDENTITY(), @color_id);
END