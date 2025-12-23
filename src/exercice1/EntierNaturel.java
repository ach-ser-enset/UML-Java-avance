package exercice1;

public class EntierNaturel {
    private int val;

    // Constructeur
    public EntierNaturel(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("Impossible de créer un entier naturel avec une valeur négative", val);
        }
        this.val = val;
    }

    // Accesseur en lecture
    public int getVal() {
        return val;
    }

    // Accesseur en écriture
    public void setVal(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException("Impossible d'affecter une valeur négative à un entier naturel", val);
        }
        this.val = val;
    }

    // Méthode pour décrémenter
    public void decrementer() throws NombreNegatifException {
        if (val - 1 < 0) {
            throw new NombreNegatifException("La décrémentation produirait un nombre négatif", val - 1);
        }
        val--;
    }

    @Override
    public String toString() {
        return "EntierNaturel{val=" + val + "}";
    }
}