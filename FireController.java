package SimulacionFuego;

import static java.lang.Thread.sleep;


public class FireController{

    private DTOGeneralParameters dtoGeneralParameters;
    private FireView fireviewer;
    private FireModel fireModel;



    public static void main(String[] args) {
        FireController et = new FireController();
        et.fireviewer.setFireController(et);
        et.playAnimation();
    }


   
    public FireController() {
        this.dtoGeneralParameters = new DTOGeneralParameters();
        this.fireviewer = new FireView();
        this.fireModel = new FireModel(dtoGeneralParameters);


    }


   
    public void playAnimation() {
        while (true) {
            if(fireviewer.getUpdate()){
                setDtoGeneralParameters(this.fireviewer.getDtoGeneralParameters());
                this.fireModel = new FireModel(dtoGeneralParameters);
                this.fireviewer.setUpdate(false);
            }
            if (this.fireviewer.getControPanel().animationControls.playPause.isSelected()) {
                this.fireviewer.getViewer().paintBackground();
                this.fireviewer.getViewer().paintForegroundImage(this.fireModel);


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

    public DTOGeneralParameters getDtoGeneralParameters() {
        return dtoGeneralParameters;
    }

    public void setDtoGeneralParameters(DTOGeneralParameters dtoGeneralParameters) {
        this.dtoGeneralParameters = dtoGeneralParameters;
    }
}
