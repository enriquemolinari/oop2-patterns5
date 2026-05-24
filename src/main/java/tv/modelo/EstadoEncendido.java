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
        tv.apagarCuandoEncendido();
    }

    @Override
    public void encender() {

    }

    @Override
    public void mutear() {
        tv.mutearCuandoEntendido();
    }

    public String toString() {
        return "Encendido";
    }
}
