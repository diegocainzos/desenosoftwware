package TPV;

public class TPV {
    public static void main (String[] args){
       Comanda e = new Comanda();
       ProductoIndividual agua = new ProductoIndividual((float) 0.10,"Agua mineral",126,(float) 0.20, "Aguita",0);
       ProductoIndividual pan = new ProductoIndividual((float)0.10,"Pan de Boiro sen gluten, feito por meigas",10,1,"Pan",(float)1.212);
       ProductoMultiple menu = new ProductoMultiple();
       agua.racion = 1;
       pan.racion = 1;
       agua.numRacion=1;
       pan.numRacion = 1;
        menu.existencias = 2;
        menu.setNombre("Menu");
       menu.aIndividuales.add(pan);
       menu.aIndividuales.add(agua);
        System.out.println("el precio  de "+menu.getNombre() + " es "+ menu.PVP());
        e.anadirComanda(menu,2);
        System.out.println("cuanto pan quedqa ?? " +pan.getExistencias());
        e.anadirComanda(pan,2);

        System.out.println("cuanto pan quedqa ?? " +pan.getExistencias());
        ImprimirCuenta printer = new ImprimirCuenta();
        printer.comanda = e;
        e.imprimirCuenta();









    }
}
