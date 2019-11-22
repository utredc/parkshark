package be.wailsharks.parkshark.war.views;

import be.wailsharks.parkshark.api.division.dto.CreateDivisionDto;
import be.wailsharks.parkshark.api.division.dto.DivisionDto;
import be.wailsharks.parkshark.domain.division.Division;
import be.wailsharks.parkshark.service.division.DivisionService;
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
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;

@Route(value = "division-serv", layout = MainView.class)
@PageTitle("ParkShark - Divisions")
@CssImport("styles/views/divisions/divisions-view.css")
public class DivisionsViewService extends Div implements AfterNavigationObserver {

    private DivisionService divisionService;

    private Grid<Division> divisionsGrid;

    private H2 createDivisionTitle = new H2("Add new division");

    private TextField nameField = new TextField();
    private TextField originalNameField = new TextField();
    private TextField directorField = new TextField();
    private ComboBox<String> parentDivisionComboBox = new ComboBox<>();

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Create");

    private Binder<Division> binder;

    /**
     * Autowiring has to be done on parameter when you want to be able to use the bean in the constructor
     *
     * @param divisionService
     * @link https://vaadin.com/forum/thread/17779205/vaadin-flow-spring-boot-using-autowired-in-components
     */
    public DivisionsViewService(@Autowired DivisionService divisionService) {
        this.divisionService = divisionService;
        setId("divisions-view");
        this.divisionsGrid = new Grid<>(Division.class);
        add(divisionsGrid);
        listDivisions();
        // Configure Grid
        divisionsGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        divisionsGrid.setHeightFull();
        //when a row is selected or deselected, populate form
        divisionsGrid.asSingleSelect().addValueChangeListener(event -> populateForm(event.getValue()));
        // Configure Form
        binder = new Binder<>(Division.class);
//        binder.bindInstanceFields(this);
        binder.forField(nameField)
                .withValidator(new StringLengthValidator(
                        "Name is required", 1, null))
                .bind(Division::getName, Division::setName);
        binder.forField(originalNameField).bind(Division::getOriginalName, Division::setOriginalName);
        binder.forField(directorField)
                .withValidator(new StringLengthValidator(
                        "Director is required", 1, null))
                .bind(Division::getDirector, Division::setDirector);
        // Bind fields. This where you'd define e.g. validation rules
//        binder.bindInstanceFields(this);
//        cancel.addClickListener(e -> divisions.asSingleSelect().clear());
        cancel.addClickListener(e -> {
            // clear fields by setting null
            clearFields();
        });

        save.addClickListener(e -> {
//            createDivision(divisionService);
//            refreshGridList();
//            clearFields();
            if (binder.isValid()) {
//                createDivision(divisionService);
                refreshGridList();
                clearFields();
            } else {
                BinderValidationStatus<Division> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
            }

        });
        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();
        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);
        add(splitLayout);
    }

    private void listDivisions() {
        divisionsGrid.setColumns("id", "name", "originalName", "director", "parentDivisionId");
        divisionsGrid.setItems(divisionService.getAllDivisions());
    }

    private void createDivision(@Autowired DivisionService divisionService) {
        try {
            if (parentDivisionComboBox.isEmpty()
                    || parentDivisionComboBox.getValue().equals("None")) {
                divisionService.addDivision(new Division(nameField.getValue(),
                        originalNameField.getValue(),
                        directorField.getValue()));
            } else {
                divisionService.addDivision(new Division(nameField.getValue(),
                        originalNameField.getValue(),
                        directorField.getValue(),
                        divisionService.getByName(parentDivisionComboBox.getValue()).getId()
                ));
            }
        } catch (Exception ex) {
            Notification.show("You did something wrong...\n Try again!");
        }
    }

    private void refreshGridList() {
        divisionsGrid.setItems(divisionService.getAllDivisions());
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorDiv = new Div();
        editorDiv.setId("editor-layout");
        FormLayout formLayout = new FormLayout();
        editorDiv.add(createDivisionTitle);
        parentDivisionComboBox.setItems(divisionService.getAllDivisions().stream().map(Division::getName));

        nameField.setPlaceholder("Switchfully");
        nameField.setLabel("Name");
        nameField.setRequiredIndicatorVisible(true);

        originalNameField.setLabel("Original Name");
        originalNameField.setPlaceholder("Original Name...");

        directorField.setLabel("Director");
        directorField.setPlaceholder("John Doe");
        directorField.setRequiredIndicatorVisible(true);

        parentDivisionComboBox.setLabel("Parent Division");
        parentDivisionComboBox.setValue("None");
//        addFormItem(editorDiv, formLayout, nameField, "Name*");
//        addFormItem(editorDiv, formLayout, originalNameField, "Original Name");
//        addFormItem(editorDiv, formLayout, directorField, "Director*");
//        addFormItem(editorDiv, formLayout, parentDivisionComboBox, "Parent Division");
        formLayout.add(nameField, originalNameField, directorField, parentDivisionComboBox);
        editorDiv.add(formLayout);
        createButtonLayout(editorDiv);
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("35", 1),
                new FormLayout.ResponsiveStep("55em", 2));
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
        binder.readBean(null);
        originalNameField.setValue("");
        parentDivisionComboBox.setValue("None");
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Lazy init of the grid items, happens only when we are sure the view will be shown to the user
        refreshGridList();
    }

    private void populateForm(Division divisionDto) {
        // Value can be null as well, that clears the form
        binder.readBean(divisionDto);
    }

}
