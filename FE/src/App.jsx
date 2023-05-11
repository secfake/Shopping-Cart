import CartList from "./components/CartList";

import React from "react";
function App() {
  return (
    <>
      <div class="shopping-cart-container mt-5">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="mb-4">
                <h2>Shopping Cart</h2>
              </div>
            </div>
          </div>

      
            <CartList></CartList>
          
        </div>
      </div>
    </>
  );
}

export default App;
