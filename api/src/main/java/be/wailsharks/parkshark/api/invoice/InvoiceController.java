package be.wailsharks.parkshark.api.invoice;

import be.wailsharks.parkshark.api.invoice.dto.InvoiceDto;
import be.wailsharks.parkshark.service.invoice.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(InvoiceController.INVOICE_CONTROLLER_RESOURCE_URL)
public class InvoiceController {
    static final String INVOICE_CONTROLLER_RESOURCE_URL = "/invoice";
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceController.class);

    private InvoiceService invoiceService;
    private InvoiceMapper invoiceMapper;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, InvoiceMapper invoiceMapper) {
        this.invoiceService = invoiceService;
        this.invoiceMapper = invoiceMapper;
    }

    @GetMapping(path = "/{memberId}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<InvoiceDto> getInvoicesForMember(@PathVariable("memberId") long id) {
        return invoiceService.getInvoicesFrom(id).stream()
                .map(invoice -> invoiceMapper.mapToDto(invoice))
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/{memberId}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public InvoiceDto createInvoicesForMember(@PathVariable("memberId") long id) {
        return invoiceMapper.mapToDto(invoiceService.createNewInvoiceForMemberWithId(id));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceDto> getAllInvoices() {
        return invoiceService.getAllInvoices().stream()
                .map(invoice -> invoiceMapper.mapToDto(invoice))
                .collect(Collectors.toList());
    }

    @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public InvoiceDto closeInvoiceWithId(@PathVariable("id") long id){
        return invoiceMapper.mapToDto(invoiceService.closeInvoiceWithId(id));
    }
}
