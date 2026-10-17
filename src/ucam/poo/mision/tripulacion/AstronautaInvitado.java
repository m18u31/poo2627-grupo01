package ucam.poo.mision.tripulacion;

public class AstronautaInvitado extends Tripulante{

	public AstronautaInvitado(String nombre, String apellido1, String apellido2, int anyoNacimiento, Especialidad especialidad,
			String[] necesidades, Tripulante[] incompatibles, Tripulante[] preferentes, int horasVuelo,
			int experienciaComputable) {
		super(nombre, apellido1, apellido2, anyoNacimiento, especialidad, necesidades, incompatibles, preferentes, horasVuelo,
				experienciaComputable);
		// TODO Auto-generated constructor stub
	}

	public int getExperienciaComputable() {
		// TODO Auto-generated method stub
		return getHorasVuelo();
	}
	
	
	

}
