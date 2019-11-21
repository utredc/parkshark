package be.wailsharks.parkshark.war;

import be.wailsharks.parkshark.war.views.DivisionsView;
import be.wailsharks.parkshark.war.views.MembersView;
import be.wailsharks.parkshark.war.views.ParkingLotView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.material.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.OFFICE;

//@Route(value = "main")
@JsModule("./styles/shared-styles.js")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "parkshark", shortName = "parkshark")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class MainView extends AppLayout {

    public static final String DIVISIONS_TITLE = "Divisions";
    public static final String PARKING_LOTS_TITLE = "Parking Lots";
    public static final String MEMBERS_TITLE = "Members";
    private final Tabs menu;

    public MainView() {
        new Header(new H1("ParkShark Header"));
        Image img = new Image("https://github.com/utredc/parkshark/blob/master/parkshark.png?raw=true",
                "ParkShark Logo");
        Image icon = new Image("https://github.com/utredc/parkshark/blob/master/parkshark-icon.png?raw=true", "ParkShark Icon");
        icon.setHeight("44px");
        img.setWidth("250px");
        Icon testIcon = new Icon(OFFICE);
        addToNavbar(new DrawerToggle(), new H3("Park Shark"), icon);
        menu = createMenuTabs();
        menu.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(menu);
    }

    private static Tabs createMenuTabs() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.add(getAvailableTabs());
        return tabs;
    }

    private static Tab[] getAvailableTabs() {
        final List<Tab> tabs = new ArrayList<>();
        tabs.add(createTab(VaadinIcon.OFFICE, DIVISIONS_TITLE, DivisionsView.class));
        tabs.add(createTab(VaadinIcon.CAR, PARKING_LOTS_TITLE, ParkingLotView.class));
        tabs.add(createTab(VaadinIcon.USERS, MEMBERS_TITLE, MembersView.class));
        return tabs.toArray(new Tab[tabs.size()]);
    }

    private static Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        return createTab(populateLink(new RouterLink(null, viewClass), icon, title));
    }

    private static Tab createTab(Component content) {
        final Tab tab = new Tab();
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(content);
        return tab;
    }

    private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
        a.add(icon.create());
        a.add(title);
        return a;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        selectTab();
    }

    private void selectTab() {
        String target = RouteConfiguration.forSessionScope()
                .getUrl(getContent().getClass());
        Optional<Component> tabToSelect = menu.getChildren().filter(tab -> {
            Component child = tab.getChildren().findFirst().get();
            return child instanceof RouterLink
                    && ((RouterLink) child).getHref().equals(target);
        }).findFirst();
        tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab) tab));
    }
}
