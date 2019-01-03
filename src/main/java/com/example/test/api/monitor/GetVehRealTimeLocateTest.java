package com.example.test.api.monitor;

import com.alibaba.fastjson.JSONObject;
import com.example.test.common.Constants;
import com.example.test.conf.MonitorInterfaceName;
import com.example.test.conf.UrlConfig;
import com.example.test.util.HttpUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetVehRealTimeLocateTest {

    @Test
    public void getVehRealTimeLocate1(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_REALTIME_LOCATE);
        String response = HttpUtil.doGet(url + Constants.TEST_CASE.get("getVehRealTimeLocate1").get(4).toString(), null, Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehRealTimeLocate1").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);

        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        Assert.assertNull(jsonObject.getJSONObject("data").get("lat"));
        Assert.assertNull(jsonObject.getJSONObject("data").get("lng"));
    }

    @Test
    public void getVehRealTimeLocate2(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_REALTIME_LOCATE);
        String response = HttpUtil.doGet(url + Constants.TEST_CASE.get("getVehRealTimeLocate2").get(4).toString(),null, Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehRealTimeLocate2").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        Assert.assertNotNull(jsonObject.getJSONObject("data").get("lat"));
        Assert.assertNotNull(jsonObject.getJSONObject("data").get("lng"));
    }

    @Test
    public void getVehRealTimeLocate3(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_REALTIME_LOCATE);
        String response = HttpUtil.doGet(url + Constants.TEST_CASE.get("getVehRealTimeLocate3").get(4).toString(),null, Constants.SESSIONID);
        Constants.TEST_CASE.get("getVehRealTimeLocate3").add(response);
        JSONObject jsonObject = JSONObject.parseObject(response);
        Assert.assertEquals(jsonObject.getIntValue("status"),200);
        Assert.assertNull(jsonObject.getJSONObject("data").get("lat"));
        Assert.assertNull(jsonObject.getJSONObject("data").get("lng"));
        //TODO 数据不存在时应该返回提示
    }

    @Test
    public void getVehRealTimeLocate4(){
        String url = UrlConfig.getMonitorUrl(MonitorInterfaceName.GET_VEH_REALTIME_LOCATE);
        CloseableHttpResponse response = HttpUtil.get(url + Constants.TEST_CASE.get("getVehRealTimeLocate4").get(4).toString(),null, Constants.SESSIONID);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),404);
    }
}
