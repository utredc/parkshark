package be.wailsharks.parkshark.api.members;


import be.wailsharks.parkshark.api.members.dto.BasicMemberInfoDto;
import be.wailsharks.parkshark.api.members.dto.CreateMemberDto;
import be.wailsharks.parkshark.api.members.dto.MemberDto;
import be.wailsharks.parkshark.api.members.dto.MemberMapper;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;
    private static final String APPLICATION_JSON_VALUE = MediaType.APPLICATION_JSON_VALUE;


    @Autowired
    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto registerMember(@RequestBody CreateMemberDto memberToCreate) {
        Member newMember = memberService.registerMember(memberMapper.convertCreateMemberDtoToMember(memberToCreate));
        return MemberMapper.convertMemberToDto(newMember);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BasicMemberInfoDto> getAllMembers() {
        return memberService.getAllMembers().stream()
                .map(MemberMapper::convertMemberToBasicInfoDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public MemberDto getSpecificMember(@PathVariable("id") long id) {
        Member result =  memberService.getSpecificMember(id);
        return MemberMapper.convertMemberToDto(result);
    }
}
