import React, { useState } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {
  const [count, setCount] = useState(0);

  // 1a. Increment value
  const increment = () => {
    setCount(prev => prev + 1);
  };

  // 1b. Say Hello
  const sayHello = () => {
    console.log("Hello! This is a static message from sayHello().");
    alert("Hello! This is a static message.");
  };

  // Decrement value
  const decrement = () => {
    setCount(prev => prev - 1);
  };

  // Multiple methods on increment button
  const handleIncrementClick = () => {
    increment();
    sayHello();
  };

  // 2. Function with argument
  const sayMessage = (msg) => {
    alert(msg);
  };

  // 3. Synthetic Event example
  const handleSyntheticEvent = (e) => {
    console.log(e); // SyntheticEvent object
    alert("I was clicked!");
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>React Event Examples</h1>

      <h2>Counter: {count}</h2>
      <button onClick={handleIncrementClick}>Increment</button>
      <button onClick={decrement}>Decrement</button>

      <hr />

      <button onClick={() => sayMessage("Welcome")}>Say Welcome</button>

      <hr />

      <button onClick={handleSyntheticEvent}>Synthetic Event Button</button>

      <hr />

      <CurrencyConvertor />
    </div>
  );
}

export default App;
