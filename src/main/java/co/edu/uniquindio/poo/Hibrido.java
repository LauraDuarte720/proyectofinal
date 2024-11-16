package co.edu.uniquindio.poo;

public class Hibrido extends Vehiculo {
    private boolean enchufable;
    private boolean ligero;
    
    public Hibrido(String codigo, String marca, String modelo, boolean nuevo, int cambios, double velocidadMaxima,
            double cilindraje, Transmision transmision, Combustible combustible, boolean enchufable, boolean ligero) {
        super(codigo, marca, modelo, nuevo, cambios, velocidadMaxima, cilindraje, transmision, combustible);
        this.enchufable = enchufable;
        this.ligero = ligero;
    }

    public boolean isEnchufable() {
        return enchufable;
    }

    public void setEnchufable(boolean enchufable) {
        this.enchufable = enchufable;
    }

    public boolean isLigero() {
        return ligero;
    }

    public void setLigero(boolean ligero) {
        this.ligero = ligero;
    }

    @Override
    public String toString() {
        return "Hibrido: "+super.toString()+", enchufable=" + enchufable + ", ligero=" + ligero;
    }

    


}
