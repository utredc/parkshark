package be.wailsharks.parkshark.war.views;

import be.wailsharks.parkshark.api.members.MemberController;
import be.wailsharks.parkshark.api.members.dto.BasicMemberInfoDto;
import be.wailsharks.parkshark.api.members.dto.MemberDto;
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
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "member", layout = MainView.class)
@PageTitle("Members")
@CssImport("styles/views/members/members-view.css")
public class MembersView extends Div implements AfterNavigationObserver {

    @Autowired
    private final MemberController memberController;
    private final Grid<BasicMemberInfoDto> membersGrid;

    private H2 createMemberTitle = new H2("Add new member");

    private TextField firstName = new TextField();
    private TextField lastName = new TextField();
    private TextField licensePlateNr = new TextField();
    private TextField licensePlateCountry = new TextField();
    private TextField telephoneNr = new TextField();
    private TextField emailAddress = new TextField();
    private TextField streetName = new TextField();
    private TextField streetNumber = new TextField();
    private ComboBox<String> membershipLevel = new ComboBox<>();
    private ComboBox<String> cityId = new ComboBox<>();

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Create");

    private Binder<BasicMemberInfoDto> binder;

    /**
     * Autowiring has to be done on parameter when you want to be able to use the bean in the constructor
     *
     * @param controller
     * @link https://vaadin.com/forum/thread/17779205/vaadin-flow-spring-boot-using-autowired-in-components
     */
    public MembersView(@Autowired MemberController controller) {
        this.memberController = controller;
        setId("divisions-view");
        this.membersGrid = new Grid<>(BasicMemberInfoDto.class);
        add(membersGrid);
        listDivisions();
        // Configure Grid
        membersGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        membersGrid.setHeightFull();
        //when a row is selected or deselected, populate form
        membersGrid.asSingleSelect().addValueChangeListener(event -> populateForm(event.getValue()));
        // Configure Form
        binder = new Binder<>(BasicMemberInfoDto.class);

        // Bind fields. This where you'd define e.g. validation rules
//        binder.bindInstanceFields(this);
        // note that password field isn't bound since that property doesn't exist in
        // DivisionDto

        // the grid valueChangeEvent will clear the form too
//        cancel.addClickListener(e -> divisions.asSingleSelect().clear());
        cancel.addClickListener(e -> clearFields());

        save.addClickListener(e -> {
            createMember(controller);
            refreshGridList();
            clearFields();
        });

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();
        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);
        add(splitLayout);
    }
    private void listDivisions() {
        membersGrid.setColumns("id", "firstName", "lastName", "licensePlateNr", "emailAddress","registrationDate");
        membersGrid.setItems(memberController.getAllMembers());
    }

    private void createMember(@Autowired MemberController controller) {
        try {
            Notification.show("Wow, you clicked a button!");
        } catch (Exception ex) {
            Notification.show("You did something wrong...\n Try again!");
        }
    }

    private void refreshGridList() {
        membersGrid.setItems(memberController.getAllMembers());
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorDiv = new Div();
        editorDiv.setId("editor-layout");
        FormLayout formLayout = new FormLayout();

        editorDiv.add(createMemberTitle);
//        parentDivisionComboBox.setItems(controller.getAllDivisions().stream().map(DivisionDto::getName));
        membershipLevel.setItems("Bronze", "Silver", "Gold");
        membershipLevel.setAllowCustomValue(false);
        membershipLevel.setValue("Bronze");
        editorDiv.add(firstName, lastName, licensePlateNr,licensePlateCountry,telephoneNr,emailAddress,streetName,streetNumber,membershipLevel);
//        addFormItem(editorDiv, formLayout, firstName, "First Name")
//        addFormItem(editorDiv, formLayout, lastName, "Last Name");
//        addFormItem(editorDiv, formLayout, licensePlateNr, "License Plate Nr");
//        addFormItem(editorDiv, formLayout, licensePlateCountry, "License Plate Country");
//        addFormItem(editorDiv, formLayout, telephoneNr, "Telephone Nr");
//        addFormItem(editorDiv, formLayout, emailAddress, "Email Address");
//        addFormItem(editorDiv, formLayout, streetName, "Street Name");
//        addFormItem(editorDiv, formLayout, streetNumber, "Street Number");
//        addFormItem(editorDiv, formLayout, membershipLevel, "Membership Level");
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
        wrapper.add(membersGrid);
    }

    private void addFormItem(Div wrapper, FormLayout formLayout,
                             AbstractField field, String fieldName) {
        formLayout.addFormItem(field, fieldName);
        wrapper.add(formLayout);
        field.getElement().getClassList().add("full-width");
    }

    private void clearFields() {
        firstName.setValue("");
        lastName.setValue("");
        licensePlateNr.setValue("");
        licensePlateCountry.setValue("");
        telephoneNr.setValue("");
        emailAddress.setValue("");
        streetName.setValue("");
        streetNumber.setValue("");
        membershipLevel.setItems("Bronze", "Silver", "Gold");
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user
        refreshGridList();
    }

    private void populateForm(BasicMemberInfoDto value) {
        // Value can be null as well, that clears the form
        binder.readBean(value);

        // The password field isn't bound through the binder, so handle that
//        password.setValue("");
    }

//    public MembersView(MemberController memberController) {
//        this.memberController = memberController;
//        this.membersGrid = new Grid<>(BasicMemberInfoDto.class);
//        add(membersGrid);
//        listDivisions();
//    }

//    private void listDivisions() {
//        membersGrid.setColumns("id", "firstName", "lastName", "licensePlateNr", "telephoneNr","emailAddress");
//        membersGrid.setItems(memberController.getAllMembers());
//    }
//
//    @Override
//    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
//        membersGrid.setItems(memberController.getAllMembers());
//    }

}
