package SimulacionFuego;

public class DTOController {
    private DTOGeneralParameters dtoGeneralParameters;
    private DTOTemperatureParameters dtoTemperatureParameters;

    private DTOPaletteParameters dtoPaletteParameters;

    public DTOController(){

    }

    public DTOGeneralParameters getDtoGeneralParameters() {
        return dtoGeneralParameters;
    }

    public void setDtoGeneralParameters(DTOGeneralParameters dtoGeneralParameters) {
        this.dtoGeneralParameters = dtoGeneralParameters;
    }

    public DTOTemperatureParameters getDtoTemperatureParameters() {
        return dtoTemperatureParameters;
    }

    public void setDtoTemperatureParameters(DTOTemperatureParameters dtoTemperatureParameters) {
        this.dtoTemperatureParameters = dtoTemperatureParameters;
    }

    public DTOPaletteParameters getDtoPaletteParameters() {
        return dtoPaletteParameters;
    }

    public void setDtoPaletteParameters(DTOPaletteParameters dtoPaletteParameters) {
        this.dtoPaletteParameters = dtoPaletteParameters;
    }
}
