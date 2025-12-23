package exercice2;

public class CompteInexistantException extends Exception {
    private String numeroCompte;

    public CompteInexistantException(String message, String numeroCompte) {
        super(message);
        this.numeroCompte = numeroCompte;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    @Override
    public String toString() {
        return super.toString() + " - Numéro de compte : " + numeroCompte;
    }
}