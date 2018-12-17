package com.lk.service.impl;

import com.lk.mapper.OptionsMapper;
import com.lk.pojo.Options;
import com.lk.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionsMapper optionsMapper;

    @Override
    public Options getOptions() {
        return optionsMapper.selectOptions();
    }

    @Override
    public void saveOptions(Options options) {
        optionsMapper.updateByPrimaryKeySelective(options);
    }
}
