package SimulacionFuego;

import javax.swing.*;
import java.awt.*;

public class ControPanel extends JPanel{
    private AnimationControls animationControls;
    private GeneralConfiguration generalConfiguration;
    private TemperatureConfiguration temperatureConfiguration;
    private PaletteConfiguration paletteConfiguration;

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
        c.gridy = 2;
        this.add(generalConfiguration,c);
        c.gridy = 3;
        this.add(temperatureConfiguration,c);

    }
    private  void styleControls(){
    animationControls.setFont(new Font("Italic", Font.ITALIC,10));
    }


    public AnimationControls getAnimationControls() {
        return animationControls;
    }

    public void setAnimationControls(AnimationControls animationControls) {
        this.animationControls = animationControls;
    }

    public GeneralConfiguration getGeneralConfiguration() {
        return generalConfiguration;
    }

    public void setGeneralConfiguration(GeneralConfiguration generalConfiguration) {
        this.generalConfiguration = generalConfiguration;
    }

    public TemperatureConfiguration getTemperatureConfiguration() {
        return temperatureConfiguration;
    }

    public void setTemperatureConfiguration(TemperatureConfiguration temperatureConfiguration) {
        this.temperatureConfiguration = temperatureConfiguration;
    }

    public PaletteConfiguration getPaletteConfiguration() {
        return paletteConfiguration;
    }

    public void setPaletteConfiguration(PaletteConfiguration paletteConfiguration) {
        this.paletteConfiguration = paletteConfiguration;
    }
}
