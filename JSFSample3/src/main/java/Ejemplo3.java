import javax.faces.bean.ManagedBean;

@ManagedBean
public class Ejemplo3 {
	
	private int numero=0;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String navegar() {
		if(this.numero % 2 == 0)
			return "par.xhtml";
		else
			return "impar.xhtml";
	}
}
