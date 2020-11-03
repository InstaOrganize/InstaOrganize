package org.portfolio.instaorganize.repository;

import org.portfolio.instaorganize.entity.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, UUID> {

    @Query("from TaskGroup t inner join Board b on t.board.boardId = b.boardId where b.boardId = :boardId")
    List<TaskGroup> findByBoardId(@Param("boardId") UUID boardId);
}
