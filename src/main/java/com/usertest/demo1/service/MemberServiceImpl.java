package com.usertest.demo1.service;

import com.usertest.demo1.model.dao.MemberDAO;
import com.usertest.demo1.model.dto.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{


    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public List<MemberVO> memberList() {
        return memberDAO.memberList();
    }

    @Override
    public void insertMember(MemberVO vo) {
        memberDAO.insertMember(vo);
    }

    @Override
    public MemberVO viewMember(String id) {
        return memberDAO.viewMember(id).get();
    }

    @Override
    public void deleteMember(String userId) {

    }

    @Override
    public void updateMember(MemberVO vo) {
        memberDAO.updateMember(vo);
    }
}
