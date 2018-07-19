package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;


public class Controller {

    @FXML
    public TableView tableview = new TableView(); //this is read-only UI table refer to ContactData table for editing
    @FXML
    private TableColumn firstName;
    @FXML
    private TableColumn secondName;
    @FXML
    private TableColumn phoneNumber;
    @FXML
    private TableColumn notes;
    @FXML
    private BorderPane borderPane;
    @FXML

    public static int index;
//    private MenuItem addContact;


    public void initialize() {
//        contacts = FXCollections.observableArrayList();
//
////
////        new Contact("Spiro", "Buzarovski", "123", "N/A"),
////                new Contact("Gorjan", "Buzarovski", "456", "dada")
//
        firstName.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("firstName"));
        secondName.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("lastName"));
        phoneNumber.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("phoneNumber"));
        notes.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("notes"));
//
//        tableview.setItems(contacts);
//       ContactData.getInstance().setContacts(contacts);

        tableview.setItems(ContactData.getInstance().getContactItems());
        tableview.getSelectionModel().select(0);

    }

    // Da sozdade dialog pane za kreiranje nov kontakt
    @FXML
    public void toNewContactController() {
        Dialog<ButtonType> newContactController = new Dialog<>();
        newContactController.initOwner(borderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AddNewContactWindow.fxml"));
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("AddNewContactWindow.fxml"));
            newContactController.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Cant load dialog");
            e.printStackTrace();
            return;
        }
        newContactController.getDialogPane().getButtonTypes().add(ButtonType.OK);
        newContactController.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = newContactController.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("Ok pressed");
        }
    }



    @FXML
    public void editSelectedItem() {
        index = tableview.getSelectionModel().getSelectedIndex();
        Dialog<ButtonType> newContactController = new Dialog<>();
        newContactController.initOwner(borderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("EditNewContactWindow.fxml"));
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("AddNewContactWindow.fxml"));
            newContactController.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Cant load dialog");
            e.printStackTrace();
            return;
        }
        newContactController.getDialogPane().getButtonTypes().add(ButtonType.OK);
        newContactController.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        newContactController.showAndWait();



    }
    @FXML
    public void deleteSelectedItem() {
        int index = tableview.getSelectionModel().getSelectedIndex();
        ContactData.getInstance().deleteContact(index);


    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }

}
