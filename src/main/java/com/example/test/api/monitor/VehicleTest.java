package com.example.test.api.monitor;

import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.MonitorInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleTest {

    @Test
    public void vehicle(){

        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.VEHICLE);
        String response = HttpUtil.doGet(url + Constants.TEST_CASE.get("vehicle").get(4).toString(), null, Constants.SESSIONID);
        Constants.TEST_CASE.get("vehicle").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);

        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        Assert.assertNotNull(jsonObject.getJSONObject("data").get("vin"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").get("favor"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("operatingUnit"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("licensePlate"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("vehProperty"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("vendor"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("operatingCity"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("soc"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("speed"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("totalOdometer"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("lat"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").containsKey("lng"));
    }
}
