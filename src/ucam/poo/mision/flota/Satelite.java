package ucam.poo.mision.flota;

//Representa un satélite que utiliza combustible para maniobras.
public class Satelite extends CargaUtil {
	private double combustibleManiobra;

	// Constructor del satélite.
    public Satelite(String identificador, String nombre, double masa, double combustibleManiobra) {
        super(identificador, nombre, masa);
        
        this.combustibleManiobra = combustibleManiobra;
    }

    // Comprueba que el combustible no sea negativo ni infinito.
    private static boolean validarCombustible(double combustible) {
        return combustible >= 0 && Double.isFinite(combustible);
    }

    public double getCombustibleManiobra() {
        return combustibleManiobra;
    }

    // Modifica el combustible si el valor es válido.
    public boolean setCombustibleManiobra(double combustibleManiobra) {
        if (validarCombustible(combustibleManiobra)) {
            this.combustibleManiobra = combustibleManiobra;
            return true;
        }
        return false;
    }

 // Calcula la masa efectiva sumando el combustible de maniobra.
    @Override
    public double getMasaEfectiva() {
        return getMasa() + combustibleManiobra;
    }

 // Devuelve la información del satélite.
    @Override
    public String toString() {
        return super.toString() + " [Satélite - Combustible de maniobra: " + combustibleManiobra + " kg, Masa efectiva: " + getMasaEfectiva() + " kg]";
    }

}