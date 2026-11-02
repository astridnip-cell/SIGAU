/**
 * Clase Estudiante para crear objetos
 * @author codigo 200810 Astrid Nayibe Infante Palacio
 * @author codigo 200808 Wilkinshon Exneider Guisao Cañaveral
 * @ sinse 2026-11-02
 */

package version2;

/**
 * 
 */
class Persona {
// Atributo de instancia
	private String documentoIdentidad;
	private String nombreCompleto;
	private int edad;
	private String correoInstitucional;
	/**
	 * @param documentoIdentidad
	 * @param nombreCompleto
	 * @param edad
	 * @param correoInstitucional
	 */
	public Persona(String documentoIdentidad, String nombreCompleto, int edad, String correoInstitucional) {
		super();
		this.documentoIdentidad = documentoIdentidad;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.correoInstitucional = correoInstitucional;
	}
	/**
	 * Método para mostar la información contenida en los atributos: documentoIdentidad, nombreCompleto, edad, correoInstitucional
     * 
     */
	@Override
	public String toString() {
		return "\n Persona documentoIdentidad=" + this.documentoIdentidad + 
				"\n nombreCompleto=" + this.nombreCompleto + 
				"\n edad=" + this.edad + 
				"\n correoInstitucional=" + this.correoInstitucional;
	}
	
	
}
