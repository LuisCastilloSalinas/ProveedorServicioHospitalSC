package vo;

import orm.Box;

public class BoxVO {
	private int id;
	private String descripcion;
	
	public BoxVO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public BoxVO(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static BoxVO getBoxVO (Box box) {
		BoxVO boxVO = new BoxVO();
		boxVO.setId(box.getId_box());
		boxVO.setDescripcion(box.getDescripcion());
		return boxVO;
	}
	
}
