package be.wailsharks.parkshark.domain.invoice;

import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;
import be.wailsharks.parkshark.domain.members.Member;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "INVOICE")
public class Invoice {

    public static final int DAYS_BEFORE_EXPIRING = 28;

    @Id
    @SequenceGenerator(name = "invoice_seq_gen", sequenceName = "INVOICE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq_gen")
    @Column(name = "ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "EXPIRE_DATE")
    private LocalDate expireDate;

    @Column(name = "PAYMENT_DATE")
    private LocalDate paymentDate;

    @OneToMany
    @JoinColumn(name = "INVOICE_ID")
    private List<InvoiceItem> invoiceItems;

    @Column(name ="STATUS")
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    public Invoice() {
    }

    public Invoice(Member member, List<InvoiceItem> invoiceItems) {
        this.member = member;
        this.startDate = LocalDate.now();
        this.expireDate = startDate.plusDays(DAYS_BEFORE_EXPIRING);
        this.invoiceItems = invoiceItems;
        this.status = InvoiceStatus.OPEN;
    }

    public long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public Invoice(List<ParkingAllocation> parkingAllocations, Member member) {
        checkMemberAndParkingAllocations(parkingAllocations, member);
        this.member = member;
        this.startDate = LocalDate.now();
        this.expireDate = startDate.plusDays(DAYS_BEFORE_EXPIRING);
        this.invoiceItems = createInvoiceItems(parkingAllocations);
        this.status = InvoiceStatus.OPEN;
    }

    private void checkMemberAndParkingAllocations(List<ParkingAllocation> parkingAllocations, Member member) {
        for (ParkingAllocation parkingAllocation:parkingAllocations) {
            if (!parkingAllocation.getMember().equals(member)) {
                throw new IllegalArgumentException("Member and member in parkinglotallocations don't match");
            }
        }
    }

    private List<InvoiceItem> createInvoiceItems(List<ParkingAllocation> parkingAllocations) {
        return parkingAllocations.stream()
                .map(InvoiceItem::new)
                .collect(Collectors.toList());
    }

}
