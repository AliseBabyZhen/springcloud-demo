一个订单服务
一个商品服务
用eureka来当注册中心进行服务提供和调用
订单去调用商品 商品可以提供多个服务 启动时更改端口即可
用fegin简化调用
用hystrix监控服务状态和进行服务不可用时熔断（弊端是每监控一个服务要更改一次请求端口）
换成用turbine同时监控多个服务，yml中指定配置文件即可。