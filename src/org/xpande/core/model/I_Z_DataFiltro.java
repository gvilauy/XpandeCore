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

/** Generated Interface for Z_DataFiltro
 *  @author Adempiere (generated) 
 *  @version Release 3.9.1
 */
public interface I_Z_DataFiltro 
{

    /** TableName=Z_DataFiltro */
    public static final String Table_Name = "Z_DataFiltro";

    /** AD_Table_ID=1000349 */
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

    /** Column name AD_User_ID */
    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";

	/** Set User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID);

	/** Get User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID();

	public I_AD_User getAD_User() throws RuntimeException;

    /** Column name Anulado */
    public static final String COLUMNNAME_Anulado = "Anulado";

	/** Set Anulado.
	  * Si esta anulado o no
	  */
	public void setAnulado (boolean Anulado);

	/** Get Anulado.
	  * Si esta anulado o no
	  */
	public boolean isAnulado();

    /** Column name C_BP_Group_ID */
    public static final String COLUMNNAME_C_BP_Group_ID = "C_BP_Group_ID";

	/** Set Business Partner Group.
	  * Business Partner Group
	  */
	public void setC_BP_Group_ID (int C_BP_Group_ID);

	/** Get Business Partner Group.
	  * Business Partner Group
	  */
	public int getC_BP_Group_ID();

	public I_C_BP_Group getC_BP_Group() throws RuntimeException;

    /** Column name Conciliado */
    public static final String COLUMNNAME_Conciliado = "Conciliado";

	/** Set Conciliado.
	  * Conciliado si o no
	  */
	public void setConciliado (boolean Conciliado);

	/** Get Conciliado.
	  * Conciliado si o no
	  */
	public boolean isConciliado();

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

    /** Column name Depositado */
    public static final String COLUMNNAME_Depositado = "Depositado";

	/** Set Depositado.
	  * Si esta o no depositado
	  */
	public void setDepositado (boolean Depositado);

	/** Get Depositado.
	  * Si esta o no depositado
	  */
	public boolean isDepositado();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name Emitido */
    public static final String COLUMNNAME_Emitido = "Emitido";

	/** Set Emitido.
	  * Documento emitido
	  */
	public void setEmitido (boolean Emitido);

	/** Get Emitido.
	  * Documento emitido
	  */
	public boolean isEmitido();

    /** Column name Entregado */
    public static final String COLUMNNAME_Entregado = "Entregado";

	/** Set Entregado.
	  * Si esta entregado o no
	  */
	public void setEntregado (boolean Entregado);

	/** Get Entregado.
	  * Si esta entregado o no
	  */
	public boolean isEntregado();

    /** Column name EsProductoBalanza */
    public static final String COLUMNNAME_EsProductoBalanza = "EsProductoBalanza";

	/** Set EsProductoBalanza	  */
	public void setEsProductoBalanza (boolean EsProductoBalanza);

	/** Get EsProductoBalanza	  */
	public boolean isEsProductoBalanza();

    /** Column name FiltroEstadoMPago */
    public static final String COLUMNNAME_FiltroEstadoMPago = "FiltroEstadoMPago";

	/** Set FiltroEstadoMPago.
	  * Si se desea filtrar o no información según estado de medios de pago
	  */
	public void setFiltroEstadoMPago (boolean FiltroEstadoMPago);

	/** Get FiltroEstadoMPago.
	  * Si se desea filtrar o no información según estado de medios de pago
	  */
	public boolean isFiltroEstadoMPago();

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

    /** Column name M_Product_Category_ID */
    public static final String COLUMNNAME_M_Product_Category_ID = "M_Product_Category_ID";

	/** Set Product Category.
	  * Category of a Product
	  */
	public void setM_Product_Category_ID (int M_Product_Category_ID);

	/** Get Product Category.
	  * Category of a Product
	  */
	public int getM_Product_Category_ID();

	public I_M_Product_Category getM_Product_Category() throws RuntimeException;

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

    /** Column name ProductType */
    public static final String COLUMNNAME_ProductType = "ProductType";

	/** Set Product Type.
	  * Type of product
	  */
	public void setProductType (String ProductType);

	/** Get Product Type.
	  * Type of product
	  */
	public String getProductType();

    /** Column name Reemplazado */
    public static final String COLUMNNAME_Reemplazado = "Reemplazado";

	/** Set Reemplazado.
	  * Reemplazado si o no
	  */
	public void setReemplazado (boolean Reemplazado);

	/** Get Reemplazado.
	  * Reemplazado si o no
	  */
	public boolean isReemplazado();

    /** Column name TipoDataFiltro */
    public static final String COLUMNNAME_TipoDataFiltro = "TipoDataFiltro";

	/** Set TipoDataFiltro.
	  * Tipo de filtro para reportes y consultas
	  */
	public void setTipoDataFiltro (String TipoDataFiltro);

	/** Get TipoDataFiltro.
	  * Tipo de filtro para reportes y consultas
	  */
	public String getTipoDataFiltro();

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

    /** Column name Z_DataFiltro_ID */
    public static final String COLUMNNAME_Z_DataFiltro_ID = "Z_DataFiltro_ID";

	/** Set Z_DataFiltro ID	  */
	public void setZ_DataFiltro_ID (int Z_DataFiltro_ID);

	/** Get Z_DataFiltro ID	  */
	public int getZ_DataFiltro_ID();

    /** Column name Z_ProductoFamilia_ID */
    public static final String COLUMNNAME_Z_ProductoFamilia_ID = "Z_ProductoFamilia_ID";

	/** Set Z_ProductoFamilia ID	  */
	public void setZ_ProductoFamilia_ID (int Z_ProductoFamilia_ID);

	/** Get Z_ProductoFamilia ID	  */
	public int getZ_ProductoFamilia_ID();

    /** Column name Z_ProductoRubro_ID */
    public static final String COLUMNNAME_Z_ProductoRubro_ID = "Z_ProductoRubro_ID";

	/** Set Z_ProductoRubro ID	  */
	public void setZ_ProductoRubro_ID (int Z_ProductoRubro_ID);

	/** Get Z_ProductoRubro ID	  */
	public int getZ_ProductoRubro_ID();

    /** Column name Z_ProductoSeccion_ID */
    public static final String COLUMNNAME_Z_ProductoSeccion_ID = "Z_ProductoSeccion_ID";

	/** Set Z_ProductoSeccion ID	  */
	public void setZ_ProductoSeccion_ID (int Z_ProductoSeccion_ID);

	/** Get Z_ProductoSeccion ID	  */
	public int getZ_ProductoSeccion_ID();

    /** Column name Z_ProductoSubfamilia_ID */
    public static final String COLUMNNAME_Z_ProductoSubfamilia_ID = "Z_ProductoSubfamilia_ID";

	/** Set Z_ProductoSubfamilia ID	  */
	public void setZ_ProductoSubfamilia_ID (int Z_ProductoSubfamilia_ID);

	/** Get Z_ProductoSubfamilia ID	  */
	public int getZ_ProductoSubfamilia_ID();
}
