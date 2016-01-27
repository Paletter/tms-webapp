package com.palette.busi.project.tms.business.delivery.flight.dto;

import java.util.Date;

import com.palette.busi.project.tms.common.base.BaseReqDto;

public class AddFlightReqDto extends BaseReqDto {

	private String sectorLabel;
    private String flightCode;
    private String origPort;
    private String destPort;
    private Date etd;
    private Date eta;
    private String mawbCode;

	public String getSectorLabel() {
		return sectorLabel;
	}

	public void setSectorLabel(String sectorLabel) {
		this.sectorLabel = sectorLabel;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
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

	public Date getEtd() {
		return etd;
	}

	public void setEtd(Date etd) {
		this.etd = etd;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public String getMawbCode() {
		return mawbCode;
	}

	public void setMawbCode(String mawbCode) {
		this.mawbCode = mawbCode;
	}
    
}
