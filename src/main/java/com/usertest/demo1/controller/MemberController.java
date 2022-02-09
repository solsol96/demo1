package com.usertest.demo1.controller;

import com.usertest.demo1.model.dto.MemberVO;
import com.usertest.demo1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Member;
import java.util.Date;
import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members")
    public String memberList(Model model) {
        List<MemberVO> list = memberService.memberList();
        model.addAttribute("list", list);
        return "members/viewMemberList";
    }

    @GetMapping(value = "/members/new")
    public String createMember() {
        return "members/memberCreate";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberVO vo) {
        MemberVO memberVO = new MemberVO();

        memberVO.setUserId(vo.getUserId());
        memberVO.setUserPw(vo.getUserPw());
        memberVO.setUserName(vo.getUserName());
        memberVO.setUserEmail(vo.getUserEmail());

        Date date = new Date();

        memberVO.setUserRegdate(date);
        memberService.insertMember(memberVO);

        return "redirect:/";
    }

    @GetMapping("/members/info")
    public String des(String id , Model model) {
        model.addAttribute("dto" , memberService.viewMember(id));
        return "members/memberInfo";
    }

    @PostMapping("/members/info")
    public String update(MemberVO vo) {
        MemberVO memberVO = new MemberVO();

        memberVO.setUserId(vo.getUserId());
        memberVO.setUserPw(vo.getUserPw());
        memberVO.setUserName(vo.getUserName());
        memberVO.setUserEmail(vo.getUserEmail());

        Date date = new Date();
        memberVO.setUserUpdatedate(date);

        memberService.updateMember(memberVO);
        System.out.println("업데이트");
        return "redirect:/";
    }

    @DeleteMapping("/members/info/delete")
    public String delete(String id) {
        System.out.println("삭제");
        return "redircet:/";
    }


}
