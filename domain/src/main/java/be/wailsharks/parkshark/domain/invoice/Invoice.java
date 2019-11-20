package be.wailsharks.parkshark.domain.invoice;

import be.wailsharks.parkshark.domain.members.Member;

import java.time.LocalDate;
import java.util.List;

public class Invoice {

    private long id;
    private Member member;
    private LocalDate startDate;
    private LocalDate expireDate;
    private LocalDate paymentDate;

    private List<InvoiceItem> invoiceItems;
    private InvoiceStatus status;

}
