package com.bit.academy.controller;

import com.bit.academy.model.MemberVO;
import com.bit.academy.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원가입 처리

    @GetMapping("/member/regist")
    public String regist() {

        return "member/regist";
    }

    @PostMapping("/member/regist")
    public String registExecute(Model model, @ModelAttribute MemberVO memberVO) {
        log.debug("---------회원가입 요청 처리-------");
        log.debug(memberVO.toString());
        this.memberService.regist(memberVO);

        log.debug("--------게시글 등록 결과---------");
        log.debug(memberVO.toString());

        memberVO = this.memberService.selectMember(memberVO.getM_no());
        model.addAttribute("member", memberVO);

        return "member/login";
    }

    //회원정보조회

    @GetMapping("/member/view/{m_no}")
    public String selectMember(Model model, int m_no) {
        model.addAttribute("member", this.memberService.selectMember(m_no));
        return "board/view";
    }

    //회원정보삭제

    @PostMapping("/member/view/{m_no}")
    public String deleteMember(HttpServletRequest request, @PathVariable int m_no) {
        this.memberService.deleteMember(request, m_no);
        return "member/main";
    }

    //회원정보수정

    @GetMapping("/member/update/{m_no}")
    public String updateMember(Model model, @PathVariable int m_no) {
        model.addAttribute("member", this.memberService.selectMember(m_no));
        return "member/update";
    }

    @PostMapping("/member/update/{m_no}")
    public String updateMemberExecute(Model model, @ModelAttribute MemberVO memberVO) {
        this.memberService.updateMember(memberVO);
        model.addAttribute("member", this.memberService.selectMember(memberVO.getM_no()));
        return "member/update_after";
    }

    //회원리스트

    @GetMapping("/member/list")
    public String memberList(Model model) {
        model.addAttribute("memberList", this.memberService.selectMemberList());

        List<MemberVO> memberList = new ArrayList<>();

        for (MemberVO memberVO : memberList) {

        }
        return "member/list";
    }

    //로그인
}


