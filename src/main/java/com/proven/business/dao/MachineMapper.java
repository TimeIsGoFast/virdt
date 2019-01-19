package com.proven.business.dao;

import java.util.List;

import com.proven.business.model.Machine;
import tk.mybatis.mapper.common.Mapper;

public interface MachineMapper extends Mapper<Machine> {

	List<String> getAllIds();
}