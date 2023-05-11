package vn.tuananh.shoppingcart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
}
