package co.edu.uniquindio.poo;

public class Cliente extends Persona{
    private String telefono;
    private int edad;
    
    public Cliente(String nombres, String apellidos, String cedula, String correo, String telefono, int edad) {
        super(nombres, apellidos, cedula, correo);
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente:"+super.toString()+ ", telefono=" + telefono + ", edad=" + edad + "]";
    }

    
}
