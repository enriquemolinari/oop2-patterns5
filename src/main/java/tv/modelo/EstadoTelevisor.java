package tv.modelo;

public interface EstadoTelevisor {
    void cambiarCanal(int canal, Televisor tv);

    void subirVolumen(Televisor tv);

    void bajarVolumen(Televisor tv);

    void apagar(Televisor tv);

    void encender(Televisor tv);

    void mutear(Televisor tv);
}
