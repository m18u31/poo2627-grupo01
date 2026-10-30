package ucam.poo.mision.misiones;

public class Tripulada extends Mision {
	private String[] tripulacion;
	
	public Tripulada (String codigo, String nombre, TipoMision tipo, String fechaLanzamiento, String cohete, String cargas, double masaTotal, String[] tripulacion) {
		super(codigo, nombre, tipo, fechaLanzamiento, cohete, cargas);
		this.asignarTripulacion(fechaLanzamiento, tripulacion);
		this.setMasaTotal(masaTotal);
	}
	
	@Override
	public boolean setMasaTotal(double masaTotal) {
		if(masaTotal<0) {
			return false;
		}
		return super.setMasaTotal(masaTotal + calculaNumAstronautas(tripulacion) * 120);
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
		int i;
		for(i=0; i<tripulacion.length; i++) {
			this.tripulacion[i] = tripulacion[i];
		}
		this.lineaBitacora(fecha + ": Tripulación asignada.");
	}
	
}


