package vn.tuananh.shoppingcart.repository;

import vn.tuananh.shoppingcart.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    public static List<Course> courses = new ArrayList<>(List.of(
            Course.builder().withId(1).withName("Courser 1").withPrice(1000000).withUserId(1).withCategories(new ArrayList<>(List.of(CategoryDB.categories.get(0), CategoryDB.categories.get(1)))).withThumbnail("image1").build(),
            Course.builder().withId(2).withName("Courser 2").withPrice(2000000).withUserId(2).withCategories(new ArrayList<>(List.of(CategoryDB.categories.get(1), CategoryDB.categories.get(2)))).withThumbnail("image2").build(),
            Course.builder().withId(3).withName("Courser 3").withPrice(3000000).withUserId(3).withCategories(new ArrayList<>(List.of(CategoryDB.categories.get(0), CategoryDB.categories.get(2)))).withThumbnail("image3").build()



    ));
}
