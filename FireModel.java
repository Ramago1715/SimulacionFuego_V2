package SimulacionFuego;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class FireModel extends BufferedImage {
	private Temperatures temperaturas;
	private ColorPalette palette;
	private int width,heigth;
	private int posX,posY;
	
	public FireModel(int width, int heigth) {
		super(width,heigth,BufferedImage.TYPE_INT_ARGB);
		setWidth(width);
		setHeigth(heigth);
		this.temperaturas = new Temperatures(this.heigth,this.width,15,10);
		this.palette = new ColorPalette();
		palette.addcolortotarget(55,new Color(0,0,0,100));
		palette.addcolortotarget(60,new Color(155,0,0,110));
		palette.addcolortotarget(72,new Color(200,100,0,180));
		palette.addcolortotarget(112,new Color(235,235,40,250));
		palette.addcolortotarget(130,new Color(255,255,200,255));
		palette.calc();
		
		
		
	}
	public void next() {
		createFireImage();
		temperaturas.next();
	}
	
	
	public void createFireImage() {
		
		for(posX = 0;posX<=this.heigth -2;posX++) {
			for(posY = 0; posY<=this.width -1;posY++) {
				int temp = this.temperaturas.getTemp(posX, posY);
				int ARGB = this.palette.palette.get(temp).getARGB();
				this.setRGB(posY, posX,ARGB);
				
			}
		}
		
	}
	public void deletecolors(){
		for(posX = 0;posX<this.heigth;posX++) {
			for(posY = 0; posY<this.width;posY++) {
				int temp = this.temperaturas.getTemp(posX, posY);
				int ARGB = this.palette.palette.get(temp).getARGB();
				this.setRGB(posY, posX,ARGB);

			}
		}
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeigth() {
		return heigth;
	}
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Temperatures getTemperaturas() {
		return temperaturas;
	}

	public void setTemperaturas(Temperatures temperaturas) {
		this.temperaturas = temperaturas;
	}

	public ColorPalette getPalette() {
		return palette;
	}

	public void setPalette(ColorPalette palette) {
		this.palette = palette;
	}
}
