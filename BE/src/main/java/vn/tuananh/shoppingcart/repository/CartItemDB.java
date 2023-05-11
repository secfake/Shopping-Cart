package vn.tuananh.shoppingcart.repository;

import vn.tuananh.shoppingcart.entity.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartItemDB {
    public static List<CartItem> cartItems = new ArrayList<>(List.of(
            CartItem.builder().withId(1).withCount(1).withCourseId(1).build(),
            CartItem.builder().withId(2).withCount(1).withCourseId(2).build(),
            CartItem.builder().withId(3).withCount(1).withCourseId(3).build()
    ));
}
