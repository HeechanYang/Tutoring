package ec.springframework.tutoring.mapper;

import ec.springframework.tutoring.model.School;
import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.model.Tutor;
import ec.springframework.tutoring.model.apply.MatchingApply;
import ec.springframework.tutoring.model.request.TuteeSignInReq;
import ec.springframework.tutoring.model.request.TuteeSignUpReq;
import ec.springframework.tutoring.model.request.TutorSigninReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Mapper
@Component
public interface TuteeMapper {
    public int checkDuplicateEmail(String email);

    public void signUp(@Param("signUpReq") TuteeSignUpReq signUpReq) throws SQLException;

    public List<School> getSchoolList();

    public Tutee signIn(@Param("signInReq") TuteeSignInReq signInReq);

    public Tutee getInfo(int tuteeIdx);

    public List<Tutor> getTutorList();

    public List<Tutor> getMyTutorList(@Param("tuteeIdx") int tuteeIdx);

    public Tutor getTutorInfo(int tutorIdx);

    public Tutor getRandomMatchedTutor();

    public int isApplying(@Param("matchingApply") MatchingApply matchingApply);
    public void apply(@Param("matchingApply") MatchingApply matchingApply) throws SQLException;

    public void permit(@Param("applyIdx") int applyIdx) throws SQLException;
    public void match(@Param("applyIdx") int applyIdx) throws SQLException;

    public void refuse(@Param("applyIdx") int applyIdx) throws SQLException;
}
