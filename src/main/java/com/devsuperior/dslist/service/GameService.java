package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
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
    public GameDTO findById(Long id) {
        return new GameDTO(gameRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        return gameRepository.findByList(listId).stream()
            .map(gameMinProjection -> new GameMinDTO(gameMinProjection))
            .toList();
    }
}
