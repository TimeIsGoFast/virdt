package com.proven.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.SessionView;
import tk.mybatis.mapper.common.Mapper;

public interface SessionViewMapper extends Mapper<SessionView> {

	List<SessionView> selectAllOrderByEndDate();

	List<SessionView> selectByPassTime(@Param(value="date")String orderDate);

	List<SessionView> selectByDeskgroupIdAndPassTime(@Param(value="deskGroupId")String deskgroupId, @Param(value="date")String orderDate);

	List<SessionView> getDataByCurrentDay(@Param(value="startDate")String startDate, @Param(value="endDate")String endDate);
}