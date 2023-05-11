package vn.tuananh.shoppingcart.repository;

import vn.tuananh.shoppingcart.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>(List.of(
            User.builder().withId(1).withName("User 1").withEmail("user1@gmail.com").withPhone("0985457125").withAvatar("avatar1").build(),
            User.builder().withId(2).withName("User 2").withEmail("user2@gmail.com").withPhone("0985457123").withAvatar("avatar2").build(),
            User.builder().withId(3).withName("User 2").withEmail("user3@gmail.com").withPhone("0985457124").withAvatar("avatar3").build()
    ));
}
