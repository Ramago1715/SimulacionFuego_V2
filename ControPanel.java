package SimulacionFuego;

import javax.swing.*;
import java.awt.*;

public class ControPanel extends JPanel{
    AnimationControls animationControls;
    GeneralConfiguration generalConfiguration;
    TemperatureConfiguration temperatureConfiguration;
    PaletteConfiguration paletteConfiguration;

    public ControPanel(){
        this.setLayout(new GridBagLayout());
        this.animationControls = new AnimationControls();
        this.generalConfiguration = new GeneralConfiguration();
        this.temperatureConfiguration = new TemperatureConfiguration();
        this.paletteConfiguration = new PaletteConfiguration();
        styleControls();
        addControlsPanel();


    }

    private void addControlsPanel(){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0;
        c.weighty = 5;
        this.add(animationControls,c);
        c.gridy = 4;
        this.add(generalConfiguration,c);

    }
    private  void styleControls(){
    animationControls.setFont(new Font("Italic", Font.ITALIC,10));
    }
}
