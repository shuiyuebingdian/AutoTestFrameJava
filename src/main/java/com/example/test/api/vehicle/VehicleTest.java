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
public class VehicleTest {

    @Test
    public void vehicle1(){
        String url = UrlConfig.getVehicleUrl(VehicleInterfaceName.VEHICLE);
        String response = HttpUtil.doGet(url + Constants.TEST_CASE.get("vehicle1").get(4).toString(), null, Constants.SESSIONID);
        Constants.TEST_CASE.get("vehicle1").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.get("status"), 200);
        Assert.assertNotNull(jsonObject.get("id"));
        Assert.assertNotNull(jsonObject.get("carId"));
        Assert.assertNotNull(jsonObject.get("vin"));
        Assert.assertNotNull(jsonObject.get("dept"));
        Assert.assertNotNull(jsonObject.get("tenantId"));
        Assert.assertNotNull(jsonObject.get("vehName"));
        Assert.assertNotNull(jsonObject.get("tenantName"));
        Assert.assertNotNull(jsonObject.get("vehSeriesName"));
        Assert.assertNotNull(jsonObject.get("vehSeriesNo"));
        Assert.assertNotNull(jsonObject.get("vehModelName"));
        Assert.assertNotNull(jsonObject.get("vehModelNo"));
        Assert.assertNotNull(jsonObject.get("vehProperty"));
        Assert.assertNotNull(jsonObject.get("vehConfNo"));
        Assert.assertNotNull(jsonObject.get("vehConfName"));
        Assert.assertNotNull(jsonObject.get("motorModelNo"));
        Assert.assertNotNull(jsonObject.get("vehColor"));
        Assert.assertNotNull(jsonObject.get("ecph"));
        Assert.assertNotNull(jsonObject.get("manufactureDate"));
        Assert.assertNotNull(jsonObject.get("purchaseDate"));
        Assert.assertNotNull(jsonObject.get("registDate"));
        Assert.assertNotNull(jsonObject.get("licensePlate"));
        Assert.assertNotNull(jsonObject.get("activeDate"));
        Assert.assertNotNull(jsonObject.get("baseServiceStatus"));
        Assert.assertNotNull(jsonObject.get("dealer"));
        Assert.assertNotNull(jsonObject.get("serviceExpireDate"));
        Assert.assertNotNull(jsonObject.get("serviceStartDate"));
        Assert.assertNotNull(jsonObject.get("telephone"));
        Assert.assertNotNull(jsonObject.get("maskCode"));
        Assert.assertNotNull(jsonObject.get("realNameDate"));
        Assert.assertNotNull(jsonObject.get("credentials"));
        Assert.assertNotNull(jsonObject.get("createDate"));
        Assert.assertNotNull(jsonObject.get("realNameStatus"));
        Assert.assertNotNull(jsonObject.get("tuid"));
        Assert.assertNotNull(jsonObject.get("infoSource"));
        Assert.assertNotNull(jsonObject.get("createrId"));
        Assert.assertNotNull(jsonObject.get("province"));
        Assert.assertNotNull(jsonObject.get("city"));
        Assert.assertNotNull(jsonObject.get("vehType"));
        Assert.assertNotNull(jsonObject.get("vendor"));
        Assert.assertNotNull(jsonObject.get("operatingCompany"));
        Assert.assertNotNull(jsonObject.get("operationCity"));
        Assert.assertNotNull(jsonObject.get("terminalNo"));
        Assert.assertNotNull(jsonObject.get("terminalBrand"));
        Assert.assertNotNull(jsonObject.get("monitorPlatform"));


    }


}
