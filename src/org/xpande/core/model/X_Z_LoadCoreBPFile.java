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

/** Generated Model for Z_LoadCoreBPFile
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_LoadCoreBPFile extends PO implements I_Z_LoadCoreBPFile, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200723L;

    /** Standard Constructor */
    public X_Z_LoadCoreBPFile (Properties ctx, int Z_LoadCoreBPFile_ID, String trxName)
    {
      super (ctx, Z_LoadCoreBPFile_ID, trxName);
      /** if (Z_LoadCoreBPFile_ID == 0)
        {
			setI_IsImported (false);
// N
			setIsConfirmed (false);
// N
			setIsCustomer (false);
// N
			setIsEmployee (false);
// N
			setIsOmitted (false);
// N
			setIsSalesRep (false);
// N
			setIsVendor (false);
// N
			setProcessed (false);
// N
			setZ_LoadCoreBPFile_ID (0);
			setZ_LoadCore_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_LoadCoreBPFile (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Z_LoadCoreBPFile[")
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

	/** Set CodigoInterno.
		@param CodigoInterno 
		Código interno genérico
	  */
	public void setCodigoInterno (String CodigoInterno)
	{
		set_Value (COLUMNNAME_CodigoInterno, CodigoInterno);
	}

	/** Get CodigoInterno.
		@return Código interno genérico
	  */
	public String getCodigoInterno () 
	{
		return (String)get_Value(COLUMNNAME_CodigoInterno);
	}

	public org.eevolution.model.I_C_TaxGroup getC_TaxGroup() throws RuntimeException
    {
		return (org.eevolution.model.I_C_TaxGroup)MTable.get(getCtx(), org.eevolution.model.I_C_TaxGroup.Table_Name)
			.getPO(getC_TaxGroup_ID(), get_TrxName());	}

	/** Set Tax Group.
		@param C_TaxGroup_ID Tax Group	  */
	public void setC_TaxGroup_ID (int C_TaxGroup_ID)
	{
		if (C_TaxGroup_ID < 1) 
			set_Value (COLUMNNAME_C_TaxGroup_ID, null);
		else 
			set_Value (COLUMNNAME_C_TaxGroup_ID, Integer.valueOf(C_TaxGroup_ID));
	}

	/** Get Tax Group.
		@return Tax Group	  */
	public int getC_TaxGroup_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_TaxGroup_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Error Msg.
		@param ErrorMsg Error Msg	  */
	public void setErrorMsg (String ErrorMsg)
	{
		set_Value (COLUMNNAME_ErrorMsg, ErrorMsg);
	}

	/** Get Error Msg.
		@return Error Msg	  */
	public String getErrorMsg () 
	{
		return (String)get_Value(COLUMNNAME_ErrorMsg);
	}

	/** Set FileLineText.
		@param FileLineText FileLineText	  */
	public void setFileLineText (String FileLineText)
	{
		set_Value (COLUMNNAME_FileLineText, FileLineText);
	}

	/** Get FileLineText.
		@return FileLineText	  */
	public String getFileLineText () 
	{
		return (String)get_Value(COLUMNNAME_FileLineText);
	}

	/** Set Imported.
		@param I_IsImported 
		Has this import been processed
	  */
	public void setI_IsImported (boolean I_IsImported)
	{
		set_Value (COLUMNNAME_I_IsImported, Boolean.valueOf(I_IsImported));
	}

	/** Get Imported.
		@return Has this import been processed
	  */
	public boolean isI_IsImported () 
	{
		Object oo = get_Value(COLUMNNAME_I_IsImported);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Confirmed.
		@param IsConfirmed 
		Assignment is confirmed
	  */
	public void setIsConfirmed (boolean IsConfirmed)
	{
		set_Value (COLUMNNAME_IsConfirmed, Boolean.valueOf(IsConfirmed));
	}

	/** Get Confirmed.
		@return Assignment is confirmed
	  */
	public boolean isConfirmed () 
	{
		Object oo = get_Value(COLUMNNAME_IsConfirmed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Customer.
		@param IsCustomer 
		Indicates if this Business Partner is a Customer
	  */
	public void setIsCustomer (boolean IsCustomer)
	{
		set_Value (COLUMNNAME_IsCustomer, Boolean.valueOf(IsCustomer));
	}

	/** Get Customer.
		@return Indicates if this Business Partner is a Customer
	  */
	public boolean isCustomer () 
	{
		Object oo = get_Value(COLUMNNAME_IsCustomer);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Employee.
		@param IsEmployee 
		Indicates if  this Business Partner is an employee
	  */
	public void setIsEmployee (boolean IsEmployee)
	{
		set_Value (COLUMNNAME_IsEmployee, Boolean.valueOf(IsEmployee));
	}

	/** Get Employee.
		@return Indicates if  this Business Partner is an employee
	  */
	public boolean isEmployee () 
	{
		Object oo = get_Value(COLUMNNAME_IsEmployee);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsOmitted.
		@param IsOmitted 
		Omitida si o no
	  */
	public void setIsOmitted (boolean IsOmitted)
	{
		set_Value (COLUMNNAME_IsOmitted, Boolean.valueOf(IsOmitted));
	}

	/** Get IsOmitted.
		@return Omitida si o no
	  */
	public boolean isOmitted () 
	{
		Object oo = get_Value(COLUMNNAME_IsOmitted);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Sales Representative.
		@param IsSalesRep 
		Indicates if  the business partner is a sales representative or company agent
	  */
	public void setIsSalesRep (boolean IsSalesRep)
	{
		set_Value (COLUMNNAME_IsSalesRep, Boolean.valueOf(IsSalesRep));
	}

	/** Get Sales Representative.
		@return Indicates if  the business partner is a sales representative or company agent
	  */
	public boolean isSalesRep () 
	{
		Object oo = get_Value(COLUMNNAME_IsSalesRep);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Vendor.
		@param IsVendor 
		Indicates if this Business Partner is a Vendor
	  */
	public void setIsVendor (boolean IsVendor)
	{
		set_Value (COLUMNNAME_IsVendor, Boolean.valueOf(IsVendor));
	}

	/** Get Vendor.
		@return Indicates if this Business Partner is a Vendor
	  */
	public boolean isVendor () 
	{
		Object oo = get_Value(COLUMNNAME_IsVendor);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set LineNumber.
		@param LineNumber LineNumber	  */
	public void setLineNumber (int LineNumber)
	{
		set_Value (COLUMNNAME_LineNumber, Integer.valueOf(LineNumber));
	}

	/** Get LineNumber.
		@return LineNumber	  */
	public int getLineNumber () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNumber);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Name 2.
		@param Name2 
		Additional Name
	  */
	public void setName2 (String Name2)
	{
		set_Value (COLUMNNAME_Name2, Name2);
	}

	/** Get Name 2.
		@return Additional Name
	  */
	public String getName2 () 
	{
		return (String)get_Value(COLUMNNAME_Name2);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Tax ID.
		@param TaxID 
		Tax Identification
	  */
	public void setTaxID (String TaxID)
	{
		set_Value (COLUMNNAME_TaxID, TaxID);
	}

	/** Get Tax ID.
		@return Tax Identification
	  */
	public String getTaxID () 
	{
		return (String)get_Value(COLUMNNAME_TaxID);
	}

	/** Set TipoIdentificacion.
		@param TipoIdentificacion 
		Tipo de Identificacion genérico
	  */
	public void setTipoIdentificacion (String TipoIdentificacion)
	{
		set_Value (COLUMNNAME_TipoIdentificacion, TipoIdentificacion);
	}

	/** Get TipoIdentificacion.
		@return Tipo de Identificacion genérico
	  */
	public String getTipoIdentificacion () 
	{
		return (String)get_Value(COLUMNNAME_TipoIdentificacion);
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

	/** Set Z_LoadCoreBPFile ID.
		@param Z_LoadCoreBPFile_ID Z_LoadCoreBPFile ID	  */
	public void setZ_LoadCoreBPFile_ID (int Z_LoadCoreBPFile_ID)
	{
		if (Z_LoadCoreBPFile_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_LoadCoreBPFile_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_LoadCoreBPFile_ID, Integer.valueOf(Z_LoadCoreBPFile_ID));
	}

	/** Get Z_LoadCoreBPFile ID.
		@return Z_LoadCoreBPFile ID	  */
	public int getZ_LoadCoreBPFile_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_LoadCoreBPFile_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_Z_LoadCore getZ_LoadCore() throws RuntimeException
    {
		return (I_Z_LoadCore)MTable.get(getCtx(), I_Z_LoadCore.Table_Name)
			.getPO(getZ_LoadCore_ID(), get_TrxName());	}

	/** Set Z_LoadCore ID.
		@param Z_LoadCore_ID Z_LoadCore ID	  */
	public void setZ_LoadCore_ID (int Z_LoadCore_ID)
	{
		if (Z_LoadCore_ID < 1) 
			set_Value (COLUMNNAME_Z_LoadCore_ID, null);
		else 
			set_Value (COLUMNNAME_Z_LoadCore_ID, Integer.valueOf(Z_LoadCore_ID));
	}

	/** Get Z_LoadCore ID.
		@return Z_LoadCore ID	  */
	public int getZ_LoadCore_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_LoadCore_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}