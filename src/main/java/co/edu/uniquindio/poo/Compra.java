package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Compra extends Transaccion{

    public Compra(Cliente cliente,Vehiculo vehiculo, Empleado empleado,String fecha) {
        super(fecha, empleado, cliente, vehiculo);

    }

    @Override
    public String toString() {
        return "Compra: "+super.toString();
    }

    

}