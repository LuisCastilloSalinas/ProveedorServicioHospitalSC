package webservices;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.orm.PersistentException;

import orm.HoraMedicaCriteria;
import orm.Medico;
import orm.MedicoCriteria;
import orm.MedicoDAO;
import orm.ReservaCriteria;
import vo.MedicoOcupacionVO;

import com.google.gson.Gson;

public class ObtenerMedicosMasSolicitadosWS {
	public ObtenerMedicosMasSolicitadosWS() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo para obtener los medicos 
	 * mas solicitados por los pacientes.
	 * Se devuelve en forma de objeto json.
	 * 
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public String obtenerMedicoMasSolicitado(Date fecha1,Date fecha2){
		String out="";
		
		try {
			
			MedicoCriteria medCriteria = new MedicoCriteria();
			HoraMedicaCriteria horaMedCriteria = medCriteria.createHora_medicaCriteria();
			horaMedCriteria.fecha.between(new Timestamp(fecha1.getTime()),new Timestamp(fecha2.getTime()));
			ReservaCriteria resCriteria = horaMedCriteria.createReservaid_reservaCriteria();
			
			
			List <Medico> medicos = medCriteria.list();
			List <MedicoOcupacionVO> medicosVO = new ArrayList<MedicoOcupacionVO>();
			ObtenerPorcentajeOcupacionMedicoWS ocupacionMed = new ObtenerPorcentajeOcupacionMedicoWS();
			HashMap<Integer, Integer> hmap = new HashMap<Integer,Integer>();
			for (Medico medico : medicos) {
				int porcentaje=ocupacionMed.obtenerPorcentajeOcupacionMedico(medico.getId_medico(), fecha1, fecha2);
				hmap.put(porcentaje, medico.getId_medico());
				
			}
			Map<Integer, Integer> map = new TreeMap<Integer,Integer>(hmap);
			 
			 Set set = map.entrySet();
	         Iterator iterator2 = set.iterator();
	         while(iterator2.hasNext()) {
	              Map.Entry me2 = (Map.Entry)iterator2.next();
	              Medico med =MedicoDAO.getMedicoByORMID((Integer) me2.getValue());
	              MedicoOcupacionVO medicoVO = new MedicoOcupacionVO();
	              medicoVO.setId(med.getId_medico());
	              medicoVO.setNombre(med.getPersonaid_persona().getNombre());
	              medicoVO.setPorcentajeOcupacion((Integer) me2.getKey());
	              
	              medicosVO.add(medicoVO);
	              
	         }
			
			
			List <MedicoOcupacionVO>  voMedicos = new ArrayList<MedicoOcupacionVO>();
			for (MedicoOcupacionVO voMedico : medicosVO) {
			
					voMedicos.add(voMedico);
				
			}
		
			Collections.sort(voMedicos);
			Gson gson = new Gson();
			out=gson.toJson(voMedicos);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		return out;
	}
}
