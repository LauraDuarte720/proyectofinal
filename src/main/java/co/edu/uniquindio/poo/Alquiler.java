package co.edu.uniquindio.poo;


public class Alquiler extends Transaccion{
    private int diasAlquiler ;
    
    
    public Alquiler( Cliente cliente,Vehiculo vehiculo, Empleado empleado, String fecha) {
        super(fecha, empleado, cliente, vehiculo);

    }

    @Override
    public String toString() {
        return "Alquiler: "+super.toString()+ ", diasAlquiler=" + diasAlquiler;
    }
    

}