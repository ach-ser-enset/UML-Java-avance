import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConsultationController {
    @FXML private ComboBox<Patient> patientCombo;
    @FXML private DatePicker dateConsultationPicker;
    @FXML private TextField motifField;
    @FXML private TextArea remarqueArea;
    @FXML private ListView<Consultation> consultationList;

    private ObservableList<Consultation> consultations = FXCollections.observableArrayList();
    private ObservableList<Patient> patients = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Exemple de patients
        patients.addAll(
            new Patient(1, "Dupont", "Jean", "1990-01-01"),
            new Patient(2, "Martin", "Sophie", "1985-05-12")
        );
        patientCombo.setItems(patients);
        consultationList.setItems(consultations);
    }

    @FXML
    public void handleAddConsultation() {
        Patient patient = patientCombo.getValue();
        String date = dateConsultationPicker.getValue() != null ? dateConsultationPicker.getValue().toString() : "";
        String motif = motifField.getText();
        String remarque = remarqueArea.getText();
        if (patient != null && !date.isEmpty() && !motif.isEmpty()) {
            consultations.add(new Consultation(consultations.size()+1, patient, date, motif, remarque));
            motifField.clear();
            remarqueArea.clear();
        }
    }
}
