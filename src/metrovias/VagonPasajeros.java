package metrovias;

public class VagonPasajeros extends Vagon {


    //De cada vagón de pasajeros se conoce el largo en metros, y el ancho útil también en metros.
    //La cantidad de pasajeros que puede transportar un vagón de pasajeros es:
    //  Si el ancho útil es de hasta 2.5 metros: metros de largo * 8.
    //  Si el ancho útil es de más de 2.5 metros: metros de largo * 10.
    // P.ej., si tenemos dos vagones de pasajeros, los dos de 10 metros de largo,
    // uno de 2 metros de ancho útil, y otro de 3 metros de ancho útil,
    // entonces el primero puede llevar 80 pasajeros, y el segundo puede llevar 100.
    // Un vagón de pasajeros no puede llevar carga.



    public VagonPasajeros(Double largoMetros, Double anchoMetros) {
        this.largoMetros = largoMetros;
        this.anchoMetros = anchoMetros;
    }

    public Double getLargoMetros() {
        return largoMetros;
    }

    public Double getAnchoMetros() {
        return anchoMetros;
    }



    public Integer cantidadPasajeros(){
        if(anchoMetros <= 2.5){
            return largoMetros.intValue() * 8;     // convertir float a int (n° positivos).....Math.ceil(anchoMetros*8);
        } else {                                   // convertir float a int (n° negativos).....Math.floor(anchoMetros*8);
            return largoMetros.intValue() * 10;
        }
    }

    @Override
    protected Double pesoMaximo(){
        return Double.valueOf(cantidadPasajeros() * 80);
    }



}
