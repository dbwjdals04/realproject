package com.bit.academy.mapper;

import com.bit.academy.model.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {


    /**
     * 회원가입
     * @param memberVO
     */
    void regist(MemberVO memberVO);

    /**
     * 회원정보수정
     * @param memberVO
     */

    void updateMember(MemberVO memberVO);

    /**
     * 회원정보삭제
     * @param m_no
     */
    void deleteMember(int m_no);

    /**
     * 회원정보
     * @param m_no
     * @return
     */
    MemberVO selectMember(int m_no);


    /**
     * 회원목록조회
     * @return
     */
    List<MemberVO> selectMemberList();

    /**
     * 로그인
     * @param memberVO
     */
    int login(MemberVO memberVO);




}

