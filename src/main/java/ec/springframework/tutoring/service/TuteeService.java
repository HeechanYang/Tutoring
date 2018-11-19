package ec.springframework.tutoring.service;

import ec.springframework.tutoring.model.ApiMessage;
import ec.springframework.tutoring.model.School;
import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.model.Tutor;
import ec.springframework.tutoring.model.apply.MatchingApply;
import ec.springframework.tutoring.model.request.TuteeSignUpReq;
import ec.springframework.tutoring.model.request.TuteeSignInReq;

import java.util.List;

public interface TuteeService {
    public ApiMessage checkDuplicateEmail(String email);

    public ApiMessage signUp(TuteeSignUpReq signUpReq);

    public List<School> getSchoolList();

    public Tutee signIn(TuteeSignInReq signInReq);

    public Tutee getInfo(int tuteeIdx);

    public List<Tutor> getTutorList();

    public List<Tutor> getMyTutorList(int tuteeIdx);

    public Tutor getTutorInfo(int tutorIdx);

    // 랜덤 매칭 된 튜터 정보 가져오기
    public Tutor getRandomMatchedTutor();

    // 신청하기
    public ApiMessage apply(MatchingApply apply);

    //수락하기
    public ApiMessage permit(int applyIdx);

    //거절하기
    public ApiMessage refuse(int applyIdx);
}
