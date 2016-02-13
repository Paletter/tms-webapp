package com.palette.busi.project.tms.server.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DeliveryVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer delivered;
	private String status;
	private List<DetailDelivery> data;
	
	public class DetailDelivery {
		private String event;
		private Date time;
		public String getEvent() {
			return event;
		}
		public void setEvent(String event) {
			this.event = event;
		}
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
	}
	
	public List<DetailDelivery> getData() {
		return data;
	}

	public void setData(List<DetailDelivery> data) {
		this.data = data;
	}

	public Integer getDelivered() {
		return delivered;
	}

	public void setDelivered(Integer delivered) {
		this.delivered = delivered;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
