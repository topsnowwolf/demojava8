package com.snowwolf.demojava8.mode.eo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 15:54
 * @modified by:
 * @versions：0.1.0
 */
@Table(name="tb_pay")
@Entity
@Data
public class UserPayEo {
    @Id
    private Long payId;
    private String tradeId;
    private String state;
    private Long money;
}
