package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditContactControler {

    @FXML
    public Button editContact;
    @FXML
    private TextField firstName;
    @FXML
    private TextField secondName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField notes;

    private int index;
    public  void initialize(){

        index = Controller.index;
        System.out.println(index);
        Contact oldContact = ContactData.getInstance().getContact(index);
        setFirstName(oldContact.getFirstName());
        setSecondName(oldContact.getLastName());
        setPhoneNumber(oldContact.getPhoneNumber());
        setNotes(oldContact.getNotes());
    }

    private void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    private void setSecondName(String firstName) {
        this.secondName.setText(firstName);
    }

    private void setPhoneNumber(String firstName) {
        this.phoneNumber.setText(firstName);
    }

    private void setNotes(String firstName) {
        this.notes.setText(firstName);
    }

    @FXML
    public void editContact(){
        Contact contact = new Contact(firstName.getText(),secondName.getText(),phoneNumber.getText(),notes.getText());
        ContactData.getInstance().editContact(index,contact);
    }
}
