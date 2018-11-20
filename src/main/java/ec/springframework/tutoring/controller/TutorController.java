package ec.springframework.tutoring.controller;

import ec.springframework.tutoring.model.ApiMessage;
import ec.springframework.tutoring.model.School;
import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.model.Tutor;
import ec.springframework.tutoring.model.apply.MatchingApply;
import ec.springframework.tutoring.model.request.*;
import ec.springframework.tutoring.service.TutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/tutor")
public class TutorController {

    private TutorService tutorService;

    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ApiOperation(position = 1, value = "튜터 회원가입", notes = "", tags = "튜터")
    public ApiMessage signUp(@RequestBody TutorSignUpReq signUpReq) {
        return tutorService.signUp(signUpReq);
    }

    @RequestMapping(value = "/check/duplicate/{email}", method = RequestMethod.GET)
    @ApiOperation(position = 2, value = "튜터 - 이메일 중복 확인", notes = "code: 1(중복 메일 없음), -1(중복 메일 존재)", tags="튜터")
    public ApiMessage checkDuplicateEmail(@PathVariable("email")String email){
        return tutorService.checkDuplicateEmail(email);
    }

    @RequestMapping(value = "/school/list", method = RequestMethod.GET)
    @ApiOperation(position = 3, value = "대학교 리스트", notes = "", tags = "튜터")
    public List<School> getSchoolList() {
        return tutorService.getSchoolList();
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ApiOperation(position = 4, value = "튜터 로그인", notes = "", tags = "튜터")
    public Tutor signIn(@RequestBody TutorSigninReq signinReq) {

        return tutorService.signIn(signinReq);
    }

//    @RequestMapping(value = "/update/info", method = RequestMethod.PUT)
//    @ApiOperation(position = 3, value = "튜터 정보 변경", notes = "", tags="튜터")
//    public ApiMessage updateInfo(TutorUpdateInfoReq updateInfoReq){
//        return new ApiMessage(ApiMessage.SUCCESS);
//    }

    @RequestMapping(value = "/info/{tutorIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 5, value = "튜터 정보 조회", notes = "", tags = "튜터")
    public Tutor getInfo(@PathVariable("tutorIdx") int tutorIdx) {
        return tutorService.getInfo(tutorIdx);
    }

    @RequestMapping(value = "/tutee/list", method = RequestMethod.GET)
    @ApiOperation(position = 6, value = "튜티 리스트 조회", notes = "", tags = "튜터")
    public List<Tutee> getTuteeList() {
        return tutorService.getTuteeList();
    }

    @RequestMapping(value = "/my/tutee/list/{tutorIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 7, value = "내 튜티 리스트 조회", notes = "", tags = "튜터")
    public List<Tutee> getMyTuteeList(@PathVariable("tutorIdx") int tutorIdx) {

        return tutorService.getMyTuteeList(tutorIdx);
    }

    @RequestMapping(value = "/tutee/{tuteeIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 8, value = "튜티 정보 조회", notes = "", tags = "튜터")
    public Tutee getTuteeInfo(@PathVariable("tuteeIdx") int tuteeIdx) {
        return tutorService.getTuteeInfo(tuteeIdx);
    }

    @RequestMapping(value = "/randommatching", method = RequestMethod.GET)
    @ApiOperation(position = 9, value = "랜덤 매칭된 튜티 정보 조회", notes = "", tags = "튜터")
    public Tutee getRandomMatchedTutee() {
        return tutorService.getRandomMatchedTutee();
    }

    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ApiOperation(position = 10, value = "신청하기", notes = "", tags = "튜터")
    public ApiMessage apply(@RequestBody ApplyReq apply) {
        return tutorService.apply(MatchingApply.applyTutorToTutee(apply));
    }

    @RequestMapping(value = "/permit/{applyIdx}", method = RequestMethod.PUT)
    @ApiOperation(position = 11, value = "수락하기", notes = "", tags = "튜터")
    public ApiMessage permit(@PathVariable("applyIdx") int applyIdx) {
        return tutorService.permit(applyIdx);
    }

    @RequestMapping(value = "/refuse/{applyIdx}", method = RequestMethod.PUT)
    @ApiOperation(position = 12, value = "거절하기", notes = "", tags = "튜터")
    public ApiMessage refuse(@PathVariable("applyIdx") int applyIdx) {
        return tutorService.refuse(applyIdx);
    }
}
