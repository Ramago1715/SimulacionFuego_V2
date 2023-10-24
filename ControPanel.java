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

        addButtonstoPanel();


    }

    private void addButtonstoPanel(){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0;
        c.weighty = 0;

        this.add(animationControls.getPlayPause(),c);

        c.gridy = 2;
        this.add(animationControls.getStopButton(),c);

        c.gridy = 3;

        this.add(new JLabel("Fire Width: "),c);

        c.gridy = 4;
        this.add(generalConfiguration.getFireWidth(),c);
        c.gridy = 5;
        this.add(new JLabel("Fire Higth: "),c);
        c.gridy = 6;
        this.add(generalConfiguration.getFireHeigth(),c);
        c.gridy = 7;
        this.add(new JLabel("Fire Position X : "),c);
        c.gridy = 8;
        this.add(generalConfiguration.getFireXPosition(),c);
        c.gridy = 9;
        this.add(new JLabel("Fire Position Y: "),c);
        c.gridy = 10;
        this.add(generalConfiguration.getFireYPosition(),c);
        c.gridy = 11;
        this.add(animationControls.getApply(),c);


    }
}
