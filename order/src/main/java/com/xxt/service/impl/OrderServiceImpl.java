package com.xxt.service.impl;

import com.xxt.dao.OrderDao;
import com.xxt.dto.OrderDTO;
import com.xxt.entities.OrderEntity;
import com.xxt.service.OrderService;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * @author xk
 * @create 2021.08.05 10:20
 */
@org.apache.dubbo.config.annotation.Service
//@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public OrderDTO findById(Long id) {
        OrderEntity entity = orderDao.findById(id);
        if(entity == null){
            return null;
        }
        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }
}
