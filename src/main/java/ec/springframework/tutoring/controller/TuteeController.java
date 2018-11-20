package ec.springframework.tutoring.controller;

import ec.springframework.tutoring.model.*;
import ec.springframework.tutoring.model.apply.MatchingApply;
import ec.springframework.tutoring.model.request.*;
import ec.springframework.tutoring.service.TuteeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/tutee")
public class TuteeController {

    private TuteeService tuteeService;

    @Autowired
    public TuteeController(TuteeService tuteeService) {
        this.tuteeService = tuteeService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ApiOperation(value = "회원가입", notes = "", tags = "튜티")
    public ApiMessage signUp(@RequestBody TuteeSignUpReq signUpReq) {
        return tuteeService.signUp(signUpReq);
    }

    @RequestMapping(value = "/check/duplicate/{email}", method = RequestMethod.GET)
    @ApiOperation(value = "튜티 - 이메일 중복 확인", notes = "code: 1(중복 메일 없음), -1(중복 메일 존재)", tags = "튜티")
    public ApiMessage checkDuplicateEmail(@PathVariable("email") String email) {
        return tuteeService.checkDuplicateEmail(email);
    }

    @RequestMapping(value = "/school/list", method = RequestMethod.GET)
    @ApiOperation(value = "중고등학교 리스트", notes = "", tags = "튜티")
    public List<School> getSchoolList() {
        return tuteeService.getSchoolList();
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ApiOperation(value = "로그인", notes = "", tags = "튜티")
    public Tutee signIn(@RequestBody TuteeSignInReq signInReq) {
        return tuteeService.signIn(signInReq);
    }

//    @RequestMapping(value = "/update/info", method = RequestMethod.PUT)
//    @ApiOperation(position = 3, value = "튜티 정보 변경", notes = "", tags="튜티")
//    public ApiMessage updateInfo(TuteeUpdateInfoReq updateInfoReq){
//
//        return new ApiMessage(ApiMessage.SUCCESS);
//    }

    @RequestMapping(value = "/info/{tuteeIdx}", method = RequestMethod.GET)
    @ApiOperation(value = "학생 정보 조회", notes = "", tags = "튜티")
    public Tutee getInfo(@PathVariable("tuteeIdx") int tuteeIdx) {
        return tuteeService.getInfo(tuteeIdx);
    }

    @RequestMapping(value = "/tutor/list", method = RequestMethod.GET)
    @ApiOperation(value = "튜터 리스트 조회", notes = "", tags = "튜티")
    public List<Tutor> getTutorList() {
        return tuteeService.getTutorList();
    }

    @RequestMapping(value = "/my/tutor/list/{tuteeIdx}", method = RequestMethod.GET)
    @ApiOperation(value = "내 튜터 리스트 조회", notes = "", tags = "튜티")
    public List<Tutor> getMyTutorList(@PathVariable("tuteeIdx") int tuteeIdx) {
        return tuteeService.getMyTutorList(tuteeIdx);
    }

    @RequestMapping(value = "/tutor/{tutorIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 7, value = "튜터 정보 조회", notes = "", tags = "튜티")
    public Tutor getTutorInfo(@PathVariable("tutorIdx") int tutorIdx) {
        return tuteeService.getTutorInfo(tutorIdx);
    }

    @RequestMapping(value = "/randommatching", method = RequestMethod.GET)
    @ApiOperation(position = 7, value = "랜덤 매칭된 튜터 정보 조회", notes = "", tags = "튜티")
    public Tutor getRandomMatchedTutor() {
        return tuteeService.getRandomMatchedTutor();
    }

    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ApiOperation(position = 7, value = "신청하기", notes = "", tags = "튜티")
    public ApiMessage apply(@RequestBody ApplyReq apply) {
        return tuteeService.apply(MatchingApply.applyTuteeToTutor(apply));
    }

    @RequestMapping(value = "/permit/{applyIdx}", method = RequestMethod.PUT)
    @ApiOperation(position = 7, value = "수락하기", notes = "", tags = "튜티")
    public ApiMessage permit(@PathVariable("applyIdx") int applyIdx) {
        return tuteeService.permit(applyIdx);
    }

    @RequestMapping(value = "/refuse/{applyIdx}", method = RequestMethod.PUT)
    @ApiOperation(position = 7, value = "거절하기", notes = "", tags = "튜티")
    public ApiMessage refuse(@PathVariable("applyIdx") int applyIdx) {
        return tuteeService.refuse(applyIdx);
    }
}
