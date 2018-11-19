package ec.springframework.tutoring.model.request;

import lombok.Data;

@Data
public class TuteeSignInReq {
    private String email;
    private String passwd;
}
