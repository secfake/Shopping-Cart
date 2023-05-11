package vn.tuananh.shoppingcart.repository;

import vn.tuananh.shoppingcart.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDB {
    public static List<Category> categories = new ArrayList<>(List.of(
            Category.builder().withId(1).withName("mobie").build(),
            Category.builder().withId(2).withName("web").build(),
            Category.builder().withId(3).withName("devops").build()


    ));
}
