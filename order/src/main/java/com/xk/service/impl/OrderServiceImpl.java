package com.xk.service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xk.dao.OrderDao;
import com.xk.dto.OrderDTO;
import com.xk.entities.OrderEntity;
import com.xk.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
