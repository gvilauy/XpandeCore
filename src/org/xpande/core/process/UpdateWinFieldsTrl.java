package org.xpande.core.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MField;
import org.compiere.model.MTab;
import org.compiere.model.MWindow;
import org.compiere.model.M_Element;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Proceso para actualizar traducción de fields de una determinada ventana, tomando como base
 * la traducción de los elementos asociados a las columnas de los fields, en el lenguaje recibido.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 5/18/18.
 */
public class UpdateWinFieldsTrl extends SvrProcess {

    private MWindow window = null;
    private String language = "es_MX";

    @Override
    protected void prepare() {

        int adWindowID = 0;

        ProcessInfoParameter[] para = getParameter();

        for (int i = 0; i < para.length; i++){

            String name = para[i].getParameterName();

            if (name != null){
                if (para[i].getParameter() != null){
                    if (name.trim().equalsIgnoreCase("AD_Window_ID")){
                        adWindowID = ((BigDecimal)para[i].getParameter()).intValueExact();
                    }
                    else if (name.trim().equalsIgnoreCase("AD_Language")){
                        this.language = ((String)para[i].getParameter()).trim();
                    }
                }
            }
        }

        if (adWindowID > 0){
            this.window = new MWindow(getCtx(), adWindowID, get_TrxName());
        }
    }

    @Override
    protected String doIt() throws Exception {

        try{

            if (this.window == null){
                return "No se obtuvo ventana.";
            }

            // Obtengo y recorro tabs de esta window
            MTab[] tabs = this.window.getTabs(true, get_TrxName());
            for (int i = 0; i < tabs.length; i++){
                MTab tab = tabs[i];
                // Obtengo y recorro fields de esta tab
                MField[] fields = tab.getFields(true, get_TrxName());
                for (int j = 0; j < fields.length; j++){
                    MField field = fields[j];

                    // Actualizo traduccion de este field en el lenguaje recibido.
                    this.updateFieldTranslation(field);
                }
            }

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return "OK";
    }


    /***
     * Actualiza traduccion de field recibido, segun elemento de la columna y lenguaje recibido en este proceso.
     * Xpande. Created by Gabriel Vila on 5/18/18.
     * @param field
     */
    private void updateFieldTranslation(MField field) {

        String sql = "", action = "";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{

            // Obtengo elemento asociado a la columna de esta field
            M_Element element = M_Element.getOfColumn(getCtx(), field.getAD_Column_ID(), get_TrxName());

            // Si no tengo elemento, salgo.
            if(element == null) return;

            sql = " select coalesce(name,'') as name, coalesce(description,'') as description, coalesce(help,'') as help " +
                    " from ad_element_trl " +
                    " where ad_element_id =" + element.get_ID() +
                    " and ad_language ='" + this.language + "'";

        	pstmt = DB.prepareStatement(sql, get_TrxName());
        	rs = pstmt.executeQuery();

        	if (rs.next()){
                action = " update ad_field_trl set name ='" + rs.getString("name") + "', " +
                            " description ='" + rs.getString("description") + "', " +
                            " help ='" + rs.getString("help") + "' " +
                            " where ad_field_id =" + field.get_ID() +
                            " and ad_language ='" + this.language + "'";
                DB.executeUpdateEx(action, get_TrxName());
        	}
        }
        catch (Exception e){
            throw new AdempiereException(e);
        }
        finally {
            DB.close(rs, pstmt);
        	rs = null; pstmt = null;
        }

    }
}
