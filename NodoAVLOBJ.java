public class NodoAVLOBJ{
    private Cliente objeto;
    private int altura;
    private NodoAVLOBJ izq;
    private NodoAVLOBJ der;

    public NodoAVLOBJ(Cliente objeto){
        this.objeto=objeto;
        this.izq=null;
        this.der=null;
        this.altura=1;
    }

    public Cliente getCliente(){
        return this.objeto;
    }

    public void setCliente(Cliente objeto){
        this.objeto=objeto;
    }

    public int getAltura(){
        return this.altura;
    }

    public void setAltura(int altura){
        this.altura=altura;
    }

    public NodoAVLOBJ getIzq(){
        return this.izq;
    }

    public void setIzq(NodoAVLOBJ nuevo){
        izq=nuevo;
    }

    public NodoAVLOBJ getDer(){
        return this.der;
    }

    public void setDer(NodoAVLOBJ nuevo){
        this.der=nuevo;
    }
}