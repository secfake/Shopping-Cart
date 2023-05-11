package vn.tuananh.shoppingcart.service;

import vn.tuananh.shoppingcart.dto.CartItemDto;

import java.util.List;

public interface CartService {
    List<CartItemDto> getAllCartItems();
    void deleteCartItem(int id);
    void decrementItem(int id);
    void incrementItem(int id);
}
