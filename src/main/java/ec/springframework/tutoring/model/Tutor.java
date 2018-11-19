package ec.springframework.tutoring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("tutor")
public class Tutor {
    private int idx;
    private String name;
    private String subject;
    private String career;
    private int age;
    private String profileImgAddr;
    private String intro;
}
