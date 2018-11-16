package ec.springframework.tutoring.model;

import lombok.Data;

@Data
public class ApiMessage {
    public static final int SUCCESS = 1;
    public static final int FAIL = -1;


    private int code;
    private String message;

    public ApiMessage(int code) {
        this.code = code;
        switch (code) {
            case SUCCESS:
                message = "SUCCESS";
                break;
            case FAIL:
                message = "FAIL";
                break;
        }
    }
}
