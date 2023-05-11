package vn.tuananh.shoppingcart.dto;

import vn.tuananh.shoppingcart.entity.Course;

public record CartItemDto(Integer id, java.util.Optional<Course> course, Integer count) {
}
