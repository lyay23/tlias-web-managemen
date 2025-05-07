# JavaWeb之初体验 - tlias管理系统

这是一个 JavaWeb 项目，名为 tlias 智能教学管理系统，包含了 Spring Boot、MyBatis 等技术的使用，用于实现部门和员工等信息的管理。以下是项目的详细介绍和代码目录结构。

## 项目简介
该项目使用 Spring Boot 作为框架，结合 MyBatis 进行数据库操作，主要实现了部门信息的查询、员工信息的管理等功能。同时，项目配置了阿里云 OSS 用于文件存储，并且支持文件上传功能。OSS配置在了本地环境下

## 代码目录结构
```
JavaWebItheima/
├── .idea/
│   ├── compiler.xml             # 编译器配置文件
│   ├── encodings.xml            # 编码配置文件
│   ├── jarRepositories.xml      # Maven 仓库配置文件
│   ├── misc.xml                 # 项目杂项配置文件
│   ├── workspace.xml            # 工作区配置文件
│   └── dataSources/
│       └── 2166d4b7-ea0a-43bd-b117-9af97f83d73a.xml  # 数据源配置文件
├── pom.xml                      # 项目 Maven 配置文件
├── README.md                    # 项目说明文档
├── tlias-web-managemen/
│   ├── .idea/
│   │   ├── compiler.xml         # 子模块编译器配置文件
│   │   ├── encodings.xml        # 子模块编码配置文件
│   │   ├── misc.xml             # 子模块杂项配置文件
│   │   └── workspace.xml        # 子模块工作区配置文件
│   ├── pom.xml                  # 子模块 Maven 配置文件
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── itheima/
│   │   │   │           ├── controller/
│   │   │   │           │   
│   │   │   │           └── service/
│   │   │   │               └── impl/
│   │   │   │                   
│   │   │   └── resources/
│   │   │       └── application.yml  # 项目配置文件
│   │   └── test/
│   │       └── ...
│   └── target/
│       └── classes/
│           └── application.yml  # 编译后的项目配置文件
```

## 配置说明
### 数据库配置
在 `tlias-web-managemen/src/main/resources/application.yml` 文件中配置了数据库连接信息：需要更改自己的Mysql用户名密码依据数据库名称
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/tlias?useUnicode=true&characterEncoding=utf-8&useSSL=true
    username: root
    password: abc123 
```

### MyBatis 配置
同样在 `application.yml` 中配置了 MyBatis 的相关信息：
```yaml
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl  # 启用 MyBatis SQL 日志
    map-underscore-to-camel-case: true
```

### 阿里云 OSS 配置 需要更改为自己的
```yaml
aliyun:
  oss:
    endpoint: https://oss-cn-hangzhou.aliyuncs.com
    bucketName: sky-take-out039
    region: cn-hangzhou
```

## 参考链接
自己在实战阶段笔记代码以及零零碎碎的知识点：[https://lyay23.github.io/posts/37847/](https://lyay23.github.io/posts/37847/)
感觉对你有帮助请点亮start

