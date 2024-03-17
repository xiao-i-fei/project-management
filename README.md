# 项目介绍


<p align=center>
   基于Springboot + Vue 开发的前后端分离博客
</p>

[在线地址](#在线地址) | [项目特点](#项目特点) | [技术介绍](#技术介绍) | [运行环境](#运行环境) | [开发环境](#开发环境) | [项目部署](#项目部署)

## 在线地址

**项目链接：** [https://www.nastt.fun/](https://www.nastt.fun/)

测试账号：api_test，密码：api_test，可登入后台查看。

## 项目特点

- 使用echarts进行图标可视化展示，展示接口调用信息
- 采用Dubbo RPC远程服务框架，调用接口提供平台
- 使用nacos作为注册中心
- 采用docker进行系统部署
- 开发自定义starter，便于开发者快速集成接口平台，在客户端快速调用接口
- 支持动态权限修改，采用RBAC模型，前端菜单和后台权限实时更新。
- 代码遵循阿里巴巴开发规范，利于开发者学习。

## 技术介绍

**前端：** vue + vuex + vue-router + axios + element + echarts

**后端：** SpringBoot + nginx + docker + SpringSecurity + Swagger2 + MyBatisPlus + Mysql + Redis

## 运行环境

**服务器：** 腾讯云1核2G CentOS7.6

**对象存储：** 阿里云OSS

**最低配置：** 1核2G服务器（关闭ElasticSearch）

## 开发环境

| 开发工具                      | 说明              |
| ----------------------------- | ----------------- |
| IDEA                          | Java开发工具IDE   |
| VSCode                        | Vue开发工具IDE    |
| Navicat                       | MySQL远程连接工具 |
| Another Redis Desktop Manager | Redis远程连接工具 |
| X-shell                       | Linux远程连接工具 |
| Xftp                          | Linux文件上传工具 |

| 开发环境 | 版本   |
| -------- | ------ |
| JDK      | 1.8    |
| MySQL    | 8.0.20 |
| Redis    | 6.0.5  |



## 系统集成



### 源码下载

> **下载starter源代码：https://github.com/xiao-i-fei/customer-starter**

源代码下载后，使用 `mvn install`命令将源码安装到本地仓库中



### 依赖引入

```xml
<dependency>
    <groupId>com.xiaofei</groupId>
    <artifactId>api-client-sdk</artifactId>
    <version>1.0</version>
</dependency>
```



### 快速使用

> **在接口平台创建一个aksk**

```yml
api:
  info:
    gateway-url: 接口管理平台后台地址
    access-key: 
    secret-key: 
```



```java
@SpringBootTest
public class RedissonStudyApplicationTest {

    @Autowired
    private ApiClient apiClient;
    
    @Test
    public void apiTest(){
        // 使用提供的客户端，直接调用
        apiClient.selectRegionListTree();
    }
}

```





## 项目部署

### 系统部署验证码报错

服务器运行jar包字体安装

docker部署安装字体

> Dockerfile文件中添加下面两行，安装字体

```dockerfile
run sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
run apk add --update ttf-dejavu fontconfig
```