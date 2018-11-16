package ec.springframework.tutoring.model.request;

import lombok.Data;

@Data
public class TuteeUpdateInfoReq {
    private String name;
    private String school;
    private int age;
    private String introduction;
}
