package tv.ui;

import tv.modelo.Observado;
import tv.modelo.Observer;
import tv.modelo.Televisor;
import tv.modelo.TelevisorEvento;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TvUI extends JFrame implements Observer {
    static final String LABEL_TV_APAGADA = "TV APAGADA";
    static final String LABEL_CANAL = "Canal ";
    static final String LABEL_VOLUMEN = "Volumen ";
    private final Televisor televisor;
    private final JLabel pantalla;
    private final JLabel estado;
    private Timer mensajeTemporal;
    private Map<TelevisorEvento, Runnable> mensajesEventos = new HashMap<>();

    public TvUI(Televisor televisor) {
        super("TV");
        this.televisor = televisor;

        this.pantalla = new JLabel(LABEL_TV_APAGADA, SwingConstants.CENTER);
        this.pantalla.setFont(new Font("SansSerif", Font.BOLD, 32));
        this.pantalla.setForeground(Color.GREEN);

        var canalVolumenInicial = LABEL_CANAL + this.televisor.canalActual() + " - " + LABEL_VOLUMEN + this.televisor.volumenActual();
        this.estado = new JLabel(canalVolumenInicial, SwingConstants.CENTER);
        this.estado.setFont(new Font("SansSerif", Font.PLAIN, 16));
        this.estado.setForeground(Color.LIGHT_GRAY);

        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        add(pantalla, BorderLayout.CENTER);
        add(estado, BorderLayout.SOUTH);

        setSize(420, 260);
        setLocation(120, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mensajesEventos.put(TelevisorEvento.ENCENDIDO, () -> {
            mostrarMensajeTemporal(LABEL_CANAL + televisor.canalActual());
        });

        mensajesEventos.put(TelevisorEvento.APAGADO, () -> {
            actualizarVistaBase(LABEL_TV_APAGADA);
        });

        mensajesEventos.put(TelevisorEvento.CANAL, () -> {
            mostrarMensajeTemporal(LABEL_CANAL + televisor.canalActual());
        });

        mensajesEventos.put(TelevisorEvento.VOLUMEN, () -> {
            mostrarMensajeTemporal(LABEL_VOLUMEN + televisor.volumenActual());
        });

        mensajesEventos.put(TelevisorEvento.MUTEADO, () -> {
//            actualizarVistaBase(LABEL_TV_MUTEADA);
            mostrarMensajeTemporal("Muteando...");
        });
    }

    @Override
    public void update(Observado observado, TelevisorEvento evento) {
        SwingUtilities.invokeLater(() -> this.mensajesEventos.get(evento).run());
    }

    private void actualizarVistaBase(String texto) {
        pantalla.setText(texto);
        estado.setText(LABEL_CANAL + televisor.canalActual() + " - Volumen " + televisor.volumenActual());
    }

    private void mostrarMensajeTemporal(String mensaje) {
        pantalla.setText(mensaje);
        if (mensajeTemporal != null && mensajeTemporal.isRunning()) {
            mensajeTemporal.stop();
        }
        mensajeTemporal = new Timer(2000, e -> actualizarVistaBase(televisor.estado()));
        mensajeTemporal.setRepeats(false);
        mensajeTemporal.start();
    }
}
