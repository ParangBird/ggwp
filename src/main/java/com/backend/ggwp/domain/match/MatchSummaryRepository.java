package com.backend.ggwp.domain.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MatchSummaryRepository extends JpaRepository<MatchSummary, Long> {
    ArrayList<MatchSummary> findByMatchId(String matchId);

    //소환사 닉네임의 상위 30개 전적찾기
    @Query(nativeQuery = true, value="SELECT * FROM match_summary WHERE name = :name LIMIT 30")
    ArrayList<MatchSummary> find30ByName(@Param("name") String name);

    @Query(nativeQuery = true, value="SELECT * FROM match_summary WHERE name = :name AND queue_id = :queueId LIMIT 30")
    ArrayList<MatchSummary> find30SoloRankByName(@Param("name") String name, 
                                                 //이부분 @Param("queueId") 오류나서 명시적으로 추가함
                                                 @Param("queueId") String queueId);
}
