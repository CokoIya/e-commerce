package com.mye.mall.service.impl;

import com.mye.mall.mapper.CmsPrefrenceAreaMapper;
import com.mye.mall.model.CmsPrefrenceArea;
import com.mye.mall.model.CmsPrefrenceAreaExample;
import com.mye.mall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选管理Service实现类
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
