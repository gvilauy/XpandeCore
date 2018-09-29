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

/** Generated Model for Z_SocioListaPrecio
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_SocioListaPrecio extends PO implements I_Z_SocioListaPrecio, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20170614L;

    /** Standard Constructor */
    public X_Z_SocioListaPrecio (Properties ctx, int Z_SocioListaPrecio_ID, String trxName)
    {
      super (ctx, Z_SocioListaPrecio_ID, trxName);
      /** if (Z_SocioListaPrecio_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_Currency_ID (0);
			setM_PriceList_ID (0);
			setZ_SocioListaPrecio_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_SocioListaPrecio (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Z_SocioListaPrecio[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (I_C_BPartner)MTable.get(getCtx(), I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_Currency getC_Currency() throws RuntimeException
    {
		return (I_C_Currency)MTable.get(getCtx(), I_C_Currency.Table_Name)
			.getPO(getC_Currency_ID(), get_TrxName());	}

	/** Set Currency.
		@param C_Currency_ID 
		The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID)
	{
		if (C_Currency_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Currency_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
	}

	/** Get Currency.
		@return The Currency for this record
	  */
	public int getC_Currency_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Currency_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_M_PriceList getM_PriceList() throws RuntimeException
    {
		return (I_M_PriceList)MTable.get(getCtx(), I_M_PriceList.Table_Name)
			.getPO(getM_PriceList_ID(), get_TrxName());	}

	/** Set Price List.
		@param M_PriceList_ID 
		Unique identifier of a Price List
	  */
	public void setM_PriceList_ID (int M_PriceList_ID)
	{
		if (M_PriceList_ID < 1) 
			set_Value (COLUMNNAME_M_PriceList_ID, null);
		else 
			set_Value (COLUMNNAME_M_PriceList_ID, Integer.valueOf(M_PriceList_ID));
	}

	/** Get Price List.
		@return Unique identifier of a Price List
	  */
	public int getM_PriceList_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_PriceList_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Z_SocioListaPrecio ID.
		@param Z_SocioListaPrecio_ID Z_SocioListaPrecio ID	  */
	public void setZ_SocioListaPrecio_ID (int Z_SocioListaPrecio_ID)
	{
		if (Z_SocioListaPrecio_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_SocioListaPrecio_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_SocioListaPrecio_ID, Integer.valueOf(Z_SocioListaPrecio_ID));
	}

	/** Get Z_SocioListaPrecio ID.
		@return Z_SocioListaPrecio ID	  */
	public int getZ_SocioListaPrecio_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_SocioListaPrecio_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}