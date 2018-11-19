package ec.springframework.tutoring.model.apply;

import ec.springframework.tutoring.model.request.ApplyReq;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchingApply {
    public static final int MATCHING_TUTEE2TUTOR = 1;
    public static final int MATCHING_TUTOR2TUTEE = 2; 

    private int tuteeIdx; 
    private int tutorIdx; 
    private int type;

    public static MatchingApply applyTuteeToTutor(ApplyReq applyReq){
        return new MatchingApply(applyReq.getTuteeIdx(),applyReq.getTutorIdx(),MatchingApply.MATCHING_TUTEE2TUTOR);
    }
    public static MatchingApply applyTutorToTutee(ApplyReq applyReq){
        return new MatchingApply(applyReq.getTuteeIdx(),applyReq.getTutorIdx(),MatchingApply.MATCHING_TUTOR2TUTEE);
    }
}
