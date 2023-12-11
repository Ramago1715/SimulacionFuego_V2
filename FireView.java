package SimulacionFuego;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    private DTOController dtoController;
    private Boolean update;


    public  FireView(){
        this.update = false;
        this.controPanel = new ControPanel();
        this.viewer = new Viewer(512,512);
        this.controPanel.setVisible(true);
        this.viewer.setVisible(true);
        this.dtoController = new DTOController();
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

        c.gridx = 0;
        c.gridy =0;
        c.weightx = 2;
        c.weighty = 1;
        this.controPanel.getAnimationControls().getPlayPause().addActionListener(this);
        this.controPanel.getAnimationControls().getApply().addActionListener(this);
        this.controPanel.getAnimationControls().getStopButton().addActionListener(this);
        this.controPanel.getAnimationControls().getChangebackgroundimage().addActionListener(this);
        this.controPanel.getTemperatureConfiguration().getBottonUpTemps().addActionListener(this);
        this.controPanel.getPaletteConfiguration().getPalettebutton().addActionListener(this);
        JFormattedTextField colorlistener = this.controPanel.getPaletteConfiguration().getARGBtarget();

        colorlistener.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    Color selectedColor = JColorChooser.showDialog(null, "Seleccione un color", Color.BLACK);
                    if (selectedColor != null) {
                        colorlistener.setBackground(selectedColor);
                        colorlistener.setForeground(new Color(255,255,255,0));
                        colorlistener.setValue(selectedColor);

                    }
                }
            }
        });

        panel.add(this.controPanel, c);
        c.gridx=3;
        c.gridy = 0;
        this.add(this.controPanel.getPaletteConfiguration(),c);
        createtable();


    }

    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        panel.add(this.viewer, c);

    }


    private void configureJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);
        setVisible(true);
        this.setResizable(false);
        setTitle("Fire");
        setIconImage(new ImageIcon(getClass().getResource("fuego.png")).getImage());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play/Pause":

                break;
            case "Apply":
                this.dtoController.getDtoGeneralParameters().setFireWidth(Integer.parseInt(this.controPanel.getGeneralConfiguration().fireWidth.getText()));
                this.dtoController.getDtoGeneralParameters().setFireHeigth(Integer.parseInt(this.controPanel.getGeneralConfiguration().fireHeigth.getText()));
                this.dtoController.getDtoGeneralParameters().setFireXPosition(Integer.parseInt(this.controPanel.getGeneralConfiguration().fireXPosition.getText()));
                this.dtoController.getDtoGeneralParameters().setFireYPosition(Integer.parseInt(this.controPanel.getGeneralConfiguration().fireYPosition.getText()));
                this.dtoController.getDtoTemperatureParameters().setBottonUpTemps(this.controPanel.getTemperatureConfiguration().getBottonUpTemps().isSelected());
                this.dtoController.getDtoTemperatureParameters().setCellsDivider(Double.parseDouble(this.controPanel.getTemperatureConfiguration().getCellsDivider().getText()));
                this.dtoController.getDtoTemperatureParameters().setFixAtenuationFactor(Double.parseDouble(this.controPanel.getTemperatureConfiguration().getFixAtenuationFactor().getText()));
                this.dtoController.getDtoTemperatureParameters().setNewCoolPixelsPercentage(this.controPanel.getTemperatureConfiguration().getNewCoolPixelsPercentage().getValue());
                this.dtoController.getDtoTemperatureParameters().setNewHotPixelsPercentage(this.controPanel.getTemperatureConfiguration().getNewHotPixelsPercentage().getValue());

                actualizarJTable();


                this.update = true;
                this.controPanel.getAnimationControls().getStopButton().doClick();

                break;
            case "Stop":
                this.controPanel.getAnimationControls().getPlayPause().setSelected(false);
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
                    this.controPanel.getAnimationControls().getNameBack().setText(nombrebackground);
                    String carpetapadre = backgroundFile.getParentFile().getName();
                    this.controPanel.getAnimationControls().getCarpetapadre().setText(carpetapadre);

                    try {
                        BufferedImage backgroundImage = ImageIO.read(backgroundFile);
                        this.viewer.setBackgroundimg(backgroundImage);

                        String resolucion = backgroundImage.getHeight() + "x" + backgroundImage.getWidth();
                        this.controPanel.getAnimationControls().getResolucion().setText(resolucion);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                break;
            case "ADD":
                int temperature = Integer.parseInt(this.controPanel.getPaletteConfiguration().getTemperaturetarget().getValue().toString());
                Color color = (Color) this.controPanel.getPaletteConfiguration().getARGBtarget().getValue();
                dtoController.getDtoPaletteParameters().addtarget(temperature,color);
                this.controPanel.getPaletteConfiguration().getDefaultTableModel().addRow(new Object[]{(Integer)temperature,(Color)color
                });
                break;
            default:
                break;
        }
    }


private void createtable(){
    for(int x =0; x<=this.dtoController.getDtoPaletteParameters().getColortargets().size()-1;x++){
        this.controPanel.getPaletteConfiguration().getDefaultTableModel().addRow(new Object[]{
            (Integer)this.dtoController.getDtoPaletteParameters().getColortargets().get(x).getTemperature(),(Color)this.dtoController.getDtoPaletteParameters().getColortargets().get(x).color
        });

    }


}
private void actualizarJTable(){
        for (int x = 0;x<= this.controPanel.getTemperatureConfiguration().getCellsPonderation().getRowCount()-1;x++){
            for (int y = 0;y<=this.controPanel.getTemperatureConfiguration().getCellsPonderation().getColumnCount()-1;y++){
              double valorcasilla = Double.parseDouble(this.controPanel.getTemperatureConfiguration().getCellsPonderation().getValueAt(x,y).toString());
              this.getDtoController().getDtoTemperatureParameters().setCellsponderation(x,y,valorcasilla);
            }
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

    public DTOController getDtoController() {
        return dtoController;
    }

    public void setDtoController(DTOController dtoController) {
        this.dtoController = dtoController;
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }
}
