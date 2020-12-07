/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.										*
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net or http://www.adempiere.net/license.html         *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.xpande.core.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for Z_DataFiltroMPago
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_DataFiltroMPago extends PO implements I_Z_DataFiltroMPago, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20201206L;

    /** Standard Constructor */
    public X_Z_DataFiltroMPago (Properties ctx, int Z_DataFiltroMPago_ID, String trxName)
    {
      super (ctx, Z_DataFiltroMPago_ID, trxName);
      /** if (Z_DataFiltroMPago_ID == 0)
        {
			setZ_DataFiltro_ID (0);
			setZ_DataFiltroMPago_ID (0);
			setZ_MedioPago_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_DataFiltroMPago (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_Z_DataFiltroMPago[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Immutable Universally Unique Identifier.
		@param UUID 
		Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID)
	{
		set_Value (COLUMNNAME_UUID, UUID);
	}

	/** Get Immutable Universally Unique Identifier.
		@return Immutable Universally Unique Identifier
	  */
	public String getUUID () 
	{
		return (String)get_Value(COLUMNNAME_UUID);
	}

	public I_Z_DataFiltro getZ_DataFiltro() throws RuntimeException
    {
		return (I_Z_DataFiltro)MTable.get(getCtx(), I_Z_DataFiltro.Table_Name)
			.getPO(getZ_DataFiltro_ID(), get_TrxName());	}

	/** Set Z_DataFiltro ID.
		@param Z_DataFiltro_ID Z_DataFiltro ID	  */
	public void setZ_DataFiltro_ID (int Z_DataFiltro_ID)
	{
		if (Z_DataFiltro_ID < 1) 
			set_Value (COLUMNNAME_Z_DataFiltro_ID, null);
		else 
			set_Value (COLUMNNAME_Z_DataFiltro_ID, Integer.valueOf(Z_DataFiltro_ID));
	}

	/** Get Z_DataFiltro ID.
		@return Z_DataFiltro ID	  */
	public int getZ_DataFiltro_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_DataFiltro_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Z_DataFiltroMPago ID.
		@param Z_DataFiltroMPago_ID Z_DataFiltroMPago ID	  */
	public void setZ_DataFiltroMPago_ID (int Z_DataFiltroMPago_ID)
	{
		if (Z_DataFiltroMPago_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_DataFiltroMPago_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_DataFiltroMPago_ID, Integer.valueOf(Z_DataFiltroMPago_ID));
	}

	/** Get Z_DataFiltroMPago ID.
		@return Z_DataFiltroMPago ID	  */
	public int getZ_DataFiltroMPago_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_DataFiltroMPago_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Z_MedioPago ID.
		@param Z_MedioPago_ID Z_MedioPago ID	  */
	public void setZ_MedioPago_ID (int Z_MedioPago_ID)
	{
		if (Z_MedioPago_ID < 1) 
			set_Value (COLUMNNAME_Z_MedioPago_ID, null);
		else 
			set_Value (COLUMNNAME_Z_MedioPago_ID, Integer.valueOf(Z_MedioPago_ID));
	}

	/** Get Z_MedioPago ID.
		@return Z_MedioPago ID	  */
	public int getZ_MedioPago_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_MedioPago_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}