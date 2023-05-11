import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo {

	private ArrayList<EstudianteDTO> agenda;
	private static String archivo = "datos_estudiantes.dat";
	private static final String DB_URL = "jdbc:MySQL://localhost/bd_estudiantes";

	public Modelo() {
		agenda = new ArrayList<EstudianteDTO>();
	}

	public void ingresarRegEstudiante(EstudianteDTO estudiante) {
		this.insertCliente(estudiante);
		agenda.add(estudiante);
	}

	public void eliminarRegistroEstudiante(int pos, String correo) {
		agenda.remove(pos);
		this.deleteEstudiante(correo);
	}

	public EstudianteDTO buscarEstudiante(String correoInstitucional) {
		for (int i = 0; i < this.agenda.size(); i++) {
			if (agenda.get(i)
					.getCorreoInstitucional()
					.equals(correoInstitucional)) {
				return agenda.get(i);
			}
		}
		return null;
	}
	
	public int buscarPosEstudiante(String correo) {
		for (int i=0 ; i<this.agenda.size() ; i++) {
			if (agenda.get(i).getCorreoInstitucional().equals(correo)) {
				return i;
			}
		}
		return -1;
	}

	public void modificarDatosEstudiante(int pos, EstudianteDTO estudiante) {
		this.updateEstudiante(estudiante, estudiante.getCorreoInstitucional());
		agenda.set(pos, estudiante);
	}

	public ArrayList<EstudianteDTO> listarDirectorio() {
		return null;
	}

	public ArrayList<EstudianteDTO> getAgenda() {
		this.selectEstudiantes();
		return agenda;
	}

	public void setAgenda(ArrayList<EstudianteDTO> agenda) {
		this.agenda = agenda;
	}

	public int escribirArchivo() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo));
			out.writeObject(agenda);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return -1;
		}
		return 0;
	}

	public int leerArchivo() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
			agenda = (ArrayList<EstudianteDTO>) in.readObject();
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			return -1;
		}
		return 0;		
	}
	/*-----------------------------------------------------------------------------*/
	/*---------------------FUNCIONES DEL CRUD CON BASES DE DATOS ------------------*/
	
	public Connection conectarBD() {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:bd_estudiantes.db");
			//Connection conn = DriverManager.getConnection(DB_URL, "root", "xxxx");
			//
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insertCliente(EstudianteDTO estudiante) {
		try {
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO estudiantes"
					+ "(nombres,"
					+ "apellidos,"
					+ "fecha,"
					+ "correoins,"
					+ "correoper,"
					+ "cel,"
					+ "fijo,"
					+ "programa) "
					+ "VALUES ("
					+ "\'"+estudiante.getNombres()+"\',"
					+ "\'"+estudiante.getApellidos()+"\',"
					+ "\'"+estudiante.getFechaNacimiento()+"\',"					
					+ "\'"+estudiante.getCorreoInstitucional()+"\',"					
					+ "\'"+estudiante.getCorreoPersonal()+"\',"
					+ "\'"+estudiante.getCelular()+"\',"
					+ "\'"+estudiante.getFijo()+"\',"
					+ "\'"+estudiante.getPrograma()+"\');";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEstudiante(EstudianteDTO estudiante, String correo) {
		try {
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			String sql = "UPDATE estudiantes "
					+ "SET "
					+ "nombres= \'"+estudiante.getNombres()+"\'"
					+ ",apellidos=\'"+estudiante.getApellidos()+"\'"
					+ ",fecha=\'" + estudiante.getFechaNacimiento()+"\'"
					+ ",correoins=\'"+estudiante.getCorreoInstitucional()+"\'"
					+ ",correoper=\'"+estudiante.getCorreoPersonal()+"\'"
					+ ",cel=\'"+estudiante.getCelular()+"\'"
					+ ",fijo=\'"+estudiante.getFijo()+"\'"
					+ ",programa=\'"+estudiante.getPrograma()+"\' "
					+ "WHERE correoins=\'"+correo+"\';";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createTableEstudiantes() {
		try {
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			String sql = "create table IF NOT EXISTS estudiantes ("
					+ "    nombres TEXT NOT NULL,"
					+ "    apellidos TEXT NOT NULL,"
					+ "    fecha TEXT NOT NULL,"
					+ "    correoins TEXT NOT NULL,"
					+ "    correoper TEXT NOT NULL,"
					+ "    cel TEXT NOT NULL,"
					+ "    fijo TEXT NOT NULL,"
					+ "    programa TEXT NOT NULL"
					+ ");";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	public void deleteEstudiante(String correo) {
		try {
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM estudiantes WHERE correoins=\'"+correo+"\';";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EstudianteDTO buscarEstudiantexCorreo(String correo) {
		EstudianteDTO estudiante = null; 
		try {
			String sql = " SELECT nombres,"
					+ "apellidos,"
					+ "fecha,"
					+ "correoins,"
					+ "correoper,"
					+ "cel,"
					+ "fijo,"
					+ "programa "
					+ "FROM estudiantes WHERE correoins=\'"+correo+"\'";
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				estudiante = new EstudianteDTO();
				estudiante.setNombres(rs.getString("nombres"));
				estudiante.setApellidos(rs.getString("apellidos"));
				estudiante.setFechaNacimiento(rs.getString("fecha"));
				estudiante.setCorreoInstitucional(rs.getString("correoins"));
				estudiante.setCorreoPersonal(rs.getString("correoper"));
				estudiante.setCelular(Long.parseLong(rs.getString("cel")));
				estudiante.setFijo(Long.parseLong(rs.getString("correoper")));
				estudiante.setPrograma(rs.getString("programa"));
				agenda.add(estudiante);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estudiante;
	}
	
	public void selectEstudiantes() {
		agenda = new ArrayList<EstudianteDTO>();
		try {
			EstudianteDTO estudiante; 
			String sql = " SELECT nombres,"
					+ "apellidos,"
					+ "fecha,"
					+ "correoins,"
					+ "correoper,"
					+ "cel,"
					+ "fijo,"
					+ "programa "
					+ "FROM estudiantes;";
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				estudiante = new EstudianteDTO();
				estudiante.setNombres(rs.getString("nombres"));
				estudiante.setApellidos(rs.getString("apellidos"));
				estudiante.setFechaNacimiento(rs.getString("fecha"));
				estudiante.setCorreoInstitucional(rs.getString("correoins"));
				estudiante.setCorreoPersonal(rs.getString("correoper"));
				estudiante.setCelular(Long.parseLong(rs.getString("cel")));
				estudiante.setFijo(Long.parseLong(rs.getString("fijo")));
				estudiante.setPrograma(rs.getString("programa"));
				agenda.add(estudiante);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*---------------------FUNCIONES DEL CRUD CON BASES DE DATOS ------------------*/
}
