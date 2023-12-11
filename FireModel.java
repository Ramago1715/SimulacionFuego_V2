package SimulacionFuego;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class FireModel extends BufferedImage {
	private Temperatures temperaturas;
	private ColorPalette palette;
	private int width,heigth;
	private int posX,posY;
	private DTOPaletteParameters dtoPaletteParameters;
	
	public FireModel(DTOController dtoController) {
		super(dtoController.getDtoGeneralParameters().getFireWidth(), dtoController.getDtoGeneralParameters().getFireHeigth(),BufferedImage.TYPE_INT_ARGB);
		this.setWidth(dtoController.getDtoGeneralParameters().getFireWidth());
		this.setHeigth(dtoController.getDtoGeneralParameters().getFireHeigth());
		this.setPosX(dtoController.getDtoGeneralParameters().getFireXPosition());
		this.setPosY(dtoController.getDtoGeneralParameters().getFireYPosition());
		this.dtoPaletteParameters = dtoController.getDtoPaletteParameters();
		this.temperaturas = new Temperatures(this.width,this.heigth,dtoController.getDtoTemperatureParameters());
		this.palette = new ColorPalette();
		settargetstopalette();
		palette.calc();

	}
	public void next() {
		createFireImage();
		temperaturas.next();
	}

	public void settargetstopalette(){
		for(int i = 0;i<=this.dtoPaletteParameters.getColortargets().size()-1;i++){
			palette.addcolortotarget(this.dtoPaletteParameters.getColortargets().get(i));
		}
	}
	
	public void createFireImage() {

		for (int x = 0; x <= this.getTemperaturas().getHeigth() - 2; x++) {
			for (int y = 0; y <= this.getTemperaturas().getWidth() - 1; y++) {
				int temp = this.temperaturas.getTemp(x, y);
				int ARGB = this.palette.palette.get(temp).getARGB();
				this.setRGB(y, x, ARGB);

			}
		}
	}

		

	public void deletecolors(){
		for(int x = 0;x<this.heigth;x++) {
			for(int y = 0; y<this.width;y++) {
				int temp = this.temperaturas.getTemp(x, y);
				int ARGB = this.palette.palette.get(temp).getARGB();
				this.setRGB(y, x,ARGB);

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
