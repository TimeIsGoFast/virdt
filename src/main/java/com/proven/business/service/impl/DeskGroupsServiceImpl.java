package com.proven.business.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.model.DeskGroups;
import com.proven.business.service.DeskGroupsService;

@Service
@Transactional
public class DeskGroupsServiceImpl extends BaseServiceImpl<DeskGroups> implements DeskGroupsService{

}
