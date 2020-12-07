package org.xpande.core.model;

import org.compiere.model.Query;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 12/6/20.
 */
public class MZDataFiltro extends X_Z_DataFiltro{

    public MZDataFiltro(Properties ctx, int Z_DataFiltro_ID, String trxName) {
        super(ctx, Z_DataFiltro_ID, trxName);
    }

    public MZDataFiltro(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }

    /***
     * Obtiene y retorna lista de filtros por cuenta contable.
     * Xpande. Created by Gabriel Vila on 12/6/20.
     * @return
     */
    public List<MZDataFiltroAcct> getFiltrosAcct(){

        String whereClause = X_Z_DataFiltroAcct.COLUMNNAME_Z_DataFiltro_ID + " =" + this.get_ID();

        List<MZDataFiltroAcct> lines = new Query(getCtx(), I_Z_DataFiltroAcct.Table_Name, whereClause, get_TrxName()).list();

        return lines;
    }

    /***
     * Obtiene y retorna lista de filtros por socio de negocio.
     * Xpande. Created by Gabriel Vila on 12/6/20.
     * @return
     */
    public List<MZDataFiltroBP> getFiltrosBP(){

        String whereClause = X_Z_DataFiltroBP.COLUMNNAME_Z_DataFiltro_ID + " =" + this.get_ID();

        List<MZDataFiltroBP> lines = new Query(getCtx(), I_Z_DataFiltroBP.Table_Name, whereClause, get_TrxName()).list();

        return lines;
    }

    /***
     * Obtiene y retorna lista de filtros por tipo de documento.
     * Xpande. Created by Gabriel Vila on 12/6/20.
     * @return
     */
    public List<MZDataFiltroDoc> getFiltrosDoc(){

        String whereClause = X_Z_DataFiltroDoc.COLUMNNAME_Z_DataFiltro_ID + " =" + this.get_ID();

        List<MZDataFiltroDoc> lines = new Query(getCtx(), I_Z_DataFiltroDoc.Table_Name, whereClause, get_TrxName()).list();

        return lines;
    }

    /***
     * Obtiene y retorna lista de filtros por medio de pago.
     * Xpande. Created by Gabriel Vila on 12/6/20.
     * @return
     */
    public List<MZDataFiltroMPago> getFiltrosMPago(){

        String whereClause = X_Z_DataFiltroMPago.COLUMNNAME_Z_DataFiltro_ID + " =" + this.get_ID();

        List<MZDataFiltroMPago> lines = new Query(getCtx(), I_Z_DataFiltroMPago.Table_Name, whereClause, get_TrxName()).list();

        return lines;
    }

    /***
     * Obtiene y retorna lista de filtros por producto.
     * Xpande. Created by Gabriel Vila on 12/6/20.
     * @return
     */
    public List<MZDataFiltroProd> getFiltrosProd(){

        String whereClause = X_Z_DataFiltroProd.COLUMNNAME_Z_DataFiltro_ID + " =" + this.get_ID();

        List<MZDataFiltroProd> lines = new Query(getCtx(), I_Z_DataFiltroProd.Table_Name, whereClause, get_TrxName()).list();

        return lines;
    }

    /***
     * Obtiene y retorna lista de filtros por retención.
     * Xpande. Created by Gabriel Vila on 12/6/20.
     * @return
     */
    public List<MZDataFiltroRet> getFiltrosRet(){

        String whereClause = X_Z_DataFiltroRet.COLUMNNAME_Z_DataFiltro_ID + " =" + this.get_ID();

        List<MZDataFiltroRet> lines = new Query(getCtx(), I_Z_DataFiltroRet.Table_Name, whereClause, get_TrxName()).list();

        return lines;
    }

    /***
     * Obtiene y retorna lista de filtros por impuesto.
     * Xpande. Created by Gabriel Vila on 12/6/20.
     * @return
     */
    public List<MZDataFiltroTax> getFiltrosTax(){

        String whereClause = X_Z_DataFiltroTax.COLUMNNAME_Z_DataFiltro_ID + " =" + this.get_ID();

        List<MZDataFiltroTax> lines = new Query(getCtx(), I_Z_DataFiltroTax.Table_Name, whereClause, get_TrxName()).list();

        return lines;
    }

}
