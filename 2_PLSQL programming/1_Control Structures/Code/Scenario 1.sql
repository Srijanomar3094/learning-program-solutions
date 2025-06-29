-- Scenario 1: Apply 1% Discount for Customers Over 60

DECLARE
  CURSOR cur_customers IS
    SELECT customer_id, age, loan_interest_rate
    FROM customers;

  v_id customers.customer_id%TYPE;
  v_age customers.age%TYPE;
  v_rate customers.loan_interest_rate%TYPE;
BEGIN
  OPEN cur_customers;
  LOOP
    FETCH cur_customers INTO v_id, v_age, v_rate;
    EXIT WHEN cur_customers%NOTFOUND;

    IF v_age > 60 THEN
      UPDATE customers
      SET loan_interest_rate = loan_interest_rate - 1
      WHERE customer_id = v_id;
      
      DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Customer ID: ' || v_id);
    END IF;
  END LOOP;
  CLOSE cur_customers;
END;
