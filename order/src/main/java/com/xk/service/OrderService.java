package com.xk.service;

import com.xk.dto.OrderDTO;

/**
 * @author xk
 * @create 2021.08.05 10:20
 */
public interface OrderService {

    OrderDTO findById(Long id);
}
