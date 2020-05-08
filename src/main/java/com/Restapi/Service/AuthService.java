package com.Restapi.Service;

import com.Restapi.API;
import com.Restapi.HttpUtil;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Service
public class AuthService {

    /**
     * 获取权限token
     *
     * @return 返回示例：
     * {
     * "access_token": "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
     * "expires_in": 2592000
     * }
     */
    public String getAuth() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "YXA6tfoUMxu-QGSa2EJXZ-k3Yw";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "YXA6vevNmTW9wDxbV8QL38RHy_GGC-0";
        return getAuth(clientId, clientSecret);
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     *
     * @param ak - 获取的 API Key
     * @param sk - 获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    private static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = API.URL;
        try {
            JSONObject body = new JSONObject();
            body.put("grant_type", "client_credentials");
            body.put("client_id", ak);
            body.put("client_secret", sk);

            URL realUrl = new URL(authHost + "token");
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();

            //POST传参
            DataOutputStream os = new DataOutputStream(connection.getOutputStream());
            String content = String.valueOf(body);
            os.writeBytes(content);
            os.flush();
            os.close();

            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

    //注册IM用户
    public String Register(String userName,String password,String nickName){
        try{
            JSONObject body = new JSONObject();
            body.put("username", userName);
            body.put("password", password);
            body.put("nickname", nickName);

            //注册用户的URL
            URL realUrl = new URL(API.URL + "users");
            String url = String.valueOf(realUrl);
            String result = HttpUtil.post(url,this.getAuth(),body);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
