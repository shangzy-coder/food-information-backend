# Submachine Backend Project

## 项目简介

Submachine 是一个基于 Spring Boot 3.4.7 的现代化企业级后端脚手架项目，采用模块化架构设计，提供完整的企业应用开发解决方案。项目集成了用户管理、权限控制、系统监控、代码生成、任务调度等核心功能模块。

## 技术栈

### 核心框架
- **Spring Boot**: 3.4.7
- **Java**: 17
- **Maven**: 依赖管理和项目构建

### 数据库相关
- **MyBatis Plus**: 3.5.12 - ORM 框架
- **MySQL**: 主要数据库（支持 MySQL Connector）
- **DM Database**: 达梦数据库支持
- **P6Spy**: 3.9.1 - SQL 监控
- **Dynamic DataSource**: 4.3.1 - 动态数据源

### 安全认证
- **Sa-Token**: 1.44.0 - 权限认证框架
- **JustAuth**: 1.16.7 - 第三方登录
- **Bouncycastle**: 1.80 - 加密算法

### 缓存和队列
- **Redis**: 缓存支持
- **Redisson**: 3.50.0 - Redis 客户端
- **Lock4j**: 2.2.7 - 分布式锁

### 工具库
- **Hutool**: 5.8.38 - Java 工具类库
- **MapStruct Plus**: 1.4.8 - 对象映射
- **Lombok**: 1.18.36 - 代码生成
- **Velocity**: 2.3 - 模板引擎

### 监控和文档
- **Spring Boot Admin**: 3.4.7 - 应用监控
- **SpringDoc**: 2.8.8 - API 文档
- **IP2Region**: 2.7.0 - IP 地址定位

### 其他组件
- **SnailJob**: 1.5.0 - 任务调度
- **Warm Flow**: 1.7.4 - 工作流引擎
- **SMS4J**: 3.3.4 - 短信服务
- **AWS SDK**: 2.28.22 - 对象存储

## 项目结构

```
submachine/
├── admin-web/                 # Web 服务入口模块
│   ├── src/main/java/        # 主应用程序代码
│   ├── src/main/resources/   # 配置文件
│   └── Dockerfile           # Docker 构建文件
├── modules/                  # 业务功能模块
│   ├── system/              # 系统管理模块
│   ├── job/                 # 任务调度模块
│   ├── generator/           # 代码生成器模块
│   └── demo/                # 演示模块
├── common-framework/         # 公共框架组件
│   ├── common-core/         # 核心工具类
│   ├── common-web/          # Web 相关组件
│   ├── common-security/     # 安全认证组件
│   ├── common-mybatis/      # 数据库组件
│   ├── common-redis/        # 缓存组件
│   ├── common-oss/          # 对象存储组件
│   ├── common-sms/          # 短信服务组件
│   ├── common-mail/         # 邮件服务组件
│   ├── common-excel/        # Excel 处理组件
│   ├── common-doc/          # 文档生成组件
│   ├── common-log/          # 日志组件
│   ├── common-json/         # JSON 处理组件
│   ├── common-encrypt/      # 加密组件
│   ├── common-sensitive/    # 敏感数据组件
│   ├── common-ratelimiter/  # 限流组件
│   ├── common-idempotent/   # 幂等组件
│   ├── common-tenant/       # 多租户组件
│   ├── common-translation/  # 翻译组件
│   ├── common-social/       # 社交登录组件
│   ├── common-sse/          # 服务端推送组件
│   ├── common-websocket/    # WebSocket 组件
│   └── common-satoken/      # Sa-Token 集成组件
└── extend-app/              # 扩展应用
    ├── monitor-admin/       # 监控管理应用
    └── snailjob-server/     # 任务调度服务器
```

## 核心功能模块

### 1. 系统管理模块 (System)
- **用户管理**: 用户信息维护、角色分配
- **角色管理**: 角色权限配置
- **菜单管理**: 系统菜单配置
- **部门管理**: 组织架构管理
- **岗位管理**: 职位信息管理
- **字典管理**: 系统字典配置
- **参数配置**: 系统参数设置
- **通知公告**: 系统消息管理
- **文件管理**: 文件上传下载
- **客户端管理**: API 客户端配置
- **租户管理**: 多租户支持
- **社交登录**: 第三方登录集成

### 2. 系统监控模块 (Monitor)
- **在线用户**: 实时用户监控
- **登录日志**: 用户登录记录
- **操作日志**: 系统操作审计
- **缓存监控**: Redis 缓存状态

