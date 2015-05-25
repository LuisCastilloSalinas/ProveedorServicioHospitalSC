package webservices;

import java.sql.Timestamp;
import java.util.Date;

import org.orm.PersistentException;

import orm.HoraMedicaCriteria;
import orm.MedicoCriteria;
import orm.ReservaCriteria;

public class ObtenerPorcentajeOcupacionMedicoWS {

	public ObtenerPorcentajeOcupacionMedicoWS() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo para la obtencion
	 * del porcentaje de ocupacion 
	 * de un medico determinado.
	 * El resultado es entregado en formato 
	 * de numero de tipo int.
	 * @param idMedico
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public int obtenerPorcentajeOcupacionMedico(int idMedico,Date fecha1,Date fecha2){
		int porcentaje=0;
		try {
			ReservaCriteria resCriteria = new ReservaCriteria();
			HoraMedicaCriteria horCriteria = resCriteria.createReserva_hora_medicaCriteria();
			horCriteria.fecha.between(new Timestamp(fecha1.getTime()),new Timestamp(fecha2.getTime()) );
			MedicoCriteria medCriteria = horCriteria.createMedicoid_medicoCriteria();
			medCriteria.id_medico.eq(idMedico);
			int hrsOcupado=resCriteria.list().size();
			
			HoraMedicaCriteria hmCriteria = new HoraMedicaCriteria();
			hmCriteria.fecha.between(new Timestamp(fecha1.getTime()),new Timestamp(fecha2.getTime()) );
			MedicoCriteria medicoCriteria = hmCriteria.createMedicoid_medicoCriteria();
			medicoCriteria.id_medico.eq(idMedico);
			int hrsAsignadas=hmCriteria.list().size();
			if(hrsAsignadas>0){
			porcentaje=hrsOcupado*100/hrsAsignadas;
			}
			
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return porcentaje;
	}
}
