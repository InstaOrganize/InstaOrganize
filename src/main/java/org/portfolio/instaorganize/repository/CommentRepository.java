package org.portfolio.instaorganize.repository;

import org.portfolio.instaorganize.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    @Query("from Comment c inner join Task t on c.task.taskId " +
            "= t.taskId where t.taskId = :taskId")
    List<Comment> findByTaskId(@Param("taskId") UUID taskId);
}
