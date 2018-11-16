package ec.springframework.tutoring.model.request;

import lombok.Data;

@Data
public class TutorSigninReq {
    private String id;
    private String passwd;
}
