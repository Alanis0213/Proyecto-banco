public class Cuenta {

    private int numero;
    private String tipo;
    private double saldo;

    public Cuenta(int numero, String tipo, double saldo) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }
}