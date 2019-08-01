package com.bit.academy.service.impl;

import com.bit.academy.mapper.MemberMapper;
import com.bit.academy.model.MemberVO;
import com.bit.academy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Override
    public int login(MemberVO memberVO) {
        return 0;
    }
}
