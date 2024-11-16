package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    
    public Moto(String codigo, String marca, String modelo, boolean nuevo, int cambios, double velocidadMaxima,
            double cilindraje, Transmision transmision, Combustible combustible) {
                super(codigo, marca, modelo, nuevo, cambios, velocidadMaxima, cilindraje, transmision, combustible);  
    }

    @Override
    public String toString() {
        return "Moto: "+super.toString();
    }
}