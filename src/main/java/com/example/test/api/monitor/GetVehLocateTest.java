package com.example.test.api.monitor;

import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.MonitorInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 获取地图麻点接口
 */
public class GetVehLocateTest {

    @Test
    public void getVehLocate1(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate1").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate1").add(response);
        Assert.assertEquals(response, getVehLocate10Response());

    }

    @Test
    public void getVehLocate2(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate2").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate2").add(response);
        Assert.assertEquals(response, getVehLocate10Response());
    }

    @Test
    public void getVehLocate3(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate3").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate3").add(response);
        Assert.assertEquals(response, getVehLocate10Response());

    }

    @Test
    public void getVehLocate4(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate4").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate4").add(response);
        Assert.assertEquals(response, getVehLocate10Response());
    }

    @Test
    public void getVehLocate5(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate5").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate5").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),500);

    }

    @Test
    public void getVehLocate6(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate6").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate6").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        assertData(jsonObject);
    }

    private void assertData(JSONObject jsonObject){
        int total = jsonObject.getJSONObject("data").getIntValue("total");
        Assert.assertNotNull(total);
        if(total > 0) {
            Assert.assertNotNull(jsonObject.getJSONObject("data").get("list"));
            Assert.assertNotNull(jsonObject.getJSONObject("data").getJSONArray("list").getJSONObject(0).containsKey("licensePlate"));
            Assert.assertNotNull(jsonObject.getJSONObject("data").getJSONArray("list").getJSONObject(0).get("vin"));
            Assert.assertNotNull(jsonObject.getJSONObject("data").getJSONArray("list").getJSONObject(0).get("onlineStatus"));
            Assert.assertNotNull(jsonObject.getJSONObject("data").getJSONArray("list").getJSONObject(0).get("lat"));
            Assert.assertNotNull(jsonObject.getJSONObject("data").getJSONArray("list").getJSONObject(0).get("lng"));
        }
    }
    @Test
    public void getVehLocate7(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate7").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate7").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        assertData(jsonObject);
    }

    @Test
    public void getVehLocate8(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate8").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate8").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        assertData(jsonObject);
    }

    @Test
    public void getVehLocate9(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate9").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate9").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        assertData(jsonObject);
    }


    @Test
    public void getVehLocate10(){
        String response = getVehLocate10Response();
        Constants.TEST_CASE.get("getVehLocate10").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        assertData(jsonObject);
    }

    private String getVehLocate10Response(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate10").get(4).toString(), Constants.SESSIONID);
        return response;
    }

    @Test
    public void getVehLocate11(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate11").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate11").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        assertData(jsonObject);
    }

    @Test
    public void getVehLocate12(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_LOCATE);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("getVehLocate12").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehLocate12").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        assertData(jsonObject);
    }
}
