package vn.tuananh.shoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
public class CartItem {
    private Integer id;
    private Integer courseId;
    private Integer count;
}
