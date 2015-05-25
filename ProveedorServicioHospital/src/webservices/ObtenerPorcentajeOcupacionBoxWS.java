package webservices;

import java.sql.Timestamp;
import java.util.Date;

import org.orm.PersistentException;

import orm.BoxCriteria;
import orm.HoraMedicaCriteria;
import orm.ReservaCriteria;

public class ObtenerPorcentajeOcupacionBoxWS {

	public ObtenerPorcentajeOcupacionBoxWS() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo para obtener el porcentaje de ocupacion
	 * de un box en especifico
	 * se utiliza el id del box 
	 * y un rango de fechas. El resultado es entregado 
	 * en forma de numero de tipo int
	 * @param idBox
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public int obtenerPorcentajeOcupacionBox(int idBox, Date fecha1, Date fecha2)  {
		int porcentaje = 0;
		try{
		ReservaCriteria resCriteria = new ReservaCriteria();
		HoraMedicaCriteria horaCriteria = resCriteria.createReserva_hora_medicaCriteria();
		horaCriteria.fecha.between(new Timestamp(fecha1.getTime()), new Timestamp(fecha2.getTime()));
		BoxCriteria boxCriteria = horaCriteria.createBoxid_boxCriteria();
		boxCriteria.id_box.eq(idBox);
		
		HoraMedicaCriteria hCriteria = new HoraMedicaCriteria();
		hCriteria.fecha.between(new Timestamp(fecha1.getTime()), new Timestamp(fecha2.getTime()));
		BoxCriteria bCriteria = hCriteria.createBoxid_boxCriteria();
		bCriteria.id_box.eq(idBox);
		if(hCriteria.list().size()>0)
		porcentaje=(resCriteria.list().size()*100/hCriteria.list().size());
		}
		catch(PersistentException e){
			e.printStackTrace();
		}
		
		return porcentaje;
	}
}
