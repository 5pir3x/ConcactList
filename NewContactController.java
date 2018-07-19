package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class NewContactController {


    @FXML
    public Button addContact;
    @FXML
    private TextField firstName;
    @FXML
    private TextField secondName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField notes;


    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    public void setSecondName(String firstName) {
        this.secondName.setText(firstName);
    }

    public void setPhoneNumber(String firstName) {
        this.phoneNumber.setText(firstName);
    }

    public void setNotes(String firstName) {
        this.notes.setText(firstName);
    }

    @FXML
    public void createNewContact(){
        Contact contact = new Contact(firstName.getText(),secondName.getText(),phoneNumber.getText(),notes.getText());
        ContactData.getInstance().addContact(contact);
    }

}
