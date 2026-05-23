package tv.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Observado {
    private final List<Observer> observadores;

    public Observado() {
        this.observadores = new ArrayList<>();
    }

    public Observado(List<Observer> observadores) {
        this.observadores = new ArrayList<>(observadores);
    }

    public void registrarObserver(Observer observador) {
        this.observadores.add(observador);
    }

    void notificar(TelevisorEvento evento) {
        for (Observer observador : observadores) {
            observador.update(this, evento);
        }
    }
}
