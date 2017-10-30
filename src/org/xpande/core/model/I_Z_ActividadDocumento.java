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

/** Generated Interface for Z_ActividadDocumento
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0
 */
public interface I_Z_ActividadDocumento 
{

    /** TableName=Z_ActividadDocumento */
    public static final String Table_Name = "Z_ActividadDocumento";

    /** AD_Table_ID=1000162 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

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
	public void setAD_Org_ID(int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AD_Role_ID */
    public static final String COLUMNNAME_AD_Role_ID = "AD_Role_ID";

	/** Set Role.
	  * Responsibility Role
	  */
	public void setAD_Role_ID(int AD_Role_ID);

	/** Get Role.
	  * Responsibility Role
	  */
	public int getAD_Role_ID();

	public I_AD_Role getAD_Role() throws RuntimeException;

    /** Column name AD_Table_ID */
    public static final String COLUMNNAME_AD_Table_ID = "AD_Table_ID";

	/** Set Table.
	  * Database Table information
	  */
	public void setAD_Table_ID(int AD_Table_ID);

	/** Get Table.
	  * Database Table information
	  */
	public int getAD_Table_ID();

	public I_AD_Table getAD_Table() throws RuntimeException;

    /** Column name C_DocType_ID */
    public static final String COLUMNNAME_C_DocType_ID = "C_DocType_ID";

	/** Set Document Type.
	  * Document type or rules
	  */
	public void setC_DocType_ID(int C_DocType_ID);

	/** Get Document Type.
	  * Document type or rules
	  */
	public int getC_DocType_ID();

	public I_C_DocType getC_DocType() throws RuntimeException;

    /** Column name CompletedBy */
    public static final String COLUMNNAME_CompletedBy = "CompletedBy";

	/** Set CompletedBy.
	  * Usuario que completo un determinado documento
	  */
	public void setCompletedBy(int CompletedBy);

	/** Get CompletedBy.
	  * Usuario que completo un determinado documento
	  */
	public int getCompletedBy();

	public I_AD_User getComplete() throws RuntimeException;

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

    /** Column name DateCompleted */
    public static final String COLUMNNAME_DateCompleted = "DateCompleted";

	/** Set DateCompleted.
	  * Fecha en la que se completo un documento
	  */
	public void setDateCompleted(Timestamp DateCompleted);

	/** Get DateCompleted.
	  * Fecha en la que se completo un documento
	  */
	public Timestamp getDateCompleted();

    /** Column name DiferenciaTiempo */
    public static final String COLUMNNAME_DiferenciaTiempo = "DiferenciaTiempo";

	/** Set DiferenciaTiempo.
	  * Diferencia entre fechas expresada en hora-minutos-segundos
	  */
	public void setDiferenciaTiempo(Timestamp DiferenciaTiempo);

	/** Get DiferenciaTiempo.
	  * Diferencia entre fechas expresada en hora-minutos-segundos
	  */
	public Timestamp getDiferenciaTiempo();

    /** Column name DocCreatedBy */
    public static final String COLUMNNAME_DocCreatedBy = "DocCreatedBy";

	/** Set DocCreatedBy.
	  * Usuario que creo un determinado documento
	  */
	public void setDocCreatedBy(int DocCreatedBy);

	/** Get DocCreatedBy.
	  * Usuario que creo un determinado documento
	  */
	public int getDocCreatedBy();

	public I_AD_User getDocCreate() throws RuntimeException;

    /** Column name DocDateCreated */
    public static final String COLUMNNAME_DocDateCreated = "DocDateCreated";

	/** Set DocDateCreated.
	  * Fecha de creación de un determinado Documento
	  */
	public void setDocDateCreated(Timestamp DocDateCreated);

	/** Get DocDateCreated.
	  * Fecha de creación de un determinado Documento
	  */
	public Timestamp getDocDateCreated();

    /** Column name DocumentNoRef */
    public static final String COLUMNNAME_DocumentNoRef = "DocumentNoRef";

	/** Set DocumentNoRef.
	  * Numero de documento referenciado
	  */
	public void setDocumentNoRef(String DocumentNoRef);

	/** Get DocumentNoRef.
	  * Numero de documento referenciado
	  */
	public String getDocumentNoRef();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive(boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name LineNo */
    public static final String COLUMNNAME_LineNo = "LineNo";

	/** Set Line.
	  * Line No
	  */
	public void setLineNo(int LineNo);

	/** Get Line.
	  * Line No
	  */
	public int getLineNo();

    /** Column name Record_ID */
    public static final String COLUMNNAME_Record_ID = "Record_ID";

	/** Set Record ID.
	  * Direct internal record ID
	  */
	public void setRecord_ID(int Record_ID);

	/** Get Record ID.
	  * Direct internal record ID
	  */
	public int getRecord_ID();

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

    /** Column name Z_ActividadDocumento_ID */
    public static final String COLUMNNAME_Z_ActividadDocumento_ID = "Z_ActividadDocumento_ID";

	/** Set Z_ActividadDocumento ID	  */
	public void setZ_ActividadDocumento_ID(int Z_ActividadDocumento_ID);

	/** Get Z_ActividadDocumento ID	  */
	public int getZ_ActividadDocumento_ID();
}
