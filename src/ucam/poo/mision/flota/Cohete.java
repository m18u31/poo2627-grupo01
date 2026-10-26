package ucam.poo.mision.flota;

import java.util.Objects; // Sin import Objetcs.equals () y Objects.hash () no se reconocerian

public class Cohete {
	private final String codigo;
	private String modelo;
	private double capacidadCargaMaxima;
	private int plazas;
	private boolean reutilizable;
	private EstadoCohete estado;
	
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
    }

	private static boolean validarCapacidad(double capacidad) {
        return capacidad > 0 && !Double.isNaN(capacidad) && !Double.isInfinite(capacidad);
    }
	
    private static boolean validarPlazas(int plazas) {
        return plazas >= 0;
    }
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
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
	
	public boolean setReutilizable(boolean reutilizable) {
        this.reutilizable = reutilizable;
        return true;
    }
	
	public EstadoCohete getEstado() {
		return estado;
	}
	
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cohete cohete = (Cohete) o;
        return Objects.equals(codigo, cohete.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
	
	@Override
	public String toString() {
		return "Cohete [" + codigo + "-" + modelo + "] Estado: " + estado + ", Capacidad: " + capacidadCargaMaxima + " Kg, Plazas: " + plazas;	
		}
	

}