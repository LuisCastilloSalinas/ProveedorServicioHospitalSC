package vo;

import orm.Medico;

public class MedicoOcupacionVO  implements Comparable<MedicoOcupacionVO>{

	
	private int id;
	private String nombre;
	private Integer porcentajeOcupacion;
	
	public MedicoOcupacionVO() {
		
	}
	
	


	public MedicoOcupacionVO(int id, String nombre,int porcentajeOcupacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.porcentajeOcupacion=porcentajeOcupacion;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	public int getPorcentajeOcupacion() {
		return porcentajeOcupacion;
	}




	public void setPorcentajeOcupacion(int porcentajeOcupacion) {
		this.porcentajeOcupacion = porcentajeOcupacion;
	}




	/**
	 * Metodo que crea un medico con los atributos
	 * de id y nombre obtenidos del medico
	 * de la capa de negocio
	 * @param medico
	 * @return
	 */
	public static MedicoOcupacionVO getMedicoVO(Medico medico){
		MedicoOcupacionVO medicoVO = new MedicoOcupacionVO();
		medicoVO.setId(medico.getId_medico());
		medicoVO.setNombre(medico.getPersonaid_persona().getNombre());
		
		return medicoVO;
	}




	public int compareTo(MedicoOcupacionVO o) {
		
		
		return o.porcentajeOcupacion.compareTo(porcentajeOcupacion);
	}




	

	
	
}

