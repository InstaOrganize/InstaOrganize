package org.portfolio.instaorganize.repository;

import org.portfolio.instaorganize.entity.Task;
import org.portfolio.instaorganize.entity.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    @Query("from Task t inner join TaskGroup tg on t.taskGroup.taskGroupId " +
            "= tg.taskGroupId where tg.taskGroupId = :taskGroupId")
    List<Task> findByBoardId(@Param("taskGroupId") UUID taskGroupId);
}
