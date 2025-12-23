public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] tableau = new int[1000];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }

        int nbThreads = 4;
        int taille = tableau.length / nbThreads;
        Sommeur[] sommeurs = new Sommeur[nbThreads];
        Thread[] threads = new Thread[nbThreads];

        for (int i = 0; i < nbThreads; i++) {
            int debut = i * taille;
            int fin = (i == nbThreads - 1) ? tableau.length : (i + 1) * taille;
            sommeurs[i] = new Sommeur(tableau, debut, fin);
            threads[i] = new Thread(sommeurs[i]);
            threads[i].start();
        }

        int sommeTotale = 0;
        for (int i = 0; i < nbThreads; i++) {
            threads[i].join();
            sommeTotale += sommeurs[i].getSomme();
        }

        System.out.println("Somme totale du tableau : " + sommeTotale);
    }
}
