import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Empleado {


    private int id;
    private int sucursal;
    private String nombre;
    private String apellido;
    private int cedula;
    private String telefono;
    private String seccion;
    private String cargo;
    private String fecha;
    private double sueldo;
    public Empleado izq;
    public Empleado der;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public int getSucursal() {
        return sucursal;
    }

    public Empleado(int id, int sucursal, String nombre, String apellido, int cedula, String telefono, String seccion, String cargo, String fecha, double sueldo) {
        this.id = id;
        this.sucursal = sucursal;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.seccion = seccion;
        this.cargo = cargo;
        this.fecha = fecha;
        this.sueldo = sueldo;
    }
}


