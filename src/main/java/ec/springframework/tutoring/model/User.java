package ec.springframework.tutoring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    public static final int GENDER_TYPE_NO_SELECT = 0;
    public static final int GENDER_TYPE_MAN = 1;
    public static final int GENDER_TYPE_WOMAN = 2;

    private int idx;
    private String email;
    private String name;
    private String phoneNum;
    private String intro;
    private String school;
    private int schoolIdx;
    private int age;
    private String profileImgAddr;

    @JsonIgnore
    private String passwd;
}
