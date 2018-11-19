package ec.springframework.tutoring.service;

import ec.springframework.tutoring.model.ApiMessage;
import ec.springframework.tutoring.model.School;
import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.model.Tutor;
import ec.springframework.tutoring.model.apply.MatchingApply;
import ec.springframework.tutoring.model.request.PermitReq;
import ec.springframework.tutoring.model.request.TutorSignUpReq;
import ec.springframework.tutoring.model.request.TutorSigninReq;

import java.util.List;

public interface TutorService {
    public ApiMessage checkDuplicateEmail(String email);

    public ApiMessage signUp(TutorSignUpReq signUpReq);

    public List<School> getSchoolList();

    public Tutor signIn(TutorSigninReq signInReq);

    public Tutor getInfo(int tutorIdx);

    public List<Tutee> getTuteeList();

    public List<Tutee> getMyTuteeList(int tutorIdx);

    public Tutee getTuteeInfo(int tuteeIdx);

    // 랜덤 매칭 된 튜티 정보 가져오기
    public Tutee getRandomMatchedTutee();

    // 신청하기
    public ApiMessage apply(MatchingApply apply);

    //수락하기
    public ApiMessage permit(int applyIdx);

    //거절하기
    public ApiMessage refuse(int applyIdx);
}
