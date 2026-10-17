package ucam.poo.mision.tripulacion;

public class AstronautaDeCarrera extends Tripulante {
	private int misionesCompletadas;
	
	
	public AstronautaDeCarrera(String nombre, String apellido1, String apellido2, int anyoNacimiento,
			String[] necesidades, Tripulante[] incompatibles, Tripulante[] preferentes, int horasVuelo,
			int experienciaComputable, int misionesCompletadas) {
		super(nombre, apellido1, apellido2, anyoNacimiento, necesidades, incompatibles, preferentes, horasVuelo,
				experienciaComputable);
		this.misionesCompletadas = misionesCompletadas;
		// TODO Auto-generated constructor stub
	}

	

	public int getMisionesCompletadas() {
		return misionesCompletadas;
	}

	@Override
	public int getExperienciaComputable() {
		// TODO Auto-generated method stub
		return getHorasVuelo() + (getMisionesCompletadas() * 100);
	}

	public void setMisionesCompletadas(int misionesCompletadas) {
		this.misionesCompletadas = misionesCompletadas;
	}

	

	
	
	

}
