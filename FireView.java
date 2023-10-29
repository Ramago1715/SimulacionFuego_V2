package SimulacionFuego;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FireView extends JFrame implements ComponentListener, ActionListener, ItemListener{
    private Viewer viewer;
    private ControPanel controPanel;
    private FireController fireController;
    private DTOGeneralParameters dtoGeneralParameters;
    private Boolean update;
    JTextField nameBack;
    JTextField carpetapadre;
    JTextField resolucion;

    public  FireView(){
        this.update = false;
        this.controPanel = new ControPanel();
        this.viewer = new Viewer(512,512);
        this.controPanel.setVisible(true);
        this.viewer.setVisible(true);
        this.dtoGeneralParameters = new DTOGeneralParameters();
        this.nameBack = new JTextField("ChimeneaDefault");
        this.carpetapadre = new JTextField("SimulacionFuegoV2");
        this.resolucion = new JTextField("512x512");
        this.configureJFrame();
        this.addUIComponents();
        this.pack();

    }


    public void addUIComponents() {
        Container panel;
        panel = this.getContentPane();
        this.addViewerToPane(panel);
        this.addControlpaneltoPanel(panel);
    }

    private void addControlpaneltoPanel(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;

        c.gridx = 1;
        c.gridy =0;
        c.weightx = 2;
        c.weighty = 1;
        this.controPanel.animationControls.getPlayPause().addActionListener(this);
        this.controPanel.animationControls.getApply().addActionListener(this);
        this.controPanel.animationControls.getStopButton().addActionListener(this);
        this.controPanel.animationControls.getChangebackgroundimage().addActionListener(this);
        panel.add(this.controPanel, c);
        c.gridy = 1;
        this.add(this.nameBack,c);
        c.gridy = 2;
        this.add(this.carpetapadre,c);
        c.gridy = 3;
        this.add(this.resolucion,c);


    }

    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        panel.add(this.viewer, c);
        this.resolucion.setColumns(10);
        this.carpetapadre.setColumns(10);
        this.nameBack.setColumns(10);
    }

    private void configureJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);
        setVisible(true);
        this.setResizable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play/Pause":

                break;
            case "Apply":
                this.dtoGeneralParameters.setFireWidth(Integer.parseInt(this.controPanel.generalConfiguration.fireWidth.getText()));
                this.dtoGeneralParameters.setFireHeigth(Integer.parseInt(this.controPanel.generalConfiguration.fireHeigth.getText()));
                this.dtoGeneralParameters.setFireXPosition(Integer.parseInt(this.controPanel.generalConfiguration.fireXPosition.getText()));
                this.dtoGeneralParameters.setFireYPosition(Integer.parseInt(this.controPanel.generalConfiguration.fireYPosition.getText()));
                this.update = true;
                this.controPanel.animationControls.stopButton.doClick();

                break;
            case "Stop":
                this.controPanel.animationControls.playPause.setSelected(false);
                this.fireController.getFireModel().getTemperaturas().initblack();
                this.fireController.getFireModel().deletecolors();
                this.viewer.paintBackground();
                this.viewer.paintForegroundImage(this.getFireController().getFireModel());
                break;
            case "Cambiar Fondo":
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Imagenes", "jpg", "jpeg", "png", "gif", "bmp");
                fileChooser.setFileFilter(imageFilter);
                int resultado = fileChooser.showOpenDialog(this);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File backgroundFile = fileChooser.getSelectedFile();
                    String nombrebackground = backgroundFile.getName();
                    this.nameBack.setText(nombrebackground);
                    String carpetapadre = backgroundFile.getParentFile().getName();
                    this.carpetapadre.setText(carpetapadre);

                    try {
                        BufferedImage backgroundImage = ImageIO.read(backgroundFile);
                        this.viewer.setBackgroundimg(backgroundImage);

                        String resolucion = backgroundImage.getHeight() + "x" + backgroundImage.getWidth();
                        this.resolucion.setText(resolucion);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                break;
            default:
                break;
        }
    }




    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public ControPanel getControPanel() {
        return controPanel;
    }

    public void setControPanel(ControPanel controPanel) {
        this.controPanel = controPanel;
    }

    public FireController getFireController() {
        return fireController;
    }

    public void setFireController(FireController fireController) {
        this.fireController = fireController;
    }

    public DTOGeneralParameters getDtoGeneralParameters() {
        return dtoGeneralParameters;
    }

    public void setDtoGeneralParameters(DTOGeneralParameters dtoGeneralParameters) {
        this.dtoGeneralParameters = dtoGeneralParameters;
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }
}
