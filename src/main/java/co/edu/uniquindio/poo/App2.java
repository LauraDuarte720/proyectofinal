package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class App2 {
    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Administrador> administradores = new ArrayList<>();
    private static List<Vehiculo> vehiculos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Transaccion> transacciones = new ArrayList<>();

    public static void main(String[] args) {
        inicializarDatos();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Bienvenido a Tu Carro UQ ===");
            System.out.println("1. Login como Empleado");
            System.out.println("2. Login como Administrador");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    loginEmpleado(scanner);
                    break;
                case 2:
                    loginAdministrador(scanner);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        scanner.close();
        System.out.println("Gracias por usar Tu Carro UQ.");
    }

    private static void inicializarDatos() {
        // Datos iniciales de ejemplo
        Administrador administrador1 = new Administrador("Juan",
                 "Pérez", "1234567890", "juan.perez@mail.com",
                "juan123", "1234", "respuesta1");

        // Añadir administrador1 a la lista de administradores
        administradores.add(administrador1);

        // Datos iniciales de ejemplo
        empleados.add(new Empleado("Luis", "Martínez", "1112223334", "luis.martinez@mail.com", 
            "luis001", "456",
                "respuestaA", administrador1));

        // Vehículos de ejemplo
        vehiculos.add(new Moto("MOTO001", "Yamaha", "MT-07", true, 6, 200.0, 689.0, Transmision.MANUAL,
                Combustible.GASOLINA));
        vehiculos.add(new Moto("MOTO002", "Kawasaki", "Ninja 400", false, 6, 190.0, 399.0, Transmision.MANUAL,
                Combustible.GASOLINA));
    }

    private static void loginEmpleado(Scanner scanner) {
        System.out.print("Ingrese su username: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        for (Empleado empleado : empleados) {
            if (empleado.getUsuario().equals(username) && empleado.getContraseña().equals(password)) {
                JOptionPane.showMessageDialog(null, "Login exitoso como Empleado");
                menuEmpleado(scanner, empleado);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private static void loginAdministrador(Scanner scanner) {
        System.out.print("Ingrese su username: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        for (Administrador admin : administradores) {
            if (admin.getUsuario().equals(username) && admin.getContraseña().equals(password)) {
                JOptionPane.showMessageDialog(null, "Login exitoso como Administrador");
                menuAdministrador(scanner, admin);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private static void menuEmpleado(Scanner scanner, Empleado empleado) {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú de Empleado ===");
            System.out.println("1. Ver vehículos disponibles");
            System.out.println("2. Registrar transacción");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    verVehiculos();
                    break;
                case 2:
                    registrarTransaccion(scanner, empleado);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void menuAdministrador(Scanner scanner, Administrador admin) {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú de Administrador ===");
            System.out.println("1. Ver vehículos disponibles");
            System.out.println("2. Agregar nuevo vehículo");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    verVehiculos();
                    break;
                case 2:
                    agregarVehiculo(scanner);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void verVehiculos() {
        System.out.println("=== Lista de Vehículos Disponibles ===");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
            System.out.println("\n");
        }
    }

    private static void registrarTransaccion(Scanner scanner, Empleado empleado) {
        System.out.println("=== Registro de Transacción ===");
        System.out.println("Seleccione el tipo de transacción:");
        System.out.println("1. Venta");
        System.out.println("2. Compra");
        System.out.println("3. Alquiler");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Seleccionar cliente
        System.out.println("=== Selección de Cliente ===");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellidoCliente = scanner.nextLine();
        System.out.print("Ingrese la cedula del cliente: ");
        String cedulaCliente = scanner.nextLine();
        System.out.print("Ingrese el correo del cliente: ");
        String correoCliente = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefonoCliente = scanner.nextLine();
        System.out.print("Ingrese la edad del cliente: ");
        int edadCliente = scanner.nextInt();

        // public Cliente(String nombres, String apellidos, String cedula, String
        // correo, String telefono, int edad)
        Cliente cliente = new Cliente(nombreCliente, apellidoCliente, cedulaCliente, correoCliente, telefonoCliente,
                edadCliente);
        clientes.add(cliente);

        // Seleccionar vehículo
        System.out.println("=== Selección de Vehículo ===");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculos.get(i).toString());
        }
        System.out.print("Seleccione un vehículo (número): ");
        int indiceVehiculo = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer
        Vehiculo vehiculoSeleccionado = vehiculos.get(indiceVehiculo);

        // Registro de la transacción
        System.out.print("Ingrese la fecha de la transacción (dd/MM/yyyy): ");
        String fecha = scanner.nextLine();

        Transaccion transaccion = null;
        switch (tipo) {
            case 1:
                transaccion = new Venta(cliente, vehiculoSeleccionado, empleado, fecha);
                break;
            case 2:
                transaccion = new Compra(cliente, vehiculoSeleccionado, empleado, fecha);
                break;
            case 3:
                transaccion = new Alquiler(cliente, vehiculoSeleccionado, empleado, fecha);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de transacción no válido", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
        }

        transacciones.add(transaccion);
        JOptionPane.showMessageDialog(null, "Transacción registrada con éxito", "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
        System.out.println(transaccion.toString());
    }

    private static void agregarVehiculo(Scanner scanner) {
        System.out.println("=== Agregar Nuevo Vehículo ===");
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Moto");
        System.out.println("2. Sedán");
        System.out.println("3. Deportivo");
        System.out.println("4. Camioneta");
        System.out.println("5. Pick-up");
        System.out.println("6. Eléctrico");
        System.out.println("7. Híbrido");
        System.out.println("8. Van");
        System.out.println("9. Camión");
        System.out.println("10. Bus");
        System.out.print("Opción: ");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese el codigo del vehículo: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.print("¿El vehículo es nuevo? (true/false): ");
        boolean esNuevo = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese la cantidad de cambios: ");
        int cambios = scanner.nextInt();
        System.out.print("Ingrese la velocidad máxima: ");
        double velocidadMax = scanner.nextDouble();
        System.out.print("Ingrese el cilindraje: ");
        double cilindraje = scanner.nextDouble();
        System.out.print("¿El vehículo tiene transmisión automática? (AUTOMATICO/MANUAL): ");
        String input = scanner.next().toUpperCase();
        scanner.nextLine(); // Limpiar buffer
        Transmision transmision;
        try {
            transmision = Transmision.valueOf(input); // Convierte la entrada al ENUM
        } catch (IllegalArgumentException e) {
            System.out.println("Valor inválido. Se asignará el valor por defecto: MANUAL.");
            transmision = Transmision.MANUAL; // Valor por defecto si la entrada es inválida
        }
        System.out.print("¿El vehículo que tipo de combustion tiene? (GASOLINA/DIESEL/ELECTRICO/HIBRIDO");
        String input2 = scanner.next().toUpperCase();
        scanner.nextLine(); // Limpiar buffer
        Combustible combustible;
        try {
            combustible = Combustible.valueOf(input2); // Convierte la entrada al ENUM
        } catch (IllegalArgumentException e) {
            System.out.println("Valor inválido. Se asignará el valor por defecto: GASOLINA.");
            combustible = Combustible.GASOLINA; // Valor por defecto si la entrada es inválida
        }

        Vehiculo nuevoVehiculo = null;
        switch (tipoVehiculo) {
            case 1:
                nuevoVehiculo = new Moto(codigo, marca, modelo, esNuevo, cambios, velocidadMax, cilindraje, transmision,
                        combustible);
                break;
            case 2:

                System.out.print("Ingrese el número de pasajeros: ");
                int numeroPasajeros = scanner.nextInt();
                System.out.print("Ingrese el número de puertas: ");
                int numeroPuertas = scanner.nextInt();
                System.out.print("Ingrese el número de bolsas de aire: ");
                int numeroBolsasAire = scanner.nextInt();
                System.out.print("¿El vehículo tiene aire acondicionado? (true/false): ");
                boolean aireAcondicionado = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene ABS? (true/false): ");
                boolean abs = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene cámara reversa? (true/false): ");
                boolean camaraReversa = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene sensor de colisión? (true/false): ");
                boolean sensorColision = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene sensor de tráfico? (true/false): ");
                boolean sensorTrafico = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene asistente de permanencia en carril? (true/false): ");
                boolean asistentePermanenciaCarril = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene velocidad crucero? (true/false): ");
                boolean velocidadCrucero = scanner.nextBoolean();
                System.out.print("Ingrese la capacidad de carga: ");
                double capacidadCarga = scanner.nextDouble();

                // Crear un nuevo objeto Sedan con los datos proporcionados
                nuevoVehiculo = new Sedan(codigo, marca, modelo, esNuevo, cambios, velocidadMax, cilindraje,
                        transmision, combustible,
                        numeroPasajeros, numeroPuertas, numeroBolsasAire, aireAcondicionado, abs, camaraReversa,
                        sensorColision, sensorTrafico, asistentePermanenciaCarril, velocidadCrucero, capacidadCarga);

                break;
            case 3:
                System.out.print("Ingrese el número de caballos de fuerza: ");
                int caballosFuerza = scanner.nextInt();
                System.out.print("Ingrese el tiempo en segundos para alcanzar los 100 km/h: ");
                double tiempoCien = scanner.nextDouble();
                System.out.print("Ingrese el número de pasajeros: ");
                int numeroPasajerosDeportivo = scanner.nextInt();
                System.out.print("Ingrese el número de puertas: ");
                int numeroPuertasDeportivo = scanner.nextInt();
                System.out.print("Ingrese el número de bolsas de aire: ");
                int numeroBolsasAireDeportivo = scanner.nextInt();

                // Crear un nuevo objeto Deportivo con los parámetros especificados
                nuevoVehiculo = new Deportivo(codigo, marca, modelo, esNuevo, cambios, velocidadMax, cilindraje,
                        transmision, combustible,
                        numeroPasajerosDeportivo, numeroPuertasDeportivo, numeroBolsasAireDeportivo, caballosFuerza,
                        tiempoCien);
                break;
            case 4:
                System.out.print("Ingrese el número de pasajeros: ");
                int numeroPasajerosCamioneta = scanner.nextInt();
                System.out.print("Ingrese el número de puertas: ");
                int numeroPuertasCamioneta = scanner.nextInt();
                System.out.print("Ingrese el número de bolsas de aire: ");
                int numeroBolsasAireCamioneta = scanner.nextInt();
                System.out.print("¿El vehículo tiene aire acondicionado? (true/false): ");
                boolean aireAcondicionadoCamioneta = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene ABS? (true/false): ");
                boolean absCamioneta = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene cámara reversa? (true/false): ");
                boolean camaraReversaCamioneta = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene sensor de colisión? (true/false): ");
                boolean sensorColisionCamioneta = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene sensor de tráfico? (true/false): ");
                boolean sensorTraficoCamioneta = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene asistente de permanencia en carril? (true/false): ");
                boolean asistentePermanenciaCarrilCamioneta = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene velocidad crucero? (true/false): ");
                boolean velocidadCruceroCamioneta = scanner.nextBoolean();
                System.out.print("Ingrese la capacidad de carga: ");
                double capacidadCargaCamioneta = scanner.nextDouble();
                System.out.print("¿La camioneta es 4x4? (true/false): ");
                boolean cuatroxcuatro = scanner.nextBoolean();

                nuevoVehiculo = new Camioneta(codigo, marca, modelo, esNuevo, cambios, velocidadMax, cilindraje,
                        transmision, combustible,
                        numeroPasajerosCamioneta, numeroPuertasCamioneta, numeroBolsasAireCamioneta,
                        aireAcondicionadoCamioneta, absCamioneta, camaraReversaCamioneta,
                        sensorColisionCamioneta, sensorTraficoCamioneta, asistentePermanenciaCarrilCamioneta,
                        velocidadCruceroCamioneta, capacidadCargaCamioneta, cuatroxcuatro);
                break;
            case 5:
                // nuevoVehiculo = new Pickup(codigo,marca, modelo,esNuevo, cambios,
                // velocidadMax, cilindraje, transmision, combustible);
                break;
            case 6:
                System.out.print("Ingrese la autonomía (en km): ");
                double autonomia = scanner.nextDouble();
                System.out.print("Ingrese el tiempo de carga (en horas): ");
                double tiempoCarga = scanner.nextDouble();

                nuevoVehiculo = new Electrico(codigo, marca, modelo, esNuevo, cambios, velocidadMax, cilindraje,
                        transmision, combustible, autonomia, tiempoCarga);
                break;

            case 7:
                System.out.print("¿El vehículo es enchufable? (true/false): ");
                boolean enchufable = scanner.nextBoolean();
                System.out.print("¿El vehículo es ligero? (true/false): ");
                boolean ligero = scanner.nextBoolean();

                nuevoVehiculo = new Hibrido(codigo, marca, modelo, esNuevo, cambios, velocidadMax, cilindraje,
                        transmision, combustible, enchufable, ligero);
                break;
            case 8:
                System.out.print("Ingrese el número de pasajeros: ");
                int numeroPasajerosVan = scanner.nextInt();

                System.out.print("Ingrese el número de puertas: ");
                int numeroPuertasVan = scanner.nextInt();

                System.out.print("Ingrese el número de bolsas de aire: ");
                int numeroBolsasAireVan = scanner.nextInt();

                System.out.print("¿Tiene aire acondicionado? (true/false): ");
                boolean aireAcondicionadoVan = scanner.nextBoolean();

                System.out.print("¿Tiene sistema ABS? (true/false): ");
                boolean absVan = scanner.nextBoolean();

                System.out.print("¿Tiene cámara reversa? (true/false): ");
                boolean camaraReversaVan = scanner.nextBoolean();

                System.out.print("Ingrese la capacidad del maletero (en litros): ");
                double capacidadMaletero = scanner.nextDouble();

                nuevoVehiculo = new Van(codigo, marca, modelo, esNuevo, cambios, velocidadMax, cilindraje,
                        transmision, combustible, numeroPasajerosVan, numeroPuertasVan,
                        numeroBolsasAireVan, aireAcondicionadoVan, absVan, camaraReversaVan, capacidadMaletero);

                // Agregar el vehículo a la lista de vehículos
                break;
            case 9:
                System.out.print("Ingrese la capacidad de carga: ");
                double capacidadCargaCamion = scanner.nextDouble();
                System.out.print("¿El vehículo tiene aire acondicionado? (true/false): ");
                boolean aireAcondicionadoCamion = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene frenos de aire? (true/false): ");
                boolean frenosAire = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene ABS? (true/false): ");
                boolean absCamion = scanner.nextBoolean();
                System.out.print("Ingrese el número de ejes: ");
                int numeroEjesCamion = scanner.nextInt();
                System.out.print("Ingrese el tipo de camión (liviano/pesado): ");
                String tipoCamionStr = scanner.nextLine();

                nuevoVehiculo = new Camion(codigo, marca, modelo, esNuevo, cambios, velocidadMax, cilindraje,
                        transmision, combustible,
                        capacidadCargaCamion, aireAcondicionadoCamion, frenosAire, absCamion, numeroEjesCamion,
                        TipoCamion.valueOf(tipoCamionStr.toUpperCase()));
                break;
            case 10:
                System.out.print("Ingrese el número de pasajeros: ");
                int numeroPasajerosBus = scanner.nextInt();
                System.out.print("Ingrese el número de puertas: ");
                int numeroPuertasBus = scanner.nextInt();
                System.out.print("Ingrese el número de bolsas de aire: ");
                int numeroBolsasAireBus = scanner.nextInt();
                System.out.print("¿El vehículo tiene aire acondicionado? (true/false): ");
                boolean aireAcondicionadoBus = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene ABS? (true/false): ");
                boolean absBus = scanner.nextBoolean();
                System.out.print("¿El vehículo tiene cámara reversa? (true/false): ");
                boolean camaraReversaBus = scanner.nextBoolean();
                System.out.print("Ingrese el número de ejes: ");
                int numeroEjesBus = scanner.nextInt();
                System.out.print("Ingrese el número de salidas de emergencia: ");
                int numeroSalidasEmergencia = scanner.nextInt();
                System.out.print("Ingrese la capacidad del maletero: ");
                double capacidadMaleteroBus = scanner.nextDouble();

                nuevoVehiculo = new Bus(codigo, marca, modelo, esNuevo, cambios, velocidadMax, cilindraje, transmision,
                        combustible,
                        numeroPasajerosBus, numeroPuertasBus, numeroBolsasAireBus, aireAcondicionadoBus, absBus,
                        camaraReversaBus, numeroEjesBus,
                        numeroSalidasEmergencia, capacidadMaleteroBus);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de vehículo no válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        vehiculos.add(nuevoVehiculo);
        JOptionPane.showMessageDialog(null, "Vehículo agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(nuevoVehiculo.toString());
    }
}
