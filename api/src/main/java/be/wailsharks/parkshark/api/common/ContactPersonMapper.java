package be.wailsharks.parkshark.api.common;

import be.wailsharks.parkshark.api.common.dto.ContactPersonDto;
import be.wailsharks.parkshark.api.common.dto.CreateContactPersonDto;
import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.ContactPerson;
import be.wailsharks.parkshark.domain.common.Name;
import be.wailsharks.parkshark.service.CityService;
import org.springframework.stereotype.Component;

@Component
public class ContactPersonMapper {

    private CityService cityService;

    public ContactPersonMapper(CityService cityService) {
        this.cityService = cityService;
    }

    public ContactPerson mapToDomain(CreateContactPersonDto createContactPersonLotDto) {
        return new ContactPerson(new Name(createContactPersonLotDto.getFirstName(),createContactPersonLotDto.getLastName())
                ,createContactPersonLotDto.getEmail()
                ,new Address(createContactPersonLotDto.getStreetName(), createContactPersonLotDto.getHouseNumber(), createContactPersonLotDto.getCityID())
                ,createContactPersonLotDto.getMobileNr()
                ,createContactPersonLotDto.getPhoneNr());
    }

    public ContactPersonDto mapToContactPersonDto(ContactPerson contactPerson) {
        return new ContactPersonDto()
                .setId(contactPerson.getId())
                .setLastName(contactPerson.getName().getLastName())
                .setFirstName(contactPerson.getName().getFirstName())
                .setEmail(contactPerson.getEmail())
                .setStreetName(contactPerson.getAddress().getStreetName())
                .setStreetNumber(contactPerson.getAddress().getHouseNumber())
                .setPostalCode(cityService
                        .getCityByID(contactPerson
                                .getAddress()
                                .getCityId())
                        .getPostalCode())
                .setCity(cityService
                        .getCityByID(contactPerson
                                .getAddress()
                                .getCityId())
                        .getCityName())
                .setMobileNr(contactPerson.getMobileNr())
                .setPhoneNr(contactPerson.getPhoneNr());

    }
}
