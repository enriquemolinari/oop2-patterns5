package tv.modelo;

interface EstadoTelevisor {
    void encender(Televisor tv);

    void cambiarCanal(Televisor tv, int canalSolicitado);

    void subirVolumen(Televisor tv);

    void bajarVolumen(Televisor tv);

    void apagar(Televisor tv);
}
