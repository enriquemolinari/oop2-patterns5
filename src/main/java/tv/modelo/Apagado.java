package tv.modelo;

class Apagado implements EstadoTelevisor {

    @Override
    public void encender(Televisor tv) {
        tv.cambiarEstado(new Encendido());
        tv.notificar(TelevisorEvento.ENCENDIDO);
    }

    @Override
    public void cambiarCanal(Televisor tv, int canalSolicitado) {
        // No tiene efecto
    }

    @Override
    public void subirVolumen(Televisor tv) {
        // No tiene efecto
    }

    @Override
    public void bajarVolumen(Televisor tv) {
        // No tiene efecto
    }

    @Override
    public void apagar(Televisor tv) {
        // No tiene efecto
    }
}
