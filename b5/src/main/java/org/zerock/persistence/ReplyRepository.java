package org.zerock.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeReply;

public interface ReplyRepository extends CrudRepository<FreeReply, Long>{

	
	@Query("SELECT r FROM FreeReply r WHERE r.board = ?1 ORDER BY r.rno ASC")	//Board 타입이므로 ?1에 들어가는 파라미터 조심
	public List<FreeReply> getListByBoard(FreeBoard board);
	
	
}
