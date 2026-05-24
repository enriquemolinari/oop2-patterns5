package tv.modelo;

public class Televisor extends Observado {
    private int canalActual;
    private int volumenActual;
    private EstadoTelevisor estadoTelevisor;

    public Televisor() {
        super();
        this.estadoTelevisor = new EstadoApagado(this);
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
        this.estadoTelevisor.encender();
    }

    public void apagar() {
        this.estadoTelevisor.apagar();
    }

    public void cambiarCanal(int canalSolicitado) {
        this.estadoTelevisor.cambiarCanal(canalSolicitado);
    }

    public void subirVolumen() {
        this.estadoTelevisor.subirVolumen();
    }

    public void bajarVolumen() {
        this.estadoTelevisor.bajarVolumen();
    }

    public void mute() {
        this.estadoTelevisor.mutear();
    }

    public void encenderCuandoApagado() {
        this.nuevoEstado(new EstadoEncendido(this));
        this.notificar(TelevisorEvento.ENCENDIDO);
    }

    public void apagarCuandoEncendido() {
        this.nuevoEstado(new EstadoApagado(this));
        this.notificar(TelevisorEvento.APAGADO);
    }

    public void mutearCuandoEntendido() {
        this.nuevoEstado(new EstadoMuteado(this));
        this.nuevoVolumen(-this.volumenActual());
        this.notificar(TelevisorEvento.MUTEADO);
    }

    public void subirVolumenCuandoMuteado() {
        this.nuevoVolumen(1);
        this.nuevoEstado(new EstadoEncendido(this));
        this.notificar(TelevisorEvento.ENCENDIDO);
    }

    public void apagarCuandoMuteado() {
        this.nuevoEstado(new EstadoApagado(this));
        this.notificar(TelevisorEvento.APAGADO);
    }
}
