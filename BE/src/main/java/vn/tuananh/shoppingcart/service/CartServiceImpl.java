package vn.tuananh.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tuananh.shoppingcart.dto.CartItemDto;
import vn.tuananh.shoppingcart.entity.CartItem;
import vn.tuananh.shoppingcart.mapper.CartItemMapper;
import vn.tuananh.shoppingcart.repository.CartItemDB;
import vn.tuananh.shoppingcart.repository.ShopRepository;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List<CartItemDto> getAllCartItems() {
        return CartItemDB.cartItems.stream().map(CartItemMapper::toCartItemDto).toList();
    }

    @Override
    public void deleteCartItem(int id) {
        shopRepository.deleteCartItem(id);
    }

    @Override
    public void decrementItem(int id) {
        shopRepository.decrementItem(id);
    }

    @Override
    public void incrementItem(int id) {
        shopRepository.incrementItem(id);
    }
}
