package org.xpande.core.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.SvrProcess;
import org.xpande.core.model.MZLoadCore;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 7/23/20.
 */
public class InterfaceLoadCore extends SvrProcess {

    MZLoadCore loadCore = null;

    @Override
    protected void prepare() {

        this.loadCore = new MZLoadCore(getCtx(), this.getRecord_ID(), get_TrxName());
    }

    @Override
    protected String doIt() throws Exception {

        try{

            if ((this.loadCore.getFileName() == null) || (this.loadCore.getFileName().trim().equalsIgnoreCase(""))){
                return "@Error@ Debe indicar archivo a procesar ";
            }

            this.loadCore.executeInterface();
        }
        catch (Exception e){
            throw new AdempiereException(e);
        }

        return "OK";
    }

}
