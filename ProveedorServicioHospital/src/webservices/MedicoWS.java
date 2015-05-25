package webservices;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import orm.Especialidad;
import orm.Medico;
import orm.MedicoDAO;
import vo.MedicoVO;

import com.google.gson.Gson;

public class MedicoWS {

	/**
	 * Metodo para obtener los 
	 * medicos. Este metodo 
	 * devuelve los medicos en un 
	 * objeto Json.
	 * @return
	 */
	public String obtenerMedicos() {
		String out = "";

		try {
			List<Medico> medicos = MedicoDAO.queryMedico(null, null);
			Gson gson = new Gson();
			List<MedicoVO> medicosVO = new ArrayList<MedicoVO>();
			for (int i = 0; i < medicos.size(); i++) {
				Medico medico = medicos.get(i);
				medicosVO.add(MedicoVO.getMedicoVO(medico));
			}
			out = gson.toJson(medicosVO);
		} catch (PersistentException e) {

			e.printStackTrace();
		}
		return out;

	}

	

}
