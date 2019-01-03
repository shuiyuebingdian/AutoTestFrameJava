package com.example.test.api.monitor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.MonitorInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.util.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {

    @Test
    public void search1(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.SEARCH);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("search1").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("search1").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        assertSearch(jsonObject);
    }

    @Test
    public void search2(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.SEARCH);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("search2").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("search2").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        assertSearch(jsonObject);
    }

    @Test
    public void search3(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.SEARCH);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("search3").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("search3").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        assertSearch(jsonObject);
    }

    @Test
    public void search4(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.SEARCH);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("search4").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("search4").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        assertSearch(jsonObject);
    }

    @Test
    public void search5(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.SEARCH);
        String response = HttpUtil.doPostJson(url, Constants.TEST_CASE.get("search5").get(4).toString(), Constants.SESSIONID);
        Constants.TEST_CASE.get("search5").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        assertSearch(jsonObject);
    }

    private void assertSearch(JSONObject jsonObject){
        int total = jsonObject.getJSONObject("data").getIntValue("total");
        Assert.assertNotNull(total);
        Assert.assertNotNull(jsonObject.getJSONObject("data").getIntValue("onlineTotal"));
        if (total > 0){
            JSONArray list = jsonObject.getJSONObject("data").getJSONArray("list");
            Assert.assertNotNull(list);
            for (int i=0; i<list.size(); i++){
                JSONObject veh = list.getJSONObject(i);
                Assert.assertNotNull(veh.get("vin"));
                Assert.assertNotNull(veh.get("onlineStatus"));
                Assert.assertNotNull(veh.get("favor"));
                Assert.assertEquals(veh.containsKey("licensePlate"), true);
                Assert.assertEquals(veh.containsKey("vendor"), true);
                Assert.assertEquals(veh.containsKey("operationCity"), true);
                Assert.assertEquals(veh.containsKey("operatingUnit"), true);
                Assert.assertEquals(veh.containsKey("city"), true);
                Assert.assertEquals(veh.containsKey("vehProperty"), true);
                Assert.assertEquals(veh.containsKey("vehModelNo"), true);

            }
        }
    }
}
