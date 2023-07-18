package com.devsuperior.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entitiy.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}
