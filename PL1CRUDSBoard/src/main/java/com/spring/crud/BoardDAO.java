package com.spring.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession sqlSession;
	

	public int insertBoard(BoardVO vo) {
		
		int result = sqlSession.update("Board.insertBoard",vo);
		return  result;
	}

	// 글 삭제
	public int deleteBoard(int seq) {
		int result = sqlSession.update("Board.deleteBoard",seq);
		return result;
	}
	public int updateBoard(BoardVO vo) {
		int result = sqlSession.update("Board.updateBoard",vo);
		return result;
	}	
	
	class BoardRowMapper implements RowMapper<BoardVO> {
		@Override
		public BoardVO mapRow (ResultSet rs, int rowNum) throws SQLException{
			BoardVO vo = new BoardVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setWriter(rs.getString("writer"));
			vo.setCategory(rs.getString("category"));
			vo.setRegdate(rs.getDate("regdate"));
			return vo;
		}
	}
	public BoardVO getBoard(int seq) {
		BoardVO result = sqlSession.selectOne("Board.getBoard",seq);
		return result;
	}
	
	public List<BoardVO> getBoardList(){
		List <BoardVO>result = sqlSession.selectList("Board.getBoardList");
		return result;
	}
}
