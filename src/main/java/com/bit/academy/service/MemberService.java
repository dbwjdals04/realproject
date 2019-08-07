package com.bit.academy.service;

import com.bit.academy.model.MemberVO;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Member;
import java.util.List;

public interface MemberService {

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
    void deleteMember(HttpServletRequest request, int m_no);


    /**
     * 회원조회
     * @param m_no
     * @return
     **/
    MemberVO selectMember(int m_no);


    /**
     * 회원목록조회
     * @return
     */
    List<MemberVO> selectMemberList();


    /**
     * 로그인
     * @return
     */


    MemberVO login(MemberVO memberVO, HttpServletRequest request);

    /**
     * idFInd
     * @return
     */


    MemberVO idFind(MemberVO memberVO);

    /**
     * pwFind
     * @return
     */


    MemberVO pwFind(MemberVO memberVO);

    /**
     * pwFind
     * @return
     */


    void logOut(HttpServletRequest request);

}
