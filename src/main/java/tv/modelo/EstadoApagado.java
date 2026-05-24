package tv.modelo;

public class EstadoApagado implements EstadoTelevisor {
    @Override
    public void cambiarCanal(int canal, Televisor tv) {

    }

    @Override
    public void subirVolumen(Televisor tv) {

    }

    @Override
    public void bajarVolumen(Televisor tv) {

    }

    @Override
    public void apagar(Televisor tv) {

    }

    @Override
    public void encender(Televisor tv) {
        tv.nuevoEstado(new EstadoEncendido());
        tv.notificar(TelevisorEvento.ENCENDIDO);
    }

    public String toString() {
        return "Apagado";
    }
}
