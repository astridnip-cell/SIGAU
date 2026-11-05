/**
* Clase Gestorpersona para crear objetos
 * @author codigo 200810 Astrid Nayibe Infante Palacio
 * @author codigo 200808 Wilkinshon Exneider Guisao Cañaveral
 * @ sinse 2026-11-02
 */
package version2;

import java.util.Scanner;          // ← LÍNEA NUEVA

/**
 * 
 */
public class GestorPersona {
	 private static final int CAPACIDAD = 20;
	 ...

	    public static void main(String[] args) {
	        GestorPersona gestor = new GestorPersona();   // ← antes decía GestorPersonas
	        gestor.ejecutarMenu();
	        gestor.scanner.close();
	    }

	    // ---------------------------------------------------------------- Menú

	    private void mostrarMenu() {
	        System.out.println("\n===== SIGAU =====");
	        System.out.println("1. Registrar usuario");
	        System.out.println("2. Mostrar usuarios");
	        System.out.println("3. Filtrar por tipo");
	        System.out.println("4. Consultar usuario");
	        System.out.println("5. Mostrar estadísticas");
	        System.out.println("6. Salir");
	        System.out.print("Seleccione una opción: ");
	    }

	    private void ejecutarMenu() {
	        int opcion;
	        do {
	            mostrarMenu();
	            opcion = leerEntero();
	            switch (opcion) {
	                case 1: registrarUsuario(); break;
	                case 2: mostrarUsuarios(); break;
	                case 3: filtrarPorTipo(); break;
	                case 4: consultarUsuario(); break;
	                case 5: mostrarEstadisticas(); break;
	                case 6: System.out.println("Gracias por usar el SIGAU. ¡Hasta pronto!"); break;
	                default: System.out.println("Opción no válida. Elija un número entre 1 y 6.");
	            }
	        } while (opcion != 6);
	    }

	    // Registro

	    private boolean registrarUsuario() {
	        if (cantidad >= CAPACIDAD) {
	            System.out.println("Error: el arreglo está lleno (" + CAPACIDAD + " usuarios).");
	            return false;
	        }
	        System.out.println("Tipos de usuario -> 1. Estudiante  2. Docente  3. Administrativo");
	        System.out.print("Seleccione el tipo: ");
	        int tipo = leerEntero();
	        if (tipo < 1 || tipo > 3) {
	            System.out.println("Error: tipo de usuario no válido.");
	            return false;
	        }

	        System.out.print("Documento de identidad: ");
	        String documento = scanner.nextLine().trim();
	        if (documento.isEmpty()) {
	            System.out.println("Error: el documento no puede estar vacío.");
	            return false;
	        }
	        if (buscarPorDocumento(documento) != null) {
	            System.out.println("Error: ya existe un usuario con ese documento.");
	            return false;
	        }
	        System.out.print("Nombre completo: ");
	        String nombre = scanner.nextLine().trim();
	        if (nombre.isEmpty()) {
	            System.out.println("Error: el nombre no puede estar vacío.");
	            return false;
	        }
	        System.out.print("Edad: ");
	        int edad = leerEntero();
	        if (edad <= 0 || edad > 120) {
	            System.out.println("Error: la edad debe estar entre 1 y 120.");
	            return false;
	        }
	        System.out.print("Correo institucional: ");
	        String correo = scanner.nextLine().trim();
	        if (!correo.contains("@") || correo.startsWith("@") || correo.endsWith("@")) {
	            System.out.println("Error: correo institucional no válido.");
	            return false;
	        }

	        Docente nueva;
	        String documentoIdentidad;
			if (tipo == 1) {
	            System.out.print("Código estudiantil: ");
	            String codigo = scanner.nextLine().trim();
	            System.out.print("Programa académico: ");
	            String programa = scanner.nextLine().trim();
	            System.out.print("Promedio acumulado (0.0 - 5.0): ");
	            double promedio = leerDecimal();
	            if (codigo.isEmpty() || programa.isEmpty()) {
	                System.out.println("Error: código y programa son obligatorios.");
	                return false;
	            }
	            if (promedio < 0.0 || promedio > 5.0) {
	                System.out.println("Error: el promedio debe estar entre 0.0 y 5.0.");
	                return false;
	            }
	            String nombreCompleto;
				String codigoEstudiantil;
				String programaAcademico;
				double promedioAcumulado;
				nueva = new Estudiante(codigoEstudiantil, nombreCompleto, programaAcademico, promedioAcumulado);
	        } else if (tipo == 2) {
	            System.out.print("Facultad: ");
	            String facultad = scanner.nextLine().trim();
	            System.out.print("Profesión: ");
	            String profesion = scanner.nextLine().trim();
	            System.out.print("Salario: ");
	            double salario = leerDecimal();
	            if (facultad.isEmpty() || profesion.isEmpty()) {
	                System.out.println("Error: facultad y profesión son obligatorias.");
	                return false;
	            }
	            if (salario <= 0) {
	                System.out.println("Error: el salario debe ser mayor que 0.");
	                return false;
	            }
	            nueva = new Docente (facultad, profesion, salario);
	        } else {
	            System.out.print("Dependencia: ");
	            String dependencia = scanner.nextLine().trim();
	            System.out.print("Cargo: ");
	            String cargo = scanner.nextLine().trim();
	            System.out.print("Salario: ");
	            double salario = leerDecimal();
	            if (dependencia.isEmpty() || cargo.isEmpty()) {
	                System.out.println("Error: dependencia y cargo son obligatorios.");
	                return false;
	            }
	            if (salario <= 0) {
	                System.out.println("Error: el salario debe ser mayor que 0.");
	                return false;
	            }
	            nueva = new Administrativo(documento, nombre, edad, correo, dependencia, cargo, salario);
	        }

	        personas[cantidad] = nueva;   // diferentes tipos en el mismo arreglo
	        cantidad++;
	        System.out.println("Usuario registrado exitosamente (" + nueva.getTipo() + "). Total: " + cantidad);
	        return true;
	    }

