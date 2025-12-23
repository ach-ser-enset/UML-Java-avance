package exercice1;

public class NombreNegatifException extends Exception {
    private int valeurErronee;

    public NombreNegatifException(String message, int valeurErronee) {
        super(message);
        this.valeurErronee = valeurErronee;
    }

    public int getValeurErronee() {
        return valeurErronee;
    }

    @Override
    public String toString() {
        return super.toString() + " - Valeur erronée : " + valeurErronee;
    }
}