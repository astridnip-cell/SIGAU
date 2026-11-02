/**
 * Clase que permite crear un arreglo de objetos de la clase Estudiante para asignar elementos, mostrar los datos 
 * de los objetos, buscar un objeto en el arreglo.
 * @author codigo 200810 Astrid Nayibe Infante Palacio
 * @author codigo 200808 Wilkinshon Exneider Guisao Cañaveral
 * @ sinse 2026-10/16
 */

package version1;

import java.util.Scanner;

public class GestorEstudiante {
    
    // Capacidad maxima del estudiantes
    private static final int CAPACIDAD = 10;
    
    // Atributos de acuerdo al diagrama
    private Estudiante[] estudiante = new Estudiante[CAPACIDAD];
    private int cantidad = 0;
    private Scanner scanner = new Scanner(System.in);
    
    
    /**
     * Método principal: pide cuántos estudiantes se van a ingresar, los registra
     * (mostrando el promedio general) e inicia el menú interactivo.
     * @param args argumentos de la línea de comandos
     */
    
    public static void main(String[] args) {
    	GestorEstudiante gestor = new GestorEstudiante();
        
        // Ingreso cantidad de estudiantes
        gestor.ingresarEstudiantes();
        
        // Menú interactivo con 7 opciones
        gestor.ejecutarMenu();
        
        // Se cierra el Scanner al finalizar el programa
        gestor.scanner.close();
    }
    
    // Pregunta cuantos estudiantes se van a ingresar y los registra uno por uno.
    // Al terminar muestra todo lo ingresado y los cálculos (promedios, promedio general y mejor promedio).
    public void ingresarEstudiantes() {
        int disponibles = CAPACIDAD - cantidad;
        
        if (disponibles == 0) {
            System.out.println("Error: El arreglo está lleno.");
            return;
        }
        
        int total = 0;
        while (total < 1 || total > disponibles) {
            System.out.print("¿Cuántos estudiantes desea ingresar? (1 a " + disponibles + "): ");
            total = leerEntero();
            if (total < 1 || total > disponibles) {
                System.out.println("Cantidad no válida. Debe estar entre 1 y " + disponibles + ".");
            }
        }
        
        int registrados = 0;
        while (registrados < total) {
            System.out.println("\n>>> Estudiante " + (registrados + 1) + " de " + total);
            if (registrarEstudiante()) {
                registrados++;
            } else {
                System.out.println("No se registró. Intente nuevamente con este estudiante.");
            }
        }
        
        mostrarResumen();
    }
    
    // Muestra todo lo ingresado y los calculos: lista de estudiantes con sus promedios,
    // promedio general, estudiante con mejor promedio y cantidad registrada.
    public void mostrarResumen() {
        System.out.println("\n========== RESULTADO ==========");
        consultarTodosEstudiantes();
        System.out.println("\n--- Cálculos ---");
        calcularPromedioGeneral();
        estudianteMejorPromedio();
        System.out.println();
        mostrarNumeroEstudiantesRegistrados();
        System.out.println("===============================");
    }
    
