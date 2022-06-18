package TPV;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Comanda {
    float descuento;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    int mesa;
    ArrayList<EntradaComanda> lineaComanda = new ArrayList<>();
    enum estado  {PENDIENTE, PAGADA,IMPAGADA,CANCELADA};

    void anadirComanda(ProductoMultiple p, float cantidad) {
        boolean cont = true;
        int i = 0;
        int u;
        int auxCantidad = (int)cantidad;
        ArrayList<Float> e = new ArrayList<Float>();
        while (auxCantidad != 0) {


            for (ProductoIndividual t : p.aIndividuales) {
                u =  t.numRacion;

                while (u > 0) {
                    if (t.racion > t.existencias) {
                        System.out.println("No hay existencias de " + t.getNombre());
                        cont = false;
                    } else {
                        e.add(t.existencias);
                        t.existencias -= t.racion;
                    } u--;
                }
            }
            auxCantidad--;
        }
        if (cont) {
            EntradaComanda LineaAux = new EntradaComanda(cantidad, p);
            lineaComanda.add(LineaAux);
            System.out.println("Comanda añadida");
        } else {
            for (ProductoIndividual t : p.aIndividuales) {
                t.existencias = e.get(i);
                i++;
            }
            System.out.println("Comanda rechazada");

        }
    }
    void anadirComanda(ProductoIndividual p, float cantidad){
        double rac = cantidad* p.racion;
        if(rac>p.existencias)
            System.out.println("No hay existencias de "+p.getNombre()+" comanda rechazada");
            
        else{
            p.existencias -=rac;
            EntradaComanda LineaAux = new EntradaComanda(cantidad, p);
            lineaComanda.add(LineaAux);
            System.out.println("comanda añadida "+p.getNombre());
            
        }
    }
    void imprimirCuenta(){
        float price=0;
        float total=0;
        float totalTaxes;
        StringBuilder sb = new StringBuilder();
        StringBuilder sv = new StringBuilder();

        System.out.println("Mesa número "+ mesa + "\n" + dtf.format(LocalDateTime.now()));
        System.out.println("Producto    Cantidad Precio PVP unidad  PVP total\n" + "=====================================================");
        for (EntradaComanda entradaComanda : lineaComanda) {
            if(entradaComanda.multiple != null){

                sv.append(entradaComanda.multiple.getNombre());
                sv.append(String.format("%15.2f",entradaComanda.cantidad));
                sv.append(String.format("%7.2f",entradaComanda.multiple.getPrecio()));
                sv.append(String.format("%11.2f",entradaComanda.multiple.getPVP()));
                sv.append(String.format("%11.2f\n",entradaComanda.cantidad*entradaComanda.multiple.getPVP()));
                price += entradaComanda.multiple.getPrecio();
                total += entradaComanda.multiple.getPVP();
            }
            else{

                sv.append(entradaComanda.individual.getNombre());
                sv.append(String.format("%15.2f",entradaComanda.cantidad));
                sv.append(String.format("%7.2f",entradaComanda.individual.getPrecio()));
                sv.append(String.format("%11.2f",entradaComanda.individual.getPVP()));
                sv.append(String.format("%11.2f\n",entradaComanda.cantidad*entradaComanda.individual.getPVP()));
                price += entradaComanda.individual.getPrecio();
                total += entradaComanda.individual.getPVP();

            }
        }
        totalTaxes=total-price;
        System.out.println(sv);

        sb.append(String.format("Total sin impuestos  %6.2f\n", price));
        sb.append(String.format("Total de impuestos   %6.2f\n", totalTaxes));
        sb.append(String.format("Total                %6.2f\n\n", total));
        System.out.println(sb);


    }




}





