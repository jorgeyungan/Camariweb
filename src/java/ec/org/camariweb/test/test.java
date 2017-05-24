
package ec.org.camariweb.test;

import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.entidades.clsDfacpro;
import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.entidades.clsProducto;
import ec.org.camariweb.funciones.crudCliente;
import ec.org.camariweb.funciones.crudDfacpro;
import ec.org.camariweb.funciones.crudFactura;
import ec.org.camariweb.funciones.crudProducto;

public class test {
    public static void main(String[] args) {
         
         //----------------------------------------------\\
        //----------- Ingreso de usuarios-----------------\\
       //--------------------------------------------------\\
        clsCliente cli = new clsCliente(3, "1600572760", "angie Paucar", "Puyo");
// 
//        crudCliente cl = new crudCliente();
//        
//        System.out.println("Prueba de clases");
//        System.out.println("=============================================");
//        System.out.println("contenido de la clase propietario");
//        System.out.println(cli.toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("INSERTANDO");
//        if (cl.save(cli)) {
//            System.out.println("Guardado");
//        }else{
//            System.out.println("error!!!!");
//        }
//        System.out.println("Comprobando si hay datos");
//        System.out.println(cl.findbyId(cli).toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Eliminando");    
//        if (cl.delete(cli)) {
//            System.out.println("eliminado");
//        }else{
//            System.out.println("no se ha podido eliminar");
//        }
        //----------------------------------------------\\
       //----------- Ingreso de Producto-----------------\\
      //--------------------------------------------------\\
       clsProducto pro = new clsProducto(1, "cocina", 20, 843.36);
// 
//        crudProducto pr = new crudProducto();
//        
//        System.out.println("Prueba de clases");
//        System.out.println("=============================================");
//        System.out.println("contenido de la clase propietario");
//        System.out.println(pro.toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("INSERTANDO");
//        if (pr.save(pro)) {
//            System.out.println("Guardado");
//        }else{
//            System.out.println("error!!!!");
//        }
//        System.out.println("Comprobando si hay datos");
//        System.out.println(pr.findbyId(pro).toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Eliminando");    
//        if (pr.delete(pro)) {
//            System.out.println("eliminado");
//        }else{
//            System.out.println("no se ha podido eliminar");
//        }
        //----------------------------------------------\\
       //----------- Ingreso de Factura-----------------\\
      //--------------------------------------------------\\
       clsFactura factur = new clsFactura(5, cli,null, 1220.12, 20.45, 1240.47);
// 
//        crudFactura fact = new crudFactura();
//        
//        System.out.println("Prueba de clases");
//        System.out.println("=============================================");
//        System.out.println("contenido de la clase propietario");
//        System.out.println(factur.toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("INSERTANDO");
//        if (fact.save(factur)) {
//            System.out.println("Guardado");
//        }else{
//            System.out.println("error!!!!");
//        }
//        System.out.println("Comprobando si hay datos");
//        System.out.println(fact.FindbyId(factur).toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("Eliminando");    
//        if (fact.delete(factur)) {
//            System.out.println("eliminado");
//        }else{
//            System.out.println("no se ha podido eliminar");
//        }

        clsDfacpro dfacp = new clsDfacpro(2, factur, pro, 2, 15);
 
        crudDfacpro dfcp = new crudDfacpro();
        
//        System.out.println("Prueba de clases");
//        System.out.println("=============================================");
//        System.out.println("contenido de la clase propietario");
//        System.out.println(dfacp.toString());
//        System.out.println("=============================================");
//        System.out.println("=============================================");
//        System.out.println("INSERTANDO");
//        if (dfcp.save(dfacp)) {
//            System.out.println("Guardado");
//        }else{
//            System.out.println("error!!!!");
//        }
        System.out.println("Comprobando si hay datos");
        System.out.println(dfcp.FindbyId(dfacp).toString());
        System.out.println("=============================================");
        System.out.println("=============================================");
//        System.out.println("Eliminando");    
//        if (dfcp.delete(dfacp)) {
//            System.out.println("eliminado");
//        }else{
//            System.out.println("no se ha podido eliminar");
//        }
     }
}
