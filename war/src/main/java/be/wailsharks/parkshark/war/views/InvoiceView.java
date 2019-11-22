package be.wailsharks.parkshark.war.views;

import be.wailsharks.parkshark.domain.invoice.Invoice;
import be.wailsharks.parkshark.domain.invoice.InvoiceItem;
import be.wailsharks.parkshark.service.invoice.InvoiceService;
import be.wailsharks.parkshark.war.MainView;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

import static com.vaadin.flow.component.Tag.H2;

@Route(value = "invoices", layout = MainView.class)
@PageTitle("ParkShark - Invoices")
@CssImport("styles/views/divisions/divisions-view.css")
public class InvoiceView  extends Div implements AfterNavigationObserver {

    InvoiceService invoiceService;

     Div monthlyInvoice = new Div();
     Div invoiceItems = new Div();
    private Grid<InvoiceItem> invoiceItemGrid;

    private TextField nameField = new TextField();
    private TextField idField = new TextField();

 public InvoiceView(@Autowired InvoiceService invoiceService){

     this.invoiceItemGrid = new Grid<>();
     monthlyInvoice.add(new H1("Invoice"));
     FormLayout monthlyForm = new FormLayout();
     nameField.setLabel("Member First Name");
     nameField.setReadOnly(true);
     idField.setLabel("Invoice ID");
     idField.setReadOnly(true);
     nameField.setValue(invoiceService.getInvoicesFrom(2).get(0).getMember().getName().getFirstName());
     idField.setValue(String.valueOf(invoiceService.getInvoicesFrom(2).get(0).getId()));

     monthlyForm.add(idField,nameField);
     monthlyInvoice.add(monthlyForm);

     invoiceItems.add(new H2("Items"));

     invoiceItemGrid.setHeightFull();
     invoiceItemGrid.addColumn(e -> String.valueOf(e.getId())).setHeader("Id");
     invoiceItemGrid.addColumn(e -> e.getParkingAllocation().getParkingLot().getName()).setHeader("Parking Allocation");
     invoiceItemGrid.addColumn(e -> String.valueOf(e.getPrice())).setHeader("Price");
//     invoiceItemGrid.setColumns("id" , "parkingAllocation", "price");
//     invoiceItemGrid.setItems(invoiceService.getInvoicesFrom(2).get(0).getInvoiceItems());

     invoiceItems.add(invoiceItemGrid);
     add(monthlyInvoice, invoiceItems);

 }
    @Override
    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
//        invoiceItemGrid.setItems(invoiceService.getInvoicesFrom(2).get(0).getInvoiceItems());
    }
}