	    // consultas

	    /** 
	     * Recorre el arreglo con referencias Persona: polimorfismo en acción. 
	     */
	    private void mostrarUsuarios() {
	        if (cantidad == 0) {
	            System.out.println("No hay usuarios registrados.");
	            return;
	        }
	        System.out.println("\n--- Listado de usuarios (" + cantidad + ") ---");
	        for (int i = 0; i < cantidad; i++) {
	            Persona p = personas[i];
	            System.out.println("Usuario #" + (i + 1));
	            p.mostrarInformacion();   // se ejecuta la versión de la clase real
	            System.out.println("----------------------------------------");
	        }
	    }

	    private void filtrarPorTipo() {
	        System.out.println("Filtrar por -> 1. Estudiante  2. Docente  3. Administrativo");
	        System.out.print("Seleccione el tipo: ");
	        int tipo = leerEntero();
	        if (tipo < 1 || tipo > 3) {
	            System.out.println("Error: tipo de usuario no válido.");
	            return;
	        }
	        String nombreTipo = tipo == 1 ? "Estudiante" : tipo == 2 ? "Docente" : "Administrativo";
	        int encontrados = 0;
	        for (int i = 0; i < cantidad; i++) {
	            if (personas[i].getTipo().equals(nombreTipo)) {
	                encontrados++;
	                System.out.println("\n" + nombreTipo + " #" + encontrados);
	                personas[i].mostrarInformacion();
	                System.out.println("----------------------------------------");
	            }
	        }
	        if (encontrados == 0) {
	            System.out.println("No hay usuarios registrados del tipo " + nombreTipo + ".");
	        } else {
	            System.out.println("Total de " + nombreTipo + "s: " + encontrados);
	        }
	    }

	    private Persona buscarPorDocumento(String documento) {
	        for (int i = 0; i < cantidad; i++) {
	            if (personas[i].getDocumento().equalsIgnoreCase(documento)) {
	                return personas[i];
	            }
	        }
	        return null;
	    }

	    private Persona consultarUsuario() {
	        System.out.print("Documento a consultar: ");
	        String documento = scanner.nextLine().trim();
	        Persona p = buscarPorDocumento(documento);
	        if (p == null) {
	            System.out.println("No se encontró un usuario con el documento " + documento + ".");
	        } else {
	            System.out.println();
	            p.mostrarInformacion();
	        }
	        return p;
	    }

	    // ---------------------------------------------------------- Estadísticas

	    private void mostrarEstadisticas() {
	        if (cantidad == 0) {
	            System.out.println("No hay usuarios registrados.");
	            return;
	        }
	        int estudiantes = 0, docentes = 0, administrativos = 0;
	        double sumaPromedios = 0, sumaSalDocentes = 0, sumaSalAdmin = 0;
	        int sumaEdades = 0;
	        Estudiante mejor = null;

	        for (int i = 0; i < cantidad; i++) {
	            Persona p = personas[i];
	            sumaEdades += p.getEdad();
	            if (p instanceof Estudiante) {
	                Estudiante e = (Estudiante) p;
	                estudiantes++;
	                sumaPromedios += e.getPromedio();
	                if (mejor == null || e.getPromedio() > mejor.getPromedio()) {
	                    mejor = e;
	                }
	            } else if (p instanceof Docente) {
	                docentes++;
	                sumaSalDocentes += ((Docente) p).getSalario();
	            } else if (p instanceof Administrativo) {
	                administrativos++;
	                sumaSalAdmin += ((Administrativo) p).getSalario();
	            }
	        }

	        System.out.println("\n--- Estadísticas del SIGAU ---");
	        System.out.println("Total de usuarios:        " + cantidad + " de " + CAPACIDAD);
	        System.out.println("Estudiantes:              " + estudiantes);
	        System.out.println("Docentes:                 " + docentes);
	        System.out.println("Administrativos:          " + administrativos);
	        System.out.printf("Edad promedio general:    %.1f años%n", (double) sumaEdades / cantidad);
	        if (estudiantes > 0) {
	            System.out.printf("Promedio de estudiantes:  %.2f%n", sumaPromedios / estudiantes);
	            System.out.println("Mejor promedio:           " + mejor.getNombre()
	                    + " (" + String.format("%.2f", mejor.getPromedio()) + ")");
	        }
	        if (docentes > 0) {
	            System.out.printf("Salario promedio docente: $%,.0f%n", sumaSalDocentes / docentes);
	        }
	        if (administrativos > 0) {
	            System.out.printf("Salario prom. administr.: $%,.0f%n", sumaSalAdmin / administrativos);
	        }
	        System.out.printf("Nómina total (doc. + adm.): $%,.0f%n", sumaSalDocentes + sumaSalAdmin);
	    }

	    // ----------------------------------------------------------------- Apoyo

	    private int leerEntero() {
	        try {
	            return Integer.parseInt(scanner.nextLine().trim());
	        } catch (NumberFormatException e) {
	            return -1;
	        }
	    }

	    private double leerDecimal() {
	        try {
	            return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
	        } catch (NumberFormatException e) {
	            return -1;
	        }
	    }
	}
