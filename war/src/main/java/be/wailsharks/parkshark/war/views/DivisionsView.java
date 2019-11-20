package be.wailsharks.parkshark.war.views;

import be.wailsharks.parkshark.api.division.DivisionController;
import be.wailsharks.parkshark.api.division.dto.CreateDivisionDto;
import be.wailsharks.parkshark.api.division.dto.DivisionDto;
import be.wailsharks.parkshark.war.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

@Route(value = "division", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("ParkShark - Divisions")
@CssImport("styles/views/divisions/divisions-view.css")
public class DivisionsView extends Div implements AfterNavigationObserver {

    private DivisionController controller;

    private Grid<DivisionDto> divisionsGrid;

    private H2 createDivisionTitle = new H2("Add new division");

    private TextField name = new TextField();
    private TextField originalName = new TextField();
    private TextField director = new TextField();
    private ComboBox<String> parentDivisionComboBox = new ComboBox<>();

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Create");

    private Binder<DivisionDto> binder;

    /**
     * Autowiring has to be done on parameter when you want to be able to use the bean in the constructor
     * @param controller
     * @link https://vaadin.com/forum/thread/17779205/vaadin-flow-spring-boot-using-autowired-in-components
     */
    public DivisionsView(@Autowired DivisionController controller) {
        this.controller = controller;
        setId("divisions-view");
        // Configure Grid
        divisionsGrid = new Grid<>();
        divisionsGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        divisionsGrid.setHeightFull();
        divisionsGrid.addColumn(DivisionDto::getId).setHeader("ID");
        divisionsGrid.addColumn(DivisionDto::getName).setHeader("Name");
        divisionsGrid.addColumn(DivisionDto::getOriginalName).setHeader("Original Name");
        divisionsGrid.addColumn(DivisionDto::getDirector).setHeader("Director");
        divisionsGrid.addColumn(DivisionDto::getParentDivisionId).setHeader("Parent Division ID");
        //when a row is selected or deselected, populate form
        divisionsGrid.asSingleSelect().addValueChangeListener(event -> populateForm(event.getValue()));
        // Configure Form
        binder = new Binder<>(DivisionDto.class);

        // Bind fields. This where you'd define e.g. validation rules
//        binder.bindInstanceFields(this);
        // note that password field isn't bound since that property doesn't exist in
        // DivisionDto

        // the grid valueChangeEvent will clear the form too
//        cancel.addClickListener(e -> divisions.asSingleSelect().clear());
        cancel.addClickListener(e -> clearFields());

        save.addClickListener(e -> {
            createDivision(controller);
            refreshGridList();
            clearFields();
        });

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();
        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);
        add(splitLayout);
    }

    private void createDivision(@Autowired DivisionController controller) {
        try {
            if(parentDivisionComboBox.isEmpty()){
                controller.createDivision(new CreateDivisionDto(name.getValue(),
                        originalName.getValue(),
                        director.getValue()));
            } else {
            controller.createDivision(new CreateDivisionDto(name.getValue(),
                    originalName.getValue(),
                    director.getValue(),
                    controller.getDivisionByName(parentDivisionComboBox.getValue()).id
            ));}
        } catch (Exception ex) {
            Notification.show("You did something wrong...\n Try again!");
        }
    }

    private void refreshGridList() {
        divisionsGrid.setItems(controller.getAllDivisions());
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorDiv = new Div();
        editorDiv.setId("editor-layout");
        FormLayout formLayout = new FormLayout();
        editorDiv.add(createDivisionTitle);
        parentDivisionComboBox.setItems(controller.getAllDivisions().stream().map(DivisionDto::getName));

        addFormItem(editorDiv, formLayout, name, "Name");
        addFormItem(editorDiv, formLayout, originalName, "Original Name");
        addFormItem(editorDiv, formLayout, director, "Director");
        addFormItem(editorDiv, formLayout, parentDivisionComboBox, "Parent Division");
        createButtonLayout(editorDiv);
        splitLayout.addToSecondary(editorDiv);
    }

    private void createButtonLayout(Div editorDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setId("button-layout");
        buttonLayout.setWidthFull();
        buttonLayout.setSpacing(true);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(cancel, save);
        editorDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
        wrapper.add(divisionsGrid);
    }

    private void addFormItem(Div wrapper, FormLayout formLayout,
                             AbstractField field, String fieldName) {
        formLayout.addFormItem(field, fieldName);
        wrapper.add(formLayout);
        field.getElement().getClassList().add("full-width");
    }

    private void clearFields() {
        name.setValue("");
        originalName.setValue("");
        director.setValue("");
        parentDivisionComboBox.setItems(controller.getAllDivisions().stream().map(DivisionDto::getName));
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user
        refreshGridList();
    }

    private void populateForm(DivisionDto value) {
        // Value can be null as well, that clears the form
        binder.readBean(value);

        // The password field isn't bound through the binder, so handle that
//        password.setValue("");
    }

}
