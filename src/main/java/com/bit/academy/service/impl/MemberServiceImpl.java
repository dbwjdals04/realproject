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

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void regist(MemberVO memberVO) {
        this.memberMapper.regist(memberVO);
    }

    @Override
    public void updateMember(MemberVO memberVO) {
        this.memberMapper.updateMember(memberVO);
    }

    @Override
    public void deleteMember(HttpServletRequest request, int m_no) {
        this.memberMapper.deleteMember(m_no);
    }

    @Override
    public MemberVO selectMember(int m_no) {
        return this.memberMapper.selectMember(m_no);
    }

    @Override
    public List<MemberVO> selectMemberList() {
        return this.memberMapper.selectMemberList();
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
    public MemberVO idFind(MemberVO memberVO) {
        MemberVO amemberVO = this.memberMapper.idFind(memberVO);

        return amemberVO;
    }

    //비번찾기

    @Override
    public MemberVO pwFind(MemberVO memberVO) {
        MemberVO amemberVO= this.memberMapper.pwFind(memberVO);
        return amemberVO;
    }

    @Override
    public void logOut(HttpServletRequest request) {
       request.getSession().removeAttribute("member");
    }
}