### 3. 任务调度模块 (Job)
- 基于 SnailJob 的分布式任务调度
- 支持 Cron 表达式定时任务
- 任务执行状态监控

### 4. 代码生成器模块 (Generator)
- 数据库表结构解析
- 自动生成 Controller、Service、Mapper、Entity
- 支持自定义模板
- 前后端代码一键生成

### 5. 演示模块 (Demo)
- 提供各种功能的示例代码
- 最佳实践展示

## 环境要求

- **JDK**: 17+
- **Maven**: 3.6+
- **MySQL**: 5.7+ 或 8.0+
- **Redis**: 4.0+

## 快速开始

### 1. 克隆项目
```bash
git clone [项目地址]
cd submachine
```

### 2. 数据库配置
1. 创建 MySQL 数据库
2. 修改 `admin-web/src/main/resources/application-dev.yml` 中的数据库连接配置
3. 执行数据库初始化脚本

### 3. Redis 配置
修改配置文件中的 Redis 连接信息：
```yaml
spring:
  data:
    redis:
      host: localhost
      port: 6379
      password: # Redis 密码
```

### 4. 编译项目
```bash
mvn clean compile
```

### 5. 运行项目
```bash
# 开发环境
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# 或直接运行主类
java -jar admin-web/target/admin-web.jar
```

### 6. 访问应用
- 应用地址: http://localhost:8080
- API 文档: http://localhost:8080/doc.html
- 监控中心: 根据配置访问 Spring Boot Admin

## Docker 部署

### 构建镜像
```bash
# 编译项目
mvn clean package -Dmaven.test.skip=true

# 构建 Docker 镜像
cd admin-web
docker build -t submachine:latest .
```

### 运行容器
```bash
docker run -d \
  --name submachine \
  -p 8080:8080 \
  -p 28080:28080 \
  -e JAVA_OPTS="-Xmx512m" \
  submachine:latest
```

## 配置说明

### 多环境配置
项目支持多环境配置，通过 Maven Profile 切换：
- **local**: 本地开发环境
- **dev**: 开发环境（默认）
- **prod**: 生产环境

### 主要配置项
- **服务端口**: 默认 8080
- **数据库连接**: 支持 MySQL、达梦数据库
- **Redis 配置**: 缓存和会话存储
- **文件存储**: 支持本地存储和云存储
- **验证码**: 支持数学计算和字符验证码
- **多租户**: 可选的多租户功能

## API 文档

项目集成了 SpringDoc，启动后可访问：
- Swagger UI: `/doc.html`
- OpenAPI 规范: `/v3/api-docs`

## 开发指南

### 1. 添加新模块
1. 在 `modules` 目录下创建新模块
2. 在根 `pom.xml` 中添加模块声明
3. 在 `admin-web` 中添加模块依赖

### 2. 使用代码生成器
1. 访问代码生成器页面
2. 选择数据库表
3. 配置生成选项
4. 一键生成代码

### 3. 自定义组件
项目提供了丰富的 common 组件，可根据需要选择使用。

## 监控和运维

### 应用监控
- 集成 Spring Boot Admin 监控应用状态
- 支持健康检查、指标监控
- 日志查看和管理

### 日志管理
- 使用 Logback 日志框架
- 支持日志级别动态调整
- 日志文件自动归档

### 性能优化
- 支持 Redis 缓存
- 数据库连接池优化
- 静态资源压缩

## 安全特性

- **认证授权**: 基于 Sa-Token 的权限控制
- **密码加密**: BCrypt 密码加密
- **接口限流**: 基于 Redis 的接口限流
- **XSS 防护**: 输入输出过滤
- **SQL 注入防护**: MyBatis 参数化查询
- **CSRF 防护**: 跨站请求伪造防护

## 贡献指南

1. Fork 项目
2. 创建特性分支
3. 提交代码变更
4. 推送到分支
5. 创建 Pull Request

## 许可证

本项目基于 [许可证名称] 开源协议，详见 LICENSE 文件。

## 联系方式

- 项目维护者: Zhao Yun
- 技术支持: [联系方式]

## 更新日志

### v1.0.2.RELEASE
- 升级 Spring Boot 到 3.4.7
- 优化系统性能
- 修复已知问题
- 增加新功能特性

---

> **注意**: 本项目为企业级脚手架，建议在生产环境使用前进行充分测试和安全评估。