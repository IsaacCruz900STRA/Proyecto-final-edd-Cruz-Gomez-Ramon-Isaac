/*public class PilaDinamicaVehiculo
{

    private Nodo tope;

    public PilaDinamicaVehiculo(){
        this.tope=null;
    }

    public boolean estaVacia(){
        return this.tope==null;
    }

    public boolean push(Vehiculo valor){
        Nodo n=new Nodo(valor);
        if(estaVacia()){

            tope=n; 
            return true;
        }
        else{

            n.setSiguiente(tope);
            tope=n;
        }
        return true;
    }

    public Vehiculo pop() throws Exception{
        if(estaVacia())
            throw new Exception ("Pila vacia");

        Vehiculo valor = tope.getValor();
        this.tope=this.tope.getSiguiente();
        return valor;

    }
    
    
    public class Nodo
    {

        private Vehiculo valor;
        private Nodo siguiente;

        public Nodo(Vehiculo valor){
            this.valor=valor;
            this.siguiente=null;

        }

        public Vehiculo getValor(){
            return this.valor;
        }

        public void setValor(Vehiculo valor){
            this.valor=valor;
        }

        public Nodo getSiguiente(){
            return this.siguiente;
        }

        public void setSiguiente(Nodo sig){
            this.siguiente=sig;
        }

    }
}*/
