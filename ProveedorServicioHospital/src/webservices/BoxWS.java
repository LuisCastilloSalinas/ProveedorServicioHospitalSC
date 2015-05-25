package webservices;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import orm.Box;
import orm.BoxDAO;
import vo.BoxVO;

import com.google.gson.Gson;

public class BoxWS {

	public BoxWS() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo para obtener los box
	 * medicos,  los box son retornados 
	 * en un objeto Json mediante la libreria
	 * GSON 
	 * @return
	 */
	public String obtenerBoxMedicos() {
		String out ="";

		try {
			List<Box> boxORM = BoxDAO.queryBox(null, null);
			Gson gson = new Gson();
			List<BoxVO> boxVO = new ArrayList<BoxVO>();

			for (int i = 0; i < boxORM.size(); i++) {
				Box box = boxORM.get(i);
				boxVO.add(BoxVO.getBoxVO(box));

			}

			out = gson.toJson(boxVO);

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
}
