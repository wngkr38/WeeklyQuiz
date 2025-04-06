package com.estsoft.weeklyquiz.controller;

import com.estsoft.weeklyquiz.repository.Team;
import lombok.Getter;

@Getter
public class TeamDTO {
    private final Long id;
    private final String name;

    public TeamDTO(Team team) {
        id = team.getId();
        name = team.getName();
    }
}
