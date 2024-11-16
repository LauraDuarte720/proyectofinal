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
        empleados.add(new Empleado("Luis", "Martínez", "1112223334", "luis.martinez@mail.com", "luis001", "contraseñaA", "respuestaA", administrador1));
        administradores.add(new Administrador("Juan", "Pérez", "1234567890", "juan.perez@mail.com", "juan123", "contraseña1", "respuesta1"));
        
        // Vehículos de ejemplo
        vehiculos.add(new Moto( "MOTO001", "Yamaha", "MT-07", true, 6, 200.0, 689.0, Transmision.MANUAL, Combustible.GASOLINA));
        vehiculos.add(new Moto("MOTO002", "Kawasaki", "Ninja 400", false, 6, 190.0, 399.0, Transmision.MANUAL, Combustible.GASOLINA));
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
            System.out.println("2. Registrar transacción");
            System.out.println("3. Agregar nuevo vehículo");
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
            System.out.println(vehiculo.mostrarDetalles());
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

        //public Cliente(String nombres, String apellidos, String cedula, String correo, String telefono, int edad) 
        Cliente cliente = new Cliente(nombreCliente,apellidoCliente, cedulaCliente,correoCliente, telefonoCliente, edadCliente);
        clientes.add(cliente);

        // Seleccionar vehículo
        System.out.println("=== Selección de Vehículo ===");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculos.get(i).mostrarDetalles());
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
                JOptionPane.showMessageDialog(null, "Tipo de transacción no válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        transacciones.add(transaccion);
        JOptionPane.showMessageDialog(null, "Transacción registrada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(transaccion.detallesTransaccion());
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

        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();
        System.out.print("¿El vehículo es nuevo? (true/false): ");
        boolean esNuevo = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese la cantidad de cambios: ");
        int cambios = scanner.nextInt();
        System.out.print("Ingrese la velocidad máxima: ");
        int velocidadMax = scanner.nextInt();
        System.out.print("Ingrese el cilindraje: ");
        int cilindraje = scanner.nextInt();
        System.out.print("¿El vehículo es automático? (true/false): ");
        boolean esAutomatico = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el tipo de combustible: ");
        String tipoCombustible = scanner.nextLine();

        Vehiculo nuevoVehiculo = null;
        switch (tipoVehiculo) {
            case 1:
                nuevoVehiculo = new Moto(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            case 2:
                nuevoVehiculo = new Sedan(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            case 3:
                nuevoVehiculo = new Deportivo(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            case 4:
                nuevoVehiculo = new Camioneta(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            case 5:
                nuevoVehiculo = new Pickup(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            case 6:
                nuevoVehiculo = new Electrico(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            case 7:
                nuevoVehiculo = new Hibrido(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            case 8:
                nuevoVehiculo = new Van(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            case 9:
                nuevoVehiculo = new Camion(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            case 10:
                nuevoVehiculo = new Bus(marca, esNuevo, modelo, cambios, velocidadMax, cilindraje, esAutomatico, tipoCombustible);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de vehículo no válido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        vehiculos.add(nuevoVehiculo);
        JOptionPane.showMessageDialog(null, "Vehículo agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(nuevoVehiculo.mostrarDetalles());
    }
}
