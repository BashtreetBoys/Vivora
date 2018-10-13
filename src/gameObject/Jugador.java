package gameObject;
import java.awt.Color;
import java.lang.invoke.SwitchPoint;

/**
 * 
 * @author MDS7.
 *
 */
public class Jugador {
	private String nombre;
	private String estado; //Estado que indica "Jugando" "Listo" "No Jugando".
	private Vibora vivorita; 
	private String contrase�a; //Al realizar la clase "Usuario" eliminar este par�metro de esta clase.
	private int puntaje;
	
	/**
	 * 
	 * @param nombre Nombre del jugador.
	 * @param estado Estado del jugador, "Jugando"/"Listo"/"No Jugando".
	 * @param vivorita La vivora asignada al jugador.
	 * @param contrase�a Contrase�a perteneciente a la cuenta del jugador.
	 */
	public Jugador(String nombre, String estado, Vibora vivorita, String contrase�a) {
		this.nombre = nombre;
		this.estado = estado;
		this.vivorita = vivorita;
		this.contrase�a = contrase�a;
		this.puntaje = 0;
	}
	
	/**
	 * Sirve para salir de la Arena.
	 * @param a Indica la Arena
	 */
	public void salirDeArena(Arena a) {
		System.out.println("Sali de la arena jaj.");
	}
	

	public Vibora getVivorita() {
		return vivorita;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public int getPuntaje() {
		return puntaje;
	}	
	
}
