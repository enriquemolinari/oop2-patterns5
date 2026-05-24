package tv.ui;

import tv.modelo.Televisor;

import javax.swing.*;
import java.awt.*;

public class ControlRemotoUI extends JFrame {
    private final Televisor televisor;

    public ControlRemotoUI(Televisor televisor) {
        super("Control Remoto");
        this.televisor = televisor;

        JPanel panel = new JPanel(new GridLayout(4, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        panel.add(crearBoton("Encender", this.televisor::encender));
        panel.add(crearBoton("Apagar", this.televisor::apagar));
        panel.add(crearBoton("Vol +", this.televisor::subirVolumen));
        panel.add(crearBoton("Vol -", this.televisor::bajarVolumen));
        panel.add(crearBoton("Mute", this.televisor::mute));
        panel.add(crearBoton("Canal 1", () -> this.televisor.cambiarCanal(1)));
        panel.add(crearBoton("Canal 2", () -> this.televisor.cambiarCanal(2)));
        panel.add(crearBoton("Canal 3", () -> this.televisor.cambiarCanal(3)));

        add(panel);
        setSize(320, 240);
        setLocation(580, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton crearBoton(String texto, Runnable accion) {
        JButton boton = new JButton(texto);
        boton.addActionListener(e -> accion.run());
        return boton;
    }
}

