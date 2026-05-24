package tv.modelo;

public class EstadoMuteado implements EstadoTelevisor {
    private Televisor tv;

    public EstadoMuteado(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void cambiarCanal(int canal) {

    }

    @Override
    public void subirVolumen() {
        tv.nuevoVolumen(1);
        tv.nuevoEstado(new EstadoEncendido(tv));
        tv.notificar(TelevisorEvento.ENCENDIDO);
    }

    @Override
    public void bajarVolumen() {

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

    }

    public String toString() {
        return "Muteado";
    }
}
