package com.snowwolf.demojava8.mode.eo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: topsnowwolf
 * @description: 店铺
 * @date: Create in 2018/11/25 15:13
 * @modified by:
 * @versions：0.1.0
 */
@Table(name="tb_shop")
@Entity
@Data
public class ShopEo {
    private String shopName;
    private String shopCity;
    private String ower;
    private String status;
    private Double distance;
    private Long saleroom;
}
