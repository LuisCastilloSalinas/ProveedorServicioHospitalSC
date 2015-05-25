package vo;

import orm.Medico;

public class MedicoVO {

	
	private int id;
	private String nombre;
	
	
	public MedicoVO() {
		
	}
	
	


	public MedicoVO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
	
	

	/**
	 * Metodo que crea un medico con los atributos
	 * de id y nombre obtenidos del medico
	 * de la capa de negocio
	 * @param medico
	 * @return
	 */
	public static MedicoVO getMedicoVO(Medico medico){
		MedicoVO medicoVO = new MedicoVO();
		medicoVO.setId(medico.getId_medico());
		medicoVO.setNombre(medico.getPersonaid_persona().getNombre());
		
		return medicoVO;
	}


	
	
}

