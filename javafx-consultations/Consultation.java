public class Consultation {
    private int id;
    private Patient patient;
    private String dateConsultation;
    private String motif;
    private String remarque;

    public Consultation() {}

    public Consultation(int id, Patient patient, String dateConsultation, String motif, String remarque) {
        this.id = id;
        this.patient = patient;
        this.dateConsultation = dateConsultation;
        this.motif = motif;
        this.remarque = remarque;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public String getDateConsultation() { return dateConsultation; }
    public void setDateConsultation(String dateConsultation) { this.dateConsultation = dateConsultation; }
    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }
    public String getRemarque() { return remarque; }
    public void setRemarque(String remarque) { this.remarque = remarque; }

    @Override
    public String toString() {
        return patient + " | " + dateConsultation + " | " + motif;
    }
}
