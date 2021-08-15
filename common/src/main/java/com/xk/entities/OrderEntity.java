package com.xk.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xk
 * @create 2021.08.04 19:45
 */
@Data
public class OrderEntity implements Serializable {

    private Long id;
    private String name;
}
