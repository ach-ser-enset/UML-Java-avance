public class Sommeur implements Runnable {
    private int[] array;
    private int debut, fin;
    private int somme = 0;

    public Sommeur(int[] array, int debut, int fin) {
        this.array = array;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = debut; i < fin; i++) {
            somme += array[i];
        }
    }

    public int getSomme() {
        return somme;
    }
}
