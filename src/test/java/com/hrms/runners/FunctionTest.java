package com.hrms.runners;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.DBUtils;

import java.util.List;
import java.util.Map;

public class FunctionTest {
    public static void main(String[] args) {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String query="select * from ohrm_location";
          List<Map<String ,String>> list= DBUtils.getDbDataIntoList(query);
        System.out.println(list);
    }
}
