package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsProducto;

import java.util.ArrayList;



public class crudProducto {
    public boolean save(clsProducto prod){
        boolean resultado = false;
        String sql = "INSERT INTO public.producto(nombre,stock,precioventa) "
                + "VALUES(?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prod.getNombre()));
        lstPar.add(new Parametro(2, prod.getStock()));
        lstPar.add(new Parametro(3, prod.getPrecioventa()));   
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    public boolean delete(clsProducto prod) {
        boolean res=false;
        String sql = "DELETE FROM public.producto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,prod.getId()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public boolean update(clsProducto prod) {
        boolean res = false;
        String sql = "UPDATE public.producto " +
                "SET nombre,stock,precioventa " + 
                "WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();        
        lstPar.add(new Parametro(1, prod.getNombre()));
        lstPar.add(new Parametro(2, prod.getStock()));
        lstPar.add(new Parametro(3, prod.getPrecioventa())); 
        lstPar.add(new Parametro(4,prod.getId()));
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public ArrayList<clsProducto> findbyAll() {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT id,nombre,stock,precioventa "+
                "FROM public.producto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto pro = null;
            while (cres.next())
            {
                pro = new clsProducto();
                pro.setId(cres.getInt("id"));
                pro.setNombre(cres.getString("nombre"));
                pro.setStock(cres.getInt("stock"));
                pro.setPrecioventa(cres.getDouble("precioventa"));
                listado.add((pro));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }

    public clsProducto findbyId(clsProducto prod) {
        clsProducto pro = null;
        String sql = "SELECT id,nombre,stock,precioventa FROM public.producto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prod.getId()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                pro = new clsProducto();
                pro.setId(cres.getInt("id"));
                pro.setNombre(cres.getString("nombre"));
                pro.setStock(cres.getInt("stock"));
                pro.setPrecioventa(cres.getDouble("precioventa"));          
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pro;
    }
    public static clsProducto findbyId(int prod) {
        clsProducto pro = null;
        String sql = "SELECT id,nombre,stock,precioventa FROM public.producto WHERE id=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,prod));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                pro = new clsProducto();
                pro.setId(cres.getInt("id"));
                pro.setNombre(cres.getString("nombre"));
                pro.setStock(cres.getInt("stock"));
                pro.setPrecioventa(cres.getDouble("precioventa"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pro;
    }
}
