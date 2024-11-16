package co.edu.uniquindio.poo;

public class Deportivo extends VehiculoNumero {
    private int caballosFuerza;
    private double tiempoCien;
    
    public Deportivo(String codigo, String marca, String modelo, boolean nuevo, int cambios, double velocidadMaxima,
            double cilindraje, Transmision transmision, Combustible combustible, int numeroPasajeros, int numeroPuertas,
            int numeroBolsasAire, int caballosFuerza, double tiempoCien) {
        super(codigo, marca, modelo, nuevo, cambios, velocidadMaxima, cilindraje, transmision, combustible,
                numeroPasajeros, numeroPuertas, numeroBolsasAire);
        this.caballosFuerza = caballosFuerza;
        this.tiempoCien = tiempoCien;
    }

    public int getCaballosFuerza() {
        return caballosFuerza;
    }

    public void setCaballosFuerza(int caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }

    public double getTiempoCien() {
        return tiempoCien;
    }

    public void setTiempoCien(double tiempoCien) {
        this.tiempoCien = tiempoCien;
    }

    @Override
    public String toString() {
        return "Deportivo: "+super.toString()+"caballosFuerza=" + caballosFuerza + ", tiempoCien=" + tiempoCien;
    }
    
    
}
