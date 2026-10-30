package ucam.poo.mision.flota;

//Representa una sonda espacial.
public class Sonda extends CargaUtil {
	private double combustibleTrayectoria;
    private String destino;

 // Constructor de la sonda.
    public Sonda(String identificador, String nombre, double masa, double combustibleTrayectoria, String destino) {
        super(identificador, nombre, masa);
        
        this.combustibleTrayectoria = combustibleTrayectoria;
        this.destino = destino;
    }

    // Comprueba que el combustible sea válido.
    private static boolean validarCombustible(double combustible) {
        return combustible >= 0 && Double.isFinite(combustible);
    }

    public double getCombustibleTrayectoria() {
        return combustibleTrayectoria;
    }

    // Modifica el combustible si el valor es válido.
    public boolean setCombustibleTrayectoria(double combustibleTrayectoria) {
        if (validarCombustible(combustibleTrayectoria)) {
            this.combustibleTrayectoria = combustibleTrayectoria;
            return true;
        }
        return false;
    }

    public String getDestino() {
        return destino;
    }

 // Modifica el destino si el texto es válido.
    public boolean setDestino(String destino) {
        if (validarTexto(destino)) {
            this.destino = destino;
            return true;
        }
        return false;
    }

 // Calcula la masa efectiva sumando el combustible de trayectoria.
    @Override
    public double getMasaEfectiva() {
        return getMasa() + combustibleTrayectoria;
    }

 // Devuelve la información de la sonda.
    @Override
    public String toString() {
        return super.toString() + " [Sonda - Destino: " + destino + ", Combustible: " + combustibleTrayectoria + " kg, Efectiva: " + getMasaEfectiva() + " kg]";
    }

}