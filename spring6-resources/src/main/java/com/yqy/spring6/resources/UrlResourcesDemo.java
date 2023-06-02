package com.yqy.spring6.resources;

import org.springframework.core.io.UrlResource;

/**
 * 演示UrlResources访问网路资源
 */
public class UrlResourcesDemo {
    public static void main(String[] args) {
        //http前缀
        loadUrlResources("http://www.baidu.com");

        //file前缀
        loadUrlResources("file:yqy.txt");
    }
    //访问http
    public static void loadUrlResources(String path) {
        try {
            //创建Resources接口的实现类UrlResources
            UrlResource url = new UrlResource(path);
            //获取资源的信息
            System.out.println(url.getFilename());
            System.out.println(url.getURL());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
