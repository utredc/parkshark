package be.wailsharks.parkshark.api.members.dto;

import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.City;
import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.service.CityService;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    private CityService cityService;

    public MemberMapper(CityService cityService) {
        this.cityService = cityService;
    }

    public Member convertCreateMemberDtoToMember(CreateMemberDto memberToCreate) {
        Name memberName = new Name(memberToCreate.getFirstName(), memberToCreate.getLastName());
        LicensePlate licensePlate = new LicensePlate(memberToCreate.getLicensePlateNr(), memberToCreate.getLicensePlateCountry());

        Address address = new Address(memberToCreate.getStreetName(),memberToCreate.getStreetNumber(), cityService.getCityByID(memberToCreate.getCityId()));
        return new Member(memberName, licensePlate, memberToCreate.getTelephoneNr(), memberToCreate.getEmailAddress(),address);
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
