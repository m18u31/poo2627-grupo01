package ucam.poo.mision.tripulacion;

public class AstronautaFormación extends Tripulante {
	
	private int horasSimulador;

	public AstronautaFormación(String nombre, String apellido1, String apellido2, int anyoNacimiento, Especialidad especialidad,
			String[] necesidades, Tripulante[] incompatibles, Tripulante[] preferentes, int horasVuelo, int horasSimulador,
			int experienciaComputable) {
		super(nombre, apellido1, apellido2, anyoNacimiento, especialidad, necesidades, incompatibles, preferentes, horasVuelo,
				experienciaComputable);
		this.horasSimulador = horasSimulador;
		// TODO Auto-generated constructor stub
	}

	public int getExperienciaComputable() {
		// TODO Auto-generated method stub
		return getHorasVuelo() + (getHorasSimulador() * 100);
	}
		

	public int getHorasSimulador() {
		return horasSimulador;
	}

	public void setHorasSimulador(int horasSimulador) {
		this.horasSimulador = horasSimulador;
	}

}
