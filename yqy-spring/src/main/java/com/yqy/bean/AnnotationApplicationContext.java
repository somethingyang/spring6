package com.yqy.bean;

import com.yqy.anno.Bean;
import com.yqy.anno.Di;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Enumeration;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext {

    //创建map集合，存放bean对象
    private Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;

    /*
    返回对象
     */
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    /*
    设置包的扫描规则
    当前包及其自包，那个包有@Bean注解，就创建对象，存入map集合，把这个类通过反射实例化
     */
    public AnnotationApplicationContext(String basePackage){

        try {
            //1 把.替换成\
            String packagePath = basePackage.replaceAll("\\.", "\\\\");
            //2 获取包的绝对路径

            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");

                //字符串截取
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                //包扫描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //属性注入
        loadDi();


    }


    /**
     * 包扫描,对象实例化
     * @param file
     */
    private void loadBean(File file) throws Exception {
        //1 判断是否是文件夹
        if (file.isDirectory()) {
            //2 获取文件夹下的所有内容
            File[] childrenFiles = file.listFiles();

            //3 判断文件夹里是否有内容
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            //4 遍历所有内容
                //4.1 遍历每个file对象，继续判断，如果还是文件，递归
                //4.2 如果是class文件，获取类名，通过反射实例化对象，存入map集合

            for (File child : childrenFiles) {
                if (child.isDirectory()) {
                    loadBean(child);
                } else {
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                    if (pathWithClass.contains(".class")) {
                        String allName = pathWithClass.replaceAll("\\\\", ".")
                                .replace(".class", "");
                        Class<?> clazz = Class.forName(allName);
                        if (!clazz.isInterface()) {
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                //实例化对象
                                Object instance = clazz.getConstructor().newInstance();
                                //存入map集合
                                if (clazz.getInterfaces().length> 0) {
                                    beanFactory.put(clazz.getInterfaces()[0], instance);
                                } else {
                                    beanFactory.put(clazz, instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 属性注入
     */
    private void loadDi() {
        //1 实例化对象在beanFactory中，所以先遍历map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry : entries) {
           //2 获取map集合每个对象（value），每个对象属性获取到
            Object instance = entry.getValue();
            Class<?> clazz = instance.getClass();
            Field[] fields = clazz.getDeclaredFields();
            //3 遍历得到每个对象属性的数组，得到每个属性
            for (Field field : fields) {
                //4 判断属性上是否有@Di注解，如果是私有属性，设置属性可访问
                Di annotation = field.getAnnotation(Di.class);
                if (annotation != null) {
                    //5 如果有@Di注解，把对象进行注入
                    field.setAccessible(true);
                    try {
                        field.set(instance, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        pathDemo1("com.yqy");
    }
}
