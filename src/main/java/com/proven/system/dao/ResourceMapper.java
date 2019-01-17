package com.proven.system.dao;

import java.util.List;

import com.proven.system.model.Resource;
import tk.mybatis.mapper.common.Mapper;

public interface ResourceMapper extends Mapper<Resource> {

	List<Resource> getResourcesByRoleId(Integer id);
}