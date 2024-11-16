package co.edu.uniquindio.poo;

public class Electrico extends Vehiculo {
    private double autonomia;
    private double tiempoCarga;
    
    public Electrico(String codigo, String marca, String modelo, boolean nuevo, int cambios, double velocidadMaxima,
            double cilindraje, Transmision transmision, Combustible combustible, double autonomia, double tiempoCarga) {
        super(codigo, marca, modelo, nuevo, cambios, velocidadMaxima, cilindraje, transmision, combustible);
        this.autonomia = autonomia;
        this.tiempoCarga = tiempoCarga;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    public double getTiempoCarga() {
        return tiempoCarga;
    }

    public void setTiempoCarga(double tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }

    @Override
    public String toString() {
        return "Electrico:"+super.toString()+", autonomia=" + autonomia + ", tiempoCarga=" + tiempoCarga ;
    }

    
}
