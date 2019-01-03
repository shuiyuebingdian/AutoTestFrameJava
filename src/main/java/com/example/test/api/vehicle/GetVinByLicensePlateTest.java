package com.example.test.api.vehicle;

import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.UrlConfig;
import com.example.test.conf.VehicleInterfaceName;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 车辆列表查询测试用例
 */
public class GetVinByLicensePlateTest {

    @Test
    public void getVinByLicensePlate1(){
        String url = UrlConfig.getVehicleUrl(VehicleInterfaceName.GET_VIN_BY_LICENSE_PLATE);
        Map<String, String> map = new HashMap<>();
        map.put("licensePlate", Constants.TEST_CASE.get("getVinByLicensePlate1").get(4).toString());
        String response = HttpUtil.doGet(url, map, Constants.SESSIONID);
        Constants.TEST_CASE.get("getVinByLicensePlate1").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.get("status"), 200);
        Assert.assertNotNull(jsonObject.containsKey("data"));

    }


    @Test
    public void getVinByLicensePlate2(){
        String url = UrlConfig.getVehicleUrl(VehicleInterfaceName.GET_VIN_BY_LICENSE_PLATE);
        Map<String, String> map = new HashMap<>();
        map.put("licensePlate", "");
        String response = HttpUtil.doGet(url, map, Constants.SESSIONID);
        Constants.TEST_CASE.get("getVinByLicensePlate2").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.get("status"), 200);
        Assert.assertEquals(jsonObject.get("data"), "");

    }
}
