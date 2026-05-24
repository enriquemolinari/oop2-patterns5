package tv.modelo;

public class EstadoEncendido implements EstadoTelevisor {
    @Override
    public void cambiarCanal(int canal, Televisor tv) {
        tv.nuevoCanal(canal);
    }

    @Override
    public void subirVolumen(Televisor tv) {
        tv.nuevoVolumen(1);
    }

    @Override
    public void bajarVolumen(Televisor tv) {
        tv.nuevoVolumen(-1);
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
        tv.nuevoEstado(new EstadoMuteado());
        tv.nuevoVolumen(-tv.volumenActual());
        tv.notificar(TelevisorEvento.MUTEADO);
    }

    public String toString() {
        return "Encendido";
    }
}
