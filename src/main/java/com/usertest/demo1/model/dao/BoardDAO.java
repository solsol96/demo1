package com.usertest.demo1.model.dao;

import com.usertest.demo1.model.dto.BoardVO;

import java.util.List;

public interface BoardDAO {
    // 게시글 작성
    public void create(BoardVO vo);
    // 게시글 상세보기
    public BoardVO read(int bno);
    // 게시글 수정
    public void update(BoardVO vo);
    // 게시글 삭제
    public void delete(int bno);
    // 게시글 전체 목록
    public List<BoardVO> listAll();
    // 게시글 조회 증가
    public void increaseViewCnt(int bno);
}
