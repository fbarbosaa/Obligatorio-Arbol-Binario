import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    static List<Empresa> empresas = new ArrayList<>();
    static List<Sucursal> sucursales = new ArrayList<>();
    static List<Empleado> empleados = new ArrayList<>();


    public static void main(String[] args) {

        //Creamos la raiz o empleado jefe
        Empleado Jefe = new Empleado
                (
                        1,
                        2,
                        "Pedro",
                        "Picapiedra",
                        12345678,
                        "09912123",
                        "ventas",
                        "Director Ejecutivo",
                        "20-10-2015",
                        45000
                );

        //Empelados
        Empleado Juan = new Empleado
                (
                        2,
                        1,
                        "Juan",
                        "Perez",
                        12121212,
                        "09821212",
                        "exportaciones",
                        " Director Financiero",
                        "13-11-2015",
                        40000
                );

        Empleado Maria = new Empleado(
                3,
                1,
                "Maria",
                "Rodriguez",
                12312313,
                "123456789",
                "ventas",
                "Director de Marketing",
                "28-11-2016",
                35000
        );

        Empleado Elena = new Empleado(
                11,
                1,
                "Elena",
                "Ruiz",
                69420718,
                "864209753",
                "compras",
                "Contador",
                "12-3-2016",
                36000
        );

        Empleado Jose = new Empleado(
                7,
                2,
                "Jose",
                "Morales",
                37291856,
                "864209234",
                "recursos humanos",
                "Especialista en Comunicaciones",
                "17-4-2018",
                30000
        );

        //Creamos 2 sucursales
        Sucursal colonia = new Sucursal(1, 1, "Colonia");
        Sucursal montevideo = new Sucursal(1, 2, "Montevideo");
        sucursales.add(colonia);
        sucursales.add(montevideo);


        //Creamos una empresa
        Empresa Pepsi = new Empresa(1, "Pepsi");
        empresas.add(Pepsi);

        //Agregamos los empleados a la lista de la empresa
        Pepsi.agregarEmpleado(Jefe);
        Pepsi.agregarEmpleado(Juan);
        Pepsi.agregarEmpleado(Maria);
        Pepsi.agregarEmpleado(Elena);
        Pepsi.agregarEmpleado(Jose);

        //Agregamos los empleados al organigrama de la empresa
        Pepsi.organigrama(Jefe);
        Pepsi.organigrama(Juan);
        Pepsi.organigrama(Maria);
        Pepsi.organigrama(Elena);
        Pepsi.organigrama(Jose);

        //Sucursales a la empresa
        Pepsi.agregarSucursal(colonia);
        Pepsi.agregarSucursal(montevideo);

        //Menu
        menuOpciones();

    }

    static void menuOpciones()
    {
        Scanner scanner = new Scanner(System.in);

        /* Colores para la consola */
        String PURPLE = "\u001B[35m";
        String RESET = "\u001B[0m";
        String WHITE = "\u001B[37m";


        boolean salir = false;
        while (!salir)
        {
            String[] mensajes = {
                    PURPLE +
                    " ",
                    "@──────[Opciones]───────@",
                    "➩ [0] Salir",
                    "➩ [1] Opciones Empresa",
                    "➩ [2] Opciones Sucursal",
                    "➩ [3] Opciones Empleado",
                    "@───────────────────────@"
                    + RESET,
            };

            for(String mensaje : mensajes)
            {
                System.out.println(mensaje);
            }

            System.out.println(WHITE + "➢ Selecciona una opcion:" + RESET);
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion)
            {
                case 0:
                    salir = true;
                    break;
                case 1:
                    opcionesEmpresa();
                    break;
                case 2:
                    opcionesSucursal();
                    break;
                case 3:
                    opcionesEmpleado();
                    break;

            }
        }
    }

    /*
    En cada uno de estos metodos se encuentran las opciones de crear,
    eliminar o listar para cada una de las clases,
    ademas de metodos especificos para algunas
    */
    static void opcionesEmpresa()
    {
        Scanner scanner = new Scanner(System.in);
        /* Colores para la consola */
        String CYAN = "\u001B[36m";
        String RESET = "\u001B[0m";
        String WHITE = "\u001B[37m";


        boolean salir = false;
        while (!salir)
        {
            String[] mensajes = {
                    CYAN +
                    " ",
                    "@──────────[Empresas]───────────@",
                    "➩ [0] Salir",
                    "➩ [1] Agregar Empresa",
                    "➩ [2] Borrar Empresa",
                    "➩ [3] Listar Empresas",
                    "➩ [4] Organigrama",
                    "➩ [5] Organigrama por seccion",
                    "@───────────────────────────────@"
                    + RESET
            };

            for(String mensaje : mensajes)
            {
                System.out.println(mensaje);
            }

            System.out.println(WHITE + "➢ Selecciona una opcion:" + RESET);
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion)
            {
                case 0:
                    salir = true;
                    break;
                case 1:
                    agregarEmpresa(empresas);
                    break;
                case 2:
                    borrarEmpresa(empresas);
                    break;
                case 3:
                    listarEmpresas(empresas);
                    break;
                case 4:
                    mostrarOrganigrama();
                    break;
                case 5:
                    empleadosSeccion();
                    break;

            }
        }

    }
    static void opcionesSucursal()
    {
        Scanner scanner = new Scanner(System.in);
        /* Colores para la consola */
        String CYAN = "\u001B[36m";
        String RESET = "\u001B[0m";
        String WHITE = "\u001B[37m";

        boolean salir = false;
        while (!salir)
        {
            String[] mensajes = {
                    CYAN +
                            " ",
                    "@──────[Sucursales]───────@",
                    "➩ [0] Salir",
                    "➩ [1] Agregar Sucursal",
                    "➩ [2] Borrar Sucursal",
                    "➩ [3] Listar Sucursales",
                    "@───────────────────────@"
                            + RESET
            };

            for(String mensaje : mensajes)
            {
                System.out.println(mensaje);
            }

            System.out.println(WHITE + "➢ Selecciona una opcion:" + RESET);
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion)
            {
                case 0:
                    salir = true;
                    break;
                case 1:
                    agregarSucursal(sucursales);
                    break;
                case 2:
                    borrarSucursal(sucursales);
                    break;
                case 3:
                    listarSucursales(sucursales);
                    break;

            }
        }
    }
    static void opcionesEmpleado()
    {
        Scanner scanner = new Scanner(System.in);
        /* Colores para la consola */
        String CYAN = "\u001B[36m";
        String RESET = "\u001B[0m";
        String WHITE = "\u001B[37m";

        boolean salir = false;
        while (!salir)
        {
            String[] mensajes = {
                    CYAN +
                            " ",
                    "@───────────[Empleados]────────────@",
                    "➩ [0] Salir",
                    "➩ [1] Agregar Empleado",
                    "➩ [2] Borrar Empleado",
                    "➩ [3] Empleado y sus subordinados",
                    "➩ [4] Empleados por sucursal",
                    "@──────────────────────────────────@"
                            + RESET
            };

            for(String mensaje : mensajes)
            {
                System.out.println(mensaje);
            }

            System.out.println(WHITE + "➢ Selecciona una opcion:" + RESET);
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion)
            {
                case 0:
                    salir = true;
                    break;
                case 1:
                    agregarEmpleado(empleados);
                    break;
                case 2:
                    borrarEmpleado(empleados);
                    break;
                case 3:
                    empleadoYSubordinados(empleados);
                    break;
                case 4:
                    empleadosSucursal();
                    break;

            }
        }
    }



 /* Metodos para agregar una empresa, sucursal o un empleado */
    static void agregarEmpresa(List<Empresa> empresas)
    {
        Scanner scanner = new Scanner(System.in);

        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println(" ");
        System.out.println("➢ Ingrese el id de la empresa:");
        int idEmpresa = scanner.nextInt();
        scanner.nextLine();

       /* Validamos si el id de la empresa ya esta en uso */
        for (Empresa empresa : empresas) {
            if (empresa.getId() == idEmpresa) {
                System.out.println(RED + "[☠ El id de la empresa ya esta en uso ☠]" + RESET);
                return;
            }
        }

        System.out.println("➢ Ingrese el nombre de la empresa:");
        String nombreEmpresa = scanner.nextLine();

        /* Validamos si el nombre de la empresa ya esta en uso */
        for (Empresa empresa : empresas) {
            if (empresa.getNombre().equals(nombreEmpresa)) {
                System.out.println(RED + "[☠ El nombre de la empresa ya esta en uso ☠]" + RESET);
                return;
            }
        }

        /* Creamos una nueva empresa con el id y nombres ingresados y la agregamos a la lista de empresas */
        empresas.add(new Empresa(idEmpresa, nombreEmpresa));
        System.out.println(" ");
        System.out.println(GREEN + "[✔ Empresa creada con exito ✔]" + RESET);
    }
    static void agregarSucursal(List<Sucursal> sucursales)
    {
        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);

        System.out.println("➢ Ingrese el id de la empresa:");
        int idEmpresa = scanner.nextInt();
        scanner.nextLine();

        // Validar si la empresa existe
        Empresa empresa = obtenerEmpresaPorId(idEmpresa);
        if (empresa == null) {
            System.out.println(RED + "[☠ Esta empresa no existe ☠]" + RESET );
            return;
        }

        System.out.println("➢ Ingrese el id de la sucursal:");
        int idSucursal = scanner.nextInt();
        scanner.nextLine();

        // Validar sucursal por id
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getId() == idSucursal) {
                System.out.println(RED + "[☠ Esta sucursal ya esta ingresada ☠]" + RESET );
                return;
            }
        }

        System.out.println("➢ Ingrese el lugar de la sucursal:");
        String lugarSucursal = scanner.nextLine();

        // Validar sucursal por nombre de lugar
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getLugar().equals(lugarSucursal)) {
                System.out.println(RED + "[☠ Este lugar ya existe ☠]" + RESET);
                return;
            }
        }

        // Validar que la sucursal pertenezca a la empresa específica
        if (empresa.tieneSucursal(idSucursal)) {
            System.out.println(RED + "[☠ La sucursal ya partene a esta empresa ☠]" + RESET);
            return;
        }

        Sucursal nuevaSucursal = new Sucursal(idEmpresa, idSucursal, lugarSucursal);
        sucursales.add(nuevaSucursal);
        empresa.agregarSucursal(nuevaSucursal);
        System.out.println(" ");
        System.out.println(GREEN + "[✔ Sucursal agregada con exito ✔]" + RESET);
    }
    static void agregarEmpleado(List<Empleado> empleados)
    {
        Scanner scanner = new Scanner(System.in);

        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        /* Validamos si el id de la empresa existe */
        System.out.println("➢ Ingrese la empresa donde va a trabajar el empleado:");
        int idEmpresa = scanner.nextInt();
        scanner.nextLine();
        Empresa empresa = obtenerEmpresaPorId(idEmpresa);
        if (empresa == null) {
            System.out.println(RED + "[☠ Esta empresa no existe ☠]" + RESET);
            return;
        }

        /* Validamos si el id del empleado ya existe */
        System.out.println("➢ Ingrese el id del empleado:");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();
        for (Empleado empleado : empleados) {
            if (empleado.getId() == idEmpleado) {
                System.out.println(RED + "[☠ Este empleado ya esta ingresado ☠]" + RESET);
                return;
            }
        }

        /* Validamos si el id del empleado ya existe */
        System.out.println("➢ Ingrese el id de la sucursal a la que partenece el empleado:");
        int idSucursal = scanner.nextInt();
        scanner.nextLine();
        for (Empleado empleado : empleados) {
            if (empleado.getSucursal() == idSucursal) {
                System.out.println(RED + "[☠ Este empleado ya esta ingresado en una sucursal ☠]" + RESET);
                return;
            }
        }


        System.out.println("➢ Ingrese el nombre del empleado:");
        String nombreEmpleado = scanner.nextLine();

        System.out.println("➢ Ingrese el apellido del empleado:");
        String apellidoEmpleado = scanner.nextLine();

        System.out.println("➢ Ingrese la cedula del empleado:");
        int cedulaEmpleado = scanner.nextInt();
        scanner.nextLine();

        System.out.println("➢ Ingrese el telefono del empleado:");
        String telefonoEmpleado = scanner.nextLine();

       /* Validamos si la seccion ingresada es valida */
        System.out.println("➢ Ingrese la seccion del empleado:");
        String seccionEmpleado = scanner.nextLine();
        if (
                !seccionEmpleado.equals("ventas") &&
                        !seccionEmpleado.equals("compras") &&
                        !seccionEmpleado.equals("exportaciones") &&
                        !seccionEmpleado.equals("recursos humanos")
        )
        {
            System.out.println(RED + "[☠ Esa seccion no existe ☠]" + RESET);
            return;
        }

        System.out.println("➢ Ingrese el cargo del empleado:");
        String cargoEmpleado = scanner.nextLine();

        System.out.println("➢ Ingrese la fecha de ingreso del empleado:");
        String fechaEmpleado = scanner.nextLine();

        System.out.println("➢ Ingrese el sueldo del empleado:");
        double sueldoEmpleado = scanner.nextInt();
        scanner.nextLine();

        /* Creamos el empleado con los datos ingresados */
        Empleado empleado = new Empleado(
                idEmpleado,
                idSucursal,
                nombreEmpleado,
                apellidoEmpleado,
                cedulaEmpleado,
                telefonoEmpleado,
                seccionEmpleado,
                cargoEmpleado,
                fechaEmpleado,
                sueldoEmpleado
        );


        empresa.agregarEmpleado(empleado);
        empresa.organigrama(empleado);
        System.out.println(GREEN + "[✔ Empleado agregado con exito ✔]" + RESET);

    }




    /* Metodos para listar una empresa, sucursal o un empleado */
    static void listarEmpresas(List<Empresa> empresas)
    {
        for(Empresa empresa : empresas)
        {
            empresa.mostrarInformacion();
        }
    }
    static void listarSucursales(List<Sucursal> sucursales)
    {
        for(Sucursal sucursal : sucursales)
        {
            sucursal.mostrarInformacion();
        }
    }
    static void mostrarOrganigrama()
    {
        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);
        System.out.println("➢ Ingrese el id de la empresa");
        int idEmpresa = scanner.nextInt();
        scanner.nextLine();
        Empresa empresa = obtenerEmpresaPorId(idEmpresa);
        if (empresa == null) {
            System.out.println(RED + "[☠ Esta empresa no existe ☠]" + RESET);
            return;
        }
        Empleado raiz = empresa.getRaiz();
        empresa.imprimirOrganigrama(raiz);
    }


    /* Metodos para borrar una empresa, sucursal o un empleado */
    static void borrarEmpresa(List<Empresa> empresas)
    {
        Scanner scanner = new Scanner(System.in);

        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println(" ");
        System.out.println("➢ Ingrese el id de la empresa");
        int idEmpresa = scanner.nextInt();
        scanner.nextLine();

        for(Empresa empresa : empresas)
        {
            if(empresa.getId() == idEmpresa)
            {
                empresas.remove(empresa);
                System.out.println(GREEN + "[✔ Empresa eliminada con exito ✔]" + RESET);
                break;
            }
            else
            {
                System.out.println(RED + "[☠ El id de la empresa no es valido ☠]" + RESET);
            }
        }

    }
    static void borrarSucursal(List<Sucursal> sucursales)
    {
        Scanner scanner = new Scanner(System.in);

        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println(" ");
        System.out.println("➢ Ingrese el id de la sucursal");
        int idSucursal = scanner.nextInt();
        scanner.nextLine();

        for(Sucursal sucursal : sucursales)
        {
            if(sucursal.getId() == idSucursal)
            {
                sucursales.remove(sucursal);
                System.out.println(" ");
                System.out.println(GREEN + "[✔ Sucursal eliminada con exito ✔]" + RESET);
                break;
            }
            else
            {
                System.out.println(RED + "[☠ El id de la sucursal no es valido ☠]" + RESET);
            }
        }

    }
    static void borrarEmpleado(List<Empleado> empleados)
    {
        Scanner scanner = new Scanner(System.in);

        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println(" ");
        System.out.println("➢ Ingrese el id del empleado");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();

        for(Empleado empleado : empleados)
        {
            if(empleado.getId() == idEmpleado)
            {
                empleados.remove(empleado);
                System.out.println(" ");
                System.out.println(GREEN + "[✔ Empleado eliminado con exito ✔]" + RESET);
                break;
            }
            else
            {
                System.out.println(RED + "[☠ El id del empleado no es valido ☠]" + RESET);
            }
        }

    }


    /* Otros metodos */
    static Empresa obtenerEmpresaPorId(int idEmpresa)
    {
        for (Empresa empresa : empresas) {
            if (empresa.getId() == idEmpresa) {
                return empresa;
            }
        }
        return null;
    }
    static void empleadosSeccion()
    {
        Scanner scanner = new Scanner(System.in);


        System.out.println("➢ Ingresa el id de la empresa");
        int idEmpresa = scanner.nextInt();
        scanner.nextLine();

        Empresa empresa = obtenerEmpresaPorId(idEmpresa);
        Empleado raizEmpresa = empresa.getRaiz();

        /* Validamos si la seccion ingresada es valida */
        System.out.println("➢ Ingresa la seccion");
        String seccionEmpleado = scanner.nextLine();
        if (
                !seccionEmpleado.equals("ventas") &&
                        !seccionEmpleado.equals("compras") &&
                        !seccionEmpleado.equals("exportaciones") &&
                        !seccionEmpleado.equals("recursos humanos")
        )
        {
            System.out.println("Esa sección no existe");
            return;
        }
        empresa.imprimirEmpleadosSeccion(raizEmpresa, seccionEmpleado);
    }
    static void empleadoYSubordinados(List<Empleado> empleados)
    {
        Scanner scanner = new Scanner(System.in);


        System.out.println("➢ Ingresa el id de la empresa");
        int idEmpresa = scanner.nextInt();
        scanner.nextLine();

        Empresa empresa = obtenerEmpresaPorId(idEmpresa);
        Empleado raizEmpresa = empresa.getRaiz();

        System.out.println("➢ Ingresa el id del empleado");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();

        empresa.imprimirEmpleadoYSubordinados(raizEmpresa, idEmpleado);
    }
    static Sucursal obtenerSucursalPorId(int idSucursal)
    {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getId() == idSucursal) {
                return sucursal;
            }
        }
        return null;
    }
    static void empleadosSucursal()
    {
        Scanner scanner = new Scanner(System.in);
        /* Colores para la consola */
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        System.out.println("➢ Ingresa el id de la empresa");
        int idEmpresa = scanner.nextInt();
        scanner.nextLine();

        Empresa empresa = obtenerEmpresaPorId(idEmpresa);
        Empleado raizEmpresa = empresa.getRaiz();


        System.out.println("➢ Ingresa la sucursal");
       int idSucursal = scanner.nextInt();
        scanner.nextLine();
        if(!empresa.tieneSucursal(idSucursal))
        {
            System.out.println(RED + "[☠ Esa sucursal no existe ☠]" + RESET);
            return;
        }


        empresa.imprimirEmpleadosSucursal(raizEmpresa, idSucursal);
    }

}



