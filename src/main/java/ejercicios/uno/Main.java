package ejercicios.uno;

public class Main {
    static void main() {
        Puerta puerta = new Puerta();

        System.out.println("Estado inicial: " + puerta.estado());

        puerta.abrir();

        System.out.println("Estado después de abrir: " + puerta.estado());

        puerta.abrir();

        System.out.println("Estado después de intentar abrir de nuevo: " + puerta.estado());

        puerta.cerrar();

        System.out.println("Estado después de cerrar: " + puerta.estado());

        puerta.cerrar();

        System.out.println("Estado después de intentar cerrar de nuevo: " + puerta.estado());
    }
}
