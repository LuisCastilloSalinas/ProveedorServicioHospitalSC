package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import webservices.ObtenerMedicosMasSolicitadosWS;
import webservices.ObtenerPacienteMasAtendidoWS;
import webservices.ObtenerPorcentajeOcupacionBoxWS;
import webservices.ObtenerPorcentajeOcupacionMedicoWS;

public class ReporteTest {

	@Test
	public void testObtenerMedicosMasSolicitados() {
		ObtenerMedicosMasSolicitadosWS medS = new ObtenerMedicosMasSolicitadosWS();
		DateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date fecha1 = null;
		Date fecha2 = null;
		try {
			fecha1 = fechaFormat.parse("2015-01-01");
			fecha2 = fechaFormat.parse("2015-12-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(!medS.obtenerMedicoMasSolicitado(fecha1, fecha2)
				.equals("[]"));
	}

	@Test
	public void testPacienteMasAtendido() {
		ObtenerPacienteMasAtendidoWS pac = new ObtenerPacienteMasAtendidoWS();
		DateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date fecha1 = null;
		Date fecha2 = null;
		try {
			fecha1 = fechaFormat.parse("2015-01-01");
			fecha2 = fechaFormat.parse("2015-12-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(!pac.pacienteMasAtendido(fecha1, fecha2).equals("[]"));

	}

	@Test
	public void testObtenerPorcentajeOcupacionBox() {
		ObtenerPorcentajeOcupacionBoxWS pBox = new ObtenerPorcentajeOcupacionBoxWS();
		DateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
		int idBox = 2;
		Date fecha1 = null;
		Date fecha2 = null;
		try {
			fecha1 = fechaFormat.parse("2015-01-01");
			fecha2 = fechaFormat.parse("2015-12-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(pBox.obtenerPorcentajeOcupacionBox(idBox, fecha1, fecha2) > 0);

	}

	@Test
	public void testObtenerPorcentajeOcupacionMedico() {
		ObtenerPorcentajeOcupacionMedicoWS pMed = new ObtenerPorcentajeOcupacionMedicoWS();
		int idMedico = 2;
		DateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date fecha1 = null;
		Date fecha2 = null;
		try {
			fecha1 = fechaFormat.parse("2015-01-01");
			fecha2 = fechaFormat.parse("2015-12-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(pMed.obtenerPorcentajeOcupacionMedico(idMedico, fecha1, fecha2)>0);

	}

}
