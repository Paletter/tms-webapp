package com.palette.busi.project.tms.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.ResultType;

import com.palette.busi.project.tms.core.entity.TmConsignmentItem;
import com.palette.busi.project.tms.core.dao.TmConsignmentItemSqlProvider;
import com.palette.busi.project.tms.core.base.BaseMybatisMapper;

public interface TmConsignmentItemIntf extends BaseMybatisMapper {


	@Select("SELECT  TM_CONSIGNMENT_ITEM_ID  AS tmConsignmentItemId, TM_CONSIGNMENT_ID  AS tmConsignmentId, CONSIGNMENT_NO  AS consignmentNo, SEQ  AS seq, GOODS_CODE  AS goodsCode, GOODS_DESCRIPTION  AS goodsDescription, BRAND_NAME  AS brandName, ACTUAL_WEIGHT  AS actualWeight, APPLY_WEIGHT  AS applyWeight, VOLUME_WEIGHT  AS volumeWeight, PIECES_ITEM_QTY  AS piecesItemQty, UNIT_PRICE  AS unitPrice, UNIT_CODE  AS unitCode, AMOUNT  AS amount, CURRENCY  AS currency, SPEC  AS spec, TARIFF  AS tariff, GOODS_URL  AS goodsUrl, TARIFF_NUMBER  AS tariffNumber, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_consignment_item WHERE tm_consignment_item_id=#{tmConsignmentItemId}")
	public TmConsignmentItem selectTmConsignmentItemById(@Param("tmConsignmentItemId") int tmConsignmentItemId);
	
	@Select("SELECT  TM_CONSIGNMENT_ITEM_ID  AS tmConsignmentItemId, TM_CONSIGNMENT_ID  AS tmConsignmentId, CONSIGNMENT_NO  AS consignmentNo, SEQ  AS seq, GOODS_CODE  AS goodsCode, GOODS_DESCRIPTION  AS goodsDescription, BRAND_NAME  AS brandName, ACTUAL_WEIGHT  AS actualWeight, APPLY_WEIGHT  AS applyWeight, VOLUME_WEIGHT  AS volumeWeight, PIECES_ITEM_QTY  AS piecesItemQty, UNIT_PRICE  AS unitPrice, UNIT_CODE  AS unitCode, AMOUNT  AS amount, CURRENCY  AS currency, SPEC  AS spec, TARIFF  AS tariff, GOODS_URL  AS goodsUrl, TARIFF_NUMBER  AS tariffNumber, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_consignment_item")
	public List<TmConsignmentItem> selectAllTmConsignmentItem();
	
	@Insert("insert into tm_consignment_item ( TM_CONSIGNMENT_ITEM_ID, TM_CONSIGNMENT_ID, CONSIGNMENT_NO, SEQ, GOODS_CODE, GOODS_DESCRIPTION, BRAND_NAME, ACTUAL_WEIGHT, APPLY_WEIGHT, VOLUME_WEIGHT, PIECES_ITEM_QTY, UNIT_PRICE, UNIT_CODE, AMOUNT, CURRENCY, SPEC, TARIFF, GOODS_URL, TARIFF_NUMBER, RECORD_VERSION, CREATE_USER_CODE, CREATE_DATE_TIME, UPDATE_USER_CODE, UPDATE_DATE_TIME ) values (#{tmConsignmentItemId},#{tmConsignmentId},#{consignmentNo},#{seq},#{goodsCode},#{goodsDescription},#{brandName},#{actualWeight},#{applyWeight},#{volumeWeight},#{piecesItemQty},#{unitPrice},#{unitCode},#{amount},#{currency},#{spec},#{tariff},#{goodsUrl},#{tariffNumber},#{recordVersion},#{createUserCode},#{createDateTime},#{updateUserCode},#{updateDateTime})")
	public int insertTmConsignmentItem(TmConsignmentItem tmConsignmentItem);

	@UpdateProvider(type=TmConsignmentItemSqlProvider.class, method="update")
	public int updateTmConsignmentItem(TmConsignmentItem tmConsignmentItem);
	
	@Delete("delete from tm_consignment_item where tm_consignment_item_id = #{tmConsignmentItemId}")
	public int deleteTmConsignmentItem(@Param("tmConsignmentItemId") int tmConsignmentItemId);

    @SelectProvider(type=TmConsignmentItemSqlProvider.class, method="selectAllByRecord")
    @ResultType(TmConsignmentItem.class)
    public List<TmConsignmentItem> selectAllByRecord(TmConsignmentItem record);
    
}