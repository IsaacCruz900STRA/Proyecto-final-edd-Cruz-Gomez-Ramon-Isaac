import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Metodos{
    private List<Vehiculo> carrosReparados = new ArrayList<>();
    private List<Vehiculo> carrosAReparar = new ArrayList<>();
    String  [] carros = ReadFileToArray.readFile("Carros.csv");
    ColaDinamica carrosReparar;
    ComparadorClientePorId comparador = new ComparadorClientePorId();
    ArbolAVL avlCliente = new ArbolAVL(comparador);
    PilaDinamica entregas= new PilaDinamica();
    Grafo ruta= new Grafo();

    public void insertarCarros(){  
        for (int i=0; i<carros.length; i++ ){
            try{
                String[] atributos = carros[i].split(","); 
                String placa= atributos [0];
                String marca= atributos[1];
                String modelo= atributos [2];
                String color= atributos [3];
                String diagnostico= atributos [4];
                String direccion= atributos [5];
                Vehiculo vehiculo = new Vehiculo(placa,marca,modelo,color,diagnostico,direccion);

                if (!estaEnListas(vehiculo)) {
                    if (Math.random() < 0.5) {
                        carrosReparados.add(vehiculo);

                    } else {
                        carrosAReparar.add(vehiculo);

                    }
                } else {
                    System.out.println("Vehículo duplicado ignorado: " + placa);
                }            
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.print("Error al agregar carro"+ e);
            }

        }

    }

    public void Insert(){
        if (carrosReparar == null) {
            carrosReparar = new ColaDinamica();
        }
        for (Vehiculo vehiculo : carrosAReparar) {
            this.carrosReparar.agregar(vehiculo); /** Agregar cada vehículo a la cola*/
        }
    }

    private boolean estaEnListas(Vehiculo vehiculo) {
        return carrosReparados.contains(vehiculo) || carrosAReparar.contains(vehiculo);
    }

    public void verCarrosAReparar(){
        carrosReparar.mostrarCola();
    }

    /**Cola*/
    public Object quitar() throws Exception{
        return carrosReparar.eliminar();
    }

    public boolean agregarCarro(String placa, String marca, String modelo, String color, String diagnostico,String direccion){
        Vehiculo nuevo= new Vehiculo(placa,marca,modelo,color,diagnostico,direccion);
        return carrosReparar.agregar(nuevo)? true: false;
    }

    /**AVL*/

    String  [] clientes = ReadFileToArray.readFile("clientes.csv");
    public void insertarClientes(){  
        for (int i=0; i<carros.length; i++ ){
            try{

                String[] atributos = clientes[i].split(","); 
                int id=Integer.parseInt( atributos [0]);
                String nombre= atributos[1];
                String direccion= atributos [2];
                String telefono= atributos [3];

                Cliente cliente = new Cliente (id,nombre,direccion,telefono);
                avlCliente.insertar(cliente);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.print("Error al agregar cancion"+ e);
            }
        }
    }   

    public Cliente buscarCliente(int id){
        return buscarClienteId(avlCliente.getRaiz(), id);
    }

    private Cliente buscarClienteId(NodoAVLOBJ nodo, int id) {

        if (nodo == null) {
            return null;  
        }

        if (nodo.getCliente().getId()==id) {
            return nodo.getCliente(); 
        }
        Cliente resultado = buscarClienteId(nodo.getDer(), id);
        if (resultado != null) {
            return resultado;
        }
        return buscarClienteId(nodo.getIzq(), id);
    }

    public Cliente eliminarCliente(int id) {
        Cliente nodo = buscarClienteId(avlCliente.getRaiz(), id);  
        if (nodo != null) {
            avlCliente.eliminar(avlCliente.getRaiz(),nodo);  
            return nodo; 
        }
        return null;
    }

    public boolean agregarCliente(int id,String nombre, String direccion, String telefono){
        Cliente nuevoCliente = new Cliente(id,nombre,direccion ,telefono);
        avlCliente.insertar(nuevoCliente);
        return true;
    }

    private void recorrerInorden(NodoAVLOBJ nodo, List<Cliente> lista) {
        if (nodo != null) {
            recorrerInorden(nodo.getIzq(), lista); 
            lista.add(nodo.getCliente());          
            recorrerInorden(nodo.getDer(), lista); 
        }
    }

    /**Quick*/

    public void ClientesPorNombre() {
        List<Cliente> listacliente = new ArrayList<>();
        recorrerInorden(avlCliente.getRaiz(), listacliente);
        Cliente [] clientes = listacliente.toArray(new Cliente[0]);
        quicksort quick= new quicksort();
        quick.quicksort(clientes, 0, clientes.length - 1);
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre());
        }
    }

    /**Pila*/
    public NodoGrafo obtenerNodo(Grafo grafo, Object dato) {
        NodoGrafo actual = grafo.getPrimero();
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual; 
            }
            actual = actual.getSiguiente();
        }
        grafo.agregarNodo(dato);
        actual = grafo.getPrimero();
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }

        return null; 
    }
    
    public PilaDinamica<String> diagnosticoCompleto() throws Exception {
        String[] diagnostico = {
                "Revisar frenos",
                "Revisar balatas",
                "Revisar fusibles",
                "Revisar suspensión",
                "Revisar sistema eléctrico",
                "Revisar motor",
                "Verificar niveles de aceite",
                "Verificar niveles de refrigerante",
                "Revisar batería",
                "Inspeccionar neumáticos",
                "Revisar sistema de transmisión",
                "Verificar sistema de escape",
                "Revisar dirección hidráulica",
                "Chequear luces delanteras y traseras",
                "Revisar sistema de aire acondicionado",
                "Revisar filtro de aire",
                "Inspeccionar sistema de frenos ABS",
                "Verificar alineación y balanceo de llantas",
                "Revisar filtro de combustible",
                "Revisar sistema de inyección de combustible"
            };

        PilaDinamica piladeDiagnostico = new PilaDinamica(); 

        for (int y=0; y<diagnostico.length; y++) {
            piladeDiagnostico.push(diagnostico[y]);
        }
        return piladeDiagnostico;
    }

    
}

