package ucam.poo.mision.flota;

public class Satelite extends CargaUtil {
	private double combustibleManiobra;

    public Satelite(String nombre, double masa, double combustibleManiobra) {
        super(nombre, masa);
        
        this.combustibleManiobra = combustibleManiobra;
    }

    private static boolean validarCombustible(double combustible) {
        return combustible >= 0 && Double.isFinite(combustible);
    }

    public double getCombustibleManiobra() {
        return combustibleManiobra;
    }

    public boolean setCombustibleManiobra(double combustibleManiobra) {
        if (validarCombustible(combustibleManiobra)) {
            this.combustibleManiobra = combustibleManiobra;
            return true;
        }
        return false;
    }

    @Override
    public double getMasaEfectiva() {
        return getMasa() + combustibleManiobra;
    }

    @Override
    public String toString() {
        return super.toString() + " [Satélite - Combustible de maniobra: " + combustibleManiobra + " kg, Masa efectiva: " + getMasaEfectiva() + " kg]";
    }

}