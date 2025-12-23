package application;

import metier.IMetier;
import metier.MetierProduitImpl;
import model.Produit;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        IMetier<Produit> metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter ce programme");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    afficherProduits(metier);
                    break;
                case 2:
                    rechercherProduit(metier, scanner);
                    break;
                case 3:
                    ajouterProduit(metier, scanner);
                    break;
                case 4:
                    supprimerProduit(metier, scanner);
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 5);

        scanner.close();
    }

    private static void afficherProduits(IMetier<Produit> metier) {
        System.out.println("\n--- Liste des produits ---");
        if (metier.getAll().isEmpty()) {
            System.out.println("Aucun produit disponible.");
        } else {
            for (Produit p : metier.getAll()) {
                System.out.println(p);
            }
        }
    }

    private static void rechercherProduit(IMetier<Produit> metier, Scanner scanner) {
        System.out.print("Entrez l'id du produit : ");
        long id = scanner.nextLong();
        Produit p = metier.findById(id);
        if (p != null) {
            System.out.println("Produit trouvé : " + p);
        } else {
            System.out.println("Aucun produit trouvé avec l'id " + id);
        }
    }

    private static void ajouterProduit(IMetier<Produit> metier, Scanner scanner) {
        System.out.println("\n--- Ajouter un nouveau produit ---");
        System.out.print("Id : ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Marque : ");
        String marque = scanner.nextLine();

        System.out.print("Prix : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Description : ");
        String description = scanner.nextLine();

        System.out.print("Nombre en stock : ");
        int stock = scanner.nextInt();

        Produit p = new Produit(id, nom, marque, prix, description, stock);
        metier.add(p);
        System.out.println("Produit ajouté avec succès !");
    }

    private static void supprimerProduit(IMetier<Produit> metier, Scanner scanner) {
        System.out.print("Entrez l'id du produit à supprimer : ");
        long id = scanner.nextLong();
        metier.delete(id);
        System.out.println("Produit supprimé (si l'id existait).");
    }
}