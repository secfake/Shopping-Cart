package vn.tuananh.shoppingcart.mapper;

import vn.tuananh.shoppingcart.dto.CartItemDto;
import vn.tuananh.shoppingcart.entity.CartItem;
import vn.tuananh.shoppingcart.entity.Course;
import vn.tuananh.shoppingcart.repository.ShopRepository;

public class CartItemMapper {
    public static CartItemDto toCartItemDto(CartItem cartItem){
        return new CartItemDto(cartItem.getId(),ShopRepository.getCourseById(cartItem.getCourseId()), cartItem.getCount());
    }
}
