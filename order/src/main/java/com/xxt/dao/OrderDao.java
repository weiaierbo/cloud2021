package com.xxt.dao;

import com.xxt.entities.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xk
 * @create 2021.08.04 19:46
 */
@Mapper
public interface OrderDao {

    OrderEntity findById(Long id);
}
