package be.wailsharks.parkshark.service.common;

import be.wailsharks.parkshark.domain.common.ContactPerson;
import be.wailsharks.parkshark.domain.common.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactPersonService {
    private ContactPersonRepository contactPersonRepository;

    @Autowired
    public ContactPersonService(ContactPersonRepository contactPersonRepository){
        this.contactPersonRepository = contactPersonRepository;
    }

    public ContactPerson getById(long id){
        return contactPersonRepository.findById(id).get();
    }

}
