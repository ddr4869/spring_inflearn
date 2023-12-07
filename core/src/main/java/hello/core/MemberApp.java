package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        MemberService memberservice = new MemberServiceImpl();
        memberservice.join(memberA);

        Member findMember = memberservice.findMember(1L);
        System.out.println("new member = " + memberA.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
