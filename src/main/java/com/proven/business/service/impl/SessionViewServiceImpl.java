package com.proven.business.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.model.SessionView;
import com.proven.business.service.SessionViewService;

@Service
@Transactional
public class SessionViewServiceImpl extends BaseServiceImpl<SessionView> implements SessionViewService{

}
