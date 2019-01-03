package com.example.test.api.vehicle;

import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.UrlConfig;
import com.example.test.conf.VehicleInterfaceName;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 车辆列表查询测试用例
 */
public class VehiclesTest {

    @Test
    public void vehicles1(){
        String url = UrlConfig.getVehicleUrl(VehicleInterfaceName.VEHICLES);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("vehicles1").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("vehicles1").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.get("status"), 200);
    }

    @Test
    public void vehicles2(){
        String url = UrlConfig.getVehicleUrl(VehicleInterfaceName.VEHICLES);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("vehicles2").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("vehicles2").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.get("status"), 200);
    }

    @Test
    public void vehicles3(){
        String url = UrlConfig.getVehicleUrl(VehicleInterfaceName.VEHICLES);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("vehicles3").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("vehicles3").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.get("status"), 200);
    }
}
