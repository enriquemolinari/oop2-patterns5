package tv.modelo;

import tv.ui.ControlRemotoUI;
import tv.ui.TvUI;

import javax.swing.*;

public class Main {
    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Televisor televisor = new Televisor();
            TvUI tvUI = new TvUI(televisor);
            ControlRemotoUI controlRemotoUI = new ControlRemotoUI(televisor);

            televisor.registrarObserver(tvUI);

            tvUI.setVisible(true);
            controlRemotoUI.setVisible(true);
        });
    }
}
