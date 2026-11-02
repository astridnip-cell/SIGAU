/**
 * Clase Docente para crear objetos
 * @author codigo 200810 Astrid Nayibe Infante Palacio
 * @author codigo 200808 Wilkinshon Exneider Guisao Cañaveral
 * @ sinse 2026-11-02
 */
 
package version2;

/**
 * 
 */
public class Docente {

	private String facultad;
	private String profesion;
	private String salario;
	/**
	 * @param facultad
	 * @param profesion
	 * @param salario
	 */
	public Docente(String facultad, String profesion, String salario) {
		super();
		this.facultad = facultad;
		this.profesion = profesion;
		this.salario = salario;
	}
	/**
	 * * Método para mostar la información contenida en los atributos: facultad, profesion, salario 
	 */
	@Override
	public String toString() {
		return "Docente [facultad=" + facultad + ", profesion=" + profesion + ", salario=" + salario + "]";
	}
	
	
	
	
	
}
