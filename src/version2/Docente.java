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
public class Docente extends Persona 
{

	private String facultad;
	private String profesion;
	private String salario;
	
	/**
	 * @param documentoIdentidad
	 * @param nombreCompleto
	 * @param edad
	 * @param correoInstitucional
	 * @param facultad
	 * @param profesion
	 * @param salario
	 */
	public Docente(String documentoIdentidad, String nombreCompleto, int edad, String correoInstitucional,
			String facultad, String profesion, String salario) {
		super(documentoIdentidad, nombreCompleto, edad, correoInstitucional);
		this.facultad = facultad;
		this.profesion = profesion;
		this.salario = salario;
	}


	/**
	 * Método para mostar la información contenida en los atributos: superclase persona, facultad, profesion, salario 
	 */
	@Override
	public String toString() {
		return "\n Docente" +super.toString() + 
				"\n facultad=" + this.facultad + 
				"\n profesion=" + this.profesion + 
				"\n salario=" + this.salario;
	}
	
	
	
	
	
}
