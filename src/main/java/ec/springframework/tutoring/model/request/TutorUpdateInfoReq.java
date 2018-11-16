package ec.springframework.tutoring.model.request;

import lombok.Data;

@Data
public class TutorUpdateInfoReq {
    private String name;
    private String subject;
    private String career;
    private int age;
    private String introduction;
}
