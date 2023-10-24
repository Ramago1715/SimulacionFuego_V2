package SimulacionFuego;

import javax.swing.*;

public class AnimationControls {
    JToggleButton playPause;
    JButton apply;
    JButton stopButton;

    public AnimationControls(){
        this.playPause = new JToggleButton("Play/Pause");
        this.apply = new JButton("Apply");
        this.stopButton = new JButton("Stop");
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
