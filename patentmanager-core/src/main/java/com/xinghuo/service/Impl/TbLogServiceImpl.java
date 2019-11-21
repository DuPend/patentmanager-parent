package com.xinghuo.service.Impl;

import com.xinghuo.pojo.TbLog;
import com.xinghuo.mapper.TbLogMapper;
import com.xinghuo.service.TbLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbLogServiceImpl implements TbLogService {

    @Autowired
    private TbLogMapper tbLogMapper;
    @Override
    public int addLogService(TbLog tbLog) {
        return tbLogMapper.addLog(tbLog);
    }

    @Override
    public TbLog selectLogByNameService(String name) {
        return tbLogMapper.selectLogByName(name);
    }

    @Override
    public List<TbLog> selectAllLogService() {
        return tbLogMapper.selectAllLog();
    }
}
