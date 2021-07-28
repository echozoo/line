package com.athc.web.service;

import com.athc.web.model.Role;
import com.athc.web.mapper.RoleMapper;
import com.athc.web.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author dujf
 * @since 2018-05-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
