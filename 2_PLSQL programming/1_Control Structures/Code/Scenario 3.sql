-- Scenario 3: Send Reminders for Loans Due in Next 30 Days

DECLARE
  CURSOR cur_loans IS
    SELECT l.loan_id, l.customer_id, l.due_date, c.name
    FROM loans l
    JOIN customers c ON l.customer_id = c.customer_id
    WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;

  v_loan_id loans.loan_id%TYPE;
  v_customer_id loans.customer_id%TYPE;
  v_due_date loans.due_date%TYPE;
  v_name customers.name%TYPE;
BEGIN
  OPEN cur_loans;
  LOOP
    FETCH cur_loans INTO v_loan_id, v_customer_id, v_due_date, v_name;
    EXIT WHEN cur_loans%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || v_loan_id ||
                         ' for Customer ' || v_name ||
                         ' is due on ' || TO_CHAR(v_due_date, 'DD-MON-YYYY'));
  END LOOP;
  CLOSE cur_loans;
END;
