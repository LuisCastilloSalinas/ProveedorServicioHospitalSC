package webservices;

import org.orm.PersistentException;

import orm.HoraMedica;
import orm.HoraMedicaCriteria;
import orm.HoraMedicaDAO;
import orm.Paciente;
import orm.PacienteCriteria;
import orm.PacienteDAO;
import orm.Reserva;
import orm.ReservaCriteria;
import orm.ReservaDAO;

public class ReservarHoraAPSWS {

	public ReservarHoraAPSWS() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo para la reserva de una 
	 * hora medica APS por parte del paciente.
	 * Se devolvera el id de la reserva realizada
	 * en caso de que la reserva 
	 * sea aceptada.
	 * @param idHoraMedicaAPS
	 * @param idPaciente
	 * @return
	 */
	public String reservarHoraAPS (int idHoraMedicaAPS , int idPaciente  ){
		String reserva="";
		
		try {
			HoraMedica horaMed = HoraMedicaDAO.getHoraMedicaByORMID(idHoraMedicaAPS);
			Paciente paciente = PacienteDAO.getPacienteByORMID(idPaciente);
			
			if(horaMed.reservaid_reserva.isEmpty()){
				PacienteCriteria pCriteria = new PacienteCriteria();
				ReservaCriteria rsCriteria = pCriteria.createReservaCriteria();
				HoraMedicaCriteria hCriteria = rsCriteria.createReserva_hora_medicaCriteria();
				hCriteria.fecha.eq(horaMed.getFecha());
				System.out.println(pCriteria.list().size());
				
				Reserva res = new Reserva (); 
				res.setPacienteid_paciente(paciente);
				res.setPersonaid_persona(paciente.getPersonaid_persona());
				res.reserva_hora_medica.add(horaMed);
				ReservaDAO.save(res);
				reserva+=res.getId_reserva();
			}
			
			else {
				reserva="Hora Medica Esta Reservada";
			}
			

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reserva;
	}
}
