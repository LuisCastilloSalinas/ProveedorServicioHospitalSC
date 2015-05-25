package vo;

import java.util.Date;

import orm.HoraMedica;

public class HoraMedicaVO {

	private int id;
	private Date fecha;
	
	public HoraMedicaVO() {
		// TODO Auto-generated constructor stub
	}
	
	public HoraMedicaVO(int id, Date fecha) {
		super();
		this.id = id;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static HoraMedicaVO getHoraMedicaVO(HoraMedica horaMedica) {
		
		HoraMedicaVO horaMedicaVO = new HoraMedicaVO();
		horaMedicaVO.setId(horaMedica.getId_hora_medica());
		horaMedicaVO.setFecha(horaMedica.getFecha());
		return horaMedicaVO;
	}
	
	
}
