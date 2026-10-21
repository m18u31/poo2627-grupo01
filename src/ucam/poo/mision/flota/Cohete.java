package ucam.poo.mision.flota;

public class Cohete {
	private String codigo;
	private String modelo;
	private double capacidadCargaMaxima;
	private int plazas;
	private boolean reutilizable;
	private EstadoCohete estado;
	
	public Cohete(String codigo, String modelo, double capacidadCargaMaxima,
			int plazas, boolean reutilizable, EstadoCohete estado) {
		this.codigo = codigo;
		this.modelo = modelo;
		this.capacidadCargaMaxima = capacidadCargaMaxima;
		this.plazas = plazas;
		this.reutilizable = reutilizable;
		this.estado = estado;	
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public double getcapacidadCargaMaxima() {
		return capacidadCargaMaxima;
	}
	
	public void setCapacidadCargaMaxima(double capacidadCargaMaxima) {
		this.capacidadCargaMaxima = capacidadCargaMaxima;
	}
	
	public int getPlazas() {
		return plazas;
	}
	
	public void setPlazas(int plazas) {
		this.plazas = plazas;
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
	
	public void setEstado (EstadoCohete estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Cohete [" + codigo + "-" + modelo + "] Estado: " + estado + ", Capcidad: " + capacidadCargaMaxima + " Kg, Plazas: " + plazas;	
		}
	

}
