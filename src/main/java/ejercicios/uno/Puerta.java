package ejercicios.uno;

public class Puerta {

    private final static int CERRADA = 0;
    private final static int ABIERTA = 1;
    int state = CERRADA;

    public String estado() {
        if (this.state == CERRADA) return "CERRADA";
        if (this.state == ABIERTA) return "ABIERTA";
        else throw new RuntimeException("Estado desconocido");
    }

    public void abrir() {
        if (state == CERRADA) {
            System.out.print("Abriendo la puerta...");
            state = ABIERTA;
        } else if (state == ABIERTA) {
            System.out.println("NO se puede abrir una puerta abierta");
        }
    }

    public void cerrar() {
        if (state == CERRADA) {
            System.out.println("no se puede cerrar una puerta cerrada");
        } else if (state == ABIERTA) {
            System.out.println("Abriendo la puerta...");
            state = ABIERTA;
        }
    }
}
