package tv.modelo;

public class EstadoEncendido implements EstadoTelevisor {
    private Televisor tv;

    public EstadoEncendido(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void cambiarCanal(int canal) {
        tv.nuevoCanal(canal);
    }

    @Override
    public void subirVolumen() {
        tv.nuevoVolumen(1);
    }

    @Override
    public void bajarVolumen() {
        tv.nuevoVolumen(-1);
    }

    @Override
    public void apagar() {
        tv.nuevoEstado(new EstadoApagado(tv));
        tv.notificar(TelevisorEvento.APAGADO);
    }

    @Override
    public void encender() {

    }

    @Override
    public void mutear() {
        tv.nuevoEstado(new EstadoMuteado(tv));
        tv.nuevoVolumen(-tv.volumenActual());
        tv.notificar(TelevisorEvento.MUTEADO);
    }

    public String toString() {
        return "Encendido";
    }
}
