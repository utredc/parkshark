package be.wailsharks.parkshark.service;


import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.members.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member registerMember(Member memberToRegister) {
        Member newMember = memberRepository.save(memberToRegister);
        return newMember;
    }

}
