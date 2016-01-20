package com.palette.busi.project.tms.core.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palette.busi.project.tms.core.base.dao.impl.BaseDaoImpl;
import com.palette.busi.project.tms.core.base.BaseException;
import com.palette.busi.project.tms.core.entity.WmDeliveryOrder;
import com.palette.busi.project.tms.core.dao.WmDeliveryOrderIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class WmDeliveryOrderDao extends BaseDaoImpl {
	
	public WmDeliveryOrder updateWmDeliveryOrder(WmDeliveryOrder wmDeliveryOrder, String user, String programId) throws BaseException {
		WmDeliveryOrderIntf mapper = this.getSqlSessionTemplate().getMapper(WmDeliveryOrderIntf.class);
		wmDeliveryOrder.setUpdateDateTime(getCurrentGMTDate());
		wmDeliveryOrder.setUpdateUserCode(user);
		mapper.updateWmDeliveryOrder(wmDeliveryOrder);
		return wmDeliveryOrder;
	}
	
	public WmDeliveryOrder insertWmDeliveryOrder(WmDeliveryOrder wmDeliveryOrder, String user, String programId) throws BaseException {
		WmDeliveryOrderIntf mapper = this.getSqlSessionTemplate().getMapper(WmDeliveryOrderIntf.class);
		wmDeliveryOrder.setCreateDateTime(getCurrentGMTDate());
		wmDeliveryOrder.setCreateUserCode(user);
		wmDeliveryOrder.setUpdateDateTime(getCurrentGMTDate());
		wmDeliveryOrder.setUpdateUserCode(user);
		mapper.insertWmDeliveryOrder(wmDeliveryOrder);
		if(wmDeliveryOrder.getWmDeliveryOrderId() == null){
			wmDeliveryOrder.setWmDeliveryOrderId(getLastPk());
		}
		return wmDeliveryOrder;
	}
	
	public WmDeliveryOrder selectWmDeliveryOrderById(Integer wmDeliveryOrderId) throws BaseException {
		WmDeliveryOrderIntf mapper = this.getSqlSessionTemplate().getMapper(WmDeliveryOrderIntf.class);
		return mapper.selectWmDeliveryOrderById(wmDeliveryOrderId);
	}
	
	public Integer deleteWmDeliveryOrder(Integer wmDeliveryOrderId) throws BaseException {
		WmDeliveryOrderIntf mapper = this.getSqlSessionTemplate().getMapper(WmDeliveryOrderIntf.class);
		return mapper.deleteWmDeliveryOrder(wmDeliveryOrderId);
	}
	
	public List<WmDeliveryOrder> selectAllWmDeliveryOrder() throws BaseException {
		WmDeliveryOrderIntf mapper = this.getSqlSessionTemplate().getMapper(WmDeliveryOrderIntf.class);
		List<WmDeliveryOrder> allWmDeliveryOrder = mapper.selectAllWmDeliveryOrder();
		return allWmDeliveryOrder;
	}
	
	public List<WmDeliveryOrder> selectAllByRecord(WmDeliveryOrder wmDeliveryOrder) throws BaseException {
		WmDeliveryOrderIntf mapper = this.getSqlSessionTemplate().getMapper(WmDeliveryOrderIntf.class);
		return mapper.selectAllByRecord(wmDeliveryOrder);
	}
	
	public PageInfo selectPageByRecord(WmDeliveryOrder wmDeliveryOrder) throws BaseException {
		PageModel pageModel = wmDeliveryOrder.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		WmDeliveryOrderIntf mapper = this.getSqlSessionTemplate().getMapper(WmDeliveryOrderIntf.class);
		mapper.selectAllByRecord(wmDeliveryOrder);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public WmDeliveryOrder selectOneByRecord(WmDeliveryOrder wmDeliveryOrder) throws BaseException {
		List<WmDeliveryOrder> resultList = selectAllByRecord(wmDeliveryOrder);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public WmDeliveryOrder saveWmDeliveryOrder(WmDeliveryOrder wmDeliveryOrder, String user, String programId) throws BaseException {
		if(wmDeliveryOrder.getWmDeliveryOrderId() == null){
			wmDeliveryOrder = insertWmDeliveryOrder(wmDeliveryOrder, user, programId);
		}else{
			wmDeliveryOrder = updateWmDeliveryOrder(wmDeliveryOrder, user, programId);
		}
		return wmDeliveryOrder;
	}
	
	private Date getCurrentGMTDate() {
		try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        dateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
	        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return dateTimeFormat.parse(dateFormat.format(new Date()));
		} catch (Exception e) {
			throw new BaseException(e.getMessage());
		}
    }
}