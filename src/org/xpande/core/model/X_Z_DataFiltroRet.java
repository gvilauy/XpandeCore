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

/** Generated Model for Z_DataFiltroRet
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_DataFiltroRet extends PO implements I_Z_DataFiltroRet, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20201206L;

    /** Standard Constructor */
    public X_Z_DataFiltroRet (Properties ctx, int Z_DataFiltroRet_ID, String trxName)
    {
      super (ctx, Z_DataFiltroRet_ID, trxName);
      /** if (Z_DataFiltroRet_ID == 0)
        {
			setZ_DataFiltro_ID (0);
			setZ_DataFiltroRet_ID (0);
			setZ_RetencionSocio_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_DataFiltroRet (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Z_DataFiltroRet[")
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

	/** Set Z_DataFiltroRet ID.
		@param Z_DataFiltroRet_ID Z_DataFiltroRet ID	  */
	public void setZ_DataFiltroRet_ID (int Z_DataFiltroRet_ID)
	{
		if (Z_DataFiltroRet_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_DataFiltroRet_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_DataFiltroRet_ID, Integer.valueOf(Z_DataFiltroRet_ID));
	}

	/** Get Z_DataFiltroRet ID.
		@return Z_DataFiltroRet ID	  */
	public int getZ_DataFiltroRet_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_DataFiltroRet_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Z_RetencionSocio ID.
		@param Z_RetencionSocio_ID Z_RetencionSocio ID	  */
	public void setZ_RetencionSocio_ID (int Z_RetencionSocio_ID)
	{
		if (Z_RetencionSocio_ID < 1) 
			set_Value (COLUMNNAME_Z_RetencionSocio_ID, null);
		else 
			set_Value (COLUMNNAME_Z_RetencionSocio_ID, Integer.valueOf(Z_RetencionSocio_ID));
	}

	/** Get Z_RetencionSocio ID.
		@return Z_RetencionSocio ID	  */
	public int getZ_RetencionSocio_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_RetencionSocio_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}