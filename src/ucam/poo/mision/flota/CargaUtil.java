package ucam.poo.mision.flota;

import java.util.Objects;

public abstract class CargaUtil {
	
	private static int numIdentificador = 0;
	
	private final String identificador;
    private String nombre;
    private double masa;

    protected CargaUtil(String nombre, double masa) {
        
    	numIdentificador++;
        this.identificador = "CAR-" + numIdentificador;

        this.nombre = nombre;
        this.masa = masa;
    }


    protected static boolean validarTexto(String texto) {
        return texto != null && !texto.isBlank();
    }

    protected static boolean validarMasa(double masa) {
        return masa > 0 && Double.isFinite(masa);
    }
    
    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }
    
    public boolean setNombre(String nombre) {
        if (validarTexto(nombre)) {
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public double getMasa() {
        return masa;
    }

    public boolean setMasa(double masa) {
        if (validarMasa(masa)) {
            this.masa = masa;
            return true;
        }
        return false;
    }

    public abstract double getMasaEfectiva();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargaUtil cargaUtil = (CargaUtil) o;
        return Objects.equals(identificador, cargaUtil.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return "Carga [" + identificador + "] " + nombre + " - Masa: " + masa + " kg";
    }

}