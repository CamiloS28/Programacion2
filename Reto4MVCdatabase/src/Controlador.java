
public class Controlador {
	
	private static Modelo m = new Modelo();
	private static Vista v = new Vista();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m.createTableEstudiantes();
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		int opcion = 0;
		boolean salir = false;
		while (!salir) {
			opcion = v.mostrarOpciones();
			switch (opcion) {
			case 1:
				ingresarEstudiante();
				break;
			case 2:
				buscarEstudiante();
				break;
			case 3:
				modificarEstudiante();
				break;
			case 4:
				eliminarEstudiante();
				break;
			case 5:
				v.mostrarDirectorio(m.getAgenda());
				break;
			case 6:
				salir = true;
				v.mostrarMensaje("\nHasta pronto");
			}
		}
	}
	
	public static void ingresarEstudiante() {
		m.leerArchivo();
		m.ingresarRegEstudiante(v.solicitarDatos(1,"Ingresar estudiante"));
		v.mostrarMensaje("Se agregó el estudiante\n");
		m.escribirArchivo();
	}
	
	public static void modificarEstudiante() {
		EstudianteDTO reganterior, regnuevo;
		m.leerArchivo();
		String correo = v.pedirCorreo("\nModificar estudiante");
		reganterior=m.buscarEstudiante(correo);
		int pos = m.buscarPosEstudiante(correo);
		if(reganterior != null && pos != -1) {
			regnuevo = new EstudianteDTO();
			regnuevo = v.solicitarDatos(2,null);
			regnuevo.setNombres(reganterior.getNombres());
			regnuevo.setApellidos(reganterior.getApellidos());
			regnuevo.setFechaNacimiento(reganterior.getFechaNacimiento());
			regnuevo.setCorreoInstitucional(reganterior.getCorreoInstitucional());
			m.modificarDatosEstudiante(pos,regnuevo);
			v.mostrarMensaje("\nSe modificó el estudiante\n");
			m.escribirArchivo();
		}
	}
	
	public static void buscarEstudiante() {
		String correo = v.pedirCorreo("Buscar estudiante");
		EstudianteDTO registro=m.buscarEstudiante(correo);
		v.mostrarMensaje("\nInformación del estudiante");
		v.mostrarDatosEstudiante(registro);
	}
	
	public static void eliminarEstudiante() {
		m.leerArchivo();
		String correo = v.pedirCorreo("\nEliminar estudiante");
		int pos = m.buscarPosEstudiante(correo);
		m.eliminarRegistroEstudiante(pos,correo);
		v.mostrarMensaje("\nSe eliminó el estudiante\n");
		m.escribirArchivo();
	}
}
