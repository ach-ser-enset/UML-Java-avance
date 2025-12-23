package exercice2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<CompteBancaire> listeComptes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Ajouter quelques comptes de test
        initialiserComptes();

        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            try {
                switch (choix) {
                    case 1:
                        ajouterCompte();
                        break;
                    case 2:
                        supprimerCompte();
                        break;
                    case 3:
                        afficherTousLesComptes();
                        break;
                    case 4:
                        effectuerDepot();
                        break;
                    case 5:
                        effectuerRetrait();
                        break;
                    case 6:
                        effectuerTransfert();
                        break;
                    case 7:
                        afficherSoldeCompte();
                        break;
                    case 8:
                        calculerInteretsEpargne();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("✗ Choix invalide !");
                }
            } catch (Exception e) {
                System.out.println("✗ Erreur : " + e.getMessage());
            }

            System.out.println();
        } while (choix != 0);

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("\n========== GESTION BANCAIRE ==========");
        System.out.println("1. Ajouter un compte");
        System.out.println("2. Supprimer un compte");
        System.out.println("3. Afficher tous les comptes");
        System.out.println("4. Effectuer un dépôt");
        System.out.println("5. Effectuer un retrait");
        System.out.println("6. Effectuer un transfert");
        System.out.println("7. Afficher le solde d'un compte");
        System.out.println("8. Calculer les intérêts (Compte Épargne)");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void initialiserComptes() {
        listeComptes.add(new CompteCourant("CC001", 5000, "Ahmed Benjelloun", 1000));
        listeComptes.add(new CompteCourant("CC002", 3000, "Fatima Alaoui", 500));
        listeComptes.add(new CompteEpargne("CE001", 10000, "Hassan Mansouri", 3.5));
        listeComptes.add(new CompteEpargne("CE002", 15000, "Amina Berrada", 4.0));
        System.out.println("✓ Comptes initialisés avec succès.");
    }

    private static void ajouterCompte() {
        System.out.println("\n--- Ajouter un compte ---");
        System.out.println("Type de compte : 1. Courant  2. Épargne");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Numéro de compte : ");
        String numero = scanner.nextLine();

        System.out.print("Nom du titulaire : ");
        String nom = scanner.nextLine();

        System.out.print("Solde initial : ");
        double solde = scanner.nextDouble();

        if (type == 1) {
            System.out.print("Découvert autorisé : ");
            double decouvert = scanner.nextDouble();
            listeComptes.add(new CompteCourant(numero, solde, nom, decouvert));
            System.out.println("✓ Compte courant ajouté avec succès.");
        } else if (type == 2) {
            System.out.print("Taux d'intérêt (%) : ");
            double taux = scanner.nextDouble();
            listeComptes.add(new CompteEpargne(numero, solde, nom, taux));
            System.out.println("✓ Compte épargne ajouté avec succès.");
        } else {
            System.out.println("✗ Type de compte invalide.");
        }
    }

    private static void supprimerCompte() {
        System.out.print("Numéro du compte à supprimer : ");
        String numero = scanner.nextLine();

        CompteBancaire compte = rechercherCompte(numero);
        if (compte != null) {
            listeComptes.remove(compte);
            System.out.println("✓ Compte supprimé avec succès.");
        } else {
            System.out.println("✗ Compte introuvable.");
        }
    }

    private static void afficherTousLesComptes() {
        System.out.println("\n--- Liste des comptes ---");
        if (listeComptes.isEmpty()) {
            System.out.println("Aucun compte disponible.");
        } else {
            for (CompteBancaire compte : listeComptes) {
                System.out.println(compte);
            }
        }
    }

    private static void effectuerDepot() {
        System.out.print("Numéro du compte : ");
        String numero = scanner.nextLine();

        CompteBancaire compte = rechercherCompte(numero);
        if (compte != null) {
            System.out.print("Montant à déposer : ");
            double montant = scanner.nextDouble();
            compte.deposer(montant);
        } else {
            System.out.println("✗ Compte introuvable.");
        }
    }

    private static void effectuerRetrait() {
        System.out.print("Numéro du compte : ");
        String numero = scanner.nextLine();

        CompteBancaire compte = rechercherCompte(numero);
        if (compte != null) {
            System.out.print("Montant à retirer : ");
            double montant = scanner.nextDouble();
            try {
                compte.retirer(montant);
            } catch (FondsInsuffisantsException e) {
                System.out.println("✗ Exception capturée : " + e.getMessage());
                System.out.println("Solde disponible : " + e.getSoldeActuel() + " DH");
                System.out.println("Montant demandé : " + e.getMontantDemande() + " DH");
            }
        } else {
            System.out.println("✗ Compte introuvable.");
        }
    }

    private static void effectuerTransfert() {
        System.out.print("Numéro du compte source : ");
        String numeroSource = scanner.nextLine();

        System.out.print("Numéro du compte destinataire : ");
        String numeroDestinataire = scanner.nextLine();

        CompteBancaire compteSource = rechercherCompte(numeroSource);
        CompteBancaire compteDestinataire = rechercherCompte(numeroDestinataire);

        if (compteSource != null) {
            System.out.print("Montant à transférer : ");
            double montant = scanner.nextDouble();

            try {
                compteSource.transferer(montant, compteDestinataire);
            } catch (FondsInsuffisantsException e) {
                System.out.println("✗ Exception : " + e.getMessage());
                System.out.println("Solde disponible : " + e.getSoldeActuel() + " DH");
            } catch (CompteInexistantException e) {
                System.out.println("✗ Exception : " + e.getMessage());
                System.out.println("Compte recherché : " + numeroDestinataire);
            }
        } else {
            System.out.println("✗ Compte source introuvable.");
        }
    }

    private static void afficherSoldeCompte() {
        System.out.print("Numéro du compte : ");
        String numero = scanner.nextLine();

        CompteBancaire compte = rechercherCompte(numero);
        if (compte != null) {
            compte.afficherSolde();
        } else {
            System.out.println("✗ Compte introuvable.");
        }
    }

    private static void calculerInteretsEpargne() {
        System.out.print("Numéro du compte épargne : ");
        String numero = scanner.nextLine();

        CompteBancaire compte = rechercherCompte(numero);
        if (compte instanceof CompteEpargne) {
            ((CompteEpargne) compte).calculerInterets();
        } else if (compte != null) {
            System.out.println("✗ Ce compte n'est pas un compte épargne.");
        } else {
            System.out.println("✗ Compte introuvable.");
        }
    }

    private static CompteBancaire rechercherCompte(String numero) {
        for (CompteBancaire compte : listeComptes) {
            if (compte.getNumeroCompte().equals(numero)) {
                return compte;
            }
        }
        return null;
    }
}