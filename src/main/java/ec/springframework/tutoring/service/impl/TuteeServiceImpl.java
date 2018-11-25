package ec.springframework.tutoring.service.impl;

import ec.springframework.tutoring.mapper.TuteeMapper;
import ec.springframework.tutoring.model.*;
import ec.springframework.tutoring.model.apply.MatchingApply;
import ec.springframework.tutoring.model.request.TuteeSignInReq;
import ec.springframework.tutoring.model.request.TuteeSignUpReq;
import ec.springframework.tutoring.service.CommonDao;
import ec.springframework.tutoring.service.TuteeService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TuteeServiceImpl extends CommonDao implements TuteeService {

    private final TuteeMapper tuteeMapper;

    public TuteeServiceImpl(TuteeMapper tuteeMapper) {
        this.tuteeMapper = tuteeMapper;
    }

    @Override
    public ApiMessage checkDuplicateEmail(String email) {
        int isDuplicated = tuteeMapper.checkDuplicateEmail(email);
        return new ApiMessage(isDuplicated != 1 ? ApiMessage.SUCCESS : ApiMessage.FAIL);
    }

    @Override
    public ApiMessage signUp(TuteeSignUpReq signUpReq) {
        try {
            tuteeMapper.signUp(signUpReq);
            return new ApiMessage(ApiMessage.SUCCESS);
        } catch (DataAccessException e) {
            return new ApiMessage(ApiMessage.FAIL);
        }
    }

    @Override
    public List<School> getSchoolList() {
        return tuteeMapper.getSchoolList();
    }

    @Override
    public Tutee signIn(TuteeSignInReq signInReq) {
        Tutee tutee = tuteeMapper.signIn(signInReq);
        if (tutee!=null){
            return tutee;
        }else{
            return new Tutee();
        }
    }

    @Override
    public Tutee getInfo(int tuteeIdx) {
        return tuteeMapper.getInfo(tuteeIdx);
    }

    @Override
    public List<Tutor> getTutorList() {
        return tuteeMapper.getTutorList();
    }

    @Override
    public List<Tutor> getMyTutorList(int tuteeIdx) {
        return tuteeMapper.getMyTutorList(tuteeIdx);
    }

    @Override
    public Tutor getTutorInfo(int tutorIdx) {
        return tuteeMapper.getTutorInfo(tutorIdx);
    }

    @Override
    public Tutor getRandomMatchedTutor(int tuteeIdx) {
        return tuteeMapper.getRandomMatchedTutor(tuteeIdx);
    }

    @Override
    public ApiMessage apply(MatchingApply apply) {
        try{
            if(tuteeMapper.isApplying(apply)==0){
                tuteeMapper.apply(apply);
                return new ApiMessage(ApiMessage.SUCCESS);
            }
            return new ApiMessage(ApiMessage.FAIL);
        }catch (DataAccessException e){
            return new ApiMessage(ApiMessage.FAIL);
        }
    }

    @Override
    public List<ApplyWithTutorInfo> getReceivedApplyList(int tuteeIdx) {
        return tuteeMapper.getReceivedApplyList(tuteeIdx);
    }

    @Override
    public List<ApplyWithTutorInfo> getSentApplyList(int tuteeIdx) {
        return tuteeMapper.getSentApplyList(tuteeIdx);
    }

    @Override
    @Transactional
    public ApiMessage permit(int applyIdx) {
        try{
            tuteeMapper.permit(applyIdx);
            tuteeMapper.match(applyIdx);
            return new ApiMessage(ApiMessage.SUCCESS);
        }catch (DataAccessException e){
            return new ApiMessage(ApiMessage.FAIL);
        }
    }

    @Override
    public ApiMessage refuse(int applyIdx) {
        try{
            tuteeMapper.refuse(applyIdx);
            return new ApiMessage(ApiMessage.SUCCESS);
        }catch (DataAccessException e){
            return new ApiMessage(ApiMessage.FAIL);
        }
    }
}
