package co.edu.unbosque.hilos.cuentas;

public class CuentaBanco {

    private int saldo = 50;

    public void retirar(int monto) {
        saldo = saldo - monto;
    }

    public int getSaldo() {
        return saldo;
    }

}

