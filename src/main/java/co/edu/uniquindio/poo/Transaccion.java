package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Transaccion{
    public String fecha;
    private Empleado empleado;
    private Cliente cliente;  
    private Vehiculo vehiculo;
    
    public Transaccion(String fecha, Empleado empleado,Cliente cliente, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.empleado = empleado;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Transaccion: fecha=" + fecha + ", empleado=" + empleado.getNombres()
                + ", cliente=" + cliente.getNombres() + ", vehiculo=" + vehiculo.getMarca();
    }

    

    
}