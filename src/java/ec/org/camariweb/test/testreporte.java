
package ec.org.camariweb.test;

import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.funciones.clsReportes;
import java.util.ArrayList;

public class testreporte {
    
    //psvm tab tab
public static void main(String[] args) {
    
    ArrayList<clsFactura> factura = new ArrayList<>();
    factura = clsReportes.clientefacturamayormil();
    System.out.print(factura.toString());

            
    }


}
