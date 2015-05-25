package test;

import static org.junit.Assert.*;

import org.junit.Test;

import webservices.ReservarHoraAPSWS;
import webservices.ReservarHoraMedicaControlWS;

public class ReservaTest {

	@Test
	public void testReservarHoraAPS() {
		ReservarHoraAPSWS res = new ReservarHoraAPSWS();
		
		int idPaciente=1;
		int idHoraMedicaAPS=16;
		
		assertTrue(!res.reservarHoraAPS(idHoraMedicaAPS, idPaciente).equals(""));
	}
	
	@Test
	
	public void testReservarHoraMedicaControl(){
		ReservarHoraMedicaControlWS resC = new ReservarHoraMedicaControlWS();
		int horaMedicaID []={19};
		int idPaciente=1;
		assertTrue(!resC.reservarHoraMedicaControl(horaMedicaID, idPaciente).equals(""));
		
	}

}
