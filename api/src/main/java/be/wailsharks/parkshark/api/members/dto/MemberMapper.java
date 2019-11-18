package be.wailsharks.parkshark.api.members.dto;

import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;
import be.wailsharks.parkshark.domain.members.Member;

public class MemberMapper {

    public static Member convertCreateMemberDtoToMember(CreateMemberDto memberToCreate) {
        Name memberName = new Name(memberToCreate.getFirstName(), memberToCreate.getLastName());
        LicensePlate licensePlate = new LicensePlate(memberToCreate.getLicensePlateNr(), memberToCreate.getLicensePlateCountry());
        return new Member(memberName, licensePlate, memberToCreate.getTelephoneNr(), memberToCreate.getEmailAddress());
    }

    public static MemberDto convertMemberToDto(Member memberToConvert) {
        return MemberDto.MemberDto()
                .setFirstName(memberToConvert.getName().getFirstName())
                .setLastName(memberToConvert.getName().getLastName())
                .setEmailAddress(memberToConvert.getEmailAddress())
                .setLicensePlateCountry(memberToConvert.getLicensePlate().getPlateCountry())
                .setLicensePlateNr(memberToConvert.getLicensePlate().getPlateNumber())
                .setTelephoneNr(memberToConvert.getTelephoneNr())
                .setRegistrationDate(memberToConvert.getRegistrationDate().toString());
    }
}
