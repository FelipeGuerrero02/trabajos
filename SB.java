class FondosInsuficientesException extends Exception {
    public FondosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}
class CuentaBancaria {
    private double saldo;
    public CuentaBancaria(double saldoInicial) {
        saldo = saldoInicial;
    }
    public double getSaldo() {
        return saldo;
    }
    public void retirar(double cantidad) throws FondosInsuficientesException {
        if (cantidad > saldo) {
            throw new FondosInsuficientesException("Error: Fondos insuficientes para realizar el retiro.");
        } else {
            saldo -= cantidad;  
            System.out.println("Retiro exitoso. Saldo restante: " + saldo);
        }
    }
    public void depositar(double cantidad) {
        saldo += cantidad;  
        System.out.println("Depósito exitoso. Saldo actual: " + saldo);
    }
}
public class SB {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(500);
        System.out.println("Saldo inicial: " + cuenta.getSaldo());
        try {
            cuenta.retirar(600);  
        } catch (FondosInsuficientesException e) {
            System.out.println(e.getMessage());  
        }
        cuenta.depositar(200);
        try {
            cuenta.retirar(400); 
        } catch (FondosInsuficientesException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Saldo final: " + cuenta.getSaldo());
    }
}
