package ucam.poo.mision.flota;

import java.util.Objects;

//Clase abstracta que representa una carga útil
public abstract class CargaUtil {
	private final String identificador;
    private String nombre;
    private double masa;

 // Constructor común para todos los tipos de carga útil
    protected CargaUtil(String identificador, String nombre, double masa) {
        
        this.identificador = identificador;
        this.nombre = nombre;
        this.masa = masa;
    }


    // Comprueba que un texto no sea nulo ni esté vacío.
    protected static boolean validarTexto(String texto) {
        return texto != null && !texto.isBlank();
    }

 // Comprueba que la masa sea positiva y un número válido.
    protected static boolean validarMasa(double masa) {
        return masa > 0 && Double.isFinite(masa);
    }
    
    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }
    
 // Modifica el nombre si el texto es válido
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

 // Modifica la masa si el valor es válido.
    public boolean setMasa(double masa) {
        if (validarMasa(masa)) {
            this.masa = masa;
            return true;
        }
        return false;
    }

 // Cada tipo de carga calcula su propia masa efectiva.
    public abstract double getMasaEfectiva();

 // Compara dos cargas mediante su identificador y tipo de clase
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargaUtil cargaUtil = (CargaUtil) o;
        return Objects.equals(identificador, cargaUtil.identificador);
    }

 // Genera el código hash a partir del identificador
    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

 // Devuelve la información común de una carga útil
    @Override
    public String toString() {
        return "Carga [" + identificador + "] " + nombre + " - Masa: " + masa + " kg";
    }

}