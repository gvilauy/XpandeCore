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

/** Generated Model for Z_FormatoEtiqueta
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_FormatoEtiqueta extends PO implements I_Z_FormatoEtiqueta, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20170712L;

    /** Standard Constructor */
    public X_Z_FormatoEtiqueta (Properties ctx, int Z_FormatoEtiqueta_ID, String trxName)
    {
      super (ctx, Z_FormatoEtiqueta_ID, trxName);
      /** if (Z_FormatoEtiqueta_ID == 0)
        {
			setAD_Process_ID (0);
			setName (null);
			setZ_FormatoEtiqueta_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_FormatoEtiqueta (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 6 - System - Client 
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
      StringBuffer sb = new StringBuffer ("X_Z_FormatoEtiqueta[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_AD_Process getAD_Process() throws RuntimeException
    {
		return (I_AD_Process)MTable.get(getCtx(), I_AD_Process.Table_Name)
			.getPO(getAD_Process_ID(), get_TrxName());	}

	/** Set Process.
		@param AD_Process_ID 
		Process or Report
	  */
	public void setAD_Process_ID (int AD_Process_ID)
	{
		if (AD_Process_ID < 1) 
			set_Value (COLUMNNAME_AD_Process_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Process_ID, Integer.valueOf(AD_Process_ID));
	}

	/** Get Process.
		@return Process or Report
	  */
	public int getAD_Process_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Process_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Z_FormatoEtiqueta ID.
		@param Z_FormatoEtiqueta_ID Z_FormatoEtiqueta ID	  */
	public void setZ_FormatoEtiqueta_ID (int Z_FormatoEtiqueta_ID)
	{
		if (Z_FormatoEtiqueta_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_FormatoEtiqueta_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_FormatoEtiqueta_ID, Integer.valueOf(Z_FormatoEtiqueta_ID));
	}

	/** Get Z_FormatoEtiqueta ID.
		@return Z_FormatoEtiqueta ID	  */
	public int getZ_FormatoEtiqueta_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_FormatoEtiqueta_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}