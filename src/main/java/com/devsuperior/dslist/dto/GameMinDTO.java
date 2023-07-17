package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entitiy.Game;
import com.devsuperior.dslist.projection.GameMinProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game game) {
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }

    public GameMinDTO(GameMinProjection gameMinProjection) {
        id = gameMinProjection.getId();
        title = gameMinProjection.getTitle();
        year = gameMinProjection.getYear();
        imgUrl = gameMinProjection.getImgUrl();
        shortDescription = gameMinProjection.getShortDescription();
    }
}
