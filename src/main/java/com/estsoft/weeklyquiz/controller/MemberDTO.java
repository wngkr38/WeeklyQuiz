package com.estsoft.weeklyquiz.controller;

import com.estsoft.weeklyquiz.repository.Member;
import lombok.Getter;

@Getter
public class MemberDTO {
    private final Long id;
    private final String name;
    private final TeamDTO team;

    public MemberDTO(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.team = new TeamDTO(member.getTeam());
    }

}