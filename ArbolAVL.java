import java.util.*;
public class ArbolAVL {
    private NodoAVLOBJ raiz;
    private Comparator<Cliente> comparador;
    public ArbolAVL(Comparator<Cliente> comparador) { 
        this.comparador = comparador;
    }
    private int obtenerAltura(NodoAVLOBJ nodo) {
        return nodo == null ? 0 : nodo.getAltura();
    }
    public NodoAVLOBJ getRaiz(){
        return raiz;
    }
    public void setRaiz(NodoAVLOBJ nuevaRaiz) {
        this.raiz = nuevaRaiz;
    }
    /**/
    private NodoAVLOBJ rotacionDerecha(NodoAVLOBJ y) {
        NodoAVLOBJ x = y.getIzq();
        NodoAVLOBJ T2 = x.getDer();

        x.setDer(y);
        y.setIzq(T2);

        y.setAltura(Math.max(obtenerAltura(y.getIzq()), obtenerAltura(y.getDer())) + 1);
        x.setAltura(Math.max(obtenerAltura(x.getIzq()), obtenerAltura(x.getDer())) + 1);
        return x;
    }
    private NodoAVLOBJ rotacionIzquierda(NodoAVLOBJ x) {
         if (x == null || x.getDer() == null) {
            return x; /** No se puede hacer la rotación si 'x' o su hijo derecho son nulos*/
        }
        NodoAVLOBJ y = x.getDer();
        NodoAVLOBJ T2 = y.getIzq();
        y.setIzq(x);
        x.setDer(T2);
        x.setAltura(1 + Math.max(obtenerAltura(x.getIzq()), obtenerAltura(x.getDer())));
        y.setAltura(1 + Math.max(obtenerAltura(y.getIzq()), obtenerAltura(y.getDer())));
        return y;
    }
    public NodoAVLOBJ generarNodo(NodoAVLOBJ nodo, Cliente cliente) {
        if (nodo == null) {
            return new NodoAVLOBJ(cliente);
        }
        if (comparador.compare(cliente, nodo.getCliente()) < 0) {
            nodo.setIzq(generarNodo(nodo.getIzq(), cliente)); 
        } else if (comparador.compare(cliente, nodo.getCliente()) > 0) {
            nodo.setDer(generarNodo(nodo.getDer(), cliente));
        } else {
            return nodo; 
        }
        nodo.setAltura(1 + Math.max(obtenerAltura(nodo.getIzq()), obtenerAltura(nodo.getDer())));
        int balance = obtenerAltura(nodo.getDer()) - obtenerAltura(nodo.getIzq());
        /** Rotaciones */
        /**balance >= 2 && valor > nodo.getDer().getDato()*/
        if (balance >=2 && comparador.compare(cliente, nodo.getDer().getCliente()) > 0) {
            return rotacionIzquierda(nodo);
        }
        /**balance <= -2 && valor < nodo.getIzq().getDato()*/
        if (balance <=-2 && comparador.compare(cliente,  nodo.getIzq().getCliente()) < 0) {
            return rotacionDerecha(nodo);
        }
        /**balance >= 2 && valor < nodo.getDer().getDato()*/
        if (balance >=2  && comparador.compare(cliente, nodo.getDer().getCliente()) < 0) {
            nodo.setDer(rotacionDerecha(nodo.getDer()));
            return rotacionIzquierda(nodo);
        }
        /**balance <= -2 && valor > nodo.getIzq().getDato()*/
        if (balance <= -2 && comparador.compare(cliente, nodo.getIzq().getCliente()) > 0) {
            nodo.setIzq(rotacionIzquierda(nodo.getIzq()));
            return rotacionDerecha(nodo);
        }
        return nodo;
    }

    public void insertar(Cliente cliente) {
        raiz = generarNodo(raiz, cliente);
    }
    public NodoAVLOBJ eliminar(NodoAVLOBJ nodo, Cliente cliente) {
        if (nodo == null) {
            return nodo; 
        }
        if (comparador.compare(cliente, nodo.getCliente()) < 0) {
            nodo.setIzq(eliminar(nodo.getIzq(), cliente)); 
        } else if (comparador.compare(cliente, nodo.getCliente()) > 0) {
            nodo.setDer(eliminar(nodo.getDer(), cliente)); 
        } else {
            if (nodo.getIzq() == null || nodo.getDer() == null) {
                /** 0  1 hijo*/
                NodoAVLOBJ temp = (nodo.getIzq() != null) ? nodo.getIzq() : nodo.getDer();
                nodo = temp;
            } else {
                /** 2 */
                NodoAVLOBJ sucesor = obtenerMinimo(nodo.getDer());
                nodo.setCliente(sucesor.getCliente());  
                nodo.setDer(eliminar(nodo.getDer(), sucesor.getCliente()));  
            }
        }
        if (nodo == null) {
            return nodo;
        }
        nodo.setAltura(1 + Math.max(obtenerAltura(nodo.getIzq()), obtenerAltura(nodo.getDer())));
        int balance = obtenerAltura(nodo.getDer()) - obtenerAltura(nodo.getIzq());
        if (balance >=2 && comparador.compare(cliente, nodo.getDer().getCliente()) > 0) {
            return rotacionIzquierda(nodo);
        }
        /**balance <= -2 && valor < nodo.getIzq().getDato()*/
        if (balance <=-2 && comparador.compare(cliente,  nodo.getIzq().getCliente()) < 0) {
            return rotacionDerecha(nodo);
        }
        /**balance >= 2 && valor < nodo.getDer().getDato()*/
        if (balance >=2  && comparador.compare(cliente, nodo.getDer().getCliente()) < 0) {
            nodo.setDer(rotacionDerecha(nodo.getDer()));
            return rotacionIzquierda(nodo);
        }
        /**balance <= -2 && valor > nodo.getIzq().getDato()*/
        if (balance <= -2 && comparador.compare(cliente, nodo.getIzq().getCliente()) > 0) {
            nodo.setIzq(rotacionIzquierda(nodo.getIzq()));
            return rotacionDerecha(nodo);
        }
        return nodo; 
    }
    private NodoAVLOBJ obtenerMinimo(NodoAVLOBJ nodo) {
        while (nodo.getIzq() != null) {
            nodo = nodo.getIzq();
        }
        return nodo;
    }
}
