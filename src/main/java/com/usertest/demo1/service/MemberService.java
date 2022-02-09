package com.usertest.demo1.service;

import com.usertest.demo1.model.dto.MemberVO;

import java.util.List;

public interface MemberService {
    // 회원 목록
    public List<MemberVO> memberList();
    // 회원 입력
    public void insertMember(MemberVO vo);
    // 회원 정보 상세보기
    public MemberVO viewMember(String id);
    // 회원 삭제
    public void deleteMember(String userId);
    // 회원 정보 수정
    public void updateMember(MemberVO vo);
}
