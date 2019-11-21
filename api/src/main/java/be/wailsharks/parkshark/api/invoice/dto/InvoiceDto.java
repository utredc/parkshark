package be.wailsharks.parkshark.api.invoice.dto;

import be.wailsharks.parkshark.api.members.dto.MemberDto;
import be.wailsharks.parkshark.domain.invoice.InvoiceItem;
import be.wailsharks.parkshark.domain.invoice.InvoiceStatus;
import be.wailsharks.parkshark.domain.members.Member;

import java.time.LocalDate;
import java.util.List;

public class InvoiceDto {
    public long id;
    public MemberDto member;
    public LocalDate startDate;
    public LocalDate expireDate;
    public LocalDate paymentDate;
    public List<InvoiceItemDto> invoiceItems;
    public String status;

    public InvoiceDto setId(long id) {
        this.id = id;
        return this;
    }


    public InvoiceDto setMember(MemberDto member) {
        this.member = member;
        return this;
    }

    public InvoiceDto setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public InvoiceDto setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public InvoiceDto setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public InvoiceDto setInvoiceItems(List<InvoiceItemDto> invoiceItems) {
        this.invoiceItems = invoiceItems;
        return this;
    }

    public long getId() {
        return id;
    }

    public MemberDto getMember() {
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

    public List<InvoiceItemDto> getInvoiceItems() {
        return invoiceItems;
    }

    public String getStatus() {
        return status;
    }

    public InvoiceDto setStatus(String status) {
        this.status = status;
        return this;
    }
}
