import java.util.ArrayList;
import java.util.Scanner;

public class Vista {

	private static Scanner entrada = new Scanner(System.in);

	public EstudianteDTO solicitarDatos(int opcion, String mensaje) {
		EstudianteDTO registro = new EstudianteDTO();
		String no = "", ap = "", fn = "", ci = "", cp = "", pr = "";
		long ce = 0, fi = 0;

		if (opcion == 1) {
			System.out.println(mensaje);
			no = pedirString("Ingresar nombres:");
			registro.setNombres(no);
			ap = pedirString("Ingresar apellidos:");
			registro.setApellidos(ap);
			fn = pedirString("Ingresar fecha de nacimiento (YYYY-MM-DD):");
			registro.setFechaNacimiento(fn);
			ci = pedirString("Ingresar correo institucional:");
			registro.setCorreoInstitucional(ci);
		}

		if (opcion == 1) {
			cp = pedirString("Ingresar correo personal:");
			registro.setCorreoPersonal(cp);
			ce = pedirLong("Ingresar número de celular:");
			registro.setCelular(ce);
			fi = pedirLong("Ingresar número fijo:");
			registro.setFijo(fi);
			pr = pedirString("Ingresar programa:");
			registro.setPrograma(pr);
		}
		else {
			cp = pedirString("Ingresar correo personal:");
			registro.setCorreoPersonal(cp);
			ce = pedirLong("Ingresar número de celular:");
			registro.setCelular(ce);
			fi = pedirLong1("Ingresar número fijo:");
			registro.setFijo(fi);
			pr = pedirString1("Ingresar programa:");
			registro.setPrograma(pr);
		}
		return registro;
	}

	public String pedirString(String mensaje) {
		System.out.println(mensaje);
		String dato = entrada.nextLine();
		System.out.println("");
		return dato;
	}

	public String pedirString1(String mensaje) {
		System.out.print(mensaje);
		String dato = entrada.nextLine();
		return dato;
	}

	
	public long pedirLong(String mensaje) {
		long dato = 0;
		try {
			System.out.println(mensaje);
			dato = entrada.nextLong();
			entrada.nextLine();
		} catch (Exception e) {
			entrada.nextLine();
			System.out.println("El dato ingresado no es un número");
			dato = 0;
		}
		System.out.println("");
		return dato;
	}

	public long pedirLong1(String mensaje) {
		long dato = 0;
		try {
			System.out.print(mensaje);
			dato = entrada.nextLong();
			entrada.nextLine();
		} catch (Exception e) {
			entrada.nextLine();
			System.out.println("El dato ingresado no es un número");
			dato = 0;
		}
		System.out.println("");
		return dato;
	}
	
	public String pedirCorreo(String mensaje) {
		System.out.println(mensaje);
		System.out.println("Ingresar correo institucional:");
		return entrada.nextLine();
	}

	public int mostrarOpciones() {
		int opcion = 0;
		System.out.println("INSTITUTO LA FLORESTA");
		System.out.println("Seleccione tarea a realizar:");
		System.out.println("1. Ingresar estudiante");
		System.out.println("2. Buscar estudiante");
		System.out.println("3. Modificar estudiante");
		System.out.println("4. Eliminar Estudiante");
		System.out.println("5. Ver directorio de estudiantes");
		System.out.println("6. Salir");
		System.out.println("Opción:\n");
		opcion = leerDatoEntero();
		return opcion;
	}

	public int leerDatoEntero() {
		int dato = 0;
		try {
			dato = entrada.nextInt();
			entrada.nextLine();
		} catch (Exception e) {
			entrada.nextLine();
			System.out.println("El dato ingresado no es un número");
			dato = 0;
		}
		return dato;
	}

	public void mostrarDatosEstudiante(EstudianteDTO estudiante) {
		if (estudiante != null) {
			System.out.println("Nombres: " + estudiante.getNombres());
			System.out.println("Apellidos: " + estudiante.getApellidos());
			System.out.println("Fecha nacimiento: " + estudiante.getFechaNacimiento());
			System.out.println("Correo institucional: " + estudiante.getCorreoInstitucional());
			System.out.println("Correo personal: " + estudiante.getCorreoPersonal());
			System.out.println("Número de teléfono celular: " + estudiante.getCelular());
			System.out.println("Número de teléfono fijo: " + estudiante.getFijo());
			System.out.println("Programa académico: " + estudiante.getPrograma());
			System.out.println("");
		} else {
			System.out.println("El estudiante no se encuentra en lista");
		}
	}

	public void mostrarDirectorio(ArrayList<EstudianteDTO> agenda) {
		System.out.println("\nEl directorio de los estudiantes\n");
		for (EstudianteDTO estudiante : agenda) {
			mostrarDatosEstudiante(estudiante);
		}
	}

	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

}
