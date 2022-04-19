package com.xxt.service;

import com.xxt.dto.OrderDTO;

/**
 * @author xk
 * @create 2021.08.05 10:20
 */
public interface OrderService {

    OrderDTO findById(Long id);

    String getPhoto(Long id) throws Exception;

    String uploadPhoto(Long id);
}
