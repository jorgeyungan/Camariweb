package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsFactura;


import java.util.ArrayList;

public class clsReportes {
    //listado de todos los clientes con compras mayores a 1000
    //mostrar la nofactura, fecha, total y el nombre del cliente y el ruc
    
    
    
    
    
    public static ArrayList<clsFactura> clientefacturamayormil() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT \"public\".factura.\"no\",\"public\".factura.fecha,\n" +
"\"public\".factura.total,\"public\".cliente.ruc,\"public\".cliente.nombre\n" +
"FROM \"public\".cliente INNER JOIN \"public\".factura \n" +
"ON \"public\".factura.clienteid = \"public\".cliente.\"id\"\n" +
"WHERE \"public\".factura.total > '1000.00'";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNo(cres.getInt("no"));
                fac.setFecha(cres.getDate("fecha"));
                fac.setTotal(cres.getDouble("total"));
                fac.setIdcliente(crudCliente.findbyId(cres.getInt(cres.getString("ruc"))));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
}
