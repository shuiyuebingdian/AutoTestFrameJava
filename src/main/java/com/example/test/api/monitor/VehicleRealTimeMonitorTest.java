package com.example.test.api.monitor;

import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.MonitorInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleRealTimeMonitorTest {
    @Test
    public void vehicleRealTimeMonitor(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.VEHICLE_REALTIME_MONITOR);
        String response = HttpUtil.doGet(url + Constants.TEST_CASE.get("vehicleRealTimeMonitor").get(4).toString(), null, Constants.SESSIONID);
        Constants.TEST_CASE.get("vehicleRealTimeMonitor").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);

        Assert.assertEquals(jsonObject.getIntValue("status"),200);
    }
}
