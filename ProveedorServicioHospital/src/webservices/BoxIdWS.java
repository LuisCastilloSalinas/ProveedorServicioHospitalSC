package webservices;

import org.orm.PersistentException;

import orm.Box;
import orm.BoxDAO;

public class BoxIdWS {

	public String obtenerNombreBoxPorId(int idBox){
		String out="";
		try {
		
		Box b = BoxDAO.getBoxByORMID(idBox);	
		out=b.getDescripcion();	
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return out;
	}
}
