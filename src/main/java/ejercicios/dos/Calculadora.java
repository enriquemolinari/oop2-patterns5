package ejercicios.dos;

public class Calculadora {
    static final double VALOR_INICIAL = 0.0;
    static final String MSG_ESTADO_ERROR = "La calculadora está en estado de error";
    private double valorAcumulado;
    private EstadoCalculadora estado;

    public Calculadora() {
        this.estado = EstadoCalculadora.INICIAL;
        this.valorAcumulado = VALOR_INICIAL;
    }

    String estado() {
        return this.estado.name();
    }

    public void mas() {
        if (estado == EstadoCalculadora.INICIAL) {
            this.estado = EstadoCalculadora.ESPERANDO_OPERANDO;
        } else if (estado == EstadoCalculadora.ESPERANDO_OPERANDO) {
            this.estado = EstadoCalculadora.ERROR;
        } else if (estado == EstadoCalculadora.ERROR) {
            System.out.println(MSG_ESTADO_ERROR);
        }
    }

    public void borrar() {
        this.estado = EstadoCalculadora.INICIAL;
        this.valorAcumulado = VALOR_INICIAL;
    }

    public void valor(double valor) {
        if (estado == EstadoCalculadora.INICIAL) {
            this.valorAcumulado = valor;
        } else if (estado == EstadoCalculadora.ESPERANDO_OPERANDO) {
            this.valorAcumulado += valor;
            this.estado = EstadoCalculadora.INICIAL;
        } else if (estado == EstadoCalculadora.ERROR) {
            System.out.println(MSG_ESTADO_ERROR);
        }
    }

    public void mostrar() {
        if (estado == EstadoCalculadora.INICIAL) {
            System.out.println(this.valorAcumulado);
        } else if (estado == EstadoCalculadora.ESPERANDO_OPERANDO) {
            this.estado = EstadoCalculadora.ERROR;
        } else {
            System.out.println("La calculadora solo muestra en estado inicial");
        }
    }
}
