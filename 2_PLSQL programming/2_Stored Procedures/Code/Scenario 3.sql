-- Scenario 3: Transfer Funds Between Accounts

CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_acc IN NUMBER,
  p_to_acc IN NUMBER,
  p_amount IN NUMBER
) IS
  v_from_balance NUMBER;
BEGIN
  -- Check balance
  SELECT balance INTO v_from_balance
  FROM accounts
  WHERE account_id = p_from_acc
  FOR UPDATE;

  IF v_from_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
  END IF;

  -- Deduct from source
  UPDATE accounts
  SET balance = balance - p_amount
  WHERE account_id = p_from_acc;

  -- Add to target
  UPDATE accounts
  SET balance = balance + p_amount
  WHERE account_id = p_to_acc;

  DBMS_OUTPUT.PUT_LINE('₹' || p_amount || ' transferred from account ' || p_from_acc || ' to ' || p_to_acc);
END;
/
