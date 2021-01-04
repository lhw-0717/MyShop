package com.example.myshop.net;

public class URLConstant {
    //首页
    public static String BASEURL = "https://cdwan.cn/";
    public static String BASEURL1 = "https://cdplay.cn/";
    public static String NEWDATA = BASEURL + "api/index";

    //    https://cdwan.cn/api/topic/list?page=1&size=10  专题
    public static String SPECIAL = BASEURL + "api/topic/list?page=";

    //    https://cdplay.cn/api/catalog/index?id=1005000
    public static String INDEX = BASEURL1 + "api/catalog/index?id=1005000";


    //    https://cdwan.cn/api/catalog/current?id=1005000
    public static String CURRENT = BASEURL + "api/catalog/current";

    //    https://cdplay.cn/api/auth/refreshToken
    public static String TOKEN = BASEURL1 + "api/auth/refreshToken";

//    https://cdplay.cn/api/auth/login
public static String LOGIN = BASEURL1 + "api/auth/login";


}
