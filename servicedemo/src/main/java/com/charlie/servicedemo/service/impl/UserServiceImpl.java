package com.charlie.servicedemo.service.impl;

import com.charlie.servicedemo.base.BaseServiceImpl;
import com.charlie.servicedemo.mapper.UserMapper;
import com.charlie.servicedemo.model.entity.User;
import com.charlie.servicedemo.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author charlie
 * @since 2022-07-19
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

}
