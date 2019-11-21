package be.wailsharks.parkshark.service.invoice;

import be.wailsharks.parkshark.domain.invoice.Invoice;
import be.wailsharks.parkshark.domain.invoice.InvoiceRepository;
import be.wailsharks.parkshark.domain.members.MemberRepository;
import be.wailsharks.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;
    private MemberService memberService;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository,  MemberService memberService) {
        this.invoiceRepository = invoiceRepository;
        this.memberService = memberService;
    }

    public List<Invoice> getInvoicesFrom(long id) {
        return invoiceRepository.findAllByMember(memberService.getSpecificMember(id));
    }
}
