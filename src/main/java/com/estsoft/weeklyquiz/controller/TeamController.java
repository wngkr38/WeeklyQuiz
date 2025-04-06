package com.estsoft.weeklyquiz.controller;

import com.estsoft.weeklyquiz.repository.Member;
import com.estsoft.weeklyquiz.repository.Team;
import com.estsoft.weeklyquiz.service.MemberService;
import com.estsoft.weeklyquiz.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class TeamController {
    private final MemberService memberService;
    private final TeamService teamService;

    @ResponseBody
    @GetMapping("/team")
    public List<Team> showTeam() {
        return teamService.getTeamAll();
    }

    @ResponseBody
    @PostMapping("/team")
    public Team saveMember(@RequestBody Team team) {
        return teamService.insertTeam(team);
    }

    @ResponseBody
    @PostMapping("/team/{team_id}")
    public Team updateTeam(@RequestBody Team team, @PathVariable Long team_id) {
        return teamService.updateTeam(team, team_id);


    }

}
