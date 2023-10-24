package SimulacionFuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FireView extends JFrame implements ComponentListener, ActionListener, ItemListener{
    Viewer viewer;
    ControPanel controPanel;
    public FireView(){
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

        c.gridx = 0;
        c.gridy =0;
        c.weightx = 0;
        c.weighty = 0;

        this.controPanel.animationControls.getPlayPause().addComponentListener(this);
        this.controPanel.animationControls.getApply().addComponentListener(this);
        this.controPanel.animationControls.getStopButton().addComponentListener(this);
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

        this.viewer = new Viewer(512, 512);
        panel.add(this.viewer, c);
    }

    private void configureJFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.addComponentListener(this);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "Play/Pause":
                System.out.println("hgo");
                break;
            case "Apply":
                int fireWidth = Integer.parseInt(this.controPanel.generalConfiguration.fireWidth.getText());
                int fireHeigth = Integer.parseInt(this.controPanel.generalConfiguration.fireHeigth.getText());
                int fireXPosition = Integer.parseInt(this.controPanel.generalConfiguration.fireXPosition.getText());
                int fireYPosition = Integer.parseInt(this.controPanel.generalConfiguration.fireYPosition.getText());
                break;
            case "Stop":
                System.out.println("hola");
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
}
