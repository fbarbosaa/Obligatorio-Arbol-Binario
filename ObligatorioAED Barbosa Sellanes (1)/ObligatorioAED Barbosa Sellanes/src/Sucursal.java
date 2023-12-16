import java.util.List;

public class Sucursal {
    private int idEmpresa;
    private int id;
    private String lugar;
    private List<Empleado> empleados;


    public Sucursal(int idEmpresa,int id, String lugar) {
        this.idEmpresa = idEmpresa;
        this.id = id;
        this.lugar = lugar;
    }

    public void mostrarInformacion()
    {
        /* Colores para la consola */
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println(" ");
        System.out.println(GREEN + "➥ Id de la empresa: " + this.idEmpresa);
        System.out.println("➥ Id de la sucursal: " + this.id);
        System.out.println("➥ Lugar de la surcursal: " + this.lugar + RESET);
    }
    public int getId() {
        return id;
    }

    public String getLugar() {
        return lugar;
    }

    public void agregarEmpleado(Empleado empleado)
    {
        empleados.add(empleado);
    }

}
