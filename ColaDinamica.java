public class ColaDinamica{
    private Nodo primero;
    private Nodo ultimo;

    public ColaDinamica(){
        this.primero=null;
        this.ultimo=null;
    }

    public boolean estavacia(){
        return primero==null;
    }

    public boolean agregar(Object valor){
        Nodo nuevo= new Nodo(valor);
        if(estavacia()){
            this.primero=nuevo;
            this.ultimo=nuevo;
            return true;
        }
        this.ultimo.setSiguiente(nuevo);
        this.ultimo=nuevo;
        return true;
    }    


    public Object eliminar() throws Exception {
        if(estavacia()){
            throw new Exception ("Cola vacia");
        }
        Object auxvalor= primero.getValor();
        this.primero=primero.getSiguiente();
        return auxvalor;
    }

    public Object verprimero() throws Exception {
        if(estavacia()){
            throw new Exception ("Cola vacia");
        }
        return primero.getValor();
    }
   
    
     public void mostrarCola() {
        if (estavacia()) {
            System.out.println("La cola está vacía.");
            return;
        }

        Nodo actual = primero;  
        while (actual != null) {  
            System.out.println(actual.getValor());  
            actual = actual.getSiguiente();  
        }
    }
}
