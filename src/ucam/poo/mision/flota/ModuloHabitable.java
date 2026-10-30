package ucam.poo.mision.flota;

//Representa un módulo habitable
public class ModuloHabitable extends CargaUtil {
	
	// Masa adicional de soporte vital por cada plaza.
	public static final double KG_SOPORTE_VITAL_POR_PLAZA = 250.0;
    private int plazas;

 // Constructor del módulo habitable.
    public ModuloHabitable(String identificador, String nombre, double masa, int plazas) {
        super(identificador, nombre, masa);
        
        this.plazas = plazas;
    }

 // Comprueba que haya al menos una plaza.
    private static boolean validarPlazas(int plazas) {
        return plazas > 0;
    }

    public int getPlazas() {
        return plazas;
    }

 // Modifica el número de plazas si el valor es válido
    public boolean setPlazas(int plazas) {
        if (validarPlazas(plazas)) {
            this.plazas = plazas;
            return true;
        }
        return false;
    }

    // Calcula la masa efectiva añadiendo el soporte vital de las plazas.
    @Override
    public double getMasaEfectiva() {
        return getMasa() + (plazas * KG_SOPORTE_VITAL_POR_PLAZA);
    }

 // Devuelve la información del módulo habitable.
    @Override
    public String toString() {
        return super.toString() + " [Módulo Habitable - Plazas: " + plazas + ", Efectiva: " + getMasaEfectiva() + " kg]";
    }

}