/**
 * Clase Estudiante para crear objetos
 * @author codigo 200810 Astrid Nayibe Infante Palacio
 * @author codigo 200808 Wilkinshon Exneider Guisao Cañaveral
 * @ sinse 2026-11-02
 */

package version2;

public class Estudiante extends Persona 
{
	private String codigoEstidiantil;
    private String programaAcademico;
    private double promedioAcumulado;
	
    /**
	 * @param documentoIdentidad
	 * @param nombreCompleto
	 * @param edad
	 * @param correoInstitucional
	 * @param codigoEstidiantil
	 * @param programaAcademico
	 * @param promedioAcumulado
	 */
	public Estudiante(String documentoIdentidad, String nombreCompleto, int edad, String correoInstitucional,
			String codigoEstidiantil, String programaAcademico, double promedioAcumulado) {
		super(documentoIdentidad, nombreCompleto, edad, correoInstitucional);
		this.codigoEstidiantil = codigoEstidiantil;
		this.programaAcademico = programaAcademico;
		this.promedioAcumulado = promedioAcumulado;
	}



	/**
	 * Método para mostrar la información contenida en: superclase persona, código estudiantil, nombre completo, programa académico y promedio acumulado
	 */
	@Override
	public String toString() {
		return 	"\n Estudiante = " + super.toString() +
				"\n Código Estidiantil= " + this.codigoEstidiantil + 
				"\n Programa Académico=" + this.programaAcademico + 
				"\n Promedio Acumulado=" + this.promedioAcumulado + "]";
	}
	
    
	       
}
