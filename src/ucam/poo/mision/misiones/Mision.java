package ucam.poo.mision.misiones;

//Importar paquetes necesarios del proyecto
import java.time.LocalDate; //Para las fechas
import ucam.poo.mision.flota.*;
import ucam.poo.mision.tripulacion.*;

public abstract class Mision {
	//Atributos
	private String codigo;
	private String nombre;
	private TipoMision tipo;
	private String fechaLanzamiento;
	private Cohete cohete;
	private CargaUtil[] cargas;
	private EstadoMision estado;
	private String[] bitacora; //TODO: Falta generar las lineas de bitacora de muchos sucesos
	private static final int MAX_LINEAS_BITACORA = 100;  //Numero maximo de lineas miestras se use un array (estatico)
	private int indiceBitacora = 0; //Apunta por que linea va
	private double masaTotal;
	
	//Constructor
	public Mision(String codigo, String nombre, TipoMision tipo, String fechaLanzamiento, Cohete cohete, CargaUtil[] cargas) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.cohete = cohete; //Del paquete flota
		this.cargas = cargas; //Del paquete flota
		this.estado = EstadoMision.planificada;
		this.bitacora = new String[MAX_LINEAS_BITACORA]; //Bitacora creada
		lineaBitacora(LocalDate.now() + ": Misión planificada."); //Primera linea
		
	}
	
	//Getters
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public TipoMision getTipo() {
		return this.tipo;
	}
	
	public String getFechaLanzamiento() {
		return this.fechaLanzamiento;
	}
	
	public Cohete getCohete() {
		return this.cohete;
	}
	
	public CargaUtil[] getCargas() {
		return this.cargas;
	}
	
	public EstadoMision getEstado() {
		return this.estado;
	}
	
	public double getMasaTotal() {
		return this.masaTotal;
	}
	
	public String[] getBitacora() {
		return this.bitacora;
	}
	
	//Setters
	public boolean setCodigo(String codigo) {
		if(codigo != null && !codigo.isBlank()) {
			this.codigo = codigo;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setNombre(String nombre) {
		if(nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setTipo(TipoMision tipo) {
		if(tipo != null) { //!tipo.isBlank() daria error porque "" no esta en la enum
			this.tipo = tipo;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setFechaLanzamiento(String fechaLanzamiento) {
		if(fechaLanzamiento != null && !fechaLanzamiento.isBlank()) {
			this.fechaLanzamiento = fechaLanzamiento;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setCohete(Cohete cohete) {
		if(cohete != null) {
			this.cohete = cohete;
			return true;
		} else {
			return false;
		}
	}

	public boolean setCargas(CargaUtil[] cargas) {
		if(cargas != null) {
			this.cargas = cargas;
			return true;
		} else {
			return false;
		}
	}

	public boolean setEstado(EstadoMision estado) {
		if(estado != null) { //!tipo.isBlank() daria error porque "" no esta en la enum
			this.estado = estado;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setMasaTotal(double masaTotal) {
		if(masaTotal < 0) {
			return false;
		}
		this.masaTotal = masaTotal;
		return true;
	}
	
	public boolean lineaBitacora(String linea) {
		if(linea == null || linea.isBlank()) {
			return false;
		}
		this.bitacora[this.indiceBitacora] = linea; //Escribe la entrada en la linea correspondiente
		indiceBitacora++; //Añade una nueva linea
		return true;
	}
	
	public double calcularMasaTotal() {
		int i;
		double masaTotal=0;
		for(i=0; i<cargas.length; i++) { //Recorremos las cargas
			if(cargas[i] == null) { //Con el primer espacio nulo asumimos que ya no hay mas y salimos
				return masaTotal;
			}
			masaTotal = masaTotal + cargas[i].getMasa(); //Se van sumando
		}
		
		return masaTotal;
	}
	
	//Metodos de seguridad
	//1. La masa total de lanzamiento de la misión no supera la capacidad máxima de carga del cohete.
	public boolean seguridadMasas() {
		if(this.masaTotal > cohete.getCapacidadCargaMaxima()) {
			return false;
		}
		return true;
	}
	
	//4. No viajan juntos dos astronautas incompatibles.
	public boolean seguridadIncompatibles() { //TODO: Primero hay que entender como comparar objetos con equals y @Override
		return true;
	}
	
	//5. El cohete está disponible: no está en mantenimiento, ni retirado, ni asignado a otra misión activa (planificada, lista o lanzada).
	public boolean seguridadCohete() {
		if(this.cohete.getEstado() == EstadoCohete.DISPONIBLE) {
			return true;
		}
		
		return false;
	}
	
	//Comprobacion de todo
	public boolean seguridadTotal() {
		if(seguridadMasas() && seguridadIncompatibles() && seguridadCohete()) {
			return true;
		}
		
		return false;
	}
	
	//Cambios de estado de la mision
	public boolean misionLista(boolean seguridad) {
		if(seguridad && this.getEstado() == EstadoMision.planificada) {
			lineaBitacora(LocalDate.now() + ": Cohete asignado.");
			this.cohete.setEstado(EstadoCohete.ASIGNADO);
			lineaBitacora(LocalDate.now() + ": Misión lista.");
			return this.setEstado(EstadoMision.lista);
		}
		return false;
	}
	
	public boolean misionCancelada() {
		if(this.getEstado() == EstadoMision.planificada) {
			lineaBitacora(LocalDate.now() + ": Misión cancelada.");
			return this.setEstado(EstadoMision.cancelada);
		}
		if(this.getEstado() == EstadoMision.lista) {
			lineaBitacora(LocalDate.now() + ":Cohete disponible.");
			this.cohete.setEstado(EstadoCohete.DISPONIBLE);
			lineaBitacora(LocalDate.now() + ": Misión cancelada.");
			return this.setEstado(EstadoMision.cancelada);
		}
		return false;
	}
	
	public boolean misionLanzada() {
		if(this.getEstado() == EstadoMision.lista) {
			lineaBitacora(LocalDate.now() + ": Misión lanzada.");
			return this.setEstado(EstadoMision.lanzada);
		}
		return false;
	}
	
	public boolean misionCompletada() {
		if(this.getEstado() == EstadoMision.lanzada) {
			lineaBitacora(LocalDate.now() + ": Misión completada.");
			if(this.cohete.isReutilizable()) {
				lineaBitacora(LocalDate.now() + ":Cohete disponible.");
				this.cohete.setEstado(EstadoCohete.DISPONIBLE);
			} else {
				lineaBitacora(LocalDate.now() + ":Cohete retirado.");
				this.cohete.setEstado(EstadoCohete.RETIRADO);
			}
			
			return this.setEstado(EstadoMision.completada);
		}
		return false;
	}
	
}
