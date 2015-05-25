package webservices;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Projections;
import org.orm.PersistentException;

import orm.HoraMedicaCriteria;
import orm.Paciente;
import orm.PacienteCriteria;
import orm.PacienteDAO;
import orm.ReservaCriteria;
import vo.PacienteOcupacionVO;

import com.google.gson.Gson;

public class ObtenerPacienteMasAtendidoWS {

	public ObtenerPacienteMasAtendidoWS() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo para obtener el paciente
	 * mas atendido. Se entrega el 
	 * resultado en un objeto Json 
	 * utilizando la libreria GSON.
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public String pacienteMasAtendido(Date fecha1, Date fecha2) {
		String out = "";

		try {

			ReservaCriteria reCriteria = new ReservaCriteria();
			HoraMedicaCriteria hmeCriteria = reCriteria
					.createReserva_hora_medicaCriteria();
			hmeCriteria.fecha.between(new Timestamp(fecha1.getTime()),
					new Timestamp(fecha2.getTime()));
			int numerohoras = reCriteria.list().size();

			PacienteCriteria pacienteCriteria = new PacienteCriteria();
			pacienteCriteria.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("id"))));
			ReservaCriteria resCriteria = pacienteCriteria
					.createReservaCriteria();
			HoraMedicaCriteria hmCriteria = resCriteria
					.createReserva_hora_medicaCriteria();
			hmCriteria.fecha.between(new Timestamp(fecha1.getTime()),
					new Timestamp(fecha2.getTime()));

			List<Integer> pacientesID = pacienteCriteria.list();
			List<PacienteOcupacionVO> pacientesVO = new ArrayList<PacienteOcupacionVO>();
			
			
			 int porcentaje =0;
			for (Integer pacienteID : pacientesID) {
				
				HoraMedicaCriteria hCriteria = new HoraMedicaCriteria();
				hCriteria.fecha.between(new Timestamp(fecha1.getTime()),
						new Timestamp(fecha2.getTime()));
				ReservaCriteria rCriteria = hCriteria.createReservaid_reservaCriteria();
				PacienteCriteria pCriteria = rCriteria.createPacienteid_pacienteCriteria();
				pCriteria.id_paciente.eq(pacienteID);
				
				Paciente p = PacienteDAO.getPacienteByORMID(pacienteID);
				 if(numerohoras>0){
				porcentaje=hCriteria.list().size()*100/numerohoras;
				 }
				 PacienteOcupacionVO pVO = new PacienteOcupacionVO();
				 pVO.setIdPaciente(p.getId_paciente());
				 pVO.setNombrePaciente(p.getPersonaid_persona().getNombre());
				 pVO.setPorcentajeOcupacion(porcentaje);
				 pacientesVO.add(pVO);
			}

			
			 Collections.sort(pacientesVO);
			 Gson gson = new Gson();
			 out=gson.toJson(pacientesVO);

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out;

	}

}
