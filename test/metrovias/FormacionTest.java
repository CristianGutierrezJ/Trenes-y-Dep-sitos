package metrovias;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class FormacionTest {

    @Test
    public void testTotalDePasajerosEnFromacionSinVagonPasajeros() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 1000.0);
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);
        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        locomotorasForm.add(locomotora1);
        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        //System.out.println(formacion.cantidadTotalPasajeros());
        Assert.assertEquals(0, formacion.cantidadTotalPasajeros(), 0.1);
    }

    @Test
    public void testTotalDePasajerosEnFromacion() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 10.0);
        VagonPasajeros vagonPasajeros2 = new VagonPasajeros(20.0, 10.0);
        VagonPasajeros vagonPasajeros3 = new VagonPasajeros(20.0, 1.5);
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);
        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);
        vagonesPasajerosForm.add(vagonPasajeros2);
        vagonesPasajerosForm.add(vagonPasajeros3);
        locomotorasForm.add(locomotora1);
        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        //System.out.println(formacion.cantidadTotalPasajeros());
        Assert.assertEquals(560.0, formacion.cantidadTotalPasajeros(), 0.1);
    }

    @Test
    public void testCantidadVagonesLivianosSinVagones() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);
        // Añado los objetos a las listas
        locomotorasForm.add(locomotora1);
        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras

        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);
        // El vagón es liviano si pesa menos de 2500 kg

        //System.out.println(formacion.cantidadVagonesLivianos());

        Assert.assertEquals(0, formacion.cantidadVagonesLivianos(), 0.1);
    }


    @Test
    public void testCantidadVagonesLivianos() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 10.0);
        VagonPasajeros vagonPasajeros2 = new VagonPasajeros(20.0, 10.0);
        VagonPasajeros vagonPasajeros3 = new VagonPasajeros(20.0, 1.5);
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);
        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);
        vagonesPasajerosForm.add(vagonPasajeros2);
        vagonesPasajerosForm.add(vagonPasajeros3);
        locomotorasForm.add(locomotora1);
        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);
        // El vagón es liviano si pesa menos de 2500 kg

        //System.out.println(vagonCarga1.pesoMaximo());     // Los dos vagones de Carga pesan menos de 2500 kg
        //System.out.println(vagonCarga2.pesoMaximo());
        //System.out.println(vagonPasajeros1.pesoMaximo());
        //System.out.println(vagonPasajeros2.pesoMaximo());
        //System.out.println(vagonPasajeros3.pesoMaximo());

        //System.out.println(formacion.cantidadVagonesLivianos());

        Assert.assertEquals(2, formacion.cantidadVagonesLivianos(), 0.1);
    }

    @Test
    public void testVelocidadMaximaFormacionSinLocomotoras() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 10.0);
        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);

        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        //System.out.println(formacion.velocidadMaxima());
        Assert.assertEquals(0, formacion.velocidadMaxima(), 0.1);
    }

    @Test
    public void testVelocidadMaximaFormacion() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 10.0);
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);
        Locomotora locomotora2 = new Locomotora(1000.0, 6000.0, 50.0);
        Locomotora locomotora3 = new Locomotora(1000.0, 6000.0, 90.0);

        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);
        locomotorasForm.add(locomotora1);
        locomotorasForm.add(locomotora2);
        locomotorasForm.add(locomotora3);

        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        //System.out.println(formacion.velocidadMaxima());
        Assert.assertEquals(50.0, formacion.velocidadMaxima(), 0.1);
    }

    @Test
    public void testCalcularPesoTotalEnVagones() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 10.0);
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);

        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);
        locomotorasForm.add(locomotora1);

        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);
        //System.out.println(vagonCarga1.pesoMaximo());
        //System.out.println(vagonCarga2.pesoMaximo());
        //System.out.println(vagonPasajeros1.pesoMaximo());
        //System.out.println(formacion.calcularPesoTotalEnVagones());
        Assert.assertEquals(18320.0, formacion.calcularPesoTotalEnVagones(), 0.1);
    }

    @Test
    public void testSosEficiente() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 10.0);
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);

        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);
        locomotorasForm.add(locomotora1);

        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        Assert.assertTrue(formacion.sosEficiente());
    }

    @Test
    public void testSosEficienteFormacionSinVagones() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);
        // Añado los objetos a las listas
        locomotorasForm.add(locomotora1);

        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        Assert.assertFalse(formacion.sosEficiente());
    }

    @Test
    public void testNoPuedoMoverme() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 3.0);
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);
        Locomotora locomotora2 = new Locomotora(1000.0, 6000.0, 50.0);
        Locomotora locomotora3 = new Locomotora(1000.0, 6000.0, 90.0);

        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);
        locomotorasForm.add(locomotora1);
        locomotorasForm.add(locomotora2);
        locomotorasForm.add(locomotora3);

        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        //System.out.println(formacion.calcularPesoTotalEnVagones());
        //System.out.println(formacion.calcularArrastreUtilTotal());    Estado publico para el test
        Assert.assertFalse(formacion.puedoMoverme());
    }

    @Test
    public void testPuedoMoverme() {
        // Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 500.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 500.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 3.0);
        Locomotora locomotora1 = new Locomotora(1000.0, 10000.0, 70.0);
        Locomotora locomotora2 = new Locomotora(1000.0, 10000.0, 50.0);
        Locomotora locomotora3 = new Locomotora(1000.0, 10000.0, 90.0);

        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);
        locomotorasForm.add(locomotora1);
        locomotorasForm.add(locomotora2);
        locomotorasForm.add(locomotora3);

        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        System.out.println(formacion.calcularPesoTotalEnVagones());
        System.out.println(formacion.calcularArrastreUtilTotal());   // Estado publico para el test
        Assert.assertTrue(formacion.puedoMoverme());
    }

    @Test
    public void testKilosDeEmpujeFaltanteSiPuedoMoverme() {
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 500.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 500.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 3.0);
        Locomotora locomotora1 = new Locomotora(1000.0, 10000.0, 70.0);
        Locomotora locomotora2 = new Locomotora(1000.0, 10000.0, 50.0);
        Locomotora locomotora3 = new Locomotora(1000.0, 10000.0, 90.0);

        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);
        locomotorasForm.add(locomotora1);
        locomotorasForm.add(locomotora2);
        locomotorasForm.add(locomotora3);

        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        Assert.assertEquals(0, formacion.kilosDeEmpujeFaltante(), 0.1);
    }

    @Test
    public void testKilosDeEmpujeFaltanteParaMoverme() {
// Creo las listas
        List<VagonPasajeros> vagonesPasajerosForm = new ArrayList<>();    //List: posee un orden. Collection NO.
        List<VagonCarga> vagonesCargaForm = new ArrayList<>();
        List<Locomotora> locomotorasForm = new ArrayList<>();
        // creo los objetos
        VagonCarga vagonCarga1 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonCarga vagonCarga2 = new VagonCarga(20.0, 10.0, 1000.0);
        VagonPasajeros vagonPasajeros1 = new VagonPasajeros(20.0, 3.0);
        Locomotora locomotora1 = new Locomotora(1000.0, 6000.0, 70.0);
        Locomotora locomotora2 = new Locomotora(1000.0, 6000.0, 50.0);
        Locomotora locomotora3 = new Locomotora(1000.0, 6000.0, 90.0);

        // Añado los objetos a las listas
        vagonesCargaForm.add(vagonCarga1);
        vagonesCargaForm.add(vagonCarga2);
        vagonesPasajerosForm.add(vagonPasajeros1);
        locomotorasForm.add(locomotora1);
        locomotorasForm.add(locomotora2);
        locomotorasForm.add(locomotora3);

        // Creo una formacion con las listas de objetos. Debo pasarle las listas de VagonPasajeros, VagonCarga, Locomotoras
        Formacion formacion = new Formacion(vagonesPasajerosForm, vagonesCargaForm, locomotorasForm);

        //System.out.println(formacion.kilosDeEmpujeFaltante());
        Assert.assertEquals(3320.0, formacion.kilosDeEmpujeFaltante(), 0.1);
    }



}