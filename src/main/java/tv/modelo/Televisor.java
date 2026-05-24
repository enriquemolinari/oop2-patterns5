package tv.modelo;

public class Televisor extends Observado {
    private int canalActual;
    private int volumenActual;
    private EstadoTelevisor estadoTelevisor;

    public Televisor() {
        super();
        this.estadoTelevisor = new EstadoApagado();
        this.canalActual = 1;
        this.volumenActual = 10;
    }

    public String estado() {
        return this.estadoTelevisor.toString();
    }

    void nuevoEstado(EstadoTelevisor nuevoEstado) {
        this.estadoTelevisor = nuevoEstado;
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
        this.estadoTelevisor.encender(this);
    }

    public void apagar() {
        this.estadoTelevisor.apagar(this);
    }

    public void cambiarCanal(int canalSolicitado) {
        this.estadoTelevisor.cambiarCanal(canalSolicitado, this);
    }

    public void subirVolumen() {
        this.estadoTelevisor.subirVolumen(this);
    }

    public void bajarVolumen() {
        this.estadoTelevisor.bajarVolumen(this);
    }

    public void mute() {
    }
}
