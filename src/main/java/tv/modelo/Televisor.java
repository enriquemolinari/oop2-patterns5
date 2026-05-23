package tv.modelo;

public class Televisor extends Observado {
    private int canalActual;
    private int volumenActual;
    private Estado estado;

    public Televisor() {
        super();
        this.estado = Estado.APAGADO;
        this.canalActual = 1;
        this.volumenActual = 10;
    }

    public int volumenActual() {
        return this.volumenActual;
    }

    public int canalActual() {
        return this.canalActual;
    }

    void nuevoVolumen(int cambioVolumen) {
        // volumen ni menor que cero ni mayor a 100 nunca
        int nuevoVolumen = Math.max(0, Math.min(100, this.volumenActual + cambioVolumen));
        if (nuevoVolumen == this.volumenActual) {
            return;
        }
        this.volumenActual = nuevoVolumen;
        notificar(TelevisorEvento.VOLUMEN);
    }

    void nuevoCanal(int canal) {
        if (this.canalActual == canal) {
            return;
        }
        this.canalActual = canal;
        notificar(TelevisorEvento.CANAL);
    }

    public void encender() {
        if (estado == Estado.APAGADO) {
            this.estado = Estado.ENCENDIDO;
            this.notificar(TelevisorEvento.ENCENDIDO);
        }
        // si esta ENCEDNDIDO no hago nada
    }

    public void apagar() {
        if (estado == Estado.ENCENDIDO) {
            this.estado = Estado.APAGADO;
            this.notificar(TelevisorEvento.APAGADO);
        }
        //Si esta APAGADO no hago nada
    }

    public void cambiarCanal(int canalSolicitado) {
        if (estado == Estado.ENCENDIDO) {
            this.nuevoCanal(canalSolicitado);
        }
        // Si essta APAGADO no hago nada
    }

    public void subirVolumen() {
        if (estado == Estado.ENCENDIDO) {
            this.nuevoVolumen(1);
        }
        // Si essta APAGADO no hago nada
    }

    public void bajarVolumen() {
        if (estado == Estado.ENCENDIDO) {
            this.nuevoVolumen(-1);
        }
        // Si essta APAGADO no hago nada
    }
}
