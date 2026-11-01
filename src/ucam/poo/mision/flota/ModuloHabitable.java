package ucam.poo.mision.flota;

public class ModuloHabitable extends CargaUtil {
	
	public static final double KG_SOPORTE_VITAL_POR_PLAZA = 250.0;
    private int plazas;

    public ModuloHabitable(String nombre, double masa, int plazas) {
        super(nombre, masa);
        
        this.plazas = plazas;
    }

    private static boolean validarPlazas(int plazas) {
        return plazas > 0;
    }

    public int getPlazas() {
        return plazas;
    }

    public boolean setPlazas(int plazas) {
        if (validarPlazas(plazas)) {
            this.plazas = plazas;
            return true;
        }
        return false;
    }

    @Override
    public double getMasaEfectiva() {
        return getMasa() + (plazas * KG_SOPORTE_VITAL_POR_PLAZA);
    }

    @Override
    public String toString() {
        return super.toString() + " [Módulo Habitable - Plazas: " + plazas + ", Efectiva: " + getMasaEfectiva() + " kg]";
    }

}