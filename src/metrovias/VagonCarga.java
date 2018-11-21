package metrovias;

public class VagonCarga extends Vagon{


    private double cargaMaximaKilos;

    public VagonCarga(Double largoMetros, Double anchoMetros, Double cargaMaximaKilos) {
        this.largoMetros = largoMetros;
        this.anchoMetros = anchoMetros;
        this.cargaMaximaKilos = cargaMaximaKilos;
    }

    public Double getLargoMetros() {
        return largoMetros;
    }

    public Double getAnchoMetros() {
        return anchoMetros;
    }

    public Double getCargaMaximaKilos() {
        return cargaMaximaKilos;
    }


    @Override
    protected Double pesoMaximo() {
        return cargaMaximaKilos + 160;
    }

    @Override
    public Integer cantidadPasajeros() {
        return 0;
    }


}
