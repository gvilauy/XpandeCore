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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.pipo.PackRoll;
import org.compiere.impexp.ImpFormat;
import org.compiere.model.*;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.eevolution.model.X_C_TaxGroup;
import org.xpande.core.utils.DateUtils;

/** Generated Model for Z_LoadCore
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class MZLoadCore extends X_Z_LoadCore implements DocAction, DocOptions {

	/**
	 *
	 */
	private static final long serialVersionUID = 20200723L;

    /** Standard Constructor */
    public MZLoadCore (Properties ctx, int Z_LoadCore_ID, String trxName)
    {
      super (ctx, Z_LoadCore_ID, trxName);
    }

    /** Load Constructor */
    public MZLoadCore (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

	@Override
	public int customizeValidActions(String docStatus, Object processing, String orderType, String isSOTrx, int AD_Table_ID, String[] docAction, String[] options, int index) {

		int newIndex = 0;

		if ((docStatus.equalsIgnoreCase(STATUS_Drafted))
				|| (docStatus.equalsIgnoreCase(STATUS_Invalid))
				|| (docStatus.equalsIgnoreCase(STATUS_InProgress))){

			options[newIndex++] = DocumentEngine.ACTION_Complete;

		}
		else if (docStatus.equalsIgnoreCase(STATUS_Completed)){

			options[newIndex++] = DocumentEngine.ACTION_None;
			//options[newIndex++] = DocumentEngine.ACTION_ReActivate;
			//options[newIndex++] = DocumentEngine.ACTION_Void;
		}

		return newIndex;
	}

	/**
	 * 	Get Document Info
	 *	@return document info (untranslated)
	 */
	public String getDocumentInfo()
	{
		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());
		return dt.getName() + " " + getDocumentNo();
	}	//	getDocumentInfo

	/**
	 * 	Create PDF
	 *	@return File or null
	 */
	public File createPDF ()
	{
		try
		{
			File temp = File.createTempFile(get_TableName() + get_ID() +"_", ".pdf");
			return createPDF (temp);
		}
		catch (Exception e)
		{
			log.severe("Could not create PDF - " + e.getMessage());
		}
		return null;
	}	//	getPDF

	/**
	 * 	Create PDF file
	 *	@param file output file
	 *	@return file if success
	 */
	public File createPDF (File file)
	{
	//	ReportEngine re = ReportEngine.get (getCtx(), ReportEngine.INVOICE, getC_Invoice_ID());
	//	if (re == null)
			return null;
	//	return re.getPDF(file);
	}	//	createPDF

	
	/**************************************************************************
	 * 	Process document
	 *	@param processAction document action
	 *	@return true if performed
	 */
	public boolean processIt (String processAction)
	{
		m_processMsg = null;
		DocumentEngine engine = new DocumentEngine (this, getDocStatus());
		return engine.processIt (processAction, getDocAction());
	}	//	processIt
	
	/**	Process Message 			*/
	private String		m_processMsg = null;
	/**	Just Prepared Flag			*/
	private boolean		m_justPrepared = false;

	/**
	 * 	Unlock Document.
	 * 	@return true if success 
	 */
	public boolean unlockIt()
	{
		log.info("unlockIt - " + toString());
	//	setProcessing(false);
		return true;
	}	//	unlockIt
	
	/**
	 * 	Invalidate Document
	 * 	@return true if success 
	 */
	public boolean invalidateIt()
	{
		log.info("invalidateIt - " + toString());
		setDocAction(DOCACTION_Prepare);
		return true;
	}	//	invalidateIt
	
	/**
	 *	Prepare Document
	 * 	@return new status (In Progress or Invalid) 
	 */
	public String prepareIt()
	{
		log.info(toString());
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());

		/*
		//	Std Period open?
		if (!MPeriod.isOpen(getCtx(), getDateDoc(), dt.getDocBaseType(), getAD_Org_ID()))
		{
			m_processMsg = "@PeriodClosed@";
			return DocAction.STATUS_Invalid;
		}
		*/


		//	Add up Amounts
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		m_justPrepared = true;
		if (!DOCACTION_Complete.equals(getDocAction()))
			setDocAction(DOCACTION_Complete);
		return DocAction.STATUS_InProgress;
	}	//	prepareIt
	
	/**
	 * 	Approve Document
	 * 	@return true if success 
	 */
	public boolean  approveIt()
	{
		log.info("approveIt - " + toString());
		setIsApproved(true);
		return true;
	}	//	approveIt
	
	/**
	 * 	Reject Approval
	 * 	@return true if success 
	 */
	public boolean rejectIt()
	{
		log.info("rejectIt - " + toString());
		setIsApproved(false);
		return true;
	}	//	rejectIt
	
	/**
	 * 	Complete Document
	 * 	@return new status (Complete, In Progress, Invalid, Waiting ..)
	 */
	public String completeIt()
	{
		//	Re-Check
		if (!m_justPrepared)
		{
			String status = prepareIt();
			if (!DocAction.STATUS_InProgress.equals(status))
				return status;
		}

		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_COMPLETE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		//	Implicit Approval
		if (!isApproved())
			approveIt();
		log.info(toString());
		//


		// Si la carga es de Socios de Negocio
		if (this.getTipoLoadCore().equalsIgnoreCase(X_Z_LoadCore.TIPOLOADCORE_SOCIOSDENEGOCIO)){
			this.generatePartners();
		}
		// Carga de Plan de Cuentas
		else if (this.getTipoLoadCore().equalsIgnoreCase(X_Z_LoadCore.TIPOLOADCORE_PLANDECUENTAS)){

			// Valido que se haya seleccionado un elemento contable para el plan de cuentas
			if (this.getC_Element_ID() <= 0){
				m_processMsg = "Debe indicar Elemento Contable a cosniderar.";
				return DocAction.STATUS_Invalid;
			}

			this.generatePlanCuentas();
		}

		//	User Validation
		String valid = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_COMPLETE);
		if (valid != null)
		{
			m_processMsg = valid;
			return DocAction.STATUS_Invalid;
		}
		//	Set Definitive Document No
		setDefiniteDocumentNo();

		setProcessed(true);
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
	}	//	completeIt
	
	/**
	 * 	Set the definite document number after completed
	 */
	private void setDefiniteDocumentNo() {
		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());
		if (dt.isOverwriteDateOnComplete()) {
			setDateDoc(new Timestamp(System.currentTimeMillis()));
		}
		if (dt.isOverwriteSeqOnComplete()) {
			String value = null;
			int index = p_info.getColumnIndex("C_DocType_ID");
			if (index == -1)
				index = p_info.getColumnIndex("C_DocTypeTarget_ID");
			if (index != -1)		//	get based on Doc Type (might return null)
				value = DB.getDocumentNo(get_ValueAsInt(index), get_TrxName(), true);
			if (value != null) {
				setDocumentNo(value);
			}
		}
	}

	/**
	 * 	Void Document.
	 * 	Same as Close.
	 * 	@return true if success 
	 */
	public boolean voidIt()
	{
		log.info("voidIt - " + toString());
		return closeIt();
	}	//	voidIt
	
	/**
	 * 	Close Document.
	 * 	Cancel not delivered Qunatities
	 * 	@return true if success 
	 */
	public boolean closeIt()
	{
		log.info("closeIt - " + toString());

		//	Close Not delivered Qty
		setDocAction(DOCACTION_None);
		return true;
	}	//	closeIt
	
	/**
	 * 	Reverse Correction
	 * 	@return true if success 
	 */
	public boolean reverseCorrectIt()
	{
		log.info("reverseCorrectIt - " + toString());
		return false;
	}	//	reverseCorrectionIt
	
	/**
	 * 	Reverse Accrual - none
	 * 	@return true if success 
	 */
	public boolean reverseAccrualIt()
	{
		log.info("reverseAccrualIt - " + toString());
		return false;
	}	//	reverseAccrualIt
	
	/** 
	 * 	Re-activate
	 * 	@return true if success 
	 */
	public boolean reActivateIt()
	{
		log.info("reActivateIt - " + toString());
		setProcessed(false);
		if (reverseCorrectIt())
			return true;
		return false;
	}	//	reActivateIt
	
	
	/*************************************************************************
	 * 	Get Summary
	 *	@return Summary of Document
	 */
	public String getSummary()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(getDocumentNo());
	//	sb.append(": ")
	//		.append(Msg.translate(getCtx(),"TotalLines")).append("=").append(getTotalLines())
	//		.append(" (#").append(getLines(false).length).append(")");
		//	 - Description
		if (getDescription() != null && getDescription().length() > 0)
			sb.append(" - ").append(getDescription());
		return sb.toString();
	}	//	getSummary

	/**
	 * 	Get Process Message
	 *	@return clear text error message
	 */
	public String getProcessMsg()
	{
		return m_processMsg;
	}	//	getProcessMsg
	
	/**
	 * 	Get Document Owner (Responsible)
	 *	@return AD_User_ID
	 */
	public int getDoc_User_ID()
	{
	//	return getSalesRep_ID();
		return 0;
	}	//	getDoc_User_ID

	/**
	 * 	Get Document Approval Amount
	 *	@return amount
	 */
	public BigDecimal getApprovalAmt()
	{
		return null;	//getTotalLines();
	}	//	getApprovalAmt
	
	/**
	 * 	Get Document Currency
	 *	@return C_Currency_ID
	 */
	public int getC_Currency_ID()
	{
	//	MPriceList pl = MPriceList.get(getCtx(), getM_PriceList_ID());
	//	return pl.getC_Currency_ID();
		return 0;
	}	//	getC_Currency_ID

    @Override
    public String toString()
    {
      StringBuffer sb = new StringBuffer ("MZLoadCore[")
        .append(getSummary()).append("]");
      return sb.toString();
    }

	/***
	 * Metodo que ejecuta el proceso de interface desde archivo.
	 * Xpande. Created by Gabriel Vila on 7/23/20.
	 */
	public void executeInterface(){

		try{
			// Elimino información anterior.
			this.deleteFileData();

			// Ejecuta según tipo de carga seleccionado en este proceso
			// Lee lineas de archivo
			// Valida lineas de archivo y trae información asociada.
			if (this.getTipoLoadCore().equalsIgnoreCase(X_Z_LoadCore.TIPOLOADCORE_SOCIOSDENEGOCIO)){
				this.getPartnerDataFromFile();
				this.setPartnerDataFromFile();
			}
			else if (this.getTipoLoadCore().equalsIgnoreCase(X_Z_LoadCore.TIPOLOADCORE_PLANDECUENTAS)){
				this.getAccountDataFromFile();
				this.setAccountDataFromFile();
			}

		}
		catch (Exception e){
			throw new AdempiereException(e);
		}
	}


	/***
	 * Elimina información leída desde archivo.
	 * Xpande. Created by Gabriel Vila on 7/23/20.
	 */
	private void deleteFileData() {

		String action = "";

		try{
			action = " delete from " + I_Z_LoadCoreBPFile.Table_Name +
					" where " + X_Z_LoadCoreBPFile.COLUMNNAME_Z_LoadCore_ID + " =" + this.get_ID();
			DB.executeUpdateEx(action, get_TrxName());

			action = " delete from " + I_Z_LoadCoreAcctFile.Table_Name +
					" where " + X_Z_LoadCoreBPFile.COLUMNNAME_Z_LoadCore_ID + " =" + this.get_ID();
			DB.executeUpdateEx(action, get_TrxName());

		}
		catch (Exception e){
			throw new AdempiereException(e);
		}
	}

	/***
	 * Proceso que lee archivo de interface para carga de Socios de Negocio.
	 * Xpande. Created by Gabriel Vila on 7/23/20.
	 */
	public void getPartnerDataFromFile() {

		FileReader fReader = null;
		BufferedReader bReader = null;

		String lineaArchivo = null;
		String mensaje = "";
		String action = "";

		try{

			// Formato de importación de archivo de interface
			ImpFormat formatoImpArchivo = ImpFormat.load("Core_Load_Partner");

			// Abro archivo
			File archivo = new File(this.getFileName());
			fReader = new FileReader(archivo);
			bReader = new BufferedReader(fReader);

			int contLineas = 0;
			int lineaID = 0;

			// Leo lineas del archivo
			lineaArchivo = bReader.readLine();

			while (lineaArchivo != null) {

				lineaArchivo = lineaArchivo.replace("'", "");
				contLineas++;

				lineaID = formatoImpArchivo.updateDB(lineaArchivo, getCtx(), get_TrxName());

				if (lineaID <= 0){
					MZLoadCoreBPFile loadCoreBPFile = new MZLoadCoreBPFile(getCtx(), 0, get_TrxName());
					loadCoreBPFile.setZ_LoadCore_ID(this.get_ID());
					loadCoreBPFile.setLineNumber(contLineas);
					loadCoreBPFile.setFileLineText(lineaArchivo);
					loadCoreBPFile.setIsConfirmed(false);
					loadCoreBPFile.setErrorMsg("Formato de Linea Incorrecto.");
					loadCoreBPFile.saveEx();
				}
				else{
					// Seteo atributos de linea procesada en tabla
					action = " update " + I_Z_LoadCoreBPFile.Table_Name +
							" set " + X_Z_LoadCoreBPFile.COLUMNNAME_Z_LoadCore_ID + " = " + this.get_ID() + ", " +
							" LineNumber =" + contLineas + ", " +
							" FileLineText ='" + lineaArchivo + "' " +
							" where " + X_Z_LoadCoreBPFile.COLUMNNAME_Z_LoadCoreBPFile_ID + " = " + lineaID;
					DB.executeUpdateEx(action, get_TrxName());
				}

				lineaArchivo = bReader.readLine();
			}

			this.setQtyCount(contLineas);
			this.saveEx();

		}
		catch (Exception e){
			throw new AdempiereException(e);
		}
		finally {
			if (bReader != null){
				try{
					bReader.close();
					if (fReader != null){
						fReader.close();
					}
				}
				catch (Exception e){
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/***
	 * Valida lineas leídas desde archivo y carga información asociada para Socios de Negocio.
	 * Xpande. Created by Gabriel Vila on 7/23/20.
	 */
	private void setPartnerDataFromFile() {

		String sql = "";

		try{
			int contadorOK = 0;
			int contadorError = 0;

			List<MZLoadCoreBPFile> loadCoreBPFileList = this.getPartnerLines();
			for (MZLoadCoreBPFile loadCoreBPFile : loadCoreBPFileList){

				if (loadCoreBPFile.getErrorMsg() != null){
					contadorError++;
					continue;
				}

				loadCoreBPFile.setIsConfirmed(true);
				loadCoreBPFile.setAD_Org_ID(this.getAD_Org_ID());

				// Codigo interno
				if ((loadCoreBPFile.getCodigoInterno() != null) && (!loadCoreBPFile.getCodigoInterno().trim().equalsIgnoreCase(""))){

					loadCoreBPFile.setCodigoInterno(loadCoreBPFile.getCodigoInterno().trim());

					// Verifico si ya existe un socio de negocio en el sistema con ese codigo interno
					sql = " select c_bpartner_id from c_bpartner where upper(value) ='" + loadCoreBPFile.getCodigoInterno().trim().toUpperCase() + "'";
					int cBPartnerIDAux = DB.getSQLValueEx(null, sql);
					if (cBPartnerIDAux > 0){
						loadCoreBPFile.setIsConfirmed(false);
						loadCoreBPFile.setErrorMsg("Ya existe en el sistema un Socio de Negocio con este Código.");
					}
				}

				// Razón Social
				if (loadCoreBPFile.isConfirmed()){
					if ((loadCoreBPFile.getName() == null) || (loadCoreBPFile.getName().trim().equalsIgnoreCase(""))){
						loadCoreBPFile.setIsConfirmed(false);
						loadCoreBPFile.setErrorMsg("Debe indicar Razón Social");
					}
					else{

						loadCoreBPFile.setName(loadCoreBPFile.getName().trim());

						// Verifico si ya existe un socio de negocio en el sistema con esa Razón Social
						sql = " select c_bpartner_id from c_bpartner where upper(name) ='" + loadCoreBPFile.getName().trim().toUpperCase() + "'";
						int cBPartnerIDAux = DB.getSQLValueEx(null, sql);
						if (cBPartnerIDAux > 0){
							loadCoreBPFile.setIsConfirmed(false);
							loadCoreBPFile.setErrorMsg("Ya existe en el sistema un Socio de Negocio con esta Razón Social.");
						}
					}
				}

				// Tipo Identificación
				if (loadCoreBPFile.isConfirmed()){
					if ((loadCoreBPFile.getTipoIdentificacion() == null) || (loadCoreBPFile.getTipoIdentificacion().trim().equalsIgnoreCase(""))){
						loadCoreBPFile.setIsConfirmed(false);
						loadCoreBPFile.setErrorMsg("Debe indicar Tipo de Identificación");
					}
					else{

						loadCoreBPFile.setTipoIdentificacion(loadCoreBPFile.getTipoIdentificacion().trim());

						// Obtengo tipo de identificación de ADempiere, segun tipo recibido
						sql = " select c_taxgroup_id from c_taxgroup where upper(value) ='" + loadCoreBPFile.getTipoIdentificacion().trim().toUpperCase() + "'";
						int cTaxGroupID = DB.getSQLValueEx(null, sql);
						if (cTaxGroupID <= 0){
							loadCoreBPFile.setIsConfirmed(false);
							loadCoreBPFile.setErrorMsg("Tipo de Identificación recibido no es válido.");
						}
						else {
							loadCoreBPFile.setC_TaxGroup_ID(cTaxGroupID);
						}
					}
				}

				// Numero de identificación
				if (loadCoreBPFile.isConfirmed()){
					if ((loadCoreBPFile.getTaxID() == null) || (loadCoreBPFile.getTaxID().trim().equalsIgnoreCase(""))){
						// Si el grupo de impuesto no permite numero de identificación nulo para clienes, aviso y salgo.
						X_C_TaxGroup taxGroup = (X_C_TaxGroup) loadCoreBPFile.getC_TaxGroup();
						if (!taxGroup.get_ValueAsBoolean("AllowCustomerNull")){
							loadCoreBPFile.setIsConfirmed(false);
							loadCoreBPFile.setErrorMsg("Debe indicar Número de Identificación cuando el socio de negocio esta marcado como Cliente");
						}
					}
					else{

						loadCoreBPFile.setTaxID(loadCoreBPFile.getTaxID().trim());

						// Verifico si ya existe un socio de negocio en el sistema con ese número de identificación.
						sql = " select c_bpartner_id from c_bpartner where upper(taxid) ='" + loadCoreBPFile.getTaxID().trim().toUpperCase() + "'";
						int cBPartnerIDAux = DB.getSQLValueEx(null, sql);
						if (cBPartnerIDAux > 0){
							loadCoreBPFile.setIsConfirmed(false);
							loadCoreBPFile.setErrorMsg("Ya existe en el sistema un Socio de Negocio con este Número de Identificación.");
						}

						// Verifico si ya existe un socio de negocio en esta carga con ese número de identificación.
						sql = " select count(*) from z_loadcorebpfile " +
								" where rtrim(taxid) ='" + loadCoreBPFile.getTaxID().trim() + "'" +
								" and z_loadcore_id =" + this.get_ID();
						int contador = DB.getSQLValueEx(null, sql);
						if (contador > 1){
							loadCoreBPFile.setIsConfirmed(false);
							loadCoreBPFile.setErrorMsg("Número de Identificación repetido en esta carga.");
						}
					}
				}

				// Departamento
				if (loadCoreBPFile.isConfirmed()){
					// Si tengo departamento
					if ((loadCoreBPFile.getCodRegion() != null) && (!loadCoreBPFile.getCodRegion().trim().equalsIgnoreCase(""))){
						// Si tengo pais
						if (loadCoreBPFile.getC_Country_ID() > 0){

							loadCoreBPFile.setCodRegion(loadCoreBPFile.getCodRegion().trim());

							// Busco departamento según codigo recibido
							sql = " select c_region_id from c_region " +
									" where lower(value) ='" + loadCoreBPFile.getCodRegion().trim().toLowerCase() + "' " +
									" and c_country_id =" + loadCoreBPFile.getC_Country_ID();
							int cRegionID = DB.getSQLValueEx(null, sql);
							if (cRegionID > 0){
								loadCoreBPFile.setC_Region_ID(cRegionID);

								// Localidad
								if (this.isValidaLocalidad()){
									if ((loadCoreBPFile.getCodLocalidad() != null) && (!loadCoreBPFile.getCodLocalidad().trim().equalsIgnoreCase(""))){

										loadCoreBPFile.setCodLocalidad(loadCoreBPFile.getCodLocalidad().trim());

										// Busco localidad según codigo recibido
										sql = " select c_city_id from c_city " +
												" where lower(locode) ='" + loadCoreBPFile.getCodLocalidad().trim().toLowerCase() + "' " +
												" and c_region_id =" + loadCoreBPFile.getC_Region_ID();
										int cCityID = DB.getSQLValueEx(null, sql);
										if (cCityID > 0){
											loadCoreBPFile.setC_City_ID(cCityID);
										}
										else{
											loadCoreBPFile.setIsConfirmed(false);
											loadCoreBPFile.setErrorMsg("No existe Localidad con ese Código para el País-Departamento indicado.");
										}
									}
								}
							}
							else {
								loadCoreBPFile.setIsConfirmed(false);
								loadCoreBPFile.setErrorMsg("No existe Departamento con ese Código para el País indicado.");
							}
						}
					}
				}

				if (loadCoreBPFile.isConfirmed()){
					contadorOK++;
				}
				else{
					contadorError++;
				}

				loadCoreBPFile.saveEx();
			}

			this.setQty(contadorOK);
			this.setQtyReject(contadorError);
			this.saveEx();

		}
		catch (Exception e){
			throw new AdempiereException(e);
		}
	}

	/***
	 * Proceso que lee archivo de interface para carga de Plan de Cuentas.
	 * Xpande. Created by Gabriel Vila on 9/19/20.
	 */
	public void getAccountDataFromFile() {

		FileReader fReader = null;
		BufferedReader bReader = null;

		String lineaArchivo = null;
		String action = "";

		try{
			// Formato de importación de archivo de interface
			ImpFormat formatoImpArchivo = ImpFormat.load("Core_Load_PlanCuentas");

			// Abro archivo
			File archivo = new File(this.getFileName());
			fReader = new FileReader(archivo);
			bReader = new BufferedReader(fReader);

			int contLineas = 0;
			int lineaID = 0;

			// Leo lineas del archivo
			lineaArchivo = bReader.readLine();

			while (lineaArchivo != null) {

				lineaArchivo = lineaArchivo.replace("'", "");
				contLineas++;

				lineaID = formatoImpArchivo.updateDB(lineaArchivo, getCtx(), get_TrxName());

				if (lineaID <= 0){
					MZLoadCoreAcctFile loadCoreAcctFile = new MZLoadCoreAcctFile(getCtx(), 0, get_TrxName());
					loadCoreAcctFile.setZ_LoadCore_ID(this.get_ID());
					loadCoreAcctFile.setLineNumber(contLineas);
					loadCoreAcctFile.setFileLineText(lineaArchivo);
					loadCoreAcctFile.setIsConfirmed(false);
					loadCoreAcctFile.setErrorMsg("Formato de Linea Incorrecto.");
					loadCoreAcctFile.saveEx();
				}
				else{
					// Seteo atributos de linea procesada en tabla
					action = " update " + I_Z_LoadCoreAcctFile.Table_Name +
							" set " + X_Z_LoadCoreAcctFile.COLUMNNAME_Z_LoadCore_ID + " = " + this.get_ID() + ", " +
							" LineNumber =" + contLineas + ", " +
							" FileLineText ='" + lineaArchivo + "' " +
							" where " + X_Z_LoadCoreAcctFile.COLUMNNAME_Z_LoadCoreAcctFile_ID + " = " + lineaID;
					DB.executeUpdateEx(action, get_TrxName());
				}
				lineaArchivo = bReader.readLine();
			}

			this.setQtyCount(contLineas);
			this.saveEx();

		}
		catch (Exception e){
			throw new AdempiereException(e);
		}
		finally {
			if (bReader != null){
				try{
					bReader.close();
					if (fReader != null){
						fReader.close();
					}
				}
				catch (Exception e){
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/***
	 * Valida lineas leídas desde archivo y carga información asociada para Plan de Cuentas.
	 * Xpande. Created by Gabriel Vila on 9/19/20.
	 */
	private void setAccountDataFromFile() {

		String sql = "";

		try{
			int contadorOK = 0;
			int contadorError = 0;

			List<MZLoadCoreAcctFile> loadCoreAcctFileList = this.getAccountLines();
			for (MZLoadCoreAcctFile loadCoreAcctFile : loadCoreAcctFileList){

				if (loadCoreAcctFile.getErrorMsg() != null){
					contadorError++;
					continue;
				}

				loadCoreAcctFile.setIsConfirmed(true);
				loadCoreAcctFile.setAD_Org_ID(this.getAD_Org_ID());

				// Cuenta Padre
				if ((loadCoreAcctFile.getParentValue() != null) && (!loadCoreAcctFile.getParentValue().trim().equalsIgnoreCase(""))){

					loadCoreAcctFile.setParentValue(loadCoreAcctFile.getParentValue().trim());

					// Si la cuenta padre es distinta de CERO, debo validar que exista una cuenta con este codigo
					if (!loadCoreAcctFile.getParentValue().trim().equalsIgnoreCase("0")){
						// Verifico si existe una cuenta con este código en esta carga de archivo
						sql = " select count(*) from z_loadcoreacctfile where rtrim(value) ='" + loadCoreAcctFile.getParentValue().trim() + "'";
						int contador = DB.getSQLValueEx(null, sql);
						if (contador <= 0){
							loadCoreAcctFile.setIsConfirmed(false);
							loadCoreAcctFile.setErrorMsg("No existe cuenta padre con código: " + loadCoreAcctFile.getParentValue().trim());
						}
					}
				}
				else{
					loadCoreAcctFile.setIsConfirmed(false);
					loadCoreAcctFile.setErrorMsg("Falta indicar Cuenta Padre");
				}

				// Codigo interno
				if (loadCoreAcctFile.isConfirmed()){
					if ((loadCoreAcctFile.getValue() == null) || (loadCoreAcctFile.getValue().trim().equalsIgnoreCase(""))){
						loadCoreAcctFile.setIsConfirmed(false);
						loadCoreAcctFile.setErrorMsg("Falta indicar Código de Cuenta");
					}
					else{

						loadCoreAcctFile.setValue(loadCoreAcctFile.getValue().trim());

						// Verifico codigo de cuenta unicó
						sql = " select count(*) from z_loadcoreacctfile where rtrim(value) ='" + loadCoreAcctFile.getValue().trim() + "'";
						int contador = DB.getSQLValueEx(null, sql);
						if (contador > 1){
							loadCoreAcctFile.setIsConfirmed(false);
							loadCoreAcctFile.setErrorMsg("Código de cuenta repetido: " + loadCoreAcctFile.getValue().trim());
						}
					}
				}

				// Nombre
				if (loadCoreAcctFile.isConfirmed()){
					if ((loadCoreAcctFile.getName() == null) || (loadCoreAcctFile.getName().trim().equalsIgnoreCase(""))){
						loadCoreAcctFile.setIsConfirmed(false);
						loadCoreAcctFile.setErrorMsg("Falta indicar Nombre de Cuenta");
					}
					else{

						loadCoreAcctFile.setName(loadCoreAcctFile.getName().trim());

						/*
						// Verifico nombre de cuenta unicó
						sql = " select count(*) from z_loadcoreacctfile where lower(rtrim(name)) ='" + loadCoreAcctFile.getName().trim().toLowerCase() + "'";
						int contador = DB.getSQLValueEx(null, sql);
						if (contador > 1){
							loadCoreAcctFile.setIsConfirmed(false);
							loadCoreAcctFile.setErrorMsg("Nombre de cuenta repetido: " + loadCoreAcctFile.getName().trim());
						}
						*/
					}
				}

				// Si cuenta marcada como moneda extranjera verifico moneda extranjera
				if (loadCoreAcctFile.isConfirmed()){
					if (loadCoreAcctFile.isForeignCurrency()){
						if (loadCoreAcctFile.getC_Currency_ID() <= 0){
							loadCoreAcctFile.setIsConfirmed(false);
							loadCoreAcctFile.setErrorMsg("Falta indicar Moneda Extranjera");
						}
					}
				}

				if (loadCoreAcctFile.isConfirmed()){
					contadorOK++;
				}
				else{
					contadorError++;
				}

				loadCoreAcctFile.saveEx();
			}

			this.setQty(contadorOK);
			this.setQtyReject(contadorError);
			this.saveEx();
		}
		catch (Exception e){
			throw new AdempiereException(e);
		}
	}


	/***
	 * Obtiene y retorna lineas de carga de socios de negocios de este documento.
	 * Xpande. Created by Gabriel Vila on 7/23/20.
	 * @return
	 */
	public List<MZLoadCoreBPFile> getPartnerLines(){

		String whereClause = X_Z_LoadCoreBPFile.COLUMNNAME_Z_LoadCore_ID + " =" + this.get_ID();

		List<MZLoadCoreBPFile> lines = new Query(getCtx(), I_Z_LoadCoreBPFile.Table_Name, whereClause, get_TrxName()).list();

		return lines;
	}

	/***
	 * Obtiene y retorna lineas de carga de Plan de Cuentas.
	 * Xpande. Created by Gabriel Vila on 9/19/20.
	 * @return
	 */
	public List<MZLoadCoreAcctFile> getAccountLines(){

		String whereClause = X_Z_LoadCoreAcctFile.COLUMNNAME_Z_LoadCore_ID + " =" + this.get_ID();

		List<MZLoadCoreAcctFile> lines = new Query(getCtx(), I_Z_LoadCoreAcctFile.Table_Name, whereClause, get_TrxName()).list();

		return lines;
	}


	/***
	 * Crea nuevos socios de negocio en el sistema.
	 * Xpande. Created by Gabriel Vila on 7/23/20.
	 */
	private void generatePartners(){

		try{

			List<MZLoadCoreBPFile> loadCoreBPFileList = this.getPartnerLines();
			for (MZLoadCoreBPFile loadCoreBPFile: loadCoreBPFileList){

				// Si esta linea no esta OK, no la proceso.
				if (!loadCoreBPFile.isConfirmed()){
					continue;
				}

				// Creo socio de negocio
				MBPartner partner = new MBPartner(getCtx(), 0, get_TrxName());
				partner.setAD_Org_ID(0);
				partner.setName(loadCoreBPFile.getName().trim().toUpperCase());
				partner.setC_TaxGroup_ID(loadCoreBPFile.getC_TaxGroup_ID());

				if (loadCoreBPFile.getTaxID() != null){
					partner.setTaxID(loadCoreBPFile.getTaxID().trim());
				}

				partner.setIsCustomer(loadCoreBPFile.isCustomer());
				partner.setIsVendor(loadCoreBPFile.isVendor());
				partner.setIsEmployee(loadCoreBPFile.isEmployee());
				partner.setIsSalesRep(loadCoreBPFile.isSalesRep());
				partner.setC_BP_Group_ID(1000000);

				if ((loadCoreBPFile.getCodigoInterno() != null) && (!loadCoreBPFile.getCodigoInterno().trim().equalsIgnoreCase(""))){
					partner.setValue(loadCoreBPFile.getCodigoInterno().trim());
				}
				if ((loadCoreBPFile.getName2() != null) && (!loadCoreBPFile.getName2().trim().equalsIgnoreCase(""))){
					partner.setName2(loadCoreBPFile.getName2().trim().toUpperCase());
				}
				else {
					partner.setName2(partner.getName());
				}

				partner.set_ValueOfColumn(X_Z_LoadCore.COLUMNNAME_Z_LoadCore_ID, this.get_ID());
				partner.saveEx();

				// Creo localizacion
				MLocation location = null;
				if ((loadCoreBPFile.getC_Country_ID() > 0) && (loadCoreBPFile.getC_Region_ID() > 0)){

					MCountry country = (MCountry) loadCoreBPFile.getC_Country();
					MRegion region = (MRegion) loadCoreBPFile.getC_Region();
					location = new MLocation(country, region);
					location.setRegionName(region.getName());

					if (loadCoreBPFile.getC_City_ID() > 0){
						MCity city = (MCity) loadCoreBPFile.getC_City();
						location.setCity(city.getName());
						location.setC_City_ID(loadCoreBPFile.getC_City_ID());
					}

					if ((loadCoreBPFile.getAddress1() != null) && (!loadCoreBPFile.getAddress1().trim().equalsIgnoreCase(""))){
						location.setAddress1(loadCoreBPFile.getAddress1().trim().toUpperCase());
					}
					else {
						location.setAddress1("SIN ASIGNAR");
					}
					location.saveEx();

					MBPartnerLocation partnerLocation = new MBPartnerLocation(getCtx(), 0, get_TrxName());
					partnerLocation.setAD_Org_ID(0);
					partnerLocation.setC_BPartner_ID(partner.get_ID());
					partnerLocation.setC_Location_ID(location.get_ID());

					if ((loadCoreBPFile.getAddress1() != null) && (!loadCoreBPFile.getAddress1().trim().equalsIgnoreCase(""))){
						partnerLocation.setName(loadCoreBPFile.getAddress1().trim().toUpperCase());
					}
					else{
						partnerLocation.setName(location.getRegionName());
					}
					if ((partnerLocation.getName() == null) || (partnerLocation.getName().trim().equalsIgnoreCase(""))){
						partnerLocation.setName("SIN DIRECCION");
					}

					if ((loadCoreBPFile.getPhone() != null) && (!loadCoreBPFile.getPhone().trim().equalsIgnoreCase(""))){
						partnerLocation.setPhone(loadCoreBPFile.getPhone().trim());
					}

					if ((loadCoreBPFile.getMobilePhone() != null) && (!loadCoreBPFile.getMobilePhone().trim().equalsIgnoreCase(""))){
						partnerLocation.setMobilePhone(loadCoreBPFile.getMobilePhone().trim());
					}

					if ((loadCoreBPFile.getEMail() != null) && (!loadCoreBPFile.getEMail().trim().equalsIgnoreCase(""))){
						partnerLocation.setEMail(loadCoreBPFile.getEMail().trim());
					}

					partnerLocation.saveEx();
				}
			}

		}
		catch (Exception e){
		    throw new AdempiereException(e);
		}
	}


	/***
	 * Carga plan de cuentas en el sistema.
	 * Xpande. Created by Gabriel Vila on 9/19/20.
	 */
	private void generatePlanCuentas(){

		int contador = 0;
		String action = "";

		try{

			// No hago nada si no hay elemento contable seleccionado
			if (this.getC_Element_ID() <= 0){
				return;
			}

			MElement element = (MElement) this.getC_Element();

			List<MZLoadCoreAcctFile> loadCoreAcctFileList = this.getAccountLines();
			for (MZLoadCoreAcctFile loadCoreAcctFile: loadCoreAcctFileList){

				// Si esta linea no esta OK, no la proceso.
				if (!loadCoreAcctFile.isConfirmed()){
					continue;
				}

				// Genero modelo para cuenta contable
				MElementValue elementValue = new MElementValue(getCtx(), 0, get_TrxName());
				elementValue.setAD_Org_ID(0);
				elementValue.setAccountSign(X_C_ElementValue.ACCOUNTSIGN_Natural);
				elementValue.setAccountType(loadCoreAcctFile.getAccountType());
				elementValue.setC_Element_ID(this.getC_Element_ID());
				elementValue.setIsDocControlled(loadCoreAcctFile.isDocControlled());
				elementValue.setIsSummary(loadCoreAcctFile.isSummary());
				elementValue.setValue(loadCoreAcctFile.getValue());
				elementValue.setName(loadCoreAcctFile.getName());
				elementValue.setPostActual(true);
				elementValue.setPostBudget(false);
				elementValue.setPostEncumbrance(false);
				elementValue.setPostStatistical(false);
				elementValue.setIsForeignCurrency(loadCoreAcctFile.isForeignCurrency());

				if (loadCoreAcctFile.getC_Currency_ID() > 0){
					elementValue.setC_Currency_ID(loadCoreAcctFile.getC_Currency_ID());
				}

				elementValue.set_ValueOfColumn("IsTaxAccount", loadCoreAcctFile.isTaxAccount());
				elementValue.set_ValueOfColumn("IsRetencionAcct", loadCoreAcctFile.isRetencionAcct());
				elementValue.set_ValueOfColumn("IsPartnerRequired", loadCoreAcctFile.isPartnerRequired());
				elementValue.set_ValueOfColumn("IsAcctCierreBP", loadCoreAcctFile.isAcctCierreBP());

				elementValue.saveEx();

				// Actualizo ID de cuenta en tabla de carga
				loadCoreAcctFile.setC_ElementValue_ID(elementValue.get_ID());
				loadCoreAcctFile.saveEx();

				contador++;
			}

			// Si cargue cuentas
			if (contador > 0){

				// Actualizo ID de cuenta padre en tabla de carga
				action = " update Z_LoadCoreAcctFile set parent_id = ev.c_elementvalue_id " +
						" from c_elementvalue ev " +
						" where Z_LoadCoreAcctFile.parentvalue = ev.value " +
						" and ev.c_element_id =" + element.get_ID() +
						" and Z_LoadCoreAcctFile.z_loadcore_id =" + this.get_ID();

				DB.executeUpdateEx(action, get_TrxName());

				// Actualizo ID en 0 para cuentas que no tienen padre
				action = " update Z_LoadCoreAcctFile set parent_id = 0 " +
						" where z_loadcore_id =" + this.get_ID() +
						" and parent_id is null " +
						" and isconfirmed ='Y' ";
				DB.executeUpdateEx(action, get_TrxName());

				// Si el elemento comtable tiene arbol asociado
				if (element.getAD_Tree_ID() > 0){

					// Borro nodos del arbol asociado al elemento contable
					action = " delete from ad_treenode cascade where ad_tree_id =" + element.getAD_Tree_ID();
					DB.executeUpdateEx(action, get_TrxName());

					// Inserto nuevos nodos en árbol
					action = " insert into ad_treenode " +
							" (ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_tree_id, node_id, parent_id, seqno) " +
							" select ad_client_id, 0, isactive, created, createdby, updated, updatedby, " +
							element.getAD_Tree_ID() + ", c_elementvalue_id, parent_id, (c_elementvalue_id - 999999)*10 " +
							" from Z_LoadCoreAcctFile " +
							" where z_loadcore_id =" + this.get_ID() +
							" and isconfirmed ='Y' ";
					DB.executeUpdateEx(action, get_TrxName());
				}
			}
		}
		catch (Exception e){
			throw new AdempiereException(e);
		}
	}

}