package zona_fit.presentacion;

import java.util.Scanner;
import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp(){
        var salir = false;
        var consola = new Scanner(System.in);
        //Creamos un obj de la clase clienteDao
        IClienteDAO clienteDao = new ClienteDAO();
        
        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola,opcion, clienteDao);
            }catch(Exception e){
                System.out.println("Error al ejecutar opcione: " + e.getMessage());
            }
        }
    }
    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                           *** Zona Fit (GYM) ***
                           1. Listar Clientes
                           2. Buscar Cliente
                           3. Agregar Cliente
                           4. Modificar cliente
                           5. Eliminar Cliente
                           6. Salir
                           Elija una op:\s""");
        return Integer.parseInt(consola.nextLine());
    }
    private static boolean ejecutarOpciones(Scanner consola, int opcion, IClienteDAO clienteDAO){
        var salir = false;
        switch(opcion){
            case 1 -> {//Listar clientes
                System.out.println("--- Listado de Clientes ---");
                var clientes = clienteDAO.listarClientes();
                clientes.forEach(System.out::println);
            }
            case 2 -> {//Buscar cliente por ID
                System.out.print("Introduzca el id del cliente a buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var encontrado = clienteDAO.buscarClientePorId(cliente);
                if(encontrado)
                    System.out.println("Cliente encontrado:" + cliente);
                else
                    System.out.println("Cliente no encontrado: " + cliente);
            }
            case 3 -> {//Agregar cliente
                System.out.println("--- Agregar Cliente ---");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellid: ");
                var apellido = consola.nextLine();
                System.out.println("Membresia: ");
                var membresia = Integer.parseInt(consola.nextLine());
                
                //Se crea el cliente son el id(La ddbb lo hace automaticamente)
                var cliente = new Cliente(nombre,apellido, membresia);
                var agregado = clienteDAO.agregarCliente(cliente);
                if(agregado)
                    System.out.println("Cliente agregado: " + cliente);
                else
                    System.out.println("Cliente no agregado: " + cliente);
            }
            case 4 ->{//Modificar cliente
                System.out.println("--- Modificar Cliente ---");
                System.out.print("Id Cliente: ");
                var idCliente= Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Membresia: ");
                var membresia = Integer.parseInt(consola.nextLine());
                //Se crea el objeto a modificar
                var cliente = new Cliente(nombre, apellido, membresia, idCliente);
                var modificado = clienteDAO.modificarCliente(cliente);
                if(modificado)
                    System.out.println("Cliente modificado: " + cliente);
                else
                    System.out.println("Cliente NO modificado: " + cliente);
            }
            case 5 -> {//Eliminar cliente
                System.out.println("--- Eliminar Cliente ---");
                System.out.print("Ingrese el id del cliente a eliminar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var eliminado = clienteDAO.eliminarCliente(cliente);
                if (eliminado)
                    System.out.println("Cliente eliminado: " + cliente);
                else
                    System.out.println("Cliente NO eliminado: " + cliente);
                
            }
            case 6 -> {
                System.out.println("Saliendo del programa...");
                salir = true;
            }          
        }
        System.out.println("");
        return salir;
    }  
}
