package be.wailsharks.parkshark.api.invoice;

import be.wailsharks.parkshark.api.allocation.ParkingAllocationMapper;
import be.wailsharks.parkshark.api.invoice.dto.InvoiceDto;
import be.wailsharks.parkshark.api.invoice.dto.InvoiceItemDto;
import be.wailsharks.parkshark.api.members.dto.MemberMapper;
import be.wailsharks.parkshark.domain.invoice.Invoice;
import be.wailsharks.parkshark.domain.invoice.InvoiceItem;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper {

    public InvoiceDto mapToDto(Invoice invoice) {
        return new InvoiceDto()
                .setId(invoice.getId())
                .setMember(MemberMapper.convertMemberToDto(invoice.getMember()))
                .setStartDate(invoice.getStartDate())
                .setExpireDate(invoice.getExpireDate())
                .setPaymentDate(invoice.getStartDate())
                .setInvoiceItems(mapInvoiceItemListToDto(invoice.getInvoiceItems()))
                .setStatus(invoice.getStatus().toString());
    }

    private List<InvoiceItemDto> mapInvoiceItemListToDto(List<InvoiceItem> invoiceItems) {
        return invoiceItems.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private InvoiceItemDto mapToDto(InvoiceItem invoiceItem) {
        return new InvoiceItemDto()
                .setId(invoiceItem.getId())
                .setParkingAllocation(ParkingAllocationMapper.mapToDto(invoiceItem.getParkingAllocation()))
                .setPrice(invoiceItem.getPrice())
                ;
    }
}
