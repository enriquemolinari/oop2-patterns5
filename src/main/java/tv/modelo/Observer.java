package tv.modelo;

public interface Observer {
    void update(Observado observado, TelevisorEvento evento);
}
