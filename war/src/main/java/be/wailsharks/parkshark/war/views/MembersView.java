//package be.wailsharks.parkshark.war.views;
//
//import be.wailsharks.parkshark.api.division.DivisionController;
//import be.wailsharks.parkshark.api.division.dto.DivisionDto;
//import be.wailsharks.parkshark.war.MainView;
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.router.AfterNavigationEvent;
//import com.vaadin.flow.router.AfterNavigationObserver;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//
//@Route(value = "member", layout = MainView.class)
//@PageTitle("Members")
//@CssImport("styles/views/members/members-view.css")
//public class MembersView extends Div implements AfterNavigationObserver {
//
//    private final DivisionController divisionController;
//    final Grid<DivisionDto> grid;
//
//    public MembersView(DivisionController divisionService) {
//        this.divisionController = divisionService;
//        this.grid = new Grid<>(DivisionDto.class);
//        add(grid);
//        listDivisions();
//    }
//
//    private void listDivisions() {
//        grid.setColumns("id", "name", "originalName", "director", "parentDivisionId");
//        grid.setItems(divisionController.getAllDivisions());
//    }
//
//    @Override
//    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
//        grid.setItems(divisionController.getAllDivisions());
//    }
//
//}
