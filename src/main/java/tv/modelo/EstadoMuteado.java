package tv.modelo;

public class EstadoMuteado implements EstadoTelevisor {
    @Override
    public void cambiarCanal(int canal, Televisor tv) {

    }

    @Override
    public void subirVolumen(Televisor tv) {
        tv.nuevoVolumen(1);
        tv.nuevoEstado(new EstadoEncendido());
        tv.notificar(TelevisorEvento.ENCENDIDO);
    }

    @Override
    public void bajarVolumen(Televisor tv) {

    }

    @Override
    public void apagar(Televisor tv) {
        tv.nuevoEstado(new EstadoApagado());
        tv.notificar(TelevisorEvento.APAGADO);
    }

    @Override
    public void encender(Televisor tv) {

    }

    @Override
    public void mutear(Televisor tv) {

    }

    public String toString() {
        return "Muteado";
    }
}
