CREATE TRIGGER RemovingCustomer
ON customers INSTEAD OF DELETE
AS
BEGIN
	DELETE FROM CustomerDemands WHERE id IN (
		SELECT c_cd.demands_id FROM customers_CustomerDemands c_cd WHERE c_cd.customers_id IN (
			select id from deleted
		)
	);

	DELETE FROM customers WHERE id IN (select id from deleted);
END