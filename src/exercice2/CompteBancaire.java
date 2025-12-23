package exercice2;

public class CompteBancaire {
    protected String numeroCompte;
    protected double solde;
    protected String nomTitulaire;

    // Constructeur
    public CompteBancaire(String numeroCompte, double solde, String nomTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }

    // Dépôt d'argent
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("✓ Dépôt de " + montant + " DH effectué avec succès.");
        } else {
            System.out.println("✗ Montant de dépôt invalide.");
        }
    }

    // Retrait d'argent
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant <= 0) {
            System.out.println("✗ Montant de retrait invalide.");
            return;
        }

        if (solde < montant) {
            throw new FondsInsuffisantsException(
                    "Fonds insuffisants pour effectuer le retrait",
                    solde,
                    montant
            );
        }

        solde -= montant;
        System.out.println("✓ Retrait de " + montant + " DH effectué avec succès.");
    }

    // Affichage du solde
    public void afficherSolde() {
        System.out.println("Solde du compte " + numeroCompte + " : " + solde + " DH");
    }

    // Transfert d'argent
    public void transferer(double montant, CompteBancaire compteDestinataire)
            throws FondsInsuffisantsException, CompteInexistantException {

        if (compteDestinataire == null) {
            throw new CompteInexistantException(
                    "Le compte destinataire n'existe pas",
                    "inconnu"
            );
        }

        if (montant <= 0) {
            System.out.println("✗ Montant de transfert invalide.");
            return;
        }

        // Effectuer le retrait sur le compte source
        this.retirer(montant);

        // Effectuer le dépôt sur le compte destinataire
        compteDestinataire.deposer(montant);

        System.out.println("✓ Transfert de " + montant + " DH effectué de " +
                this.numeroCompte + " vers " + compteDestinataire.numeroCompte);
    }

    // Getters
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    @Override
    public String toString() {
        return "Compte N° " + numeroCompte +
                " - Titulaire : " + nomTitulaire +
                " - Solde : " + solde + " DH";
    }
}