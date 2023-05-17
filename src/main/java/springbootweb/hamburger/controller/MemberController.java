package springbootweb.hamburger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootweb.hamburger.dto.MemberFormDto;
import springbootweb.hamburger.entity.Member;
import springbootweb.hamburger.service.MemberService;

import javax.validation.Valid;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    
    
    @GetMapping(value = "/new")
    public String MemberForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }
    
    @PostMapping(value = "/new")
    public String MemberForm(@Valid MemberFormDto memberFormDto, 
                             BindingResult bindingResult, Model model){
        
        // 검증 걸림
        if(bindingResult.hasErrors()){
            return "member/memberForm";
        }

        //중복 가입
        try { 
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        }catch (IllegalStateException e){
            model.addAttribute("errormessage", e.getMessage());
            return "member/memberForm";
        }

        return "redirect:/menu";
    }

    @GetMapping(value = "/login")
    public String loginMember(){
        return "/member/memberLoginForm";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호");
        return "/member/memberLoginForm";
    }
}
