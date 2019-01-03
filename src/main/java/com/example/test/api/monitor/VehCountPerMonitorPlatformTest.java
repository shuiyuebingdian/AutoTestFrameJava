package com.example.test.api.monitor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.MonitorInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehCountPerMonitorPlatformTest {

    @Test
    public void vehCountPerMonitorPlatform(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.VEH_COUNT_PER_MONITOR_PLATFORM);
        String response = HttpUtil.doGet(url + Constants.TEST_CASE.get("vehCountPerMonitorPlatform").get(4).toString(),null, Constants.SESSIONID);
        Constants.TEST_CASE.get("vehCountPerMonitorPlatform").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONArray list = jsonObject.getJSONArray("data");
        Assert.assertNotNull(list);
        for (int i=0; i<list.size(); i++){
            JSONObject veh = list.getJSONObject(i);
            Assert.assertNotNull(veh.get("id"));
            Assert.assertNotNull(veh.get("monitorPlatform"));
            Assert.assertNotNull(veh.get("num"));

        }
    }
}
