/**
 * Clase Administrativo para crear objetos
 * @author codigo 200810 Astrid Nayibe Infante Palacio
 * @author codigo 200808 Wilkinshon Exneider Guisao Cañaveral
 * @ sinse 2026-11-02
 */
 
package version2;

/**
 * 
 */
public class Administrativo extends Persona
{
	private String dependencia;
	private String cargo;
	private String salario;
	
	/**
	 * @param documentoIdentidad
	 * @param nombreCompleto
	 * @param edad
	 * @param correoInstitucional
	 * @param dependencia
	 * @param cargo
	 * @param salario
	 */
	public Administrativo(String documentoIdentidad, String nombreCompleto, int edad, String correoInstitucional,
			String dependencia, String cargo, String salario) {
		super(documentoIdentidad, nombreCompleto, edad, correoInstitucional);
		this.dependencia = dependencia;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	/**
	 * Método para mostrar la información contenida en: la superclase Persona, dependencia, cargo, salario
	 */
	@Override
	public String toString() {
	    return "\n Administrativo" + super.toString() + 
	    		"\n  dependencia=" + this.dependencia + 
	    		"\n  cargo=" + this.cargo + 
	    		"\n  salario=" + this.salario;
	}
	

}
