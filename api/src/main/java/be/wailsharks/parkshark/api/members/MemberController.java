package be.wailsharks.parkshark.api.members;


import be.wailsharks.parkshark.api.members.dto.CreateMemberDto;
import be.wailsharks.parkshark.api.members.dto.MemberDto;
import be.wailsharks.parkshark.api.members.dto.MemberMapper;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto registerMember(@RequestBody CreateMemberDto memberToCreate) {
        Member newMember = memberService.registerMember(memberMapper.convertCreateMemberDtoToMember(memberToCreate));
        return MemberMapper.convertMemberToDto(newMember);
    }
}
