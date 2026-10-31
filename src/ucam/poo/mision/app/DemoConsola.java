package ucam.poo.mision.app;

import ucam.poo.mision.tripulacion.*;

public class DemoConsola {
	
	static AstronautaDeCarrera astronauta1 = new AstronautaDeCarrera("Pedro","Duque",null, 1990,Tripulante.Especialidad.COMANDANTE,new String[] {"Insulina"},null,null,250,2);
	static AstronautaDeCarrera astronauta2 = new AstronautaDeCarrera("Paco","Fernandez","Orihuela",1997,Tripulante.Especialidad.PILOTO,null,null,null,320,3);
	static AstronautaInvitado astronauta3 = new AstronautaInvitado("Isabel","García","Sánchez",1990,Tripulante.Especialidad.PILOTO,new String[] {"Gafas","Vitamina D"},null,null,420);
	static AstronautaFormacion astronauta4 = new AstronautaFormacion("Ana","Pascual","Riquelme", 2002,Tripulante.Especialidad.INGENIERO,null,null,null,250,2);
	static AstronautaDeCarrera astronauta5 = new AstronautaDeCarrera("Omar","Santana","Fuentes",1997,Tripulante.Especialidad.MEDICO,null,new Tripulante[] {astronauta3},new Tripulante[] {astronauta2},320,4);
	static AstronautaDeCarrera astronauta6 = new AstronautaDeCarrera("Lucía", "Navarro", "Soler", 1992,Tripulante.Especialidad.INGENIERO, new String[] {"Alergia al polen"}, null, new Tripulante[] {astronauta4}, 480, 5);
	static AstronautaInvitado astronauta7 = new AstronautaInvitado("Jorge", "Molina", "Rey", 1988,Tripulante.Especialidad.CIENTIFICO, null, new Tripulante[] {astronauta5}, null, 390);
	static AstronautaFormacion astronauta8 = new AstronautaFormacion("Carla", "Vega", "Núñez", 2001, Tripulante.Especialidad.PILOTO, new String[] {"Gafas"}, new Tripulante[] {astronauta2}, new Tripulante[] {astronauta1}, 180, 3);
	static AstronautaDeCarrera astronauta9 = new AstronautaDeCarrera("Daniel", "Serrano", "Gil", 1985,Tripulante.Especialidad.COMANDANTE,null, new Tripulante[] {astronauta3}, new Tripulante[] {astronauta6},720, 8);
	static AstronautaInvitado astronauta10 = new AstronautaInvitado("Nerea", "Campos", "León", 1995, Tripulante.Especialidad.MEDICO, new String[] {"Vitamina D"}, null, new Tripulante[] {astronauta5},310);
	
	static Tripulante [] tripulantes = new Tripulante[] {astronauta1,astronauta2, astronauta3,astronauta4,astronauta5,astronauta6,astronauta7,astronauta8,astronauta9,astronauta10};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0;i<tripulantes.length;i++) {
				System.out.println(tripulantes[i].getExperienciaComputable());
	}

}
}
