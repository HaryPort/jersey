package com.dream;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 发送图片到另一台到Tomcat服务器
 *
 * @author Harry
 */
public class JerseyDemo {

    public static void main(String[] args) {
        //实例化Jersey
        Client client = new Client();

        //另一台服务器的请求
        String url = "http://localhost:8088/image-web/upload/abc.jpg";

        //设置请求路径
        WebResource resource = client.resource(url);

        //本地路径
        String path = "D:\\照片\\100CASIO\\abc.jpg";

        //将文件读取到内存中
        byte[] bytes = null;
        try {
            bytes = FileUtils.readFileToByteArray(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //发送开始: POST GET, 基于PUT 提交
        resource.put(String.class, bytes);

        System.out.println("发送完毕");
    }
}
