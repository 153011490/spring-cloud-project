package com.lrh.springcloud.entities.common;

public class ResponseCode {
    public static final Integer OK = 200; //现有资源已被更改
    public static final Integer CREATED = 201; //现有资源已被更改
    public static final Integer ACCEPTED = 202; //已接受处理请求但尚未完成
    public static final Integer NO_CONTENT = 204; //无返回数据
    public static final Integer SEE_OTHER = 303; //负载均衡
    public static final Integer BAD_REQUEST = 400; //用户发送的错误请求
    public static final Integer UNAUTHORIZED = 401; //用户没有权限
    public static final Integer FORBIDDEN = 403; //访问禁止
    public static final Integer NOT_FOUND = 404; //资源不存在
    public static final Integer INTERNAL_SERVER_ERROR = 500; //通用错误响应
    public static final Integer NOT_IMPLEMENTED = 501; //暂未实现接口
}
