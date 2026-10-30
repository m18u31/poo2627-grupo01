package ucam.poo.mision.misiones;

public class NoTripulada extends Mision {
	private String centroControl;
	
	public NoTripulada(String codigo, String nombre, TipoMision tipo, String fechaLanzamiento, String cohete, String cargas, String centroControl, double masaTotal) {
		super(codigo, nombre, tipo, fechaLanzamiento, cohete, cargas);
		this.centroControl = centroControl;
		this.setMasaTotal(masaTotal);
	}
	
	public String getCentroControl() {
		return this.centroControl;
	}
	public boolean setCentroControl(String centroControl) {
		if(centroControl == null || centroControl.isBlank()) {
			return false;
		}
		this.centroControl = centroControl;
		return true;
	}
	
	@Override
	public boolean setMasaTotal(double masaTotal) {
		if(masaTotal<0) {
			return false;
		}
		return super.setMasaTotal(masaTotal);
	}
	
}
