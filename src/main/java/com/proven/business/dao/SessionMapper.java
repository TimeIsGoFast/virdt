package com.proven.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.Session;

import tk.mybatis.mapper.common.Mapper;

public interface SessionMapper extends Mapper<Session> {

	List<String> getEndDateIsnull();

	void deleteBySessionKey(@Param(value="key")String sessionKey);
}