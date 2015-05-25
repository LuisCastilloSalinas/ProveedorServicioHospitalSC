package webservices;

import org.orm.PersistentException;

import orm.HoraMedica;
import orm.HoraMedicaDAO;
import orm.Paciente;
import orm.PacienteDAO;
import orm.Reserva;
import orm.ReservaDAO;


public class ReservarHoraMedicaControlWS {

	/**
	 * Metodo para la reserva 
	 * de hora medica de control
	 * por parte de un medico.
	 * El resultado es la entrega 
	 * de el id de la reserva 
	 * en caso de que sea aceptada.
	 * @param horaMedicaID
	 * @param idPaciente
	 * @return
	 */
	public String reservarHoraMedicaControl(int [] horaMedicaID, int idPaciente) {
		String out="";
		
		try{
		for (int i : horaMedicaID) {
			HoraMedica horaMed = HoraMedicaDAO.getHoraMedicaByORMID(i);
			if(horaMed.reservaid_reserva.isEmpty()){
				Paciente p = PacienteDAO.getPacienteByORMID(idPaciente);
				Reserva reserva = new Reserva();
				reserva.setPacienteid_paciente(p);
				reserva.setPersonaid_persona(p.getPersonaid_persona());
				reserva.reserva_hora_medica.add(horaMed);
				ReservaDAO.save(reserva);
				out+=reserva.getId_reserva();
			}
			else{
				
				out="Hora medica no disponible";
			}
			
		}
		}
		catch(PersistentException e){
			
		}
		
		return out;
	}
	
}
