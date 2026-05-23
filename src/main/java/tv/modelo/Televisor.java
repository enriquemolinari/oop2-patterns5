package tv.modelo;

public class Televisor extends Observado {
    private EstadoTelevisor estadoActual;
    private int canalActual;
    private int volumenActual;

    public Televisor() {
        super();
        this.estadoActual = new Apagado();
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

    void cambiarEstado(EstadoTelevisor nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public void encender() {
        estadoActual.encender(this);
    }

    public void apagar() {
        estadoActual.apagar(this);
    }

    public void cambiarCanal(int canalSolicitado) {
        estadoActual.cambiarCanal(this, canalSolicitado);
    }

    public void subirVolumen() {
        estadoActual.subirVolumen(this);
    }

    public void bajarVolumen() {
        estadoActual.bajarVolumen(this);
    }
}
