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

/** Generated Model for Z_ProductoUPC
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_ProductoUPC extends PO implements I_Z_ProductoUPC, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20170607L;

    /** Standard Constructor */
    public X_Z_ProductoUPC (Properties ctx, int Z_ProductoUPC_ID, String trxName)
    {
      super (ctx, Z_ProductoUPC_ID, trxName);
      /** if (Z_ProductoUPC_ID == 0)
        {
			setM_Product_ID (0);
			setUPC (null);
			setZ_ProductoUPC_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_ProductoUPC (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Z_ProductoUPC[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set UPC/EAN.
		@param UPC 
		Bar Code (Universal Product Code or its superset European Article Number)
	  */
	public void setUPC (String UPC)
	{
		set_Value (COLUMNNAME_UPC, UPC);
	}

	/** Get UPC/EAN.
		@return Bar Code (Universal Product Code or its superset European Article Number)
	  */
	public String getUPC () 
	{
		return (String)get_Value(COLUMNNAME_UPC);
	}

	/** Set Z_ProductoUPC ID.
		@param Z_ProductoUPC_ID Z_ProductoUPC ID	  */
	public void setZ_ProductoUPC_ID (int Z_ProductoUPC_ID)
	{
		if (Z_ProductoUPC_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_ProductoUPC_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_ProductoUPC_ID, Integer.valueOf(Z_ProductoUPC_ID));
	}

	/** Get Z_ProductoUPC ID.
		@return Z_ProductoUPC ID	  */
	public int getZ_ProductoUPC_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_ProductoUPC_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}