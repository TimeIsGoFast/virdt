package com.proven.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.proven.business.model.Machine;
import tk.mybatis.mapper.common.Mapper;

public interface MachineMapper extends Mapper<Machine> {

	List<String> getAllIds();

	List<String> selectByUpn(@Param(value="upn")String upn);

	void deleteAll();
}