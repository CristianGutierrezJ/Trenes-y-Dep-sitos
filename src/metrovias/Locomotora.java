package metrovias;

public class Locomotora {

   // De cada locomotora se sabe:
    // su peso, el peso máximo que puede arrastrar, y su velocidad máxima.
    // P.ej. puedo tener una locomotora que pesa 1000 kg, puede arrastrar hasta 12000 kg, y su velocidad máxima es de 80 km/h.
    // Obviamente se tiene que arrastrar a ella misma, entonces no le puedo cargar 12000 kg de vagones,
    // solamente 11000; diremos que este es su “arrastre útil”.

    private double pesoKilos;
    private double pesoMaximoQueArrastraKilos;
    private double velocidadMaxima;

    public Locomotora(double pesoKilos, double pesoMaximoQueArrastraKilos, double velocidadMaxima) {
        this.pesoKilos = pesoKilos;
        this.pesoMaximoQueArrastraKilos = pesoMaximoQueArrastraKilos;
        this.velocidadMaxima = velocidadMaxima;
    }

    public double getPesoKilos() {
        return pesoKilos;
    }

    public double getPesoMaximoQueArrastraKilos() {
        return pesoMaximoQueArrastraKilos;
    }

    public Double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    // Tiene un "Arrastre util" = peso maximo que arrastra - peso metrovias.Locomotora.
    public double arrastreUtil(){
        return getPesoMaximoQueArrastraKilos() - pesoKilos;
    }

    public boolean calcularMenorVelocidad(double velocidadMaximaFormacion){
        return this.velocidadMaxima < velocidadMaximaFormacion;
    }



}
