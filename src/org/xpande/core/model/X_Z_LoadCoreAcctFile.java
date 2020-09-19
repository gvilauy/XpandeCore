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

/** Generated Model for Z_LoadCoreAcctFile
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_LoadCoreAcctFile extends PO implements I_Z_LoadCoreAcctFile, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200919L;

    /** Standard Constructor */
    public X_Z_LoadCoreAcctFile (Properties ctx, int Z_LoadCoreAcctFile_ID, String trxName)
    {
      super (ctx, Z_LoadCoreAcctFile_ID, trxName);
      /** if (Z_LoadCoreAcctFile_ID == 0)
        {
			setAccountType (null);
			setI_IsImported (false);
// N
			setIsAcctCierreBP (false);
// N
			setIsConfirmed (false);
// N
			setIsDocControlled (false);
// N
			setIsForeignCurrency (false);
// N
			setIsOmitted (false);
// N
			setIsPartnerRequired (false);
// N
			setIsRetencionAcct (false);
// N
			setIsSummary (false);
// N
			setIsTaxAccount (false);
// N
			setName (null);
			setParentValue (null);
			setProcessed (false);
// N
			setValue (null);
			setZ_LoadCoreAcctFile_ID (0);
			setZ_LoadCore_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_LoadCoreAcctFile (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Z_LoadCoreAcctFile[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** AccountType AD_Reference_ID=117 */
	public static final int ACCOUNTTYPE_AD_Reference_ID=117;
	/** Asset = A */
	public static final String ACCOUNTTYPE_Asset = "A";
	/** Liability = L */
	public static final String ACCOUNTTYPE_Liability = "L";
	/** Revenue = R */
	public static final String ACCOUNTTYPE_Revenue = "R";
	/** Expense = E */
	public static final String ACCOUNTTYPE_Expense = "E";
	/** Owner's Equity = O */
	public static final String ACCOUNTTYPE_OwnerSEquity = "O";
	/** Memo = M */
	public static final String ACCOUNTTYPE_Memo = "M";
	/** Set Account Type.
		@param AccountType 
		Indicates the type of account
	  */
	public void setAccountType (String AccountType)
	{

		set_Value (COLUMNNAME_AccountType, AccountType);
	}

	/** Get Account Type.
		@return Indicates the type of account
	  */
	public String getAccountType () 
	{
		return (String)get_Value(COLUMNNAME_AccountType);
	}

	/** Set Alias.
		@param Alias 
		Defines an alternate method of indicating an account combination.
	  */
	public void setAlias (String Alias)
	{
		set_Value (COLUMNNAME_Alias, Alias);
	}

	/** Get Alias.
		@return Defines an alternate method of indicating an account combination.
	  */
	public String getAlias () 
	{
		return (String)get_Value(COLUMNNAME_Alias);
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
			set_Value (COLUMNNAME_C_Currency_ID, null);
		else 
			set_Value (COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
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

	/** Set IsAcctCierreBP.
		@param IsAcctCierreBP 
		Si es una cuenta que requiera detalle por socio de negocio en cierre y apertura de cuentas integrales
	  */
	public void setIsAcctCierreBP (boolean IsAcctCierreBP)
	{
		set_Value (COLUMNNAME_IsAcctCierreBP, Boolean.valueOf(IsAcctCierreBP));
	}

	/** Get IsAcctCierreBP.
		@return Si es una cuenta que requiera detalle por socio de negocio en cierre y apertura de cuentas integrales
	  */
	public boolean isAcctCierreBP () 
	{
		Object oo = get_Value(COLUMNNAME_IsAcctCierreBP);
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

	/** Set Document Controlled.
		@param IsDocControlled 
		Control account - If an account is controlled by a document, you cannot post manually to it
	  */
	public void setIsDocControlled (boolean IsDocControlled)
	{
		set_Value (COLUMNNAME_IsDocControlled, Boolean.valueOf(IsDocControlled));
	}

	/** Get Document Controlled.
		@return Control account - If an account is controlled by a document, you cannot post manually to it
	  */
	public boolean isDocControlled () 
	{
		Object oo = get_Value(COLUMNNAME_IsDocControlled);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Foreign Currency Account.
		@param IsForeignCurrency 
		Balances in foreign currency accounts are held in the nominated currency
	  */
	public void setIsForeignCurrency (boolean IsForeignCurrency)
	{
		set_Value (COLUMNNAME_IsForeignCurrency, Boolean.valueOf(IsForeignCurrency));
	}

	/** Get Foreign Currency Account.
		@return Balances in foreign currency accounts are held in the nominated currency
	  */
	public boolean isForeignCurrency () 
	{
		Object oo = get_Value(COLUMNNAME_IsForeignCurrency);
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

	/** Set IsPartnerRequired.
		@param IsPartnerRequired 
		Si se requiere o no socio de negocio
	  */
	public void setIsPartnerRequired (boolean IsPartnerRequired)
	{
		set_Value (COLUMNNAME_IsPartnerRequired, Boolean.valueOf(IsPartnerRequired));
	}

	/** Get IsPartnerRequired.
		@return Si se requiere o no socio de negocio
	  */
	public boolean isPartnerRequired () 
	{
		Object oo = get_Value(COLUMNNAME_IsPartnerRequired);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsRetencionAcct.
		@param IsRetencionAcct 
		Es cuenta contable asociada a una retención a socio de negocio
	  */
	public void setIsRetencionAcct (boolean IsRetencionAcct)
	{
		set_Value (COLUMNNAME_IsRetencionAcct, Boolean.valueOf(IsRetencionAcct));
	}

	/** Get IsRetencionAcct.
		@return Es cuenta contable asociada a una retención a socio de negocio
	  */
	public boolean isRetencionAcct () 
	{
		Object oo = get_Value(COLUMNNAME_IsRetencionAcct);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Summary Level.
		@param IsSummary 
		This is a summary entity
	  */
	public void setIsSummary (boolean IsSummary)
	{
		set_Value (COLUMNNAME_IsSummary, Boolean.valueOf(IsSummary));
	}

	/** Get Summary Level.
		@return This is a summary entity
	  */
	public boolean isSummary () 
	{
		Object oo = get_Value(COLUMNNAME_IsSummary);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsTaxAccount.
		@param IsTaxAccount 
		Si es o no cuenta contable asociada a impuestos
	  */
	public void setIsTaxAccount (boolean IsTaxAccount)
	{
		set_Value (COLUMNNAME_IsTaxAccount, Boolean.valueOf(IsTaxAccount));
	}

	/** Get IsTaxAccount.
		@return Si es o no cuenta contable asociada a impuestos
	  */
	public boolean isTaxAccount () 
	{
		Object oo = get_Value(COLUMNNAME_IsTaxAccount);
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

	/** Set Parent Key.
		@param ParentValue 
		Key if the Parent
	  */
	public void setParentValue (String ParentValue)
	{
		set_Value (COLUMNNAME_ParentValue, ParentValue);
	}

	/** Get Parent Key.
		@return Key if the Parent
	  */
	public String getParentValue () 
	{
		return (String)get_Value(COLUMNNAME_ParentValue);
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

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

	/** Set Z_LoadCoreAcctFile ID.
		@param Z_LoadCoreAcctFile_ID Z_LoadCoreAcctFile ID	  */
	public void setZ_LoadCoreAcctFile_ID (int Z_LoadCoreAcctFile_ID)
	{
		if (Z_LoadCoreAcctFile_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_LoadCoreAcctFile_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_LoadCoreAcctFile_ID, Integer.valueOf(Z_LoadCoreAcctFile_ID));
	}

	/** Get Z_LoadCoreAcctFile ID.
		@return Z_LoadCoreAcctFile ID	  */
	public int getZ_LoadCoreAcctFile_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_LoadCoreAcctFile_ID);
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