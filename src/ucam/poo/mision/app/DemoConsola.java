package ucam.poo.mision.app;

import ucam.poo.mision.tripulacion.*;

public class DemoConsola {
	
	public static void demoListaAstronautas() {
		AstronautaDeCarrera astronauta1 = new AstronautaDeCarrera("Pedro","Duque",null, 1990,Tripulante.Especialidad.COMANDANTE,new String[] {"Insulina"},null,null,250,2);
		AstronautaDeCarrera astronauta2 = new AstronautaDeCarrera("Paco","Fernandez","Orihuela",1997,Tripulante.Especialidad.PILOTO,null,null,null,320,3);
		AstronautaInvitado astronauta3 = new AstronautaInvitado("Isabel","García","Sánchez",1990,Tripulante.Especialidad.PILOTO,new String[] {"Gafas","Vitamina D"},null,null,420);
		AstronautaFormacion astronauta4 = new AstronautaFormacion("Ana","Pascual","Riquelme", 2002,Tripulante.Especialidad.INGENIERO,null,null,null,250,2);
		AstronautaDeCarrera astronauta5 = new AstronautaDeCarrera("Omar","Santana","Fuentes",1997,Tripulante.Especialidad.MEDICO,null,new Tripulante[] {astronauta3},new Tripulante[] {astronauta2},320,4);
		AstronautaDeCarrera astronauta6 = new AstronautaDeCarrera("Lucía", "Navarro", "Soler", 1992,Tripulante.Especialidad.INGENIERO, new String[] {"Alergia al polen"}, null, new Tripulante[] {astronauta4}, 480, 5);
		AstronautaInvitado astronauta7 = new AstronautaInvitado("Jorge", "Molina", "Rey", 1988,Tripulante.Especialidad.CIENTIFICO, null, new Tripulante[] {astronauta5}, null, 390);
		AstronautaFormacion astronauta8 = new AstronautaFormacion("Carla", "Vega", "Núñez", 2001, Tripulante.Especialidad.PILOTO, new String[] {"Gafas"}, new Tripulante[] {astronauta2}, new Tripulante[] {astronauta1}, 180, 3);
		AstronautaDeCarrera astronauta9 = new AstronautaDeCarrera("Daniel", "Serrano", "Gil", 1985,Tripulante.Especialidad.COMANDANTE,null, new Tripulante[] {astronauta3}, new Tripulante[] {astronauta6},720, 8);
		AstronautaInvitado astronauta10 = new AstronautaInvitado("Nerea", "Campos", "León", 1995, Tripulante.Especialidad.MEDICO, new String[] {"Vitamina D"}, null, new Tripulante[] {astronauta5},310);
		Tripulante [] tripulantes = new Tripulante[] {astronauta1,astronauta2, astronauta3,astronauta4,astronauta5,astronauta6,astronauta7,astronauta8,astronauta9,astronauta10};

		String[] necesidades = {};
		Tripulante[] incompatibles = {};
		Tripulante[] preferentes = {};
		
		
		for (int i=0;i<tripulantes.length;i++) {
			necesidades = tripulantes[i].getNecesidades();
			incompatibles = tripulantes[i].getIncompatibles();
			preferentes = tripulantes[i].getPreferentes();
			System.out.println("Nombre y Apellidos: " + tripulantes[i].getNombre() + " " + tripulantes[i].getApellido1() + " " + tripulantes[i].getApellido2());
			System.out.println("\t"+"ID: " + tripulantes[i].getId());
			System.out.print("\t"+"Tipo de Astronauta: ");
			if(tripulantes[i] instanceof AstronautaFormacion) {
				System.out.println("Astronauta en Formación");
			}
			else if(tripulantes[i] instanceof AstronautaDeCarrera) {
				System.out.println("Astronauta de Carrera");
			}
			else System.out.println("Astronauta invitado");
			System.out.println("\t"+"Año de nacimiento: " + tripulantes[i].getAnyoNacimiento());
			System.out.println("\t"+"Especialidad: " + tripulantes[i].getEspecialidad());
			System.out.println("\t"+"Necesidades: ");
			if (necesidades != null) {
				
				for (int j = 0; j < necesidades.length; j++) {
					System.out.println("\t\t" +necesidades[j]);
				}
			}
			System.out.println("\t"+"Astronautas Incompatibles: ");
			if (incompatibles != null) {
				
				for (int j = 0; j < incompatibles.length; j++) {
					System.out.println("\t\t" +incompatibles[j].getNombre() + " " +incompatibles[j].getApellido1()+ " con ID: " + incompatibles[j].getId());
				}
			}
			
			System.out.println("\t"+"Astronautas Preferentes: ");
			if (preferentes != null) {
				
				for (int j = 0; j < preferentes.length; j++) {
					System.out.println("\t\t" +preferentes[j].getNombre() + " " +preferentes[j].getApellido1()+ " con ID: " + preferentes[j].getId());
				}
			}
			System.out.println("\t"+"Horas de vuelo: " + tripulantes[i].getHorasVuelo());
			if(tripulantes[i] instanceof AstronautaDeCarrera) {
				AstronautaDeCarrera astronauta = (AstronautaDeCarrera) tripulantes[i];
				System.out.println("\t"+"Misiones Completadas: " + astronauta.getMisionesCompletadas());
			}
			if(tripulantes[i] instanceof AstronautaFormacion) {
				AstronautaFormacion astronauta = (AstronautaFormacion) tripulantes[i];
				System.out.println("\t"+"Horas en simulador: " + astronauta.getHorasSimulador());
			}
			System.out.println("\t"+"Experiencia computable: " + tripulantes[i].getExperienciaComputable());
			
			
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demoListaAstronautas();

	}
}
