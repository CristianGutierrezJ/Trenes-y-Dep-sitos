package metrovias;

public abstract class Vagon implements Comparable<Vagon>{

    protected Double largoMetros;
    protected Double anchoMetros;

    private static final Integer PESO_MAXIMO=2500;

    public abstract Double pesoMaximo();

    public boolean sosLiviano() {
        return pesoMaximo()<PESO_MAXIMO;
    }

    public abstract Integer cantidadPasajeros();



    @Override
    public int compareTo(Vagon otroVagon) {
        if(otroVagon==null) return 1;
        Double miPeso=this.pesoMaximo();
        Double otroPeso=otroVagon.pesoMaximo();
        if(miPeso > otroPeso){
            return 1;
        } else {
            return 0;
        }
    }




}
