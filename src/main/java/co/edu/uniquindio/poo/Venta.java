package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Venta extends Transaccion{
    private double precioVenta;

    public Venta(String idTransaccion, LocalDate fecha, double precioVenta,Empleado empleado,Cliente cliente, Vehiculo vehiculo) {
        super(idTransaccion, fecha, empleado, cliente, vehiculo);
        this.precioVenta = precioVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Venta: "+super.toString()+", precioVenta=" + precioVenta;
    }

    
}