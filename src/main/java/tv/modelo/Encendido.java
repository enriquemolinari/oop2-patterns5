package tv.modelo;

class Encendido implements EstadoTelevisor {

    @Override
    public void encender(Televisor tv) {
        //nada
    }

    @Override
    public void cambiarCanal(Televisor tv, int canalSolicitado) {
        tv.nuevoCanal(canalSolicitado);
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
        tv.cambiarEstado(new Apagado());
        tv.notificar(TelevisorEvento.APAGADO);
    }
}
