package SimulacionFuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FireView extends JFrame implements ComponentListener, ActionListener, ItemListener{
    Viewer viewer;
    ControPanel controPanel;
    public FireView(){
        configureJFrame();
        this.configureJFrame();
        this.addUIComponents();
    }

    public void addUIComponents() {
        Container panel;
        panel = this.getContentPane();
        this.addViewerToPane(panel);
        this.addButtonsToPane(panel);
    }

    private void addButtonsToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.gridy =1;
        this.tbPlay = new JToggleButton("Play/Stop");
        this.tbPlay.addActionListener(this);
        panel.add(this.tbPlay, c);
    }

    private void addViewerToPane(Container panel) {
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.SOUTH;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
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
    }


    @Override
    public void actionPerformed(ActionEvent e) {

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
