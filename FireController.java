package SimulacionFuego;

import static java.lang.Thread.sleep;


public class FireController{


    private FireView fireviewer;
    private FireModel fireModel;



    public static void main(String[] args) {
        FireController et = new FireController();
        et.fireviewer.setFireController(et);
        et.playAnimation();
    }


   
    public FireController() {
        this.fireviewer = new FireView();
        this.fireModel = new FireModel(255, 95);

    }


   
    public void playAnimation() {
        while (true) {
            if (this.fireviewer.controPanel.animationControls.playPause.isSelected()) {
                this.fireviewer.viewer.paintBackground();
                this.fireviewer.viewer.paintForegroundImage(this.fireModel);

            }
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }

    public FireView getFireviewer() {
        return fireviewer;
    }

    public void setFireviewer(FireView fireviewer) {
        this.fireviewer = fireviewer;
    }

    public FireModel getFireModel() {
        return fireModel;
    }

    public void setFireModel(FireModel fireModel) {
        this.fireModel = fireModel;
    }
}
