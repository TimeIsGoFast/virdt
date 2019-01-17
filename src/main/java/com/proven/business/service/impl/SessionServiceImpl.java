package com.proven.business.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.model.Session;
import com.proven.business.service.SessionService;

@Service
@Transactional
public class SessionServiceImpl extends BaseServiceImpl<Session> implements SessionService{

}
