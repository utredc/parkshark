package be.wailsharks.parkshark.domain.invoice;

import be.wailsharks.parkshark.domain.members.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    List<Invoice> findAllByMember(Member member);

    List<Invoice> findAll();
}
