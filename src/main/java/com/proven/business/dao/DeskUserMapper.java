package com.proven.business.dao;

import java.util.List;

import com.proven.business.model.DeskUser;
import tk.mybatis.mapper.common.Mapper;

public interface DeskUserMapper extends Mapper<DeskUser> {

	List<Integer> getIds();

	void deleteAll();
}