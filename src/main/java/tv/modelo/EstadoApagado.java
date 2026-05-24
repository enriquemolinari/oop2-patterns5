package tv.modelo;

public class EstadoApagado implements EstadoTelevisor {
    private Televisor tv;

    public EstadoApagado(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void cambiarCanal(int canal) {

    }

    @Override
    public void subirVolumen() {

    }

    @Override
    public void bajarVolumen() {

    }

    @Override
    public void apagar() {

    }

    @Override
    public void encender() {
        tv.nuevoEstado(new EstadoEncendido(tv));
        tv.notificar(TelevisorEvento.ENCENDIDO);
    }

    @Override
    public void mutear() {

    }

    public String toString() {
        return "Apagado";
    }
}
