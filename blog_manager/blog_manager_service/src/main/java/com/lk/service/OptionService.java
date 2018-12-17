package com.lk.service;

import com.lk.pojo.Options;


public interface OptionService {
    Options getOptions();
    void saveOptions(Options options);
}
