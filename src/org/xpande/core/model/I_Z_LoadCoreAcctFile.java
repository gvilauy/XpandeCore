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
package org.xpande.core.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for Z_LoadCoreAcctFile
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0
 */
public interface I_Z_LoadCoreAcctFile 
{

    /** TableName=Z_LoadCoreAcctFile */
    public static final String Table_Name = "Z_LoadCoreAcctFile";

    /** AD_Table_ID=1000319 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AccountType */
    public static final String COLUMNNAME_AccountType = "AccountType";

	/** Set Account Type.
	  * Indicates the type of account
	  */
	public void setAccountType (String AccountType);

	/** Get Account Type.
	  * Indicates the type of account
	  */
	public String getAccountType();

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Alias */
    public static final String COLUMNNAME_Alias = "Alias";

	/** Set Alias.
	  * Defines an alternate method of indicating an account combination.
	  */
	public void setAlias (String Alias);

	/** Get Alias.
	  * Defines an alternate method of indicating an account combination.
	  */
	public String getAlias();

    /** Column name C_Currency_ID */
    public static final String COLUMNNAME_C_Currency_ID = "C_Currency_ID";

	/** Set Currency.
	  * The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID);

	/** Get Currency.
	  * The Currency for this record
	  */
	public int getC_Currency_ID();

	public I_C_Currency getC_Currency() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name ErrorMsg */
    public static final String COLUMNNAME_ErrorMsg = "ErrorMsg";

	/** Set Error Msg	  */
	public void setErrorMsg (String ErrorMsg);

	/** Get Error Msg	  */
	public String getErrorMsg();

    /** Column name FileLineText */
    public static final String COLUMNNAME_FileLineText = "FileLineText";

	/** Set FileLineText	  */
	public void setFileLineText (String FileLineText);

	/** Get FileLineText	  */
	public String getFileLineText();

    /** Column name I_IsImported */
    public static final String COLUMNNAME_I_IsImported = "I_IsImported";

	/** Set Imported.
	  * Has this import been processed
	  */
	public void setI_IsImported (boolean I_IsImported);

	/** Get Imported.
	  * Has this import been processed
	  */
	public boolean isI_IsImported();

    /** Column name IsAcctCierreBP */
    public static final String COLUMNNAME_IsAcctCierreBP = "IsAcctCierreBP";

	/** Set IsAcctCierreBP.
	  * Si es una cuenta que requiera detalle por socio de negocio en cierre y apertura de cuentas integrales
	  */
	public void setIsAcctCierreBP (boolean IsAcctCierreBP);

	/** Get IsAcctCierreBP.
	  * Si es una cuenta que requiera detalle por socio de negocio en cierre y apertura de cuentas integrales
	  */
	public boolean isAcctCierreBP();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsConfirmed */
    public static final String COLUMNNAME_IsConfirmed = "IsConfirmed";

	/** Set Confirmed.
	  * Assignment is confirmed
	  */
	public void setIsConfirmed (boolean IsConfirmed);

	/** Get Confirmed.
	  * Assignment is confirmed
	  */
	public boolean isConfirmed();

    /** Column name IsDocControlled */
    public static final String COLUMNNAME_IsDocControlled = "IsDocControlled";

	/** Set Document Controlled.
	  * Control account - If an account is controlled by a document, you cannot post manually to it
	  */
	public void setIsDocControlled (boolean IsDocControlled);

	/** Get Document Controlled.
	  * Control account - If an account is controlled by a document, you cannot post manually to it
	  */
	public boolean isDocControlled();

    /** Column name IsForeignCurrency */
    public static final String COLUMNNAME_IsForeignCurrency = "IsForeignCurrency";

	/** Set Foreign Currency Account.
	  * Balances in foreign currency accounts are held in the nominated currency
	  */
	public void setIsForeignCurrency (boolean IsForeignCurrency);

	/** Get Foreign Currency Account.
	  * Balances in foreign currency accounts are held in the nominated currency
	  */
	public boolean isForeignCurrency();

    /** Column name IsOmitted */
    public static final String COLUMNNAME_IsOmitted = "IsOmitted";

	/** Set IsOmitted.
	  * Omitida si o no
	  */
	public void setIsOmitted (boolean IsOmitted);

	/** Get IsOmitted.
	  * Omitida si o no
	  */
	public boolean isOmitted();

    /** Column name IsPartnerRequired */
    public static final String COLUMNNAME_IsPartnerRequired = "IsPartnerRequired";

	/** Set IsPartnerRequired.
	  * Si se requiere o no socio de negocio
	  */
	public void setIsPartnerRequired (boolean IsPartnerRequired);

	/** Get IsPartnerRequired.
	  * Si se requiere o no socio de negocio
	  */
	public boolean isPartnerRequired();

    /** Column name IsRetencionAcct */
    public static final String COLUMNNAME_IsRetencionAcct = "IsRetencionAcct";

	/** Set IsRetencionAcct.
	  * Es cuenta contable asociada a una retención a socio de negocio
	  */
	public void setIsRetencionAcct (boolean IsRetencionAcct);

	/** Get IsRetencionAcct.
	  * Es cuenta contable asociada a una retención a socio de negocio
	  */
	public boolean isRetencionAcct();

    /** Column name IsSummary */
    public static final String COLUMNNAME_IsSummary = "IsSummary";

	/** Set Summary Level.
	  * This is a summary entity
	  */
	public void setIsSummary (boolean IsSummary);

	/** Get Summary Level.
	  * This is a summary entity
	  */
	public boolean isSummary();

    /** Column name IsTaxAccount */
    public static final String COLUMNNAME_IsTaxAccount = "IsTaxAccount";

	/** Set IsTaxAccount.
	  * Si es o no cuenta contable asociada a impuestos
	  */
	public void setIsTaxAccount (boolean IsTaxAccount);

	/** Get IsTaxAccount.
	  * Si es o no cuenta contable asociada a impuestos
	  */
	public boolean isTaxAccount();

    /** Column name LineNumber */
    public static final String COLUMNNAME_LineNumber = "LineNumber";

	/** Set LineNumber	  */
	public void setLineNumber (int LineNumber);

	/** Get LineNumber	  */
	public int getLineNumber();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name ParentValue */
    public static final String COLUMNNAME_ParentValue = "ParentValue";

	/** Set Parent Key.
	  * Key if the Parent
	  */
	public void setParentValue (String ParentValue);

	/** Get Parent Key.
	  * Key if the Parent
	  */
	public String getParentValue();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name UUID */
    public static final String COLUMNNAME_UUID = "UUID";

	/** Set Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID);

	/** Get Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public String getUUID();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();

    /** Column name Z_LoadCoreAcctFile_ID */
    public static final String COLUMNNAME_Z_LoadCoreAcctFile_ID = "Z_LoadCoreAcctFile_ID";

	/** Set Z_LoadCoreAcctFile ID	  */
	public void setZ_LoadCoreAcctFile_ID (int Z_LoadCoreAcctFile_ID);

	/** Get Z_LoadCoreAcctFile ID	  */
	public int getZ_LoadCoreAcctFile_ID();

    /** Column name Z_LoadCore_ID */
    public static final String COLUMNNAME_Z_LoadCore_ID = "Z_LoadCore_ID";

	/** Set Z_LoadCore ID	  */
	public void setZ_LoadCore_ID (int Z_LoadCore_ID);

	/** Get Z_LoadCore ID	  */
	public int getZ_LoadCore_ID();

	public I_Z_LoadCore getZ_LoadCore() throws RuntimeException;
}
