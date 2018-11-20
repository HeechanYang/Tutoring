package ec.springframework.tutoring.service.impl;

import ec.springframework.tutoring.mapper.TutorMapper;
import ec.springframework.tutoring.model.ApiMessage;
import ec.springframework.tutoring.model.School;
import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.model.Tutor;
import ec.springframework.tutoring.model.apply.MatchingApply;
import ec.springframework.tutoring.model.request.TutorSignUpReq;
import ec.springframework.tutoring.model.request.TutorSigninReq;
import ec.springframework.tutoring.service.CommonDao;
import ec.springframework.tutoring.service.TutorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class TutorServiceImpl  extends CommonDao implements TutorService{

    private final TutorMapper tutorMapper;

    public TutorServiceImpl(TutorMapper tutorMapper) {
        this.tutorMapper = tutorMapper;
    }

    @Override
    public ApiMessage checkDuplicateEmail(String email) {
        int isDuplicated = tutorMapper.checkDuplicateEmail(email);
        return new ApiMessage(isDuplicated != 1 ? ApiMessage.SUCCESS : ApiMessage.FAIL);
    }

    @Override
    public ApiMessage signUp(TutorSignUpReq signUpReq) {
        try{
            tutorMapper.signUp(signUpReq);
            return new ApiMessage(ApiMessage.SUCCESS);
        }catch (SQLException e){
            return new ApiMessage(ApiMessage.FAIL);
        }
    }

    @Override
    public List<School> getSchoolList() {
        return tutorMapper.getSchoolList();
    }

    @Override
    public Tutor signIn(TutorSigninReq signInReq) {
        return tutorMapper.signIn(signInReq);
    }

    @Override
    public Tutor getInfo(int tutorIdx) {
        return tutorMapper.getInfo(tutorIdx);
    }

    @Override
    public List<Tutee> getTuteeList() {


        return tutorMapper.getTuteeList();
    }

    @Override
    public List<Tutee> getMyTuteeList(int tuteeIdx) {
        return tutorMapper.getMyTuteeList(tuteeIdx);
    }

    @Override
    public Tutee getTuteeInfo(int tuteeIdx) {
        return tutorMapper.getTuteeInfo(tuteeIdx);
    }

    @Override
    public Tutee getRandomMatchedTutee() {
        return tutorMapper.getRandomMatchedTutee();
    }

    @Override
    public ApiMessage apply(MatchingApply apply) {
        try{
            if(tutorMapper.isApplying(apply)==0){
                tutorMapper.apply(apply);
                return new ApiMessage(ApiMessage.SUCCESS);
            }
            return new ApiMessage(ApiMessage.FAIL);
        }catch (SQLException e){
            return new ApiMessage(ApiMessage.FAIL);
        }
    }

    @Override
    @Transactional
    public ApiMessage permit(int applyIdx) {
        try{
            tutorMapper.permit(applyIdx);
            tutorMapper.match(applyIdx);
            return new ApiMessage(ApiMessage.SUCCESS);
        }catch (SQLException e){
            return new ApiMessage(ApiMessage.FAIL);
        }
    }

    @Override
    public ApiMessage refuse(int applyIdx) {
        try{
            tutorMapper.refuse(applyIdx);
            return new ApiMessage(ApiMessage.SUCCESS);
        }catch (SQLException e){
            return new ApiMessage(ApiMessage.FAIL);
        }
    }
}
