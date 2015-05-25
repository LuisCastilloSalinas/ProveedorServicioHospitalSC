package test;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import webservices.BoxWS;
import webservices.BuscarHoraAPSWS;
import webservices.BuscarSuDisponibilidadDeHoraWS;
import webservices.EspecialidadWS;
import webservices.MedicoEspecialidadWS;
import webservices.MedicoWS;

public class BuscarTest {

	@Test
	public void testObtenerBoxMedicos() {
		BoxWS b = new BoxWS();
		assertTrue(!b.obtenerBoxMedicos().equals("[]"));
		
	}
	
	
	@Test
	public void testObtenerHoraAPS(){
		BuscarHoraAPSWS horaAPS = new BuscarHoraAPSWS();
		int idMedico=3;
		DateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha1=null;
		Date fecha2=null;
		try {
			fecha1 = fechaFormat.parse("2015-01-01");
			
			
			fecha2 = fechaFormat.parse("2015-12-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(!horaAPS.obtenerHoraAPS(idMedico, fecha1, fecha2).equals("[]"));
		
	}
	
	@Test
	public void testGetDisponibilidadDeHora(){
		BuscarSuDisponibilidadDeHoraWS buscaHora = new BuscarSuDisponibilidadDeHoraWS();
		
		int idMedico=3;
		DateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha1=null;
		Date fecha2=null;
		try {
			fecha1 = fechaFormat.parse("2015-01-01");
			fecha2 = fechaFormat.parse("2015-12-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertTrue(!buscaHora.getDisponibilidadDeHora(idMedico, fecha1, fecha2).equals("[]"));
		
	}
	

	@Test
	public void testObtenerEspecialidades(){
		EspecialidadWS es = new EspecialidadWS();
		assertTrue(!es.obtenerEspecialidad().equals("[]"));
		
	}
	
	@Test
	public void testObtenerMedicosPorEspecialidad(){
		MedicoEspecialidadWS med = new MedicoEspecialidadWS();
		assertTrue(!med.obtenerMedicosPorEspecialidad(3).equals("[]"));
		
	}
	
	@Test
	public void testObtenerMedicos(){
		MedicoWS med = new MedicoWS();
		assertTrue(!(med.obtenerMedicos()).equals("[]"));
		
	}

}
