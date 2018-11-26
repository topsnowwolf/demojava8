package com.snowwolf.demojava8.mode.dto;

import lombok.Data;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 20:05
 * @modified by:
 * @versions：0.1.0
 */
@Data
public class ShopDto implements Comparable<ShopDto>{
    private String shopName;
    private String shopCity;
    private String ower;
    private String status;
    private Double distance;
    private Long saleroom;

    @Override
    public int compareTo(ShopDto o) {
        return (this.distance > o.distance)?1:-1;
    }
}
