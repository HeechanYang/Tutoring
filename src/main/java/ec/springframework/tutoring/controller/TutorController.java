package ec.springframework.tutoring.controller;

import ec.springframework.tutoring.model.ApiMessage;
import ec.springframework.tutoring.model.Tutee;
import ec.springframework.tutoring.model.Tutor;
import ec.springframework.tutoring.model.request.TutorSignUpReq;
import ec.springframework.tutoring.model.request.TutorSigninReq;
import ec.springframework.tutoring.model.request.TutorUpdateInfoReq;
import ec.springframework.tutoring.service.TutorService;
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
@RequestMapping("/api/tutor")
public class TutorController {

    private TutorService tutorService;

    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ApiOperation(position = 1, value = "튜터 회원가입", notes = "", tags="튜터")
    public ApiMessage signUp(TutorSignUpReq signUpReq){

        return new ApiMessage(ApiMessage.SUCCESS);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ApiOperation(position = 2, value = "튜터 로그인", notes = "", tags="튜터")
    public Tutor signIn(TutorSigninReq signinReq){

        return new Tutor();
    }

    @RequestMapping(value = "/update/info", method = RequestMethod.PUT)
    @ApiOperation(position = 3, value = "튜터 정보 변경", notes = "", tags="튜터")
    public ApiMessage updateInfo(TutorUpdateInfoReq updateInfoReq){

        return new ApiMessage(ApiMessage.SUCCESS);
    }

    @RequestMapping(value = "/info/{tutorIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 4, value = "튜터 정보 조회", notes = "", tags="튜터")
    public Tutor getInfo(@PathVariable("tutorIdx")int tutorIdx){

        return new Tutor();
    }

    @RequestMapping(value = "/tutee/list", method = RequestMethod.GET)
    @ApiOperation(position = 5, value = "튜티 리스트 조회", notes = "", tags="튜터")
    public List<Tutee> getTuteeList(){
        return tutorService.getTuteeList();
    }

    @RequestMapping(value = "/my/tutee/list/{tutorIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 6, value = "내 튜티 리스트 조회", notes = "", tags="튜터")
    public List<Tutee> getMyTuteeList(@PathVariable("tutorIdx")int tutorIdx){

        return tutorService.getMyTuteeList(tutorIdx);
    }

    @RequestMapping(value = "/tutee/{tuteeIdx}", method = RequestMethod.GET)
    @ApiOperation(position = 7, value = "튜티 정보 조회", notes = "", tags="튜터")
    public Tutee getTuteeInfo(@PathVariable("tuteeIdx")int tuteeIdx){

        return new Tutee();
    }
}
