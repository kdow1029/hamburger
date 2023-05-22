package springbootweb.hamburger.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springbootweb.hamburger.dto.Member;
import springbootweb.hamburger.service.face.MemberService;

import javax.servlet.http.HttpSession;

@Controller

public class MemberController {

    @Autowired private MemberService memberService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @GetMapping(value = "/member/login")
    public void login(){



    }

    @PostMapping(value = "/member/login")
    public String loginProcess(Member member, HttpSession session){

        logger.info("{}",member);
        boolean loginResult = memberService.login(member);
        logger.info("{}",loginResult);
        if (loginResult){
            logger.info("로그인성공");

            session.setAttribute("login",loginResult);

            session.setAttribute("id",member.getId());
            session.setAttribute("name",memberService.getName(member));


            return "redirect:/member/main";
        }else{
            logger.info("로그인 실패");

            return "redirect:/member/login";
        }

    }




    @GetMapping(value = "/member/join")
    public void join(){

    }

    @PostMapping(value = "/member/join")
    public String joinProcess(Member member, HttpSession session) {
        logger.info("{}", member);

        boolean joinResult = memberService.join(member);


        if (joinResult){
            logger.info("회원가입 성공");
            return "redirect:/member/main";
        }else {
            logger.info("회원가입 실패");
            return "redirect:/member/join";
        }

    }


    @RequestMapping(value = "member/main")
    public void main(){}

    @RequestMapping(value = "/member/logout")
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:/member/main";
    }

}
