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
public class Administrativo {
	private String depentencia;
	private String cargo;
	private String salario;
	/**
	 * @param depentencia
	 * @param cargo
	 * @param salario
	 */
	public Administrativo(String depentencia, String cargo, String salario) {
		super();
		this.depentencia = depentencia;
		this.cargo = cargo;
		this.salario = salario;
	}
	/**
	 * Método para mostrar la información contenida en: dependencia, cargo, salario
	 */
	@Override
	public String toString() {
		return "Administrativo [depentencia=" + depentencia + ", cargo=" + cargo + ", salario=" + salario + "]";
	}
	
	

}
