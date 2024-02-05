import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Banco> bancos = new ArrayList<>();

        Banco banco1=new Banco("sena");
        bancos.add(banco1);

        Cliente cliente1=new Cliente("1233", "alanis");
        Cliente cliente2=new Cliente("233", "alison");
        Cliente cliente3=new Cliente("222", "nicole");


        Cuenta cuenta1=new Cuenta(1, "ahorros", 300);
        Cuenta cuenta2=new Cuenta(2, "ahorros", 200);
        Cuenta cuenta3=new Cuenta(3, "corriente", 300);
        banco1.agregarCliente(cliente1, cuenta1);
        banco1.agregarCliente(cliente2, cuenta2);
        banco1.agregarCliente(cliente3, cuenta3);
        

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Crear/cambiar nombre Banco");
            System.out.println("2. Agregar Cliente a un Banco");
            System.out.println("3. Ver información clientes");
            System.out.println("4. Ver saldos totales cuentas de ahorros");
            System.out.println("5. Ver saldos totales cuentas corrientes");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                System.out.print("¿Desea cambiar el nombre del banco existente (S) o crear un nuevo banco (N)? ");
                String opcionCrearCambiar = scanner.next();
                if (opcionCrearCambiar.equalsIgnoreCase("S")) {
                    System.out.print("Ingrese el nombre del banco que desea cambiar: ");
                    String nombreBancoActual = scanner.next();
                    Banco bancoEncontrado = null;
                    for (Banco banco : bancos) {
                        if (banco.getNombre().equalsIgnoreCase(nombreBancoActual)) {
                            bancoEncontrado = banco;
                            break;
                        }
                    }
                    if (bancoEncontrado != null) {
                        System.out.print("Ingrese el nuevo nombre del Banco: ");
                        String nuevoNombreBanco = scanner.next();
                        bancoEncontrado.setNombre(nuevoNombreBanco);
                        System.out.println("Nombre del banco cambiado exitosamente a: " + nuevoNombreBanco);
                    } else {
                        System.out.println("El nombre del banco ingresado no coincide con el nombre actual del banco.");
                    }
                } else if (opcionCrearCambiar.equalsIgnoreCase("N")) {
                    System.out.print("Ingrese el nombre del nuevo Banco: ");
                    String nombreNuevoBanco = scanner.next();
                    Banco nuevoBanco = new Banco(nombreNuevoBanco);
                    bancos.add(nuevoBanco);
                    System.out.println("Nuevo banco creado con el nombre: " + nombreNuevoBanco);
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
                break;

            
            
                case 2:
                System.out.print("Ingrese el nombre del Banco: ");
                    String nombreBancoCliente = scanner.next();
                    Banco bancoEncontrado = null;
                    for (Banco banco : bancos) {
                        if (banco.getNombre().equals(nombreBancoCliente)) {
                            bancoEncontrado = banco;
                            break;
                        }
                    }if (bancoEncontrado != null){
                        System.out.print("Ingrese la cédula del cliente: ");
                        String cedula = scanner.next();
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombreCliente = scanner.next();
                        Cliente cliente = new Cliente(cedula, nombreCliente);
                        
                        System.out.print("Ingrese el número de cuenta: ");
                        int numeroCuenta = scanner.nextInt();
                        System.out.print("Ingrese el tipo de cuenta (Ahorros/Corriente): ");
                        String tipoCuenta = scanner.next();
                        System.out.print("Ingrese el saldo inicial: ");
                        double saldoInicial = scanner.nextDouble();
                        if (tipoCuenta.equalsIgnoreCase("Ahorros") || tipoCuenta.equalsIgnoreCase("Corriente")) {
                            Cuenta cuenta = new Cuenta(numeroCuenta, tipoCuenta, saldoInicial);
                            bancoEncontrado.agregarCliente(cliente, cuenta);
                            System.out.println("Cliente y cuenta agregados al Banco.");
                        } else {
                            System.out.println("Tipo de cuenta no válido. Debe ser 'Ahorros' o 'Corriente'.");
                        }
                    }else{
                        System.out.println("banco no esncontrado");
                    }
            
                break;
                case 3:
                System.out.println("clientes en todos los bancos: ");
                for (Banco banco : bancos) {
                    banco.mostrarInformacionClientes();
                }
                    
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del Banco: ");
                    String nombreBancoConsulta = scanner.next();
                    Banco bancoConsulta = null;
                    for (Banco banco : bancos) {
                        if (banco.getNombre().equals(nombreBancoConsulta)) {
                            bancoConsulta = banco;
                            break;
                        }
                    }if (bancoConsulta != null) {
                    double saldoAhorros = bancoConsulta.calcularSaldosTotales("ahorros");
                    System.out.println("Total de saldos en cuentas de ahorros: " + saldoAhorros);
                    }else {
                        System.out.println("Banco no encontrado.");
                    }
                    
                    break;
                case 5:
                System.out.print("Ingrese el nombre del Banco: ");
                    String nomBancoConsulta = scanner.next();
                    Banco banConsulta = null;
                    for (Banco banco2 : bancos) {
                        if (banco2.getNombre().equals(nomBancoConsulta)) {
                            banConsulta = banco2;
                            break;
                        }
                    }if (banConsulta != null) {
                        double saldoCorrientes = banConsulta.calcularSaldosTotales("corriente");
                        System.out.println("Total de saldos en cuentas corrientes: " + saldoCorrientes);
                    } else {
                        System.out.println("banco no encontrado");
                    }
                    
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
    }
}
}
