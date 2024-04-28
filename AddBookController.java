package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

public class AddBookController implements Initializable {

    @FXML
    private TextField LastNameField;
    @FXML
    private TextField FirstNameField;
    @FXML
    private TextField EmailField;

    @FXML
    private Button addBtn;
    @FXML
    private Button exportBtn;
    @FXML
    private Button importBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button quitBtn;

    @FXML
    private TableView<Person> table;
    private ObservableList<Person> data = FXCollections.observableArrayList();

    private DataClass dataClass = new DataClass();

    @FXML
    private TableColumn<Person, String> firstNameCol;
    @FXML
    private TableColumn<Person, String> lastNameCol;
    @FXML
    private TableColumn<Person, String> emailCol;

    protected void handleSubmitButtonAction(ActionEvent event) {
        Window owner = addBtn.getScene().getWindow();
        if (LastNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter your last name", owner);
        } else if (FirstNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter your first name", owner);
        } else if (EmailField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter your email", owner);
        } else {
            showAlert(Alert.AlertType.CONFIRMATION, "Registration Successful!", "Welcome " + FirstNameField.getText() + " " + LastNameField.getText(), owner);
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content, Window owner) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.initOwner(owner);
        alert.show();
    }

    @FXML
    private void add() {        
        if (!LastNameField.getText().isEmpty() && !FirstNameField.getText().isEmpty() && !EmailField.getText().isEmpty()) {
            Person newPerson = new Person(FirstNameField.getText(), LastNameField.getText(), EmailField.getText());
            dataClass.add(newPerson);
            data.add(newPerson); 
            clearFields();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Person added successfully!", addBtn.getScene().getWindow());
        } else {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please fill in all fields to add to the table", addBtn.getScene().getWindow());
        }
    }

    private void clearFields() {
        FirstNameField.clear();
        LastNameField.clear();
        EmailField.clear();
    }

    @FXML
    private void remove() {
        Person selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            data.remove(selectedItem);
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No item selected to remove", removeBtn.getScene().getWindow());
        }
    }
    
    @FXML
    private void importC(ActionEvent event) {
        List<Person> importedPersons = dataClass.getImportList();
        
        if (!importedPersons.isEmpty()) {
            data.addAll(importedPersons);
            showAlert(Alert.AlertType.INFORMATION, "Import", "Imported " + importedPersons.size() + " persons successfully!", importBtn.getScene().getWindow());
        } else {
            showAlert(Alert.AlertType.ERROR, "Import Error", "No persons imported.", importBtn.getScene().getWindow());
        }
    }


    @FXML
    private void export(ActionEvent event) {
        List<Person> exportedPersons = new ArrayList<>(data);
        dataClass.setExportList(exportedPersons);

        // Perform additional export operations if needed, such as saving to a file or database
        // For example:
        // exportToDatabase(exportedPersons);

        showAlert(Alert.AlertType.INFORMATION, "Export", "Exported " + exportedPersons.size() + " persons successfully!", exportBtn.getScene().getWindow());
    }


    @FXML
    private void quit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        if (!table.getColumns().contains(firstNameCol)) {
            table.getColumns().add(firstNameCol);
        }
        if (!table.getColumns().contains(lastNameCol)) {
            table.getColumns().add(lastNameCol);
        }
        if (!table.getColumns().contains(emailCol)) {
            table.getColumns().add(emailCol);
        }
        
        data.addAll(dataClass.getImportList());
        table.setItems(data);
    }


}
