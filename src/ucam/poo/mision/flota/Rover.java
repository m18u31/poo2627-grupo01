package ucam.poo.mision.flota;

public class Rover extends CargaUtil {
	private double baterias;

    public Rover(String nombre, double masa, double baterias) {
        super(nombre, masa);

        this.baterias = baterias;
    }

    private static boolean validarBaterias(double baterias) {
        return baterias >= 0 && Double.isFinite(baterias);
    }

    public double getBaterias() {
        return baterias;
    }

    public boolean setBaterias(double baterias) {
        if (validarBaterias(baterias)) {
            this.baterias = baterias;
            return true;
        }
        return false;
    }

    @Override
    public double getMasaEfectiva() {
        return getMasa() + baterias;
    }

    @Override
    public String toString() {
        return super.toString() + " [Rover - Baterías: " + baterias + " kg, Efectiva: " + getMasaEfectiva() + " kg]";
    }
}