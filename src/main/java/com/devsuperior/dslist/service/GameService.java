package com.devsuperior.dslist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entitiy.Game;
import com.devsuperior.dslist.exception.GameNotFoundException;
import com.devsuperior.dslist.repository.GameRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream()
            .map(game -> new GameMinDTO(game))
            .toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) throws GameNotFoundException {
        Optional<Game> game = gameRepository.findById(id);

        if (!game.isPresent()) {
            throw new GameNotFoundException("Game with id = " + id + " not found.");
        }

        return new GameDTO(game.get());
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        return gameRepository.findByList(listId).stream()
            .map(gameMinProjection -> new GameMinDTO(gameMinProjection))
            .toList();
    }
}
