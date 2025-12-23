package exercice2;

public class CompteEpargne extends CompteBancaire {
    private double tauxInteret; // Taux en pourcentage (ex: 3.5 pour 3.5%)

    public CompteEpargne(String numeroCompte, double solde, String nomTitulaire, double tauxInteret) {
        super(numeroCompte, solde, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }

    // Méthode pour calculer et ajouter les intérêts
    public void calculerInterets() {
        double interets = solde * (tauxInteret / 100);
        solde += interets;
        System.out.println("✓ Intérêts de " + interets + " DH ajoutés au compte épargne.");
        System.out.println("Nouveau solde : " + solde + " DH");
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public String toString() {
        return "CompteEpargne N° " + numeroCompte +
                " - Titulaire : " + nomTitulaire +
                " - Solde : " + solde + " DH" +
                " - Taux d'intérêt : " + tauxInteret + "%";
    }
}