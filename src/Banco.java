import java.util.ArrayList;

public class Banco {

    private String nombre;
    private ArrayList<Cliente> clientes;
    private ArrayList<Cuenta> cuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.cuentas = new ArrayList<>();
    }


    public void agregarCliente(Cliente cliente, Cuenta cuenta) {
        clientes.add(cliente);
        cuentas.add(cuenta);
    }

    public void mostrarInformacionClientes() {
        System.out.println();
        System.out.println("Banco: " + nombre);
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            Cuenta cuenta = cuentas.get(i);
            System.out.println("Cedula: " + cliente.getCedula() + ", Nombre: " + cliente.getNombre() +
                    ", Número de cuenta: " + cuenta.getNumero() + ", Tipo: " + cuenta.getTipo() +
                    ", Saldo: " + cuenta.getSaldo());
        }
    }

    public double calcularSaldosTotales(String tipoCuenta) {
        double totalSaldo = 0;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getTipo().equals(tipoCuenta)) {
                totalSaldo += cuenta.getSaldo();
            }
        }
        return totalSaldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    
}