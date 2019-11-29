package com.xinghuo.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

/**
 * create by   Lenovo on 2019/11/25
 **/
@Service
public interface TbExportService {
    XSSFWorkbook show();
    XSSFWorkbook AdminShow();
}
