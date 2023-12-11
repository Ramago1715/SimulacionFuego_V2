package SimulacionFuego;

import static java.lang.Thread.sleep;


public class FireController{

    private DTOController dtoController ;
    private FireView fireviewer;
    private FireModel fireModel;



    public static void main(String[] args) {
        FireController et = new FireController();
        et.fireviewer.setFireController(et);
        et.playAnimation();
    }


   
    public FireController() {
        this.dtoController = new DTOController();
        this.fireviewer = new FireView();
        this.fireModel = new FireModel(dtoController);


    }


   
    public void playAnimation() {
        while (true) {
            if(fireviewer.getUpdate()){
                setDtoController(this.fireviewer.getDtoController());
                this.fireModel = new FireModel(dtoController);
                this.fireviewer.setUpdate(false);
            }
            if (this.fireviewer.getControPanel().getAnimationControls().getPlayPause().isSelected()) {
                this.fireviewer.getViewer().paintBackground();
                this.fireviewer.getViewer().paintForegroundImage(this.fireModel);
                this.fireviewer.getControPanel().getAnimationControls().getPlayPause().setText("Pause");
            }else{
                this.fireviewer.getControPanel().getAnimationControls().getPlayPause().setText("Play");
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

    public DTOController dtoController() {
        return dtoController;
    }

    public void setDtoController(DTOController dtoController) {
        this.dtoController = dtoController;
    }
}
