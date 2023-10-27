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
	private BufferStrategy bs;
    private int fireX;
    private int fireY;


	public Viewer(int pixWidth, int pixHeight) {
	    Dimension d = new Dimension(pixWidth, pixHeight);
        setFireX(pixWidth);
        setFireY(pixHeight);
	    this.setPreferredSize(d);
	    this.loadBackground();
	    this.bs = null;

	}

	private void loadBackground() {
		try {
            this.backgroundimg = ImageIO.read(new File("bg.jpg"));
        } catch (IOException e) {
        }	
	}
	
	public void paintForegroundImage(FireModel fireimg) {
        if (this.bs == null) {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(fireimg, (int) (getFireX()/2.3273),(int)(getFireY()/1.6516),(int)(this.getWidth()/2.3273),(int)(this.getHeight()/5.3895), null);

        fireimg.next();

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


    //Getters and setters
    public BufferedImage getBackgroundimg() {
        return backgroundimg;
    }

    public void setBackgroundimg(BufferedImage backgroundimg) {
        this.backgroundimg = backgroundimg;
    }

    public int getFireX() {
        return fireX;
    }

    public void setFireX(int fireX) {
        this.fireX = fireX;
    }

    public int getFireY() {
        return fireY;
    }

    public void setFireY(int fireY) {
        this.fireY = fireY;
    }
}