package com.estsoft.weeklyquiz.service;

import com.estsoft.weeklyquiz.repository.Team;
import com.estsoft.weeklyquiz.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public List<Team> getTeamAll(){
        return teamRepository.findAll();
    }

    public Team insertTeam(Team team){
        Team savedTeam = teamRepository.save(team);
        return savedTeam;
    }

    public Team updateTeam(Team team , Long team_id) {
        Team teamId = teamRepository.findById(team_id).get();
        teamId.setName(team.getName());
        return teamRepository.save(teamId);
    }

    public Team findById(Long team_id) {
        return teamRepository.findById(team_id)
                .orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + team_id));
    }
}

