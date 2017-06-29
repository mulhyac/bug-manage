package com.sunny.bugmanage.utils;

/**
 * @author sunny
 * @className com.sunny.bugmanage.utils.HttpHelperUtils
 * @date 2017-06-28 17:25
 * @description:
 */
public class HttpHelperUtils {


   /* public static JsonObject sendGet(String url) {
        HttpResponse response;
        BufferedReader reader = null;
        StringBuffer sbf;
        try {
            HttpGet request = new HttpGet(url);
            response = HttpClients.createDefault().execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String lines;
                sbf = new StringBuffer();
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), "utf-8");
                    sbf.append(lines);
                }
                return GsonUtils.getJsonObject(sbf.toString());
            } else {
                throw new BugManageException("GET请求异常");
            }

        } catch (Exception e) {
            throw new BugManageException(1, e);
        } 
    }*/

}
