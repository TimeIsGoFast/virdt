package com.proven.system.dao;

import java.util.List;

import com.proven.system.model.Role;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {

	List<Role> getRolesByUid(String uid);
}