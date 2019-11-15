package be.wailsharks.parkshark.service;


import be.wailsharks.parkshark.domain.members.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberDto registerMember(CreateMemberDto memberToRegister) {

    }
}
