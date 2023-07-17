package com.devsuperior.dslist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entitiy.Game;
import com.devsuperior.dslist.projection.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
        @Query(nativeQuery = true, value = """
            SELECT game.id, game.title, game.game_year AS `year`, game.img_url AS imgUrl,
            game.short_description AS shortDescription, belonging.position
            FROM game
            INNER JOIN belonging ON game.id = belonging.game_id
            WHERE belonging.list_id = :listId
            ORDER BY belonging.position
            	""")
    List<GameMinProjection> findByList(Long listId);
}
