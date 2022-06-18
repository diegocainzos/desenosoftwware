package TPV;

import java.util.ArrayList;


public class ProductoMultiple extends Producto{
    ArrayList<Ingrediente> aIngredientes = new ArrayList<>();
    ArrayList<ProductoIndividual> aIndividuales = new ArrayList<>();
    ArrayList<ProductoMultiple> aMultiples = new ArrayList<>();

    public float PVP(){
        float aux=0;
        if(!aIngredientes.isEmpty()){
            for(int i = 0; i<aIngredientes.size();i++){
               aIngredientes.get(i).PVP();
                aux+=aIngredientes.get(i).getPVP();
            }
        }
        if(!aIndividuales.isEmpty()){
            for(int i = 0; i<aIndividuales.size();i++){
                aIndividuales.get(i).PVP();
                aux+=aIndividuales.get(i).getPVP();
            }
        }

        if(!aMultiples.isEmpty()){
            for(int i = 0; i<aMultiples.size();i++){
                aMultiples.get(i).PVP();
                aux+=aMultiples.get(i).getPVP();
            }
        }
        setPVP(aux);
        return getPVP();


        

    }
    public float getPrecio() {
        float aux = 0;
        for (ProductoIndividual a : aIndividuales)
            aux += a.getPrecio();
        for (Ingrediente a : aIngredientes)
            aux += a.getPrecio();
        for (ProductoMultiple a : aMultiples)
            aux += a.getPrecio();

        return aux;



    }
}
