package org.portfolio.instaorganize.repository;

import org.portfolio.instaorganize.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, UUID> {
}