package webservices;

import java.util.ArrayList;
import java.util.List;

import orm.Especialidad;
import orm.EspecialidadDAO;
import vo.EspecialidadVO;

import com.google.gson.Gson;

public class EspecialidadWS {
	public EspecialidadWS() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * Metodo para obtener las especialidades
	 * existentes.
	 * Son retornadas en un Objeto JSon en forma
	 * de String 
	 * @return
	 */
	public String obtenerEspecialidad() {
		
		String out = "";
		
		try {
			List<Especialidad> lista =	EspecialidadDAO.queryEspecialidad(null, null);
			
			com.google.gson.Gson gson = new com.google.gson.Gson();
			
			List<EspecialidadVO> especialidadesVO = new ArrayList<EspecialidadVO>();
			
			for(int i=0;i<lista.size();i++){
				Especialidad especialidad = lista.get(i);
				especialidadesVO.add(EspecialidadVO.obtenerEspecialidadVO(especialidad));
				
			}
			
			out = gson.toJson(especialidadesVO);
		} catch (Exception e) {
			
		}
		
		return out;
		
	}
}