    // Forma para mostrar el meno
    public void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE GESTIÓN ACADÉMICA UNIVERSITARIA =====");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Mostrar todos los estudiantes");
        System.out.println("3. Buscar estudiante por código");
        System.out.println("4. Calcular promedio general");
        System.out.println("5. Mostrar estudiante con mejor promedio");
        System.out.println("6. Mostrar cantidad de estudiantes registrados");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    // Ciclo del menu: conecta las opciones con los metodos de la clase
    public void ejecutarMenu() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero();
            
            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    consultarTodosEstudiantes();
                    break;
                case 3:
                    buscarEstudianteCodigo();
                    break;
                case 4:
                    calcularPromedioGeneral();
                    break;
                case 5:
                    estudianteMejorPromedio();
                    break;
                case 6:
                    mostrarNumeroEstudiantesRegistrados();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);
    }
    
    // Procede a leer solo los numeros para que al ingresar texto arroje el error 
    private int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    // Lee tambien los decimales asegurandose de que al ingresar texto arroje el error 
    private double leerDecimal() {
        try {
            return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    // 1. Registrar estudiante
    public boolean registrarEstudiante() {
        if (cantidad >= CAPACIDAD) {
            System.out.println("Error: No se pueden registrar más estudiantes. El arreglo está lleno.");
            return false;
        }
        
        System.out.println("\n--- Registrar Nuevo Estudiante ---");
        
        System.out.print("Código: ");
        String codigo = scanner.nextLine().trim();
        
        // Evitar codigos repetidos
        for (int i = 0; i < cantidad; i++) {
            if (estudiante[i].getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Error: Ya existe un estudiante con el código " + codigo);
                return false;
            }
        }
        
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Edad: ");
        int edad = leerEntero();
        if (edad <= 0) {
            System.out.println("Error: La edad ingresada no es válida.");
            return false;
        }
        
        System.out.print("Programa académico: ");
        String programa = scanner.nextLine();
        
        System.out.print("Promedio acumulado (0.0 a 5.0): ");
        double promedio = leerDecimal();
        if (promedio < 0 || promedio > 5) {
            System.out.println("Error: El promedio debe estar entre 0.0 y 5.0.");
            return false;
        }
        
        estudiante[cantidad] = new Estudiante(codigo, nombre, edad, programa, promedio);
        cantidad++;
        
        System.out.println("Estudiante registrado exitosamente.");
        return true;
    }
    
    // 2. Consultar todos los estudiantes
    public void consultarTodosEstudiantes() {
        if (cantidad == 0) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.println("\n--- Lista de Estudiantes ---");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante #" + (i + 1) + ":");
            estudiante[i].mostrarInformacion();
            System.out.println("------------------------------");
        }
    }
    
    // 3. Buscar estudiante por codigo
    public Estudiante buscarEstudianteCodigo() {
        if (cantidad == 0) {
            System.out.println("No hay estudiantes registrados.");
            return null;
        }
        
        System.out.print("Ingrese el código a buscar: ");
        String codigoBuscar = scanner.nextLine().trim();
        
        for (int i = 0; i < cantidad; i++) {
            if (estudiante[i].getCodigo().equalsIgnoreCase(codigoBuscar)) {
                System.out.println("\nEstudiante encontrado:");
                estudiante[i].mostrarInformacion();
                return estudiante[i];
            }
        }
        
        System.out.println("No se encontró un estudiante con el código: " + codigoBuscar);
        return null;
    }
    
    // 4. Calcular promedio general
    public double calcularPromedioGeneral() {
        if (cantidad == 0) {
            System.out.println("No hay estudiantes registrados.");
            return 0;
        }
        
        double suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma += estudiante[i].getPromedio();
        }
        
        double promedioGeneral = suma / cantidad;
        System.out.println("El promedio general de los estudiantes es: " + String.format("%.2f", promedioGeneral));
        return promedioGeneral;
    }
    
    // 5. Estudiante con mejor promedio
    public Estudiante estudianteMejorPromedio() {
        if (cantidad == 0) {
            System.out.println("No hay estudiantes registrados.");
            return null;
        }
        
        int indiceMejor = 0;
        for (int i = 1; i < cantidad; i++) {
            if (estudiante[i].getPromedio() > estudiante[indiceMejor].getPromedio()) {
                indiceMejor = i;
            }
        }
        
        System.out.println("\nEstudiante con mejor promedio:");
        estudiante[indiceMejor].mostrarInformacion();
        return estudiante[indiceMejor];
    }
    
    // 6. Mostrar numero de estudiantes registrados
    public void mostrarNumeroEstudiantesRegistrados() {
        System.out.println("Cantidad de estudiantes registrados: " + cantidad);
    }
    
    // Información del sistema
    public void mostrarInformacion() {
        System.out.println("Sistema de Gestión Académica Universitaria (SIGAU)");
        System.out.println("Versión 1.0");
    }
}