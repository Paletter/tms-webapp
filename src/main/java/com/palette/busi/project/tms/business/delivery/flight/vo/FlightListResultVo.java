package com.palette.busi.project.tms.business.delivery.flight.vo;

public class FlightListResultVo {

	private Integer tmSectorId;
	private String sectorCode;
	private String mawbCode;
    private String sectorLabel;
    private String origPort;
    private String origPortDesc;
    private String destPort;
    private String destPortDesc;
    private String etd;
    private String eta;
    private String actionDesc;
    private String actionCode;

	public Integer getTmSectorId() {
		return tmSectorId;
	}

	public void setTmSectorId(Integer tmSectorId) {
		this.tmSectorId = tmSectorId;
	}

	public String getMawbCode() {
		return mawbCode;
	}

	public void setMawbCode(String mawbCode) {
		this.mawbCode = mawbCode;
	}

	public String getSectorLabel() {
		return sectorLabel;
	}

	public void setSectorLabel(String sectorLabel) {
		this.sectorLabel = sectorLabel;
	}

	public String getOrigPortDesc() {
		return origPortDesc;
	}

	public void setOrigPortDesc(String origPortDesc) {
		this.origPortDesc = origPortDesc;
	}

	public String getDestPortDesc() {
		return destPortDesc;
	}

	public void setDestPortDesc(String destPortDesc) {
		this.destPortDesc = destPortDesc;
	}

	public String getEtd() {
		return etd;
	}

	public void setEtd(String etd) {
		this.etd = etd;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getOrigPort() {
		return origPort;
	}

	public void setOrigPort(String origPort) {
		this.origPort = origPort;
	}

	public String getDestPort() {
		return destPort;
	}

	public void setDestPort(String destPort) {
		this.destPort = destPort;
	}

	public String getSectorCode() {
		return sectorCode;
	}

	public void setSectorCode(String sectorCode) {
		this.sectorCode = sectorCode;
	}
    
}
