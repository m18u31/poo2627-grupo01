package ucam.poo.mision.misiones;

public abstract class Mision {
	private String codigo;
	private String nombre;
	private TipoMision tipo;
	private String fechaLanzamiento;
	private String cohete;
	private String cargas;
	private EstadoMision estado;
	private String[] bitacora; //TODO: Falta generar las lineas de bitacora de muchos sucesos
	private static final int MAX_LINEAS_BITACORA = 100;  //Numero maximo de lineas miestras se use un array (estatico)
	private int indiceBitacora = 0;
	private double masaTotal;
	
	public Mision(String codigo, String nombre, TipoMision tipo, String fechaLanzamiento, String cohete, String cargas) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.cohete = cohete;
		this.cargas = cargas;
		this.estado = EstadoMision.planificada;
		this.bitacora = new String[MAX_LINEAS_BITACORA];
		lineaBitacora(fechaLanzamiento + ": Misión planificada.");
		
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
	
	public String getCohete() {
		return this.cohete;
	}
	
	public String getCargas() {
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
	
	public boolean setCohete(String cohete) {
		if(cohete != null && !cohete.isBlank()) {
			this.cohete = cohete;
			return true;
		} else {
			return false;
		}
	}

	public boolean setCargas(String cargas) {
		if(cargas != null && !cargas.isBlank()) {
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
		this.masaTotal = masaTotal;
		return true;
	}
	
	public boolean lineaBitacora(String linea) {
		if(linea == null || linea.isBlank()) {
			return false;
		}
		this.bitacora[this.indiceBitacora] = linea;
		indiceBitacora++;
		return true;
	}
	
	
}
