package vo;

public class PacienteOcupacionVO implements Comparable< PacienteOcupacionVO> {
	private int idPaciente;
	private String nombrePaciente;
	private Integer porcentajeOcupacion;
	
	public PacienteOcupacionVO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PacienteOcupacionVO(int idPaciente, String nombrePaciente,
			int porcentajeOcupacion) {
		super();
		this.idPaciente = idPaciente;
		this.nombrePaciente = nombrePaciente;
		this.porcentajeOcupacion = porcentajeOcupacion;
	}



	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public int getPorcentajeOcupacion() {
		return porcentajeOcupacion;
	}

	public void setPorcentajeOcupacion(int porcentajeOcupacion) {
		this.porcentajeOcupacion = porcentajeOcupacion;
	}



	public int compareTo(PacienteOcupacionVO o) {
		// TODO Auto-generated method stub
		return o.porcentajeOcupacion.compareTo(porcentajeOcupacion);
	}
	
	
	
}
