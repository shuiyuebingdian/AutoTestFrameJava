package com.example.test.api.monitor;

import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.MonitorInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取车辆汇总数据接口测试
 * 获取当前在线车辆数、今日活跃车辆数和车辆总数
 */
public class GetStaVehicleNumTest {

    @Test(testName = "获取车辆汇总数据")
    public void getStaVehicleNum(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_STA_VEHICLE_NUM);
        String response = HttpUtil.doGet(url, null, Constants.SESSIONID);
        Constants.TEST_CASE.get("getStaVehicleNum").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        Assert.assertNotNull(jsonObject.getJSONObject("data").get("total"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").get("online"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").get("activeInToday"));
    }
}
