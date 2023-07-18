package com.devsuperior.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslist.entitiy.GameList;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(GameList gameList) {
        BeanUtils.copyProperties(gameList, this);
    }
}
