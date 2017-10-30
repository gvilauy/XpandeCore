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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for Z_ActividadDocumento
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_ActividadDocumento extends PO implements I_Z_ActividadDocumento, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20171030L;

    /** Standard Constructor */
    public X_Z_ActividadDocumento (Properties ctx, int Z_ActividadDocumento_ID, String trxName)
    {
      super (ctx, Z_ActividadDocumento_ID, trxName);
      /** if (Z_ActividadDocumento_ID == 0)
        {
			setAD_Table_ID (0);
			setC_DocType_ID (0);
			setCompletedBy (0);
			setDateCompleted (new Timestamp( System.currentTimeMillis() ));
			setDiferenciaTiempo (new Timestamp( System.currentTimeMillis() ));
			setDocCreatedBy (0);
			setDocDateCreated (new Timestamp( System.currentTimeMillis() ));
			setDocumentNoRef (null);
			setRecord_ID (0);
			setZ_ActividadDocumento_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_ActividadDocumento (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Z_ActividadDocumento[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_AD_Role getAD_Role() throws RuntimeException
    {
		return (I_AD_Role)MTable.get(getCtx(), I_AD_Role.Table_Name)
			.getPO(getAD_Role_ID(), get_TrxName());	}

	/** Set Role.
		@param AD_Role_ID 
		Responsibility Role
	  */
	public void setAD_Role_ID (int AD_Role_ID)
	{
		if (AD_Role_ID < 0) 
			set_Value (COLUMNNAME_AD_Role_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Role_ID, Integer.valueOf(AD_Role_ID));
	}

	/** Get Role.
		@return Responsibility Role
	  */
	public int getAD_Role_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_AD_Table getAD_Table() throws RuntimeException
    {
		return (I_AD_Table)MTable.get(getCtx(), I_AD_Table.Table_Name)
			.getPO(getAD_Table_ID(), get_TrxName());	}

	/** Set Table.
		@param AD_Table_ID 
		Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1) 
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_DocType getC_DocType() throws RuntimeException
    {
		return (I_C_DocType)MTable.get(getCtx(), I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_AD_User getComplete() throws RuntimeException
    {
		return (I_AD_User)MTable.get(getCtx(), I_AD_User.Table_Name)
			.getPO(getCompletedBy(), get_TrxName());	}

	/** Set CompletedBy.
		@param CompletedBy 
		Usuario que completo un determinado documento
	  */
	public void setCompletedBy (int CompletedBy)
	{
		set_Value (COLUMNNAME_CompletedBy, Integer.valueOf(CompletedBy));
	}

	/** Get CompletedBy.
		@return Usuario que completo un determinado documento
	  */
	public int getCompletedBy () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CompletedBy);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DateCompleted.
		@param DateCompleted 
		Fecha en la que se completo un documento
	  */
	public void setDateCompleted (Timestamp DateCompleted)
	{
		set_Value (COLUMNNAME_DateCompleted, DateCompleted);
	}

	/** Get DateCompleted.
		@return Fecha en la que se completo un documento
	  */
	public Timestamp getDateCompleted () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateCompleted);
	}

	/** Set DiferenciaTiempo.
		@param DiferenciaTiempo 
		Diferencia entre fechas expresada en hora-minutos-segundos
	  */
	public void setDiferenciaTiempo (Timestamp DiferenciaTiempo)
	{
		set_Value (COLUMNNAME_DiferenciaTiempo, DiferenciaTiempo);
	}

	/** Get DiferenciaTiempo.
		@return Diferencia entre fechas expresada en hora-minutos-segundos
	  */
	public Timestamp getDiferenciaTiempo () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DiferenciaTiempo);
	}

	public I_AD_User getDocCreate() throws RuntimeException
    {
		return (I_AD_User)MTable.get(getCtx(), I_AD_User.Table_Name)
			.getPO(getDocCreatedBy(), get_TrxName());	}

	/** Set DocCreatedBy.
		@param DocCreatedBy 
		Usuario que creo un determinado documento
	  */
	public void setDocCreatedBy (int DocCreatedBy)
	{
		set_Value (COLUMNNAME_DocCreatedBy, Integer.valueOf(DocCreatedBy));
	}

	/** Get DocCreatedBy.
		@return Usuario que creo un determinado documento
	  */
	public int getDocCreatedBy () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DocCreatedBy);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DocDateCreated.
		@param DocDateCreated 
		Fecha de creación de un determinado Documento
	  */
	public void setDocDateCreated (Timestamp DocDateCreated)
	{
		set_Value (COLUMNNAME_DocDateCreated, DocDateCreated);
	}

	/** Get DocDateCreated.
		@return Fecha de creación de un determinado Documento
	  */
	public Timestamp getDocDateCreated () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DocDateCreated);
	}

	/** Set DocumentNoRef.
		@param DocumentNoRef 
		Numero de documento referenciado
	  */
	public void setDocumentNoRef (String DocumentNoRef)
	{
		set_Value (COLUMNNAME_DocumentNoRef, DocumentNoRef);
	}

	/** Get DocumentNoRef.
		@return Numero de documento referenciado
	  */
	public String getDocumentNoRef () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNoRef);
	}

	/** Set Line.
		@param LineNo 
		Line No
	  */
	public void setLineNo (int LineNo)
	{
		set_Value (COLUMNNAME_LineNo, Integer.valueOf(LineNo));
	}

	/** Get Line.
		@return Line No
	  */
	public int getLineNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Record ID.
		@param Record_ID 
		Direct internal record ID
	  */
	public void setRecord_ID (int Record_ID)
	{
		if (Record_ID < 0) 
			set_Value (COLUMNNAME_Record_ID, null);
		else 
			set_Value (COLUMNNAME_Record_ID, Integer.valueOf(Record_ID));
	}

	/** Get Record ID.
		@return Direct internal record ID
	  */
	public int getRecord_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Record_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Z_ActividadDocumento ID.
		@param Z_ActividadDocumento_ID Z_ActividadDocumento ID	  */
	public void setZ_ActividadDocumento_ID (int Z_ActividadDocumento_ID)
	{
		if (Z_ActividadDocumento_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_ActividadDocumento_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_ActividadDocumento_ID, Integer.valueOf(Z_ActividadDocumento_ID));
	}

	/** Get Z_ActividadDocumento ID.
		@return Z_ActividadDocumento ID	  */
	public int getZ_ActividadDocumento_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_ActividadDocumento_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}