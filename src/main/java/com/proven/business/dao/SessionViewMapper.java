package com.proven.business.dao;

import java.util.List;

import com.proven.business.model.SessionView;
import tk.mybatis.mapper.common.Mapper;

public interface SessionViewMapper extends Mapper<SessionView> {

	List<SessionView> selectAllOrderByEndDate();
}