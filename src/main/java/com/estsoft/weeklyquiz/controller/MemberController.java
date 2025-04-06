package com.estsoft.weeklyquiz.controller;

import com.estsoft.weeklyquiz.service.MemberService;
import com.estsoft.weeklyquiz.repository.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @ResponseBody
    @GetMapping("/members")
    public List<Member> showMembers(){
        return memberService.getMemberAll();
    }

    @ResponseBody
    @PostMapping("/members")
    public Member saveMember(@RequestBody Member member){
        return memberService.insertMember(member);
    }
    @ResponseBody
    @GetMapping("members/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @ResponseBody
    @DeleteMapping("/members/{id}")
    public String deleteMemberById(@PathVariable Long id){
        memberService.deleteMemberById(id);
        return "삭제 성공";
    }

    //GET search/members?name=
    @GetMapping("search/members")
    @ResponseBody
    public List<Member> selectMemberByName(@RequestParam("name") String name){
        return memberService.selectMemberByName(name);
    }

    @PostMapping("/team/{team_id}/members")
    @ResponseBody
    public MemberDTO addMember(@PathVariable("team_id") Long teamId,
                               @RequestBody Member member) {
        return new MemberDTO(memberService.addMember(teamId, member));
    }


    @GetMapping("/hi")
    public String htmlPage() {
        return "hi";
    }
}
