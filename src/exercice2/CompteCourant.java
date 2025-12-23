package exercice2;

public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, double solde, String nomTitulaire, double decouvertAutorise) {
        super(numeroCompte, solde, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant <= 0) {
            System.out.println("✗ Montant de retrait invalide.");
            return;
        }

        // Vérifier si le retrait est possible avec le découvert
        if (solde + decouvertAutorise < montant) {
            throw new FondsInsuffisantsException(
                    "Fonds insuffisants même avec le découvert autorisé",
                    solde,
                    montant
            );
        }

        solde -= montant;
        System.out.println("✓ Retrait de " + montant + " DH effectué sur compte courant.");

        if (solde < 0) {
            System.out.println("⚠ Attention : Vous êtes à découvert de " + Math.abs(solde) + " DH");
        }
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    @Override
    public String toString() {
        return "CompteCourant N° " + numeroCompte +
                " - Titulaire : " + nomTitulaire +
                " - Solde : " + solde + " DH" +
                " - Découvert autorisé : " + decouvertAutorise + " DH";
    }
}