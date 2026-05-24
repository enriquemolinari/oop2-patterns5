package ejercicios.dos;

public class Main {
    static void main() {
        Calculadora calculadora = new Calculadora();

        System.out.println("Estado inicial: " + calculadora.estado());

        calculadora.valor(10);

        System.out.println("Estado después de ingresar operando: " + calculadora.estado());

        calculadora.mas();
        calculadora.mas();
        calculadora.borrar();

        System.out.println("Estado después de ingresar operando cero: " + calculadora.estado());

        calculadora.valor(10);

        calculadora.mostrar();
    }
}
