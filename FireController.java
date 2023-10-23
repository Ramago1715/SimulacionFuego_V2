package SimulacionFuego;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static java.lang.Thread.sleep;

import javax.swing.JFrame;
import javax.swing.JToggleButton;


public class FireController extends JFrame {


    private FireView fireviewer;
    private FireModel animation;



    public static void main(String[] args) {
        FireController et = new FireController();
        et.playAnimation();
    }


   
    public FireController() {
        this.initClass();
        this.setVisible(true);
        this.pack();
    }


   
    public void playAnimation() {
        while (true) {
            if (this.tbPlay.isSelected()) {
                this.fireviewer.viewer.paintBackground();
                this.fireviewer.viewer.paintForegroundImage(this.animation);
            }
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }
    private void initClass() {
        this.animation = new FireModel(255, 95);
    }






    


}
