package be.wailsharks.parkshark.war.views;

import be.wailsharks.parkshark.api.parkinglot.ParkingLotController;
import be.wailsharks.parkshark.api.parkinglot.dto.ParkingLotDto;
import be.wailsharks.parkshark.war.MainView;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;

@Route(value = "parking-lots", layout = MainView.class)
@PageTitle("ParkShark - Parking Lots")
@CssImport("styles/views/register/register-view.css")
public class ParkingLotView extends Div implements AfterNavigationObserver {

    private final ParkingLotController parkingLotController;
    final Grid<ParkingLotDto> grid;

    public ParkingLotView(ParkingLotController divisionService) {
        this.parkingLotController = divisionService;
        this.grid = new Grid<>(ParkingLotDto.class);
        add(grid);
        listParkingLots();
    }

//    id;
//    public double pricePerHour;
//    public String name;
//    public int maxCapacity;
//    public ContactPersonDto contactPersonDto;
//    public String streetName;
//    public String houseNumber;
//    public String postalCode;
//    public String city;
//    public String category;
//    public DivisionDto divisionDto

    private void listParkingLots() {
        grid.setColumns("id", "name", "streetName", "city", "category", "pricePerHour");
        grid.setItems(parkingLotController.getAllParkingLots());
    }

    @Override
    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
        grid.setItems(parkingLotController.getAllParkingLots());
    }
}
