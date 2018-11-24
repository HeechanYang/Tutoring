package ec.springframework.tutoring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApplyWithTuteeInfo extends Tutee{
    private static final int STATUS_REFUSED = -1;
    private static final int STATUS_WAITING = 0;
    private static final int STATUS_PERMITTED = 1;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss+0900", timezone="KST")
    private Date applyTime;
    private int status;
}
