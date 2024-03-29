package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsFactura;
import java.util.ArrayList;



public class crudFactura {
    public boolean save(clsFactura fac){
        boolean resultado = false;
        String sql = "INSERT INTO public.factura(clienteid,fecha,subtotal,iva,total) "
                + "VALUES(?,?,?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, fac.getIdcliente().getId()));
        lstPar.add(new Parametro(2, fac.getFecha()));
        lstPar.add(new Parametro(3, fac.getSubtotal()));
        lstPar.add(new Parametro(4, fac.getIva()));
        lstPar.add(new Parametro(5, fac.getTotal()));         
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public boolean delete(clsFactura fac) {
        boolean res=false;
        String sql = "DELETE FROM public.factura WHERE no=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,fac.getNo()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public boolean update(clsFactura fac) {
        boolean res = false;
        String sql = "UPDATE public.factura " +
                "SET clienteid=?, fecha=?,subtotal=?,iva=?,total=? " + 
                "WHERE no=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, fac.getIdcliente().getId()));
        lstPar.add(new Parametro(2, fac.getFecha()));
        lstPar.add(new Parametro(3, fac.getSubtotal())); 
        lstPar.add(new Parametro(4,fac.getIva()));
        lstPar.add(new Parametro(5,fac.getTotal()));
        lstPar.add(new Parametro(6,fac.getNo()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }
    public ArrayList<clsFactura> findbyAll() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT no,clienteid,fecha,subtotal,iva,total FROM public.factura";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura fac = null;
            while (cres.next())
            {
                fac = new clsFactura();
                fac.setNo(cres.getInt("no"));
                fac.setIdcliente(crudCliente.findbyId(cres.getInt("id")));
                fac.setFecha(cres.getDate("fecha"));
                fac.setSubtotal(cres.getDouble("subtotal"));
                fac.setIva(cres.getDouble("iva"));
                fac.setTotal(cres.getDouble("total"));
                listado.add((fac));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
     public  clsFactura FindbyId(clsFactura factura) {
        clsFactura fac = null;
        String sql = "SELECT no,clienteid,fecha,subtotal,iva,total"
                + " FROM public.factura WHERE no=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getNo()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                fac = new clsFactura();
                fac.setNo(cres.getInt("no"));
                fac.setIdcliente(crudCliente.findbyId(cres.getInt("clienteid")));
                fac.setFecha(cres.getDate("fecha"));
                fac.setSubtotal(cres.getDouble("subtotal"));
                fac.setIva(cres.getDouble("iva"));
                fac.setTotal(cres.getDouble("total"));            
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fac;
    }
    public static clsFactura findbyId(int factura) {
        clsFactura fac = null;
        String sql = "SELECT no,clienteid,fecha,subtotal,iva,total"
                + " FROM public.factura WHERE no=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,factura));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                fac = new clsFactura();
                fac.setNo(cres.getInt("no"));
                fac.setIdcliente(crudCliente.findbyId(cres.getInt("clienteid")));
                fac.setFecha(cres.getDate("fecha"));
                fac.setSubtotal(cres.getDouble("subtotal"));
                fac.setIva(cres.getDouble("iva"));
                fac.setTotal(cres.getDouble("total"));         
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fac;
    }
}
