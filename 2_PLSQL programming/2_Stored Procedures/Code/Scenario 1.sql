-- Scenario 1: Monthly Interest Processing for Savings Accounts

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE accounts
  SET balance = balance + (balance * 0.01)
  WHERE account_type = 'SAVINGS';

  DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
END;
/
