package ucam.poo.mision.misiones;

import java.time.LocalDate;

//Importar paquetes necesarios del proyecto o externos
import ucam.poo.mision.flota.*;

public class NoTripulada extends Mision {
	//Atriburos
	private String centroControl;
	
	//Constructor
	public NoTripulada(String codigo, String nombre, TipoMision tipo, String fechaLanzamiento, Cohete cohete, CargaUtil[] cargas, String centroControl, double masaTotal) {
		super(codigo, nombre, tipo, fechaLanzamiento, cohete, cargas);
		this.setCentroControl(centroControl);
		this.setMasaTotal(this.calcularMasaTotal()); //Calculo de masas de la clase Mision
	}
	
	//Getters
	public String getCentroControl() {
		return this.centroControl;
	}
	
	//Setters
	public boolean setCentroControl(String centroControl) {
		if(centroControl == null || centroControl.isBlank()) {
			return false;
		}
		this.centroControl = centroControl;
		this.lineaBitacora(LocalDate.now() + ": Centro de control asignado."); //Bitacora
		return true;
	}
	
}
