package co.edu.unbosque.hilos.cajero;

public class CuentaBancaria {
    private int saldo = 50;

    public int getSaldo() {
        return saldo;
    }

    public void retirar(int monto) {
        saldo = saldo - monto;
    }
}
