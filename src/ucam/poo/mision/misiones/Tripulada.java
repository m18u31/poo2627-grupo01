package ucam.poo.mision.misiones;

import ucam.poo.mision.flota.*;

public class Tripulada extends Mision {
	private String[] tripulacion;
	
	public Tripulada (String codigo, String nombre, TipoMision tipo, String fechaLanzamiento, Cohete cohete, CargaUtil[] cargas, double masaTotal, String[] tripulacion) {
		super(codigo, nombre, tipo, fechaLanzamiento, cohete, cargas);
		this.asignarTripulacion(fechaLanzamiento, tripulacion);
		this.setMasaTotal(this.calcularMasaTotal());
	}
	
	@Override
	public double calcularMasaTotal() {
		return super.calcularMasaTotal() + calculaNumAstronautas(tripulacion) * 120;
	}
	
	public int calculaNumAstronautas(String[] tripulacion) {
		if(tripulacion == null) {
			return 0;
		}
		
		int i, contador=0;
		for(i=0; i<tripulacion.length; i++){
			if(tripulacion[i] == null) {
				return contador;
			}
			contador++;
		}
		return contador;
	}
	
	public void asignarTripulacion(String fecha, String[] tripulacion) {
		this.tripulacion = tripulacion;
		this.lineaBitacora(fecha + ": Tripulación asignada.");
	}
	
}


