/**
 * Clase Estudiante para crear objetos
 * @author codigo 200810 Astrid Nayibe Infante Palacio
 * @author codigo 200808 Wilkinshon Exneider Guisao Cañaveral
 * @ sinse 2026-10-16
 */

package version1;

public class Estudiante 
{
	private String codigo;
    private String nombre;
    private int edad;
    private String programa;
    private double promedio;
	
    public Estudiante() {
    }

    
    public Estudiante(String codigo, String nombre, int edad, String programa, double promedio) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.programa = programa;
        this.promedio = promedio;
    }
    
    public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
    /* Método para mostar la información contenida en los atributos: código, nombre, edad, programa, promedio en el objeto
     * 
     */
	 public void mostrarInformacion() 
	 {
	        System.out.println("Código: " + this.codigo
	        					+"\nNombre: " + this.nombre
	        					+"\nEdad: " + this.edad
	        					+"\nPrograma: " + this.programa
	        					+"\nPromedio: " + this.promedio);
	 }       
	       
}
