import java.util.ArrayList;
import java.util.List;

public class Empresa{
    private int id;
    private String nombre;
    private List<Empleado> empleados;
    private List<Sucursal> sucursales;
    Empleado raiz;



    public void organigrama(Empleado nuevoEmpleado)
    {
        if (raiz == null) {
            raiz = nuevoEmpleado;
        } else {
            Empleado anterior = null, actual = raiz;

            while (actual != null) {
                anterior = actual;
                if (nuevoEmpleado.getId() < actual.getId()) {
                    actual = actual.izq;
                } else {
                    actual = actual.der;
                }
            }

            if (nuevoEmpleado.getId() < anterior.getId()) {
                anterior.izq = nuevoEmpleado;
            } else {
                anterior.der = nuevoEmpleado;
            }
        }
    }

    //Dada una seccion imprimir todos los empleados de esa seccion de mayor a menor jerarquia
    public void imprimirEmpleadosSeccion(Empleado raiz, String seccion)
    {
        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        if (raiz != null) {
            imprimirEmpleadosSeccion(raiz.izq, seccion); // Primero recorremos el nodo derecho para obtener los empleados con ID más altos.
            if (raiz.getSeccion().equals(seccion)) {
                System.out.println(" ");
                System.out.println(GREEN + "➤ Empleado " + "[" + raiz.getId() + "]" + ": " + raiz.getNombre() + " " + raiz.getApellido());
            }
            imprimirEmpleadosSeccion(raiz.der, seccion); // Luego recorremos el nodo izquierdo para obtener los empleados con ID más bajos.
        }
    }

    public void imprimirEmpleadosSucursal(Empleado raiz, int sucursal)
    {
        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        if (raiz != null) {
            imprimirEmpleadosSucursal(raiz.izq, sucursal); // Primero recorremos el nodo derecho para obtener los empleados con ID más altos.
            if (raiz.getSucursal() == sucursal ) {
                System.out.println(" ");
                System.out.println(GREEN + "➤ Empleado " + "[" + raiz.getId() + "]" + ": " + raiz.getNombre() + " " + raiz.getApellido());
            }
            imprimirEmpleadosSucursal(raiz.der, sucursal); // Luego recorremos el nodo izquierdo para obtener los empleados con ID más bajos.
        }
    }

    //Dado un empleado imprimir sus subordinados
    public void imprimirEmpleadoYSubordinados(Empleado nodo, int idEmpleado) {
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        if (nodo != null) {
            if (nodo.getId() == idEmpleado) {

                // Imprimir los datos del empleado.
                System.out.println(GREEN + "➤ Empleado " + "[" + nodo.getId() + "]" + ": "+
                        "  \n  ➪ Nombre: " + nodo.getNombre() +
                        "  \n  ➪ Apellido: " + nodo.getApellido() +
                        "  \n  ➪ Cedula: " + nodo.getCedula() +
                        "  \n  ➪ Seccion: " + nodo.getSeccion());

                // Imprimir los datos de los subordinados.
                System.out.println(" ");
                System.out.println("Subordinados:");
                if (nodo.izq != null) {
                    System.out.println("  ➥ Izquierda: " +
                            "  \n  ➪ Nombre: " + nodo.izq.getNombre() +
                            "  \n  ➪ Apellido: " + nodo.izq.getApellido() +
                            "  \n  ➪ Cedula: " + nodo.izq.getCedula() +
                            "  \n  ➪ Seccion: " + nodo.izq.getSeccion());
                }
                if (nodo.der != null) {
                    System.out.println("  ➥ Derecha: " +
                            "  \n  ➪ Nombre: " + nodo.der.getNombre() +
                            "  \n  ➪ Apellido: " + nodo.der.getApellido() +
                            "  \n  ➪ Cedula: " + nodo.der.getCedula() +
                            "  \n  ➪ Seccion: " + nodo.der.getSeccion() + RESET);
                }
            } else if (idEmpleado < nodo.getId()) {
                imprimirEmpleadoYSubordinados(nodo.izq, idEmpleado);
            } else {
                imprimirEmpleadoYSubordinados(nodo.der, idEmpleado);
            }
        }
    }


    //Metodo constructor
    public Empresa(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    //Metodo para mostrar los atributos de la empresa
    public void mostrarInformacion()
    {
        /* Colores para la consola */
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println(" ");
        System.out.println(GREEN + "➤ " + this.nombre );
        System.out.println("➥ Id: " + this.id);

        int contadorEmpleados = 0;
        for(Empleado empleado : empleados)
        {
            contadorEmpleados ++;
        }

        int contadorSucursales = 0;
        for(Sucursal sucursal : sucursales)
        {
            contadorSucursales ++;
        }

        System.out.println("➥ Cantidad de empleados: " + (contadorEmpleados) );
        System.out.println("➥ Cantidad de sucursales: " + (contadorSucursales) + RESET);
        System.out.println(" ");
    }


    public void agregarSucursal(Sucursal sucursal)
    {
        sucursales.add(sucursal);
    }

    public void agregarEmpleado(Empleado empleado)
    {
        empleados.add(empleado);
    }

    public void imprimirOrganigrama(Empleado nodo) {
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";
        if (nodo != null) {
            System.out.println(" ");
            System.out.println(GREEN + "➤ Empleado " + "[" + nodo.getId() + "]" + ": " + nodo.getNombre() + " " + nodo.getApellido());
            if (nodo.izq != null) {
                System.out.println("  ➥ Izquierda: " + nodo.izq.getNombre() + " " + nodo.izq.getApellido());
            }
            if (nodo.der != null) {
                System.out.println("  ➥ Derecha: " + nodo.der.getNombre() + " " + nodo.der.getApellido() + RESET);
            }
            imprimirOrganigrama(nodo.izq);
            imprimirOrganigrama(nodo.der);
        }
    }


    public boolean tieneSucursal(int idSucursal) {
        if (sucursales != null) {
            for (Sucursal sucursal : sucursales) {
                if (sucursal.getId() == idSucursal) {
                    return true;
                }
            }
        }
        return false;
    }

    //Gets
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Empleado getRaiz() {
        return raiz;
    }
}
