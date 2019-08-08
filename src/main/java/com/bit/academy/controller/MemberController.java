package com.bit.academy.controller;

import com.bit.academy.model.MemberVO;
import com.bit.academy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/admin/member/{searchOption}/{searchKeyword}")
    public String searchMember(Model model, @PathVariable String searchOption, @PathVariable String searchKeyword){
        model.addAttribute("memberList", this.memberService.searchMemberList(searchOption, searchKeyword));
        List<MemberVO> memberList = new ArrayList<>();

        for(MemberVO memberVO:memberList){

        }
        return "admin/memberList";
    }

    @ResponseBody
    @GetMapping("/admin/member/{m_no}")
    public MemberVO memberJSON(Model model, @PathVariable int m_no){
        return this.memberService.selectMember(m_no);
    }


    @GetMapping("/admin/memberList")
    public String memberList(Model model){
        model.addAttribute("memberList", this.memberService.selectMemberList());
        List<MemberVO> memberList = new ArrayList<>();

        for(MemberVO memberVO:memberList){

        }

        return "admin/memberList";
    }


    @GetMapping("/member/member_chk")
    public String memberChk(){
        return "member/member_check";
    }


    @GetMapping("/member/member_info")
    public String memberInfo(){
        return "member/member_info";
    }

    @PostMapping("/member/member_info")
    public String testSession( @ModelAttribute MemberVO memberVO
            , Model model
            , HttpServletRequest request){

        String chk_pw = request.getParameter("chk_pw");

        model.addAttribute("member", this.memberService.memberInfo(memberVO, chk_pw));

        return "member/member_info";
    }

    @GetMapping("/member/member_update")
    public String memberUpdate(){
        return "member/member_info";
    }

    @PostMapping("/member/member_update")
    public String memberUpdateExecute(@ModelAttribute MemberVO memberVO, Model model, HttpServletRequest request){

        log.debug("===========================================");
        log.debug(memberVO.toString());
        this.memberService.memberUpdate(memberVO);


        model.addAttribute("member", this.memberService.selectMember(memberVO.getM_no()));

        return "member/member_info";
    }

    @GetMapping("/admin")
    public String index(){
        return "admin/adminMain";
    }

}
