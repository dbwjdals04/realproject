package com.bit.academy.service.impl;

import com.bit.academy.mapper.MemberMapper;
import com.bit.academy.model.MemberVO;
import com.bit.academy.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {


    //휘연이꺼
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public MemberVO selectMember(int m_no) {
        return this.memberMapper.selectMember(m_no);
    }

    @Override
    public List<MemberVO> selectMemberList() {
        return this.memberMapper.selectMemberList();
    }

    @Override
    public List<MemberVO> searchMemberList(String searchOption, String searchKeyword) {
        return this.memberMapper.searchMemberList(searchOption, searchKeyword);
    }

    @Override
    public MemberVO memberInfo(MemberVO memberVO, String chk_pw) {
        log.debug("#########################");
        log.debug(memberVO.toString());
        int m_no = memberVO.getM_no();
        memberVO = this.memberMapper.selectMember(memberVO.getM_no());
        //MemberVO memberVO1 = this.memberMapper.selectMember(memberVO.getM_no());

        /*memberVO.setM_address("testadd");
        memberVO.setM_id("test1id");
        memberVO.setM_no(2);
        memberVO.setM_phone("010-1234-5678");
        memberVO.setM_name("test1");
        memberVO.setM_password("test1pw");
        memberVO.setM_regdate("2019-08-01 01:31:12");*/
        log.debug(memberVO.toString());


        if(memberVO.getM_password().equals(chk_pw)){
            //request.getSession().setAttribute("member", memberVO);
            log.debug("success");
            return memberVO;
        }else{
            log.debug("fail");
            return null;
        }
    }

    @Override
    public MemberVO memberUpdate(MemberVO memberVO) {

        this.memberMapper.updateMember(memberVO);

        return null;
    }

    @Override
    public void regist(MemberVO memberVO) {
        this.memberMapper.regist(memberVO);
    }

    //로그인
    @Override
    public MemberVO login(MemberVO memberVO, HttpServletRequest request) {


        log.debug("############ 로그인 요청 정보 #############");

        log.debug(memberVO.toString());



        MemberVO DBmemberVO = (MemberVO) this.memberMapper.login(memberVO);


        if (DBmemberVO != null) {
            request.getSession().setAttribute("member", DBmemberVO);
            request.getSession().setMaxInactiveInterval(60 * 30);


        } else if (DBmemberVO == null) {
            request.getSession(false);
//            String id = (String)request.getSession().getAttribute("member");
//            log.debug(id);
            // log out 도 동일하게 처리 가능합니다.
//            request.getSession().removeAttribute("member");
        }

        return DBmemberVO;
    }

    //아이디찾기

    @Override
    public MemberVO idFind(MemberVO memberVO, HttpServletRequest request) {
        MemberVO IdMember = this.memberMapper.idFind(memberVO);
        if (IdMember != null) {
            request.getSession().setAttribute("member", IdMember);
            request.getSession().setMaxInactiveInterval(60 * 30);
        } else if (IdMember == null) {
            request.getSession().setAttribute("member", IdMember);
        }

        return IdMember;
    }

    //비번찾기

    @Override
    public MemberVO pwFind(MemberVO memberVO) {
        return this.memberMapper.pwFind(memberVO);
    }

    @Override
    public void logOut(HttpServletRequest request) {
        request.getSession().removeAttribute("member");
    }
}
