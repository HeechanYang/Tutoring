package ec.springframework.tutoring.model.request;

import lombok.Data;

@Data
public class TuteeSigninReq {
    private String id;
    private String passwd;
}
