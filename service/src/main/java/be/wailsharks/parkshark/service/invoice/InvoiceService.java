package be.wailsharks.parkshark.service.invoice;

import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;
import be.wailsharks.parkshark.domain.allocation.ParkingAllocationRepository;
import be.wailsharks.parkshark.domain.allocation.Status;
import be.wailsharks.parkshark.domain.invoice.Invoice;
import be.wailsharks.parkshark.domain.invoice.InvoiceRepository;
import be.wailsharks.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;
    private MemberService memberService;
    private ParkingAllocationRepository parkingAllocationRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, MemberService memberService, ParkingAllocationRepository parkingAllocationRepository) {
        this.invoiceRepository = invoiceRepository;
        this.memberService = memberService;
        this.parkingAllocationRepository = parkingAllocationRepository;
    }

    public List<Invoice> getInvoicesFrom(long id) {
        return invoiceRepository.findAllByMember(memberService.getSpecificMember(id));
    }

    public Invoice createNewInvoiceForId(long id) {
        List<ParkingAllocation> parkingAllocations = parkingAllocationRepository.findByMemberAndStatusIs(memberService.getSpecificMember(id), Status.STOPPED);
        return new Invoice(parkingAllocations,memberService.getSpecificMember(id));
    }
}
