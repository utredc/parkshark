package be.wailsharks.parkshark.war.views;

import be.wailsharks.parkshark.war.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "home", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("ParkShark - Home")
public class HomeView extends VerticalLayout {

 HomeView(){
     add(new H1("PARKSHARK HOME"));
 }
}
