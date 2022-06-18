package TPV;

public class Ingrediente extends Producto{
    float racion;


    public Ingrediente(String nombre, float precio, float existencias) {
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }
    void anadirExis(Ingrediente p, float exist){
        p.existencias += exist;
    }
    void restarExis(Ingrediente p, float exist){
        p.existencias -= exist;
    }
    public float PVP(){
        float temp =(racion* getPrecio()) + (racion*getPrecio()*getIva());
        setPVP(temp);
        return getPVP();
    }
    

}
