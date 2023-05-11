import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const CartList = () => {
  const [cartList, setCartList] = useState([]);
  const [total, setTotal] = useState(0);
  const API_URL = "http://127.0.0.1:8080/api/v1/cartItems";
  // get all product
  useEffect(() => {
    const getAllCartItem = async () => {
      try {
        let response = await axios.get(API_URL);
        if (response.status === 200) {
          setCartList(response.data);
          console.log(response.data);
          changeTotal(response.data);
        } else {
          console.error(response);
        }
      } catch (error) {
        console.log(error);
      }
    };
    getAllCartItem();
 
  }, []);

  ///
  const changeTotal = (cartList) =>{
    let newTotal = 0;
    for(let i = 0; i < cartList.length; i++){
      newTotal += cartList[i].count*cartList[i].course.price;
    }
    console.log(newTotal);
    setTotal(newTotal);
  }


  const decrement = async (id,index) => {
    try {
      let response = await axios.put(`${API_URL}/${id}/decrement`);
      if (response.status === 200) {
        let newCartList = [...cartList];
        newCartList[index].count-=1;
        setCartList(newCartList);
        changeTotal(newCartList);
      } else {
        console.error(response);
      }
    } catch (error) {
      console.log(error);
    }
  };
///

  const increment = async (id,index) => {
    try {
      let response = await axios.put(`${API_URL}/${id}/increment`);
      if (response.status === 200) {
        let newCartList = [...cartList];
        newCartList[index].count+=1;
        setCartList(newCartList);
        changeTotal(newCartList);
      } else {
        console.error(response);
      }
    } catch (error) {
      console.log(error);
    }
  };

///
const deletItem = async (id,index)=> {
  if (window.confirm('Bạn có muốn xóa sản phẩm không?')) {
    try {
      let response = await axios.delete(`${API_URL}/${id}`)
      if (response.status === 200) {
        let newCartList = [...cartList];
        newCartList.splice(index,1);
        setCartList(newCartList);
        changeTotal(newCartList);
      } else {
        console.error(response);
      }
    } catch (error) {
      console.log(error);
    }
  }



}


  return (
    <>
    {cartList.length===0 ? 
             <p class="fst-italic message">Không có sản phẩm trong giỏ hàng</p> : null}
    <div class="row shopping-cart">
    <div class="col-md-8">
      <div class="product-list">
        {cartList.map((item, index) => (
          <div key={item.id} className="product-item d-flex border mb-4">
            <div className="image">
              <img
                src= {`http://localhost:8080/images/${item.course.thumbnail}.jpeg`}
                alt={`Sản phẩm ${index+1}`}
              />
            </div>
            <div className="info d-flex flex-column justify-content-between px-4 py-3 flex-grow-1">
              <div>
                <div className="d-flex justify-content-between align-items-center">
                  <h2 className="text-dark fs-5 fw-normal">
                    {item.course.name}
                  </h2>
                  <h2 className="text-danger fs-5 fw-normal">
                    {item.course.price}
                  </h2>
                </div>
                <div className="text-black-50">
                  <div className="d-inline-block me-3">
                    <button
                      className="border py-2 px-3 d-inline-block fw-bold bg-light"
                      onClick={() => decrement(item.id, index)}
                    >
                      -
                    </button>
                    <span className="py-2 px-3 d-inline-block fw-bold">
                      {item.count}
                    </span>
                    <button
                      className="border py-2 px-3 d-inline-block fw-bold bg-light"
                      onClick={() => increment(item.id,index)}
                    >
                      +
                    </button>
                  </div>
                </div>
              </div>
              <div>
                <button className="text-primary border-0 bg-transparent fw-light" onClick={() => deletItem(item.id, index)}>
                  <span>
                    <i className="fa-solid fa-trash-can"></i>
                  </span>
                  Xóa
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
    <div class="col-md-4">
      <div class="bill">
        <div class="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
          <span class="text-black-50">Tạm tính:</span>
          <span class="text-primary" id="sub-total-money">
            {total} VND
          </span>
        </div>
        <div class="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
          <span class="text-black-50">VAT (10%):</span>
          <span class="text-primary" id="vat-money">
            {total*10/100} VND
          </span>
        </div>
        <div class="border mb-2 p-3 fs-5 fw-normal d-flex justify-content-between align-items-center">
          <span class="text-black-50">Thành tiền:</span>
          <span class="text-primary" id="total-money">
            {total*110/100} VND
          </span>
        </div>
      </div>
    </div>
    </div>
    </>
  );
};

export default CartList;
