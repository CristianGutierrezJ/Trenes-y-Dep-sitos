package metrovias;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Deposito {

    private static final Integer UNIDADES_MINIMAS_DE_FORMACION_COMPLEJA = 20;
    private static final Integer PESO_MINIMO_DE_FORMACION_COMPLEJA = 1000;
    private List<Formacion> formaciones = new ArrayList<Formacion>();
    private List<Locomotora> locomotoras = new ArrayList<Locomotora>();


    public void guardarFormación(Formacion formacion) {
        formaciones.add(formacion);
    }

    public void guardarLocomotora(Locomotora locomotora) {
        locomotoras.add(locomotora);
    }


    //  7-  Dado un depósito,
    //          El conjunto formado por el vagón más pesado de cada formación;
    //        ..se espera un conjunto de vagones.
    // Dada la lista de formaciones, la itero y en cada formacion le pido que me entregue la mas pesada y la adhiero a la lista de los mas pesados
    public Collection<Vagon> conjuntoVagonesMasPesadosDeCadaFormacion() {
        Collection<Vagon> masPesadosDeCadaFormacion = new ArrayList<>();
        for (Formacion formacion : formaciones) {
            masPesadosDeCadaFormacion.add(formacion.vagonMasPesado());
        }
        return masPesadosDeCadaFormacion;
    }


    // 8 -  Si un depósito necesita un conductor experimentado.
    //  Un depósito necesita un conductor experimentado si alguna de sus formaciones es compleja.
    //  Una formación es compleja si: tiene más de 20 unidades (sumando locomotoras y vagones),
    //  o el peso total (sumando locomotoras y vagones) es de más de 10000 kg.

    private boolean hayFormacionesComplejas() {
        for (Formacion formacion : formaciones) {
            if (formacion.size() > UNIDADES_MINIMAS_DE_FORMACION_COMPLEJA ||
                    formacion.calcularPesoFormacionCompleta() > PESO_MINIMO_DE_FORMACION_COMPLEJA) {
                return true;
            }
        }
        return false;
    }

    public boolean necesitasConductorExperimentado() {
        return hayFormacionesComplejas();
    }

    // 9 -
    // Agregar, dentro de un depósito, una locomotora a una formación determinada, de forma tal que la formación pueda moverse.
    // Si la formación ya puede moverse, entonces no se hace nada.
    // Si no, se le agrega una locomotora suelta del depósito cuyo arrastre útil sea mayor o igual a....
    // ...los kilos de empuje que le faltan a la formación.
    // Si no hay ninguna locomotora suelta que cumpla esta condición, no se hace nada.

    public void agregarLocomotoraAFormacion(Formacion formacion) {
        List<Locomotora> locomotorasDisponiblesParaAgregar = formacion.locomotorasDisponiblesParaAgregar(locomotoras);

        if (!formacion.puedoMoverme()) {  // Si no puede moverse agrego metrovias.Locomotora(si hay alguna disponible que cumple los requisitos) caso contrario no agrego nada.

            if (locomotorasDisponiblesParaAgregar.isEmpty()) {
                System.out.println("No hay locomotoras disponibles para agregar a su formación");
            } else {
                Locomotora locomotora = locomotorasDisponiblesParaAgregar.get(0);
                formacion.agregarLocomotora(locomotora);
                // Renuevo la locomotora de la lista del deposito
                //locomotorasDisponiblesParaAgregar.remove(locomotora); // Esta accion no hace falta
                locomotoras.remove(locomotora);
            }
        } else {
            System.out.println("No hace falta agregar una locomotora");
        }
    }


}
