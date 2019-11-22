package be.wailsharks.parkshark.service.invoice;

import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;
import be.wailsharks.parkshark.domain.allocation.ParkingAllocationRepository;
import be.wailsharks.parkshark.domain.allocation.Status;
import be.wailsharks.parkshark.domain.invoice.Invoice;
import be.wailsharks.parkshark.domain.invoice.InvoiceItem;
import be.wailsharks.parkshark.domain.invoice.InvoiceItemRepository;
import be.wailsharks.parkshark.domain.invoice.InvoiceRepository;
import be.wailsharks.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceItemRepository invoiceItemRepository;
    private MemberService memberService;
    private ParkingAllocationRepository parkingAllocationRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceItemRepository invoiceItemRepository, MemberService memberService, ParkingAllocationRepository parkingAllocationRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceItemRepository = invoiceItemRepository;
        this.memberService = memberService;
        this.parkingAllocationRepository = parkingAllocationRepository;
    }

    public List<Invoice> getInvoicesFrom(long id) {
        return invoiceRepository.findAllByMember(memberService.getSpecificMember(id));
    }

    public Invoice createNewInvoiceForId(long id) {
        List<ParkingAllocation> parkingAllocations = parkingAllocationRepository.findByMemberAndStatusIs(memberService.getSpecificMember(id), Status.STOPPED);
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        for (ParkingAllocation parkingAllocation : parkingAllocations) {
            invoiceItems.add(invoiceItemRepository.save(new InvoiceItem(parkingAllocation)));
        }
        return invoiceRepository.save(new Invoice(memberService.getSpecificMember(id),invoiceItems));
    }
}
