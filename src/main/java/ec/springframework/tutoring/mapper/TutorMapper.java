package ec.springframework.tutoring.mapper;

import ec.springframework.tutoring.model.School;
import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.model.Tutor;
import ec.springframework.tutoring.model.apply.MatchingApply;
import ec.springframework.tutoring.model.request.TuteeSignUpReq;
import ec.springframework.tutoring.model.request.TutorSignUpReq;
import ec.springframework.tutoring.model.request.TutorSigninReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Mapper
@Component
public interface TutorMapper {
    public int checkDuplicateEmail(String email);

    public void signUp(@Param("signUpReq") TutorSignUpReq signUpReq) throws SQLException;

    public List<School> getSchoolList();

    public Tutor signIn(@Param("signInReq") TutorSigninReq signInReq);

    public Tutor getInfo(int tutorIdx);

    public List<Tutee> getTuteeList();

    public List<Tutee> getMyTuteeList(@Param("tutorIdx") int tutorIdx);

    public Tutee getTuteeInfo(int tuteeIdx);

    public Tutee getRandomMatchedTutee();

    public void apply(@Param("matchingApply") MatchingApply matchingApply) throws SQLException;

    public void permit(@Param("applyIdx") int applyIdx) throws SQLException;
    public void match(@Param("applyIdx") int applyIdx) throws SQLException;

    public void refuse(@Param("applyIdx") int applyIdx) throws SQLException;
}
