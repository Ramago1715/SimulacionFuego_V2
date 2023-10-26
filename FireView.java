package SimulacionFuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FireView extends JFrame implements ComponentListener, ActionListener, ItemListener{
    Viewer viewer;
    ControPanel controPanel;
    FireController fireController;

    public  FireView(){
        this.controPanel = new ControPanel();
        this.viewer = new Viewer(512,512);
        this.controPanel.setVisible(true);
        this.viewer.setVisible(true);
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
        panel.add(this.controPanel, c);

    }

    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 1;
        c.gridwidth = 1;


        panel.add(this.viewer, c);
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

                int fireWidth = Integer.parseInt(this.controPanel.generalConfiguration.fireWidth.getText());
                int fireHeigth = Integer.parseInt(this.controPanel.generalConfiguration.fireHeigth.getText());
                int fireXPosition = Integer.parseInt(this.controPanel.generalConfiguration.fireXPosition.getText());
                int fireYPosition = Integer.parseInt(this.controPanel.generalConfiguration.fireYPosition.getText());
                FireModel newfire = new FireModel(fireWidth,fireHeigth);
                this.viewer.paintForegroundImage(newfire);
                this.viewer.setFireX(fireXPosition);
                this.viewer.setFireY(fireYPosition);
                this.controPanel.animationControls.stopButton.doClick();

                break;
            case "Stop":
                this.controPanel.animationControls.playPause.setSelected(false);
                this.fireController.getFireModel().getTemperaturas().initblack();
                this.fireController.getFireModel().deletecolors();
                this.viewer.paintBackground();
                this.viewer.paintForegroundImage(this.getFireController().getFireModel());









                break;
            default:
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
}
