package ec.springframework.tutoring.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorSignUpReq {
    private String email;
    private String passwd;
    private String name;
    private String phoneNum;
    private int genderType;
    private int age;
    private int schoolIdx;
    private String career;
    private String intro;
}
