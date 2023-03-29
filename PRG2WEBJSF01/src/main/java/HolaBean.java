import javax.faces.bean.ManagedBean;

@ManagedBean
public class HolaBean {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
}