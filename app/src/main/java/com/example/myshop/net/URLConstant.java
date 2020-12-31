package com.example.myshop.net;

public class URLConstant {
    //首页
    public static String BASEURL = "https://cdwan.cn/";
    public static String NEWDATA = BASEURL + "api/index";

    //    https://cdwan.cn/api/topic/list?page=1&size=10  专题
    public static String SPECIAL = BASEURL + "api/topic/list?page=1";
    public static String SPECIAL2 = BASEURL + "api/topic/list?page=2";

    //    https://cdplay.cn/api/catalog/index?id=1005000
    public static String INDEX = BASEURL + "api/catalog/index?id=1005000";


    //    https://cdwan.cn/api/catalog/current?id=1005000
    public static String CURRENT = BASEURL + "api/catalog/current?id=";


}
