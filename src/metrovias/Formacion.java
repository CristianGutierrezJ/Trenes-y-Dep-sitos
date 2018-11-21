package metrovias;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Formacion {
    // Una formación es lo que habitualmente llamamos “un tren”,
    // tiene una o varias locomotoras, y uno o varios vagones. Hay vagones de pasajeros y vagones de carga.
    // En cada depósito hay: formaciones ya armadas, y locomotoras sueltas que pueden ser agregadas a una formación.

    private  List<Vagon> vagones = new ArrayList<>();
    private  List<Locomotora> locomotoras = new ArrayList<>();



    public Formacion(List<Vagon> vagones, List<Locomotora> locomotoraForm) {
        this.vagones = vagones;
        this.locomotoras = locomotoraForm;
    }


    // 1- El total de pasajeros que puede transportar una formación.
    public int cantidadTotalPasajeros() {
/*        int cantidadPasajeros = 0;
        for(VagonPasajeros vagonPasajeros: vagonesPasajeros){
            cantidadPasajeros = cantidadPasajeros + vagonPasajeros.cantidadPasajeros();
        }
        return cantidadPasajeros;
*/
        return vagones.stream().mapToInt(vagon -> vagon.cantidadPasajeros()).sum();
    }

    // 2- Cuántos vagones livianos tiene una formación; un vagón es liviano si su peso máximo es menor a 2500 kg.
    public Integer cantidadVagonesLivianos(){
        int cantidadVagonesLivianos = 0;
        for(Vagon vagon: vagones){
            if(vagon.sosLiviano()) {
                cantidadVagonesLivianos ++;
            }
        }
        return cantidadVagonesLivianos;
    }

    // 3- La velocidad máxima de una formación, que es el mínimo entre las velocidades máximas de las locomotoras.
    public double velocidadMaxima(){
        return locomotoras.stream().min((o1, o2) -> o1.getVelocidadMaxima().compareTo(o2.getVelocidadMaxima())).get().getVelocidadMaxima();
    }


    // 4- Si una formación es eficiente; es eficiente si cada una de sus locomotoras arrastra, al menos,
    //      5 veces su peso (el de la locomotora misma).
    // recorro el peso de los vagones y luego el peso de las locomotoras y si el peso de os vagones quintuplica al de alguna de las loocomotoras...Es EFICIENTE
    public Double calcularPesoTotalEnVagones(){
        double pesoTotalEnVagones = 0;
        for (Vagon vagonCarga : vagones) {
            pesoTotalEnVagones = pesoTotalEnVagones + vagonCarga.pesoMaximo();
        }
        return pesoTotalEnVagones;
    }

    public boolean sosEficiente() {
        Double pesoTotalEnVagones = calcularPesoTotalEnVagones();
        for (Locomotora locomotora : locomotoras) {
            if (pesoTotalEnVagones * 5 >= locomotora.arrastreUtil()) {
                return true;
            }
        }
        return false;
    }


    // 5- Si una formación puede moverse.
    //   Una formación puede moverse si el arrastre útil total de las locomotoras es mayor o igual al peso máximo total de los vagones.
    public Double calcularArrastreUtilTotal(){
        double arrastreUtilTotalEnLocomotora=0;

        for (Locomotora locomotora : locomotoras) {
            arrastreUtilTotalEnLocomotora = arrastreUtilTotalEnLocomotora + locomotora.arrastreUtil();
        }
        return arrastreUtilTotalEnLocomotora;
    }


    public boolean puedoMoverme() {
        Double pesoTotalVagones = calcularPesoTotalEnVagones();
        Double arrastreUtilTotalEnLocomotora = calcularArrastreUtilTotal();
        return arrastreUtilTotalEnLocomotora >= pesoTotalVagones;
    }

    // 6- Cuántos kilos de empuje le faltan a una formación para poder moverse,
    //      que es: 0 si ya se puede mover,
    //      y (peso máximo total de los vagones – arrastre útil total de las locomotoras) en caso contrario.

    public double kilosDeEmpujeFaltante(){
        double pesoTotalVagones = calcularPesoTotalEnVagones();
        double arrastreUtilTotalEnLocomotora = calcularArrastreUtilTotal();

        if(puedoMoverme()){
            return 0;
        }
        else{
            return pesoTotalVagones - arrastreUtilTotalEnLocomotora;
        }
    }

    // 7-
    public Vagon vagonMasPesado(){
        Vagon vagonMasPesado = null;
        for(Vagon vagon: vagones){
            if(vagon.compareTo(vagonMasPesado)>0){
                vagonMasPesado=vagon;
            }
        }
        return vagonMasPesado;
    }

    public Double calcularPesoTotalEnLocomotoras(){
        Double pesoTotalEnLocomotoras = 0.0;
        for (Locomotora locomotora: locomotoras){
            pesoTotalEnLocomotoras = pesoTotalEnLocomotoras + locomotora.getPesoKilos();
        }
        return pesoTotalEnLocomotoras;
    }

    public Double calcularPesoFormacionCompleta(){
        Double pesoTotalVagones = calcularPesoTotalEnVagones();
        Double pesoTotalLocomotoras = calcularPesoTotalEnLocomotoras();
        return pesoTotalVagones + pesoTotalLocomotoras;
    }

    public Integer size(){
        Integer vagonesCargaTamano = vagones.size();
        Integer locomotorasTamano = locomotoras.size();
        return vagonesCargaTamano + locomotorasTamano;
    }

    protected List<Locomotora>  locomotorasDisponiblesParaAgregar(List<Locomotora> locomotoras){
        // Si no, se le agrega una locomotora suelta del depósito cuyo arrastre útil sea mayor o igual a....
        // ...los kilos de empuje que le faltan a la formación.
        // Solucion: Me paso la lista de locomotoras del deposito y veo si alguna cumple los requisitos para ser agregada a la formacion
        List<Locomotora> locomotorasDisponiblesParaAgregar = new ArrayList<>();

        for (Locomotora locomotora: locomotoras) {
            Double arrastreUtilLocomotora = locomotora.arrastreUtil();
            Double kilosDeEmpujeFaltanteFormacion = this.kilosDeEmpujeFaltante();

            if (arrastreUtilLocomotora >= kilosDeEmpujeFaltanteFormacion) {
                locomotorasDisponiblesParaAgregar.add(locomotora);
            }
        }
        return locomotorasDisponiblesParaAgregar;
    }



    protected void agregarLocomotora(Locomotora locomotora){
        locomotoras.add(locomotora);
    }


}
