package com.usertest.demo1.service;

import com.usertest.demo1.model.dao.BoardDAO;
import com.usertest.demo1.model.dto.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public void create(BoardVO vo) {
        boardDAO.create(vo);
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
        return boardDAO.listAll();
    }

    @Override
    public void increaseViewCnt(int bno) {

    }
}
