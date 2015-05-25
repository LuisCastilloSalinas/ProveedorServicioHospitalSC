package vo;

import orm.Especialidad;

public class EspecialidadVO {

	private Integer id;
	private String descripcion;

	public EspecialidadVO() {

	}

	public EspecialidadVO(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static EspecialidadVO obtenerEspecialidadVO(Especialidad especialidad) {
		EspecialidadVO especialidadVO = new EspecialidadVO(
				especialidad.getId_especialidad(),
				especialidad.getDescripcion());
		
		return especialidadVO;

	}

}
