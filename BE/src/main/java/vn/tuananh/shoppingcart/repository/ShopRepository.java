package vn.tuananh.shoppingcart.repository;

import org.springframework.stereotype.Repository;
import vn.tuananh.shoppingcart.entity.CartItem;
import vn.tuananh.shoppingcart.entity.Course;
import vn.tuananh.shoppingcart.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public class ShopRepository {
    public List<CartItem> getAllCartItems() {
        return CartItemDB.cartItems;
    }

    public void deleteCartItem(Integer id) {
        CartItem cartItem = getCartItemById(id).orElseThrow(() -> new NotFoundException("Course " + id + " not found"));
        CartItemDB.cartItems.remove(cartItem);
    }

    public Optional<CartItem> getCartItemById(int id) {
        return CartItemDB.cartItems.stream().filter(cartItem -> cartItem.getId() == id).findFirst();
    }

    public static Optional<Course> getCourseById(int id) {
        return CourseDB.courses.stream().filter(course -> course.getId() == id).findFirst();
    }

    public void incrementItem(int id) {
        CartItem cartItem = getCartItemById(id).orElseThrow(() -> new NotFoundException("Course " + id + " not found"));
            cartItem.setCount(cartItem.getCount() + 1);
    }
    public void decrementItem(int id) {
        CartItem cartItem = getCartItemById(id).orElseThrow(() -> new NotFoundException("Course " + id + " not found"));
        if (cartItem.getCount() > 1) {
            cartItem.setCount(cartItem.getCount() - 1);
        }else {
            throw new NotFoundException("Count not < 1");
        }
    }
}
