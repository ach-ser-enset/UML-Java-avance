package exercice2;

public class FondsInsuffisantsException extends Exception {
    private double soldeActuel;
    private double montantDemande;

    public FondsInsuffisantsException(String message, double soldeActuel, double montantDemande) {
        super(message);
        this.soldeActuel = soldeActuel;
        this.montantDemande = montantDemande;
    }

    public double getSoldeActuel() {
        return soldeActuel;
    }

    public double getMontantDemande() {
        return montantDemande;
    }

    @Override
    public String toString() {
        return super.toString() +
                " - Solde actuel : " + soldeActuel +
                " DH, Montant demandé : " + montantDemande + " DH";
    }
}