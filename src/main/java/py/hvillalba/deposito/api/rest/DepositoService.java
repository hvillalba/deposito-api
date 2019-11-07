/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.deposito.api.rest;

import py.hvillalba.deposito.dto.Vw_stock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import py.hvillalba.deposito.dto.Response;
import py.hvillalba.deposito.model.Reparto;
import py.hvillalba.deposito.model.RepartoItem;
import py.hvillalba.deposito.model.RepartoPicking;
import py.hvillalba.deposito.model.Ubicaciones;

/**
 *
 * @author hectorvillalba
 */
@Path("deposito")
@Stateless
public class DepositoService implements Serializable
{
    @PersistenceContext(unitName = "deposito-pu")
    EntityManager em;
    Logger log;
    
    public DepositoService() {
        this.log = Logger.getLogger("DepositoService");
    }
    
    @Path("list-reparto")
    @GET
    @Produces({ "application/json" })
    public Response<List<Reparto>> listaReparto() {
        final Response<List<Reparto>> response = (Response<List<Reparto>>)new Response();
        try {
            final List<Reparto> listaReparto = new ArrayList<Reparto>();
            final List<Reparto> lista = (List<Reparto>)this.em.createQuery("select r from Reparto r").getResultList();
            for (final Reparto reparto : lista) {
                if (reparto.getConteoConfirmado() == null || !reparto.getConteoConfirmado()) {
                    final List<RepartoItem> listaItem = (List<RepartoItem>)this.em.createQuery("select r from RepartoItem r where r.reparto.oid = :id order by r.articuloLote.articulo.codigo ").setParameter("id", (Object)reparto.getOid()).getResultList();
                    for (final RepartoItem repartoItem : listaItem) {
                        if (repartoItem.getConfirmado() == null) {
                            reparto.setRepartoItemList((List)listaItem);
                            listaReparto.add(reparto);
                            break;
                        }
                    }
                }
            }
            this.log.info("Lista: " + listaReparto.size());
            response.setCodigo(Integer.valueOf(200));
            response.setData(listaReparto);
            response.setMensaje("Proceso satisfactorio");
            this.log.info("Proceso satisfactorio...");
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
            response.setCodigo(Integer.valueOf(400));
            response.setMensaje("Error : " + e.getMessage());
            this.log.warning("Error: " + e.getMessage());
            return response;
        }
    }
    
    @Path("list-repartoitem-articulos/{id}")
    @GET
    @Produces({ "application/json" })
    public Response<List<RepartoItem>> listaRepartoItem(@PathParam("id") final Integer id) {
        final Response<List<RepartoItem>> response = (Response<List<RepartoItem>>)new Response();
        try {
            this.log.info("Id: " + id);
            final List<RepartoItem> lista = (List<RepartoItem>)this.em.createQuery("select r from RepartoItem r where r.reparto.oid = :id order by r.articuloLote.articulo.codigo ").setParameter("id", (Object)id).getResultList();
            final List<RepartoItem> lista2 = new ArrayList<RepartoItem>();
            for (final RepartoItem repartoItem : lista) {
                int cantDescontada = 0;
                if (repartoItem.getRepartoPickingList() != null && !repartoItem.getRepartoPickingList().isEmpty()) {
                    for (final RepartoPicking reparoPicking : repartoItem.getRepartoPickingList()) {
                        cantDescontada += (int)(Object)reparoPicking.getCantidadIngresada();
                    }
                }
                if (cantDescontada == repartoItem.getCantidad()) {
                    continue;
                }
                repartoItem.setCantidadIngresada(Integer.valueOf(cantDescontada));
                lista2.add(repartoItem);
            }
            this.log.info("Lista: " + lista.size());
            response.setCodigo(Integer.valueOf(200));
            response.setData(lista2);
            response.setMensaje("Proceso satisfactorio");
            this.log.info("Proceso satisfactorio...");
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
            response.setCodigo(Integer.valueOf(400));
            response.setMensaje("Error : " + e.getMessage());
            this.log.warning("Error: " + e.getMessage());
            return response;
        }
    }
    
    @Path("list-repartoitem-articulos-all/{id}")
    @GET
    @Produces({ "application/json" })
    public Response<List<RepartoItem>> listaRepartoItemAll(@PathParam("id") final Integer id) {
        final Response<List<RepartoItem>> response = (Response<List<RepartoItem>>)new Response();
        try {
            this.log.info("Id: " + id);
            final List<RepartoItem> lista = (List<RepartoItem>)this.em.createQuery("select r from RepartoItem r where r.reparto.oid = :id ").setParameter("id", (Object)id).getResultList();
            this.log.info("Lista: " + lista.size());
            response.setCodigo(Integer.valueOf(200));
            response.setData(lista);
            response.setMensaje("Proceso satisfactorio");
            this.log.info("Proceso satisfactorio...");
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
            response.setCodigo(Integer.valueOf(400));
            response.setMensaje("Error : " + e.getMessage());
            this.log.warning("Error: " + e.getMessage());
            return response;
        }
    }
    
    @Path("list-reparto-picking/{id}")
    @GET
    @Produces({ "application/json" })
    public Response<List<RepartoPicking>> listaRepartoPicking(@PathParam("id") final Integer id) {
        final Response<List<RepartoPicking>> response = (Response<List<RepartoPicking>>)new Response();
        try {
            this.log.info("Id: " + id);
            final List<RepartoPicking> lista = (List<RepartoPicking>)this.em.createQuery("select r from RepartoPicking r where r.repartoItem.oid = :id").setParameter("id", (Object)id).getResultList();
            this.log.info("Lista: " + lista.size());
            response.setCodigo(Integer.valueOf(200));
            response.setData(lista);
            response.setMensaje("Proceso satisfactorio");
            this.log.info("Proceso satisfactorio...");
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
            response.setCodigo(Integer.valueOf(400));
            response.setMensaje("Error : " + e.getMessage());
            this.log.warning("Error: " + e.getMessage());
            return response;
        }
    }
    
    @Path("get-ubicacion/{idArticulo}/{lote}")
    @GET
    @Produces({ "application/json" })
    public Response<List<Ubicaciones>> getUbicacion(@PathParam("idArticulo") final String idArticulo, @PathParam("lote") final String lote) {
        final Response<List<Ubicaciones>> response = (Response<List<Ubicaciones>>)new Response();
        final List<Ubicaciones> listaUbicaciones = new ArrayList<Ubicaciones>();
        try {
            this.log.info("Id: " + idArticulo);
            this.log.info("Lote: " + lote);
            final Query query = this.em.createNativeQuery("select * from vw_stock where CodigoArticulo = '" + idArticulo + "' and Lote like '%" + lote + "%'");
            final List<Object[]> object = (List<Object[]>)query.getResultList();
            if (object == null) {
                response.setCodigo(Integer.valueOf(205));
                response.setMensaje("No se encontraron datos");
                this.log.info("No se encontraron datos...");
                return response;
            }
            for (final Object[] objects : object) {
                final Vw_stock vw_stock = new Vw_stock();
                vw_stock.setCodigoArticulo(objects[0].toString());
                vw_stock.setLote(objects[1].toString());
                vw_stock.setCodigoSucursal(Integer.valueOf(Integer.parseInt(objects[2].toString())));
                vw_stock.setCodigoDeposito(objects[3].toString());
                vw_stock.setCodigoCalle(objects[4].toString());
                vw_stock.setCodigoEstante(objects[5].toString());
                vw_stock.setCodigoFila(objects[6].toString());
                vw_stock.setExistencia(Double.valueOf(Double.parseDouble(objects[7].toString())));
                final Ubicaciones ubicaciones = (Ubicaciones)this.em.createQuery("select u from Ubicaciones u where u.calle.codigo = :calle and u.deposito.codigo = :deposito and u.estante.codigo = :estante and u.fila.codigo = :fila and u.sucursal.codigo = :sucursal").setParameter("calle", (Object)vw_stock.getCodigoCalle()).setParameter("deposito", (Object)vw_stock.getCodigoDeposito()).setParameter("estante", (Object)vw_stock.getCodigoEstante()).setParameter("fila", (Object)vw_stock.getCodigoFila()).setParameter("sucursal", (Object)vw_stock.getCodigoSucursal()).getSingleResult();
                ubicaciones.setExistencia(vw_stock.getExistencia());
                ubicaciones.setLote(vw_stock.getLote());
                ubicaciones.setCodigoArticulo(vw_stock.getCodigoArticulo());
                listaUbicaciones.add(ubicaciones);
            }
            this.log.info("Lista: " + listaUbicaciones.size());
            response.setCodigo(Integer.valueOf(200));
            response.setData(listaUbicaciones);
            response.setMensaje("Proceso satisfactorio");
            this.log.info("Proceso satisfactorio...");
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
            response.setCodigo(Integer.valueOf(400));
            response.setMensaje("Error : " + e.getMessage());
            this.log.warning("Error: " + e.getMessage());
            return response;
        }
    }
    
    @Path("update-reparto-picking/{ubicacion}/{repartoItem}/{cantidad}")
    @POST
    @Produces({ "application/json" })
    public Response<RepartoPicking> updateRepartoPicking(@PathParam("ubicacion") final Integer ubicacion, @PathParam("repartoItem") final Integer repartoItem, @PathParam("cantidad") final Double cantidad) {
        final Response<RepartoPicking> response = (Response<RepartoPicking>)new Response();
        try {
            this.log.info("### UpdateRepartoPicking ###");
            this.log.info("Ubicacion: " + ubicacion);
            this.log.info("RepartoItem: " + repartoItem);
            this.log.info("Cantidad: " + cantidad);
            final List<RepartoPicking> listaRepartoPicking = (List<RepartoPicking>)this.em.createQuery("select r from RepartoPicking r where r.repartoItem.oid = :id").setParameter("id", (Object)repartoItem).getResultList();
            double cantRepartoItem = 0.0;
            if (listaRepartoPicking != null && !listaRepartoPicking.isEmpty()) {
                for (final RepartoPicking repartoPicking : listaRepartoPicking) {
                    cantRepartoItem += repartoPicking.getCantidadIngresada();
                }
                this.log.info("Sum CantRepartoItem: " + cantRepartoItem);
                cantRepartoItem += cantidad;
                this.log.info("Sum Total: " + cantRepartoItem);
                this.log.info("Total Reparto Item: " + (double)listaRepartoPicking.get(0).getRepartoItem().getCantidad());
                if (cantRepartoItem > listaRepartoPicking.get(0).getRepartoItem().getCantidad()) {
                    response.setCodigo(Integer.valueOf(204));
                    response.setData(null);
                    response.setMensaje("La cantidad que intenta ingresar supera lo solicitado por el Reparto");
                    this.log.info("La cantidad que intenta ingresar supera lo solicitado por el Reparto");
                    return response;
                }
                if (cantidad > listaRepartoPicking.get(0).getRepartoItem().getCantidad()) {
                    response.setCodigo(Integer.valueOf(204));
                    response.setData(null);
                    response.setMensaje("La cantidad que intenta ingresar supera lo solicitado por el Reparto");
                    this.log.info("La cantidad que intenta ingresar supera lo solicitado por el Reparto");
                    return response;
                }
            }
            RepartoItem reparto = null;
            try {
                reparto = (RepartoItem)this.em.createQuery("select r from RepartoItem r where r.oid = :id ").setParameter("id", (Object)repartoItem).getSingleResult();
                if (cantidad == (double)reparto.getCantidad()) {
                    reparto.setConfirmado(Boolean.FALSE);
                }
                if (cantRepartoItem == reparto.getCantidad()) {
                    reparto.setConfirmado(Boolean.FALSE);
                }
                this.em.merge((Object)reparto);
            }
            catch (Exception e) {
                response.setCodigo(Integer.valueOf(204));
                response.setData(null);
                response.setMensaje("Error: " + e.getMessage());
                return response;
            }
            final Ubicaciones ubicaciones = (Ubicaciones)this.em.createQuery("select u from Ubicaciones u where u.oid = :id").setParameter("id", (Object)ubicacion).getSingleResult();
            Integer oid = (Integer)this.em.createNativeQuery("select isnull(max(Oid),0) from RepartoPicking").getSingleResult();
            ++oid;
            this.log.info("Oid: " + oid);
            final RepartoPicking repartoPicking2 = new RepartoPicking();
            repartoPicking2.setCantidadIngresada(cantidad);
            repartoPicking2.setOid(oid);
            repartoPicking2.setRepartoItem(reparto);
            repartoPicking2.setUbicaciones(ubicaciones);
            if (cantRepartoItem + cantRepartoItem == reparto.getCantidad()) {
                this.log.info("Actualizamos el estado del Reparto");
            }
            this.em.persist((Object)repartoPicking2);
            this.log.info("Proceso satisfactorio");
            response.setCodigo(Integer.valueOf(200));
            response.setData(repartoPicking2);
            response.setMensaje("Proceso satisfactorio");
            return response;
        }
        catch (Exception e2) {
            e2.printStackTrace();
            response.setCodigo(Integer.valueOf(400));
            response.setData(null);
            response.setMensaje("Error: " + e2.getMessage());
            return response;
        }
    }
    
    @Path("update-reparto-item/{oid}")
    @POST
    @Produces({ "application/json" })
    public Response<RepartoItem> updateRepartoItem(@PathParam("oid") final Integer repartoItem) {
        final Response<RepartoItem> response = (Response<RepartoItem>)new Response();
        try {
            RepartoItem reparto = null;
            this.log.info("### UpdateRepartoItem ###");
            this.log.info("RepartoItemOid: " + repartoItem);
            try {
                reparto = (RepartoItem)this.em.createQuery("select f from RepartoItem f where f.oid = :id").setParameter("id", (Object)repartoItem).getSingleResult();
            }
            catch (NoResultException e2) {
                response.setCodigo(Integer.valueOf(205));
                response.setData(null);
                response.setMensaje("No se encontro ningun registro con ese id");
            }
            reparto.setConfirmado(Boolean.valueOf(true));
            this.em.merge((Object)reparto);
            response.setCodigo(Integer.valueOf(200));
            response.setData(reparto);
            response.setMensaje("Proceso satisfactorio");
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
            response.setCodigo(Integer.valueOf(400));
            response.setData(null);
            response.setMensaje("Error: " + e.getMessage());
            return response;
        }
    }
    
    @Path("update-reparto/{oid}")
    @POST
    @Produces({ "application/json" })
    public Response<Reparto> updateReparto(@PathParam("oid") final Integer repartoOid) {
        final Response<Reparto> response = (Response<Reparto>)new Response();
        try {
            Reparto reparto = null;
            this.log.info("### UpdateReparto ###");
            this.log.info("RepartoOid: " + repartoOid);
            try {
                reparto = (Reparto)this.em.createQuery("select f from Reparto f where f.oid = :id").setParameter("id", (Object)repartoOid).getSingleResult();
            }
            catch (NoResultException e2) {
                response.setCodigo(Integer.valueOf(205));
                response.setData(null);
                response.setMensaje("No se encontro ningun registro con ese id");
            }
            reparto.setConteoConfirmado(Boolean.valueOf(true));
            this.em.merge((Object)reparto);
            response.setCodigo(Integer.valueOf(200));
            response.setData(reparto);
            response.setMensaje("Proceso satisfactorio");
            return response;
        }
        catch (Exception e) {
            e.printStackTrace();
            response.setCodigo(Integer.valueOf(400));
            response.setData(null);
            response.setMensaje("Error: " + e.getMessage());
            return response;
        }
    }
}
