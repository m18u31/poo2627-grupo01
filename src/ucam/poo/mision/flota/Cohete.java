package ucam.poo.mision.flota;

import java.util.Objects; // Sin import Objetcs.equals () y Objects.hash () no se reconocerian

// Representa un cohete de la flota
public class Cohete {
	private final String codigo;
	private String modelo;
	private double capacidadCargaMaxima;
	private int plazas;
	private boolean reutilizable;
	private EstadoCohete estado;
	
	
	// Constructor que crea un cohete con estado inicial disponible
	public Cohete(String codigo, String modelo, double capacidadCargaMaxima, 
			int plazas, boolean reutilizable) {
        
        this.codigo = codigo;
        this.modelo = modelo;
        this.capacidadCargaMaxima = capacidadCargaMaxima;
        this.plazas = plazas;
        this.reutilizable = reutilizable;
        this.estado = EstadoCohete.DISPONIBLE;	
	}
	

	
	private static boolean validarTexto(String texto) {
        return texto != null && !texto.isBlank();
    }  // Comprueba que un texto no sea nulo ni esté vacío

	private static boolean validarCapacidad(double capacidad) {
        return capacidad > 0 && !Double.isNaN(capacidad) && !Double.isInfinite(capacidad);
    } // Comprueba que la capacidad sea positiva y un número válido.
	
    private static boolean validarPlazas(int plazas) {
        return plazas >= 0;
    }  // Comprueba que el número de plazas no sea negativo
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	// Modifica el modelo si el texto es válido.
	public boolean setModelo(String modelo) {
        if (validarTexto(modelo)) {
            this.modelo = modelo;
            return true;
        }
        return false;
    }
	
	public double getCapacidadCargaMaxima() {
		return capacidadCargaMaxima;
	}
	
	 // Modifica la capacidad máxima si el valor es válido.
	public boolean setCapacidadCargaMaxima(double capacidadCargaMaxima) {
        if (validarCapacidad(capacidadCargaMaxima)) {
            this.capacidadCargaMaxima = capacidadCargaMaxima;
            return true;
        }
        return false;
    }
	
	public int getPlazas() {
		return plazas;
	}

	// Modifica el número de plazas si el valor es válido.
	public boolean setPlazas(int plazas) {
        if (validarPlazas(plazas)) {
            this.plazas = plazas;
            return true;
        }
        return false;
    }
	
	public boolean isReutilizable() {
		return reutilizable;
	}
	
	public void setReutilizable(boolean reutilizable) {
	    this.reutilizable = reutilizable;
	}
	
	public EstadoCohete getEstado() {
		return estado;
	}
	
	// // Cambia el estado si no es nulo y el cohete no está retirado
	public boolean setEstado(EstadoCohete nuevoEstado) {
        if (nuevoEstado == null) {
            return false;
        }
        if (this.estado == EstadoCohete.RETIRADO) {
            return false;
        }
        this.estado = nuevoEstado;
        return true;
    }

	 // Compara dos cohetes mediante su código.
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cohete cohete = (Cohete) o;
        return Objects.equals(codigo, cohete.codigo);
    }

	// Genera el código hash a partir del código del cohete.
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
    
 // Devuelve la información principal del cohete.
	@Override
	public String toString() {
		return "Cohete [" + codigo + "-" + modelo + "] Estado: " + estado + ", Capacidad: " + capacidadCargaMaxima + " Kg, Plazas: " + plazas;	
		}
	

}