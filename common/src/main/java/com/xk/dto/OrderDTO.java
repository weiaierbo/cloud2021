package com.xk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xk
 * @create 2021.08.04 20:01
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {

    private Long id;

    private String name;

}
