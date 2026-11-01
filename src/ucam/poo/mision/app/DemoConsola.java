package ucam.poo.mision.app;

import ucam.poo.mision.flota.*;
import ucam.poo.mision.misiones.*;
import ucam.poo.mision.tripulacion.*;

public class DemoConsola {
	
	//Metodo para generar listas de astronautas
	public static Tripulante[] listasAstronautas(int opcion) {
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
		
		switch (opcion) {
		    case 1: //Astronautas incompatibles
		    	return new Tripulante[] {astronauta1,astronauta3,astronauta5};
		    case 2: //Falta piloto
		    	return new Tripulante[] {astronauta1,astronauta4,astronauta6};
		    case 3: //Falta medico
		    	return new Tripulante[] {astronauta1,astronauta2,astronauta3};
		    case 4: //Demasiados astronautas
		    	return new Tripulante[] {astronauta1,astronauta2, astronauta3,astronauta4,astronauta6,astronauta10};
		    case 5: //Grupo correcto
		    	return new Tripulante[] {astronauta8,astronauta9,astronauta10};
		}
		//En caso de error en el switch, se devuelve el grupo correcto
		return new Tripulante[] {astronauta8,astronauta9,astronauta10};
	}
	
	//Metodo para generar listas de cargas
	public static CargaUtil[] listasCargas(int opcion) {
		Satelite satelite = new Satelite("Satelite", 2623.0, 3469.0);
		Sonda sonda = new Sonda("Sonda", 750.0, 104.0, "Luna");
		ModuloHabitable moduloHabitable = new ModuloHabitable("Modulo Habitable N4", 1400.0, 4);
		Rover rover = new Rover("Rover", 953.3, 71.7);
		
		switch (opcion) {
			case 1: //Nada
				return null;    
			case 2: //Solo satelite
		    	return new CargaUtil[] {satelite};
		    case 3: //Solo sonda
		    	return new CargaUtil[] {sonda};
		    case 4: //Todo sin satelite
		    	return new CargaUtil[] {sonda, moduloHabitable, rover};
		    case 5: //Todo
		    	return new CargaUtil[] {satelite, sonda, moduloHabitable, rover};
		}
		//En caso de error en el switch, se devuelve el kit completo
		return new CargaUtil[] {satelite, sonda, moduloHabitable, rover};
	}
	
