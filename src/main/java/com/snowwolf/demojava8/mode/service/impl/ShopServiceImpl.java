package com.snowwolf.demojava8.mode.service.impl;

import com.snowwolf.demojava8.mode.dao.ShopRepository;
import com.snowwolf.demojava8.mode.dto.ShopDto;
import com.snowwolf.demojava8.mode.eo.ShopEo;
import com.snowwolf.demojava8.mode.service.ShopService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 20:22
 * @modified by:
 * @versions：0.1.0
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Override
    public List<ShopEo> findAll() {
        return shopRepository.findAll();
    }

    public List<ShopDto> findShops(){
        List<ShopEo> all = shopRepository.findAll();
        return all.stream().map(shopEo -> {
          ShopDto shopDto = new ShopDto();
          BeanUtils.copyProperties(shopEo,shopDto);
          return shopDto;
        }).collect(toList());
    }
}
