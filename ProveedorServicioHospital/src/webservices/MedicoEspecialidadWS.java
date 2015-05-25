package webservices;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import orm.Medico;
import orm.MedicoDAO;
import vo.EspecialidadVO;
import vo.MedicoVO;

import com.google.gson.Gson;

public class MedicoEspecialidadWS {

	public MedicoEspecialidadWS() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo para obtener medicos 
	 * segun su especialidad.
	 * Este metodo devolvera los medicos
	 * segun especialidad en un obtjeto
	 * Json.
	 * @param idEspecialidad
	 * @return
	 */
	public String obtenerMedicosPorEspecialidad(int idEspecialidad) {
		String out="";
		
		try {
			List<Medico> medicos = MedicoDAO.queryMedico("especialidadid_especialidad="+idEspecialidad+"", null);
			List<MedicoVO> medicosVO = new ArrayList<MedicoVO>();
			for (int i = 0; i < medicos.size(); i++) {
				Medico medico = medicos.get(i);
				medicosVO.add(MedicoVO.getMedicoVO(medico));
			}
			Gson gson = new Gson();
			out = gson.toJson(medicosVO);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return out;
	}
}
