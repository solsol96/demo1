package com.usertest.demo1.model.dao;

import com.usertest.demo1.model.dto.BoardVO;
import org.hibernate.type.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{
    private final EntityManager em;
    private static int sequence = 0;

    @Autowired
    public BoardDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(BoardVO vo) {
        vo.setBno(++sequence);
        Date date = new Date();
        vo.setRegDate(date);
        em.persist(vo);
    }

    @Override
    public BoardVO read(int bno) {
        return null;
    }

    @Override
    public void update(BoardVO vo) {

    }

    @Override
    public void delete(int bno) {

    }

    @Override
    public List<BoardVO> listAll() {
        return em.createQuery("select b from BoardVO b")
                .getResultList();
    }

    @Override
    public void increaseViewCnt(int bno) {

    }
}
