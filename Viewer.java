package SimulacionFuego;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Dimension;
import java.awt.Graphics;


public class Viewer extends Canvas {
	private BufferedImage backgroundimg;
	private FireModel fireimg;
	private BufferStrategy bs;


	public Viewer(int pixWidth, int pixHeight, FireModel fireimg) {
	    Dimension d = new Dimension(pixWidth, pixHeight);
	    this.setPreferredSize(d);
	    this.loadBackground();
	    this.fireimg = fireimg;
	    this.bs = null;
	}

	private void loadBackground() {
		try {
            this.backgroundimg = ImageIO.read(new File("bg.jpg"));
        } catch (IOException e) {
        }	
	}
	
	public void paintForegroundImage() {
        if (this.bs == null) {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(this.fireimg, (int) (this.getWidth()/2.3273),(int)(this.getHeight()/1.6516),(int)(this.getWidth()/2.3273),(int)(this.getHeight()/5.3895), null);
        this.fireimg.next();

        bs.show();
        g.dispose();
    }
	
	
	public void paintBackground() {
        if (this.bs == null) {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(this.backgroundimg, 0, 0, this.getWidth(), this.getHeight(), null);
       

        
       
    }
	
}