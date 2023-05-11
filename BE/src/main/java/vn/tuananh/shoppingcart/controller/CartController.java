package vn.tuananh.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import vn.tuananh.shoppingcart.service.CartService;

@RestController
@RequestMapping("/api/v1/cartItems")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("")
    public ResponseEntity<?> getAllCartItems(){
        return ResponseEntity.ok(cartService.getAllCartItems());
    }

    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable int id) {
        cartService.deleteCartItem(id);
    }

    @PutMapping("/{id}/increment")
    public void incrementItem(@PathVariable int id){
        cartService.incrementItem(id);


    }
    @PutMapping("/{id}/decrement")
    public void decrementItem(@PathVariable int id){
        cartService.decrementItem(id);
    }
}
