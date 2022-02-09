package com.usertest.demo1.model.dao;

import com.usertest.demo1.model.dto.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberDAOImpl implements MemberDAO {

    private final EntityManager em;

    @Autowired
    public MemberDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<MemberVO> memberList() {
        return em.createQuery("select m from MemberVO m", MemberVO.class)
                .getResultList();
    }

    @Override
    public void insertMember(MemberVO vo) {
        em.persist(vo);
    }

    @Override
    public Optional<MemberVO> viewMember(String userId) {
        return Optional.ofNullable(em.find(MemberVO.class , userId));
    }

    @Override
    public void deleteMember(String userId) {
        em.remove(viewMember(userId));
    }

    @Override
    public void updateMember(MemberVO vo) {
        MemberVO result = viewMember(vo.getUserId()).get();
        result.setUserName(vo.getUserName());
        result.setUserPw(vo.getUserPw());
        result.setUserEmail(vo.getUserEmail());
        result.setUserUpdatedate(vo.getUserUpdatedate());
    }
}
