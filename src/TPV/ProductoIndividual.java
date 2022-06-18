package TPV;

public class ProductoIndividual extends Producto {
    int numRacion;//número de raciones por menus, es decir si un menu tiene dos hamburguesas iguales, seria dos
    float racion;//Sería 1 unidad, si se trata de un filete y sería 0.33 L si es una lata de un refresco

    void anadirExis(ProductoIndividual p, float exist) {
        p.existencias += exist;
    }

    void restarExis(ProductoIndividual p, float exist) {
        p.existencias -= exist;
    }

    public ProductoIndividual(float iva, String descrip, float existencias, float precio, String nombre, float PVP) {
        this.iva = iva;
        this.descrip = descrip;
        this.existencias = existencias;
        this.precio = precio;
        this.nombre = nombre;
        this.PVP = PVP;

    }
    public float PVP(){
        float temp =(racion* getPrecio()) + (racion*getPrecio()*getIva());
        setPVP(temp);
        return getPVP();
    }
}
