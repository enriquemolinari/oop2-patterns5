package tv.modelo;

public interface EstadoTelevisor {
    void cambiarCanal(int canal);

    void subirVolumen();

    void bajarVolumen();

    void apagar();

    void encender();

    void mutear();
}