	public static void main(String[] args) {
		
		int i;
		
		Cohete cohete1 = new Cohete("Delta IV", 1500.0, 3, false);
		Cohete cohete2 = new Cohete("Atlas V", 5000.0, 3, false);
		Cohete cohete3 = new Cohete("Starship", 11000.0, 4, true);
		
		//MISION 1
		System.out.println("-----MISION 1-----");
		
		Tripulada rocky1 = new Tripulada ("Rocky I", TipoMision.orbital, "2026-11-15", cohete1, listasCargas(1), listasAstronautas(1));
		
		System.out.println("1) Aceptando mision " + rocky1.getCodigo() + ": " + rocky1.misionLista(rocky1.seguridadTotal()));
		System.out.println("Reasignando tripulacion a " + rocky1.getCodigo() + ": " + rocky1.asignarTripulacion(listasAstronautas(4)));
		System.out.println("2) Aceptando mision " + rocky1.getCodigo() + ": " + rocky1.misionLista(rocky1.seguridadTotal()));
		System.out.println("Reasignando tripulacion a " + rocky1.getCodigo() + ": " + rocky1.asignarTripulacion(listasAstronautas(5)));
		System.out.println("3) Aceptando mision " + rocky1.getCodigo() + ": " + rocky1.misionLista(rocky1.seguridadTotal()));
		System.out.println("4) Cancelando mision " + rocky1.getCodigo() + ": " + rocky1.misionCancelada());
		
		System.out.println("Bitacora de la mision:");
		for(i=0; i<rocky1.getBitacora().length; i++) {
			if(rocky1.getBitacora()[i] == null) {
				continue;
			}
			System.out.println(rocky1.getBitacora()[i]);
		}
		
		//MISION 2
		System.out.println("-----MISION 2-----");
		
		Tripulada rocky2 = new Tripulada ("Rocky II", TipoMision.lunar, "2026-12-15", cohete1, listasCargas(4), listasAstronautas(2));
		
		System.out.println("1) Aceptando mision " + rocky2.getCodigo() + ": " + rocky2.misionLista(rocky2.seguridadTotal()));
		
		System.out.println("Bitacora de la mision:");
		for(i=0; i<rocky2.getBitacora().length; i++) {
			if(rocky2.getBitacora()[i] == null) {
				continue;
			}
			System.out.println(rocky2.getBitacora()[i]);
		}
		
		//MISION 3
		System.out.println("-----MISION 3-----");
		
		Tripulada rocky3 = new Tripulada ("Rocky III", TipoMision.lunar, "2026-12-15", cohete2, listasCargas(4), listasAstronautas(2));
		
		System.out.println("1) Aceptando mision " + rocky3.getCodigo() + ": " + rocky3.misionLista(rocky3.seguridadTotal()));
		System.out.println("Reasignando tripulacion a " + rocky3.getCodigo() + ": " + rocky3.asignarTripulacion(listasAstronautas(3)));
		System.out.println("2) Aceptando mision " + rocky3.getCodigo() + ": " + rocky3.misionLista(rocky3.seguridadTotal()));
		System.out.println("Reasignando tripulacion a " + rocky3.getCodigo() + ": " + rocky3.asignarTripulacion(listasAstronautas(5)));
		System.out.println("3) Aceptando mision " + rocky3.getCodigo() + ": " + rocky3.misionLista(rocky3.seguridadTotal()));
		System.out.println("4) Lanzando mision " + rocky3.getCodigo() + ": " + rocky3.misionLanzada());
		System.out.println("4) Completando mision " + rocky3.getCodigo() + ": " + rocky3.misionCompletada());
		
		System.out.println("Bitacora de la mision:");
		for(i=0; i<rocky3.getBitacora().length; i++) {
			if(rocky3.getBitacora()[i] == null) {
				continue;
			}
			System.out.println(rocky3.getBitacora()[i]);
		}
		
		//MISION 4
		System.out.println("-----MISION 4-----");
		
		Tripulada rocky4 = new Tripulada ("Rocky IV", TipoMision.estacion_espacial, "2027-01-15", cohete2, listasCargas(4), listasAstronautas(5));
		
		System.out.println("1) Aceptando mision " + rocky4.getCodigo() + ": " + rocky4.misionLista(rocky4.seguridadTotal()));
		
		System.out.println("Bitacora de la mision:");
		for(i=0; i<rocky4.getBitacora().length; i++) {
			if(rocky4.getBitacora()[i] == null) {
				continue;
			}
			System.out.println(rocky4.getBitacora()[i]);
		}
		
		//MISION 5
		System.out.println("-----MISION 5-----");
		
		NoTripulada rocky5 = new NoTripulada ("Rocky V", TipoMision.marciana, "2027-02-15", cohete3, listasCargas(5), "Robledo de Chavela");
		
		System.out.println("1) Aceptando mision " + rocky5.getCodigo() + ": " + rocky5.misionLista(rocky5.seguridadTotal()));
		System.out.println("2) Lanzando mision " + rocky5.getCodigo() + ": " + rocky5.misionLanzada());
		System.out.println("3) Completando mision " + rocky5.getCodigo() + ": " + rocky5.misionCompletada());
		
		System.out.println("Bitacora de la mision:");
		for(i=0; i<rocky5.getBitacora().length; i++) {
			if(rocky5.getBitacora()[i] == null) {
				continue;
			}
			System.out.println(rocky5.getBitacora()[i]);
		}
		
		//MISION 6
		System.out.println("-----MISION 6-----");
		
		NoTripulada rocky6 = new NoTripulada ("Rocky VI", TipoMision.marciana, "2027-03-15", cohete3, listasCargas(5), "Robledo de Chavela");
		
		System.out.println("1) Aceptando mision " + rocky6.getCodigo() + ": " + rocky6.misionLista(rocky6.seguridadTotal()));
		System.out.println("2) Lanzando mision " + rocky6.getCodigo() + ": " + rocky6.misionLanzada());
		System.out.println("3) Completando mision " + rocky6.getCodigo() + ": " + rocky6.misionCompletada());
		
		System.out.println("Bitacora de la mision:");
		for(i=0; i<rocky6.getBitacora().length; i++) {
			if(rocky6.getBitacora()[i] == null) {
				continue;
			}
			System.out.println(rocky6.getBitacora()[i]);
		}
	}
}
