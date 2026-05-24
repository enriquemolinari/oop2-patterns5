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
        tv.subirVolumenCuandoMuteado();
    }

    @Override
    public void bajarVolumen() {

    }

    @Override
    public void apagar() {
        tv.apagarCuandoMuteado();
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
