package com.estsoft.weeklyquiz.service;

import com.estsoft.weeklyquiz.repository.Member;
import com.estsoft.weeklyquiz.repository.MemberRepository;
import com.estsoft.weeklyquiz.repository.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final TeamService teamService;
    private final MemberRepository memberRepository;

    // getMemberAll 모든 정보를 조회
    public List<Member> getMemberAll(){
        return memberRepository.findAll();
    }
    //member 테이블에 insert 쿼리
    public Member insertMember(Member member){
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
    public void deleteMemberById(Long id){
        memberRepository.deleteById(id);
    }


    public List<Member> selectMemberByName(String name) {
        return memberRepository.findByNameContaining(name);

    }
    public Member addMember(Long teamId, Member member) {
        Team team = teamService.findById(teamId);
        member.setTeam(team);
        return memberRepository.save(member);
    }

}
