package be.wailsharks.parkshark.domain.invoice;

import org.springframework.data.repository.CrudRepository;

public interface InvoiceItemRepository extends CrudRepository<InvoiceItem, Long> {
}
