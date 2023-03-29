import javax.faces.bean.ManagedBean;

@ManagedBean
public class EjemploDos {
	private int numero = 0;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String navega() {
		if (numero %2 == 0)
			return "par.xhtml";
		else
			return "impar.xhtml";
	}
}
