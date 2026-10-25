package ucam.poo.mision.misiones;

public class Mision {
	private String codigo;
	private String nombre;
	private TipoMision tipo;
	private String fechaLanzamiento;
	private String cohete;
	private String cargas;
	private EstadoMision estado;
	
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
		if(tipo != null) { //!tipo.isBlank() no es necesario porque "" no esta en la enum
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
		if(estado != null) { //!tipo.isBlank() no es necesario porque "" no esta en la enum
			this.estado = estado;
			return true;
		} else {
			return false;
		}
	}
	
}
