package SimulacionFuego;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AnimationControls extends JPanel {
    JToggleButton playPause;
    JButton apply;
    JButton stopButton;

    public AnimationControls(){
        this.setLayout(new GridBagLayout());
        setPlayPause(new JToggleButton("Play/Pause"));
        setApply(new JButton("Apply"));
        setStopButton(new JButton("Stop"));
        stylebuttons();
        addbuttonstopanel();

    }

    private void addbuttonstopanel(){
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 1;

        this.add(getPlayPause(),c);
        c.gridy = 2;
        this.add(getStopButton(),c);
        c.gridy = 3;
        this.add(getApply(),c);

    }

    private void stylebuttons(){
        Border compound = new CompoundBorder(new LineBorder(Color.white),new EmptyBorder(50,2,50,2));
        getPlayPause().setBorder(compound);
        getPlayPause().setPreferredSize(new Dimension(115,35));
        getPlayPause().setForeground(Color.white);
        getPlayPause().setBackground(new Color(118,182,188));

        getApply().setBorder(compound);
        getApply().setPreferredSize(new Dimension(115,35));
        getApply().setForeground(Color.white);
        getApply().setBackground(new Color(126,180,136));

        getStopButton().setBorder(compound);
        getStopButton().setPreferredSize(new Dimension(115,35));
        getStopButton().setForeground(Color.white);
        getStopButton().setBackground(new Color(249,199,132));


    }






    public JToggleButton getPlayPause() {
        return playPause;
    }

    public void setPlayPause(JToggleButton playPause) {
        this.playPause = playPause;
    }

    public JButton getApply() {
        return apply;
    }

    public void setApply(JButton apply) {
        this.apply = apply;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public void setStopButton(JButton stopButton) {
        this.stopButton = stopButton;
    }
}
