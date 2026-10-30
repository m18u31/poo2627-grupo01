package ucam.poo.mision.misiones;

//Importar paquetes necesarios del proyecto o externos
import java.time.LocalDate; //Para las fechas
import ucam.poo.mision.flota.*;
import ucam.poo.mision.tripulacion.*;
import ucam.poo.mision.tripulacion.Tripulante.Especialidad;

public class Tripulada extends Mision {
	//Atributos
	private Tripulante[] tripulacion;
	
	public Tripulada (String codigo, String nombre, TipoMision tipo, String fechaLanzamiento, Cohete cohete, CargaUtil[] cargas, double masaTotal, Tripulante[] tripulacion) {
		super(codigo, nombre, tipo, fechaLanzamiento, cohete, cargas);
		this.asignarTripulacion(tripulacion);
		this.setMasaTotal(this.calcularMasaTotal()); //Calculo de masas propio sobrescrito con @Override
	}
	
	//Calculo de masas propio sobrescrito con @Override
	@Override
	public double calcularMasaTotal() {
		return super.calcularMasaTotal() + calculaNumAstronautas(tripulacion) * 120;
	}
	
	//Calcular el numero de astronautas asignados a la mision
	public int calculaNumAstronautas(Tripulante[] tripulacion) {
		if(tripulacion == null) {
			return 0;
		}
		
		int i, contador=0;
		for(i=0; i<tripulacion.length; i++){ //Recorremos y sumamos
			if(tripulacion[i] == null) {
				return contador;
			}
			contador++;
		}
		return contador;
	}
	
	//Asignacion de tripulacion
	public void asignarTripulacion(Tripulante[] tripulacion) {
		this.tripulacion = tripulacion;
		this.lineaBitacora(LocalDate.now() + ": Tripulación asignada."); //Bitacora
	}
	
	//Metodos de seguridad
	//2. En una misión tripulada, el número de astronautas no supera las plazas del cohete.
	public boolean seguridadAforo() {
		if(this.tripulacion == null) {
			return false;
		}
		if(this.calculaNumAstronautas(this.tripulacion) > this.getCohete().getPlazas()) {
			return false;
		}
		return true;
	}
	
	//3. Toda misión tripulada incluye al menos un comandante y un piloto.
	public boolean seguridadComPil() {
		if(this.tripulacion == null) {
			return false;
		}
		
		int i, coms=0, pils=0;
		for(i=0; i<tripulacion.length; i++) {
			if(this.tripulacion[i].getEspecialidad() == Especialidad.COMANDANTE) {
				coms++;
			}
			if(this.tripulacion[i].getEspecialidad() == Especialidad.PILOTO) {
				pils++;
			}
		}
		
		if(coms>0 && pils>0) {
			return true;
		}
		
		return false;
	}
	
	//6. Toda misión tripulada incluye al menos un médico.
	public boolean seguridadMedico() {
		if(this.tripulacion == null) {
			return false;
		}
			
		int i, medicos=0;
		for(i=0; i<tripulacion.length; i++) {
			if(this.tripulacion[i].getEspecialidad() == Especialidad.MEDICO) {
				medicos++;
			}
		}
		
		if(medicos>0) {
			return true;
		}
		
		return false;
	}
	
	//Comprobacion propia de todo sobrescrita con @Override
	@Override
	public boolean seguridadTotal() {
		//A lo comprobado en Mision, le añadimos tres sistemas de seguridad propios de Tripulada
		if(super.seguridadTotal() && seguridadAforo() && seguridadComPil() && seguridadMedico()) {
			return true;
		}
		
		return false;
	}
}


