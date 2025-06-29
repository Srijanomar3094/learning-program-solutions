-- Scenario 2: Employee Bonus Based on Department Performance

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_dept_id IN NUMBER,
  p_bonus_pct IN NUMBER  -- Pass like 10 for 10%
) IS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * p_bonus_pct / 100)
  WHERE department_id = p_dept_id;

  DBMS_OUTPUT.PUT_LINE('Bonus applied to department ' || p_dept_id);
END;
/
