public class PilaDinamica<T> {
    private Nodo<T> tope;
    public PilaDinamica() {
        this.tope = null;
    }
    public boolean estaVacia() {
        return this.tope == null;
    }
    public boolean push(T valor) {
        Nodo<T> n = new Nodo<>(valor);
        if (estaVacia()) {
            tope = n;
        } else {
            n.setSiguiente(tope);
            tope = n;
        }
        return true;
    }
    public T pop() throws Exception {
        if (estaVacia())
            throw new Exception("Pila vacía");
        T valor = tope.getValor();
        this.tope = this.tope.getSiguiente();
        return valor;
    }


 
    public  class Nodo<T> {
        private T valor;
        private Nodo<T> siguiente;

        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }

        public T getValor() {
            return this.valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public Nodo<T> getSiguiente() {
            return this.siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }
    }
}
