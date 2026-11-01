package ucam.poo.mision.flota;

public class Sonda extends CargaUtil {
	private double combustibleTrayectoria;
    private String destino;

    public Sonda(String nombre, double masa, double combustibleTrayectoria, String destino) {
        super(nombre, masa);
        
        this.combustibleTrayectoria = combustibleTrayectoria;
        this.destino = destino;
    }

    private static boolean validarCombustible(double combustible) {
        return combustible >= 0 && Double.isFinite(combustible);
    }

    public double getCombustibleTrayectoria() {
        return combustibleTrayectoria;
    }

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

    public boolean setDestino(String destino) {
        if (validarTexto(destino)) {
            this.destino = destino;
            return true;
        }
        return false;
    }

    @Override
    public double getMasaEfectiva() {
        return getMasa() + combustibleTrayectoria;
    }

    @Override
    public String toString() {
        return super.toString() + " [Sonda - Destino: " + destino + ", Combustible: " + combustibleTrayectoria + " kg, Efectiva: " + getMasaEfectiva() + " kg]";
    }

}