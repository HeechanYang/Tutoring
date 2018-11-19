package ec.springframework.tutoring.controller;

import ec.springframework.tutoring.model.ApiMessage;
import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.model.Tutor;
import ec.springframework.tutoring.model.request.TuteeSignUpReq;
import ec.springframework.tutoring.model.request.TuteeSigninReq;
import ec.springframework.tutoring.model.request.TuteeUpdateInfoReq;
import ec.springframework.tutoring.service.TuteeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(position = 1, value = "회원가입", notes = "", tags="튜티")
    public ApiMessage signUp(TuteeSignUpReq signUpReq){
        return new ApiMessage(ApiMessage.SUCCESS);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ApiOperation(position = 2, value = "로그인", notes = "", tags="튜티")
    public Tutee signIn(TuteeSigninReq signinReq){

        return new Tutee();
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.PUT)
    @ApiOperation(position = 3, value = "튜티 정보 변경", notes = "", tags="튜티")
    public ApiMessage updateInfo(TuteeUpdateInfoReq updateInfoReq){

        return new ApiMessage(ApiMessage.SUCCESS);
    }

    @RequestMapping(value = "/info/{tuteeIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 4, value = "학생 정보 조회", notes = "", tags="튜티")
    public Tutee getInfo(@PathVariable("tuteeIdx")int tuteeIdx){

        return new Tutee();
    }

    @RequestMapping(value = "/tutor/list", method = RequestMethod.GET)
    @ApiOperation(position = 5, value = "튜터 리스트 조회", notes = "", tags="튜티")
    public List<Tutor> getTutorList(){

        return tuteeService.getTutorList();
    }

    @RequestMapping(value = "/my/tutor/list/{tuteeIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 6, value = "내 튜터 리스트 조회", notes = "", tags="튜티")
    public List<Tutor> getMyTutorList(@PathVariable("tuteeIdx")int tuteeIdx){

        return tuteeService.getMyTutorList(tuteeIdx);
    }

    @RequestMapping(value = "/tutor/{tutorIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 7, value = "튜터 정보 조회", notes = "", tags="튜티")
    public Tutor getTutorInfo(@PathVariable("tutorIdx")int tutorIdx){

        return new Tutor();
    }
}
