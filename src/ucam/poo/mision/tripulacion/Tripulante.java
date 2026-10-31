package ucam.poo.mision.tripulacion;

public abstract class Tripulante {
	// Declaramos la especialidad como enumeración
	public enum Especialidad {
		COMANDANTE,
		PILOTO,
		INGENIERO,
		MEDICO,
		CIENTIFICO
	}
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int anyoNacimiento;
	private Especialidad especialidad;
	private String[] necesidades;
	private Tripulante[] incompatibles;
	private Tripulante[] preferentes;
	private int horasVuelo;
	private int experienciaComputable;
	private final String prefijoID = "AST-";
	private static int numID=0;
	
		
	

	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido1() {
		return apellido1;
	}




	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}




	public String getApellido2() {
		return apellido2;
	}




	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}




	public int getAnyoNacimiento() {
		return anyoNacimiento;
	}




	public void setAnyoNacimiento(int anyoNacimiento) {
		this.anyoNacimiento = anyoNacimiento;
	}
	
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}




	public String[] getNecesidades() {
		return necesidades;
	}




	public void setNecesidades(String[] necesidades) {
		this.necesidades = necesidades;
	}




	public Tripulante[] getIncompatibles() {
		return incompatibles;
	}




	public void setIncompatibles(Tripulante[] incompatibles) {
		this.incompatibles = incompatibles;
	}




	public Tripulante[] getPreferentes() {
		return preferentes;
	}




	public void setPreferentes(Tripulante[] preferentes) {
		this.preferentes = preferentes;
	}




	public int getHorasVuelo() {
		return horasVuelo;
	}




	public void setHorasVuelo(int horasVuelo) {
		this.horasVuelo = horasVuelo;
	}




	public abstract int getExperienciaComputable();




	public void setExperienciaComputable(int experienciaComputable) {
		this.experienciaComputable = experienciaComputable;
	}




	public static int getNumID() {
		return numID;
	}




	public static void setNumID(int numID) {
		Tripulante.numID = numID;
	}

	public String getPrefijoID() {
		return prefijoID;
	}

	public String getId() {
			
		return prefijoID.concat(String.valueOf(numID));
	}


	public Tripulante(String nombre, String apellido1, String apellido2, int anyoNacimiento, Especialidad especialidad, String[] necesidades,
			Tripulante[] incompatibles, Tripulante[] preferentes, int horasVuelo) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.anyoNacimiento = anyoNacimiento;
		this.especialidad = especialidad;
		this.necesidades = necesidades;
		this.incompatibles = incompatibles;
		this.preferentes = preferentes;
		this.horasVuelo = horasVuelo;
		
	}




	

}
