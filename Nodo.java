 public class Nodo{
        private Object valor;
        private Nodo siguiente;

        public Nodo(Object valor){
            this.valor=valor;
            this.siguiente=null;

        }

        public Object getValor(){
            return this.valor;
        }

        public void setValor(Object valor){
            this.valor=valor;
        }

        public Nodo getSiguiente(){
            return this.siguiente;
        }

        public void setSiguiente(Nodo sig){
            this.siguiente=sig;
        }

    
    }