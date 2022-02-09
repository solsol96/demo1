package com.usertest.demo1.model.dao;

import com.usertest.demo1.model.dto.MemberVO;

import java.util.List;
import java.util.Optional;

public interface MemberDAO {
    // 회원 목록
    public List<MemberVO> memberList();
    // 회원 입력
    public void insertMember(MemberVO vo);
    // 회원 정보 상세보기
    public Optional<MemberVO> viewMember(String userId);
    // 회원 삭제
    public void deleteMember(String userId);
    // 회원정보 수정
    public void updateMember(MemberVO vo);
}
