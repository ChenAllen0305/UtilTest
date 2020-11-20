package HttpTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SendHttpRequest {
    /**
     * post请求方法
     * @param url 请求地址
     * @param params  参数
     * @return
     */
//    public static String sendPost(String url, Map<String,Object> params) {
//        String response = null;
//        try {
//            List<BasicNameValuePair> pairs = null;
//            if (params != null && !params.isEmpty()) {
//                pairs = new ArrayList<>(params.size());
//                for (String key : params.keySet()) {
//                    pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
//                }
//            }
//            CloseableHttpClient httpclient = null;
//            CloseableHttpResponse httpresponse = null;
//            try {
//                httpclient = HttpClients.createDefault();
//                HttpPost httppost = new HttpPost(url);
//                // StringEntity stringentity = new StringEntity(data);
//                if (pairs != null && pairs.size() > 0) {
//                    httppost.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
//                }
//                httpresponse = httpclient.execute(httppost);
//                response = EntityUtils.toString(httpresponse.getEntity());
//            } finally {
//                if (httpclient != null) {
//                    httpclient.close();
//                }
//                if (httpresponse != null) {
//                    httpresponse.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return response;
//    }



    /**
     * get请求方法
     * @param url 地址
     * @param param 参数，格式name=韦小宝&age=12，中文必须通过URLEncoder.encode()进行转义
     * @return
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlName = "";
            if (param.length() != 0) {
                urlName = url + "?" + param;
            } else {
                urlName = url;
            }
            URL resUrl = new URL(urlName);
            URLConnection urlConnec = resUrl.openConnection();
            urlConnec.setRequestProperty("accept", "*/*");
            urlConnec.setRequestProperty("connection", "Keep-Alive");
            urlConnec.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            urlConnec.connect();
            Map<String, List<String>> map = urlConnec.getHeaderFields();
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(urlConnec.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送get请求失败" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //post请求测试
      /*  Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","韦小宝");
        map.put("age",120);
        String resultPost = sendPost("http://localhost:8080/ModelTest1/test/getUserPost",map);
        System.out.println(resultPost);*/

        //get请求测试
        String name;
        try {
            //因为是中文  所以需要转义
            name = URLEncoder.encode("工厂","utf-8");
            String resultGet = sendGet("http://localhost:8080/ModelTest1/test/getUserGet","name="+name+"&age=1");
            System.out.println(resultGet);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
