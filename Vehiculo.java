public class Vehiculo{
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String diagnostico;
    private String  direccion;

    public Vehiculo(String placa, String marca, String modelo,String color,String diagnostico, String direccion){
        this.placa=placa;
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;
        this.diagnostico=diagnostico;
        this.direccion=direccion;
    
    }
    
    public String getPlaca(){
     return placa;
    }
    public String getMarca(){
     return marca;
    }
    public String getModelo(){
     return modelo;
    }
    public String getColor(){
     return color;
    }
    public String getDiagnostico(){
     return diagnostico;
    }
    public String getDireccion(){
     return direccion ;
    }
    public String toString(){
    return placa+" "+marca+" "+modelo+" "+color+" "+diagnostico;
    }
}