import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{
    public static void main (String args[]){
        Metodos metodosEmpresa= new Metodos();
        metodosEmpresa.insertarClientes();
        metodosEmpresa.insertarCarros();
        metodosEmpresa.Insert();
        Scanner scan=new Scanner(System.in);
        int opcion=0;
        int opcion2=0;
        int opcion3=0;
        try{

            do{
                System.out.println ("Bienvenido"+"\n"+"Selecciona una opcion"+"\n"
                    +"1._Ver opciones Carros a reparar"+"\n"
                    +"2._Realizar un diagnostico completo"+"\n"
                    +"3._Opciones relacionadas a clientes"+"\n"
                    +"4._Salir"+"\n");

                try{
                    opcion=scan.nextInt();
                    scan.nextLine();
                }catch(InputMismatchException e){
                    System.out.println("Opción inválida, por favor ingresa un número valido\n");
                    scan.nextLine();
                    continue;
                }
                switch(opcion){
                    case 1:
                        do{
                            System.out.printf(String.format("%80s%n","Bienvenido"));
                            System.out.println("Selecciona una opcion"+"\n"
                                +"1._Ver lista de carros a reparar"+"\n"
                                +"2._Agregar carro con diagnostico hecho a reparar"+"\n"
                                +"3._Quitar carro reparado"+"\n"
                                +"4._Regresar al menu principal");
                            try{
                                opcion2= scan.nextInt();
                                scan.nextLine();
                            }catch(InputMismatchException e){
                                System.out.println("Opción inválida, por favor ingresa un número valido\n");
                                scan.nextLine();
                                continue;
                            }
                            switch(opcion2){
                                case 1:
                                    metodosEmpresa.verCarrosAReparar();
                                    break;
                                case 2: 
                                    /**scan.nextLine();*/
                                    System.out.println("Ingrese Placa");
                                    String placa=scan.nextLine();
                                    System.out.println("Ingrese marca");
                                    String marca=scan.nextLine();
                                    System.out.println("Ingrese modelo");
                                    String modelo=scan.nextLine();
                                    System.out.println("Ingreso color");
                                    String color=scan.nextLine();
                                    System.out.println("Ingrese diagnostico");
                                    String diagnostico=scan.nextLine();
                                    System.out.println("Ingrese direccion");
                                    String direccion=scan.nextLine();

                                    metodosEmpresa.agregarCarro(placa,marca,modelo,color,diagnostico,direccion);
                                    break;
                                case 3: 
                                    System.out.println(metodosEmpresa.quitar());
                                    break;
                                
                            }
                        }while(opcion2!=4);
                        break;

                    case 2:
                        Grafo grafo = new Grafo(); 
                        System.out.println("Ingrese la información del vehículo:");
                        System.out.print("Placa: ");
                        String placa = scan.nextLine();
                        System.out.print("Marca: ");
                        String marca = scan.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = scan.nextLine();
                        System.out.print("Color: ");
                        String color = scan.nextLine();
                        System.out.print("Dirección: ");
                        String direccion = scan.nextLine();

                        /** objeto Vehiculo y agregarlo al grafo*/
                        Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, color,"", direccion);
                        grafo.agregarNodo(vehiculo);

                        PilaDinamica<String> pila = metodosEmpresa.diagnosticoCompleto();
                        while (!pila.estaVacia()) {
                            String diagnostico = pila.pop(); 
                            System.out.println("Tarea de diagnóstico: " + diagnostico);
                            System.out.print("¿Se encontró falla? (Ingrese si o de enter en caso contrario): ");
                            String respuesta = scan.nextLine().trim().toLowerCase();

                            if (respuesta.equals("si")) {
                                falla falla = new falla(diagnostico);
                                grafo.agregarNodo(falla);
                                grafo.agregarArista(vehiculo, falla);
                                System.out.println("Falla registrada: " + diagnostico);
                            } else {
                                System.out.println("Tarea completada sin problemas.");
                            }
                            System.out.println(); 
                        }

                
                        System.out.println("Reporte vehículo y fallas detectadas:");
                        grafo.imprimirGrafo();
                        
                        break;

                    case 3: 
                        do{
                            System.out.printf(String.format("%80s%n","Bienvenido"));
                            System.out.println("Selecciona una opcion"+"\n"
                                +"1._Buscar cliente (id)"+"\n"
                                +"2._Eliminar cliente"+"\n"
                                +"3.Agregar cliente"+"\n"
                                +"4._Ver lista clientes"+"\n"
                                +"5.Regresar al menu principal");
                            try{
                                opcion3=scan.nextInt();
                                scan.nextLine();
                            }catch(InputMismatchException e){
                                System.out.println("Opción inválida, por favor ingresa un número valido\n");
                                scan.nextLine();
                                continue;
                            }
                            switch(opcion3){
                                case 1:
                                    System.out.println("Ingrese ID");
                                    int id=Integer.parseInt(scan.nextLine());     
                                    System.out.print(metodosEmpresa.buscarCliente(id));
                                    break;
                                case 2: /**Eliminar cliente*/
                                    System.out.println("Ingrese ID");
                                    int id_=Integer.parseInt(scan.nextLine());     
                                    System.out.print(metodosEmpresa.eliminarCliente(id_));                    
                                    break;
                                case 3: /**Agregar*/
                                    System.out.println("Ingrese datos del cliente");
                                    System.out.println("Ingrese ID");
                                    int id_cliente=Integer.parseInt(scan.nextLine()); 
                                    System.out.println("Ingrese nombre");
                                    String nombre_= scan.nextLine(); 
                                    System.out.println("Ingrese direccion");
                                    String direccionnuevo=scan.nextLine(); 
                                    System.out.println("Ingrese telefono");
                                    String telefono=scan.nextLine(); 
                                    if(metodosEmpresa.agregarCliente(id_cliente, nombre_, direccionnuevo, telefono)){
                                        System.out.println("Se agrego con exito");
                                    }else System.out.println("No se ha podido insertar el cliente");

                                    break;
                                case 4:
                                    metodosEmpresa.ClientesPorNombre();
                                    break;
                            }
                        }while(opcion3!=5);
                    
                }
            }while(opcion!=4);

        }catch(Exception e){
            System.out.print("Ocurrio un error :("+ e);
        }

    }
}