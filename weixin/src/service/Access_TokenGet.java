package service;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
 


import util.HttpUtils;
import net.sf.json.JSONObject;
 
 
/**
 * ClassName: WeChatTask
 * @Description: 微信两小时定时任务体
 * @author dapengniao
 * @date 2016年3月10日 下午1:42:29
 */
public class Access_TokenGet {
    /**
     * @Description: 任务执行体
     * @param @throws Exception
     * @author dapengniao
     * @date 2016年3月10日 下午2:04:37
     */
    public void getToken_getTicket() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credential");
        params.put("secret", "373d4f2bf9641ac3e669d8edc10e97e7");
        params.put("appid", "wx7559f2546d6acfe1");
//        params.put("secret", "0c2b901920ed426d3c94b13db32aff4b");
//        params.put("appid", "wxcb56da6a7ea87135");
        String jstoken = HttpUtils.sendGet(
                "https://api.weixin.qq.com/cgi-bin/token", params);
        String access_token = JSONObject.fromObject(jstoken).getString(
                "access_token"); // 获取到token并赋值保存
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token为=============================="+access_token);
    }
 
}