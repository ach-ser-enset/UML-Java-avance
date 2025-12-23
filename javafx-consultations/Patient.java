public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private String dateNaissance;

    public Patient() {}

    public Patient(int id, String nom, String prenom, String dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(String dateNaissance) { this.dateNaissance = dateNaissance; }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}
