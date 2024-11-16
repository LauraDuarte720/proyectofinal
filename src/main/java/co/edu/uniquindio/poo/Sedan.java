package co.edu.uniquindio.poo;

public class Sedan extends VehiculoProvision {
    
    public Sedan(String codigo, String marca, String modelo, boolean nuevo, int cambios,
            double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible,
            int numeroPasajeros, int numeroPuertas, int numeroBolsasAire, boolean aireAcondicionado, boolean abs,
            boolean camaraReversa, boolean sensorColision, boolean sensorTrafico, boolean asistentePermanenciaCarril,
            boolean velocidadCrucero, double capacidadCarga) {
        super(codigo, marca, modelo, nuevo, cambios, velocidadMaxima, cilindraje, transmision, combustible,
                numeroPasajeros, numeroPuertas, numeroBolsasAire, aireAcondicionado, abs, camaraReversa,sensorColision,
                sensorTrafico, asistentePermanenciaCarril, velocidadCrucero, capacidadCarga);
    }

    @Override
    public String toString() {
        return "Sedan: "+super.toString();
    }

    


}
