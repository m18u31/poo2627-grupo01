package ucam.poo.mision.flota;

// Representa un rover que utiliza baterías.
public class Rover extends CargaUtil {
	private double baterias;

	 // Constructor del rover.
    public Rover(String identificador, String nombre, double masa, double baterias) {
        super(identificador, nombre, masa);

        this.baterias = baterias;
    }

 // Comprueba que las baterías no tengan una masa negativa o infinita.
    private static boolean validarBaterias(double baterias) {
        return baterias >= 0 && Double.isFinite(baterias);
    }

    public double getBaterias() {
        return baterias;
    }

    // Modifica las baterías si el valor es válido.
    public boolean setBaterias(double baterias) {
        if (validarBaterias(baterias)) {
            this.baterias = baterias;
            return true;
        }
        return false;
    }

 // Calcula la masa efectiva sumando la masa de las baterías.
    @Override
    public double getMasaEfectiva() {
        return getMasa() + baterias;
    }

 // Devuelve la información del rover.
    @Override
    public String toString() {
        return super.toString() + " [Rover - Baterías: " + baterias + " kg, Efectiva: " + getMasaEfectiva() + " kg]";
    }
}