package exercice1;

public class TestEntierNaturel {
    public static void main(String[] args) {
        System.out.println("=== Test de la classe EntierNaturel ===\n");

        // Test 1 : Création d'un entier naturel valide
        try {
            System.out.println("Test 1 : Création d'un entier naturel avec valeur 5");
            EntierNaturel en1 = new EntierNaturel(5);
            System.out.println("✓ Créé avec succès : " + en1);
            System.out.println("Valeur : " + en1.getVal());
        } catch (NombreNegatifException e) {
            System.out.println("✗ Erreur : " + e);
        }

        // Test 2 : Création d'un entier naturel avec valeur négative
        System.out.println("\nTest 2 : Tentative de création avec valeur -3");
        try {
            EntierNaturel en2 = new EntierNaturel(-3);
            System.out.println("✓ Créé : " + en2);
        } catch (NombreNegatifException e) {
            System.out.println("✗ Exception capturée : " + e.getMessage());
            System.out.println("Valeur erronée mémorisée : " + e.getValeurErronee());
        }

        // Test 3 : Utilisation de setVal avec valeur valide
        try {
            System.out.println("\nTest 3 : Création puis modification avec setVal(10)");
            EntierNaturel en3 = new EntierNaturel(5);
            System.out.println("Valeur initiale : " + en3.getVal());
            en3.setVal(10);
            System.out.println("✓ Nouvelle valeur : " + en3.getVal());
        } catch (NombreNegatifException e) {
            System.out.println("✗ Erreur : " + e);
        }

        // Test 4 : Utilisation de setVal avec valeur négative
        try {
            System.out.println("\nTest 4 : Tentative de setVal(-5)");
            EntierNaturel en4 = new EntierNaturel(3);
            System.out.println("Valeur actuelle : " + en4.getVal());
            en4.setVal(-5);
        } catch (NombreNegatifException e) {
            System.out.println("✗ Exception capturée : " + e.getMessage());
            System.out.println("Valeur erronée mémorisée : " + e.getValeurErronee());
        }

        // Test 5 : Décrémentation normale
        try {
            System.out.println("\nTest 5 : Décrémentation normale");
            EntierNaturel en5 = new EntierNaturel(3);
            System.out.println("Valeur initiale : " + en5.getVal());
            en5.decrementer();
            System.out.println("✓ Après décrémentation : " + en5.getVal());
            en5.decrementer();
            System.out.println("✓ Après 2ème décrémentation : " + en5.getVal());
        } catch (NombreNegatifException e) {
            System.out.println("✗ Erreur : " + e);
        }

        // Test 6 : Décrémentation qui produirait un nombre négatif
        try {
            System.out.println("\nTest 6 : Décrémentation sur 0");
            EntierNaturel en6 = new EntierNaturel(0);
            System.out.println("Valeur actuelle : " + en6.getVal());
            en6.decrementer();
            System.out.println("Après décrémentation : " + en6.getVal());
        } catch (NombreNegatifException e) {
            System.out.println("✗ Exception capturée : " + e.getMessage());
            System.out.println("Valeur erronée qui aurait été produite : " + e.getValeurErronee());
        }

        // Test 7 : Décrémentations successives jusqu'à l'erreur
        try {
            System.out.println("\nTest 7 : Décrémentations successives");
            EntierNaturel en7 = new EntierNaturel(2);
            System.out.println("Valeur de départ : " + en7.getVal());

            for (int i = 0; i < 5; i++) {
                en7.decrementer();
                System.out.println("✓ Après décrémentation " + (i + 1) + " : " + en7.getVal());
            }
        } catch (NombreNegatifException e) {
            System.out.println("✗ Exception capturée : " + e.getMessage());
            System.out.println("Valeur erronée : " + e.getValeurErronee());
        }

        System.out.println("\n=== Fin des tests ===");
    }
}