# 构建阶段
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# 复制根 pom 文件
COPY pom.xml .

# 复制所有模块的 pom 文件（利用 Docker 缓存层）
COPY admin-web/pom.xml admin-web/
COPY common-framework/pom.xml common-framework/
COPY extend-app/pom.xml extend-app/
COPY modules/pom.xml modules/

# 复制 common-framework 子模块的 pom 文件
COPY common-framework/common-bom/pom.xml common-framework/common-bom/
COPY common-framework/common-core/pom.xml common-framework/common-core/
COPY common-framework/common-doc/pom.xml common-framework/common-doc/
COPY common-framework/common-encrypt/pom.xml common-framework/common-encrypt/
COPY common-framework/common-excel/pom.xml common-framework/common-excel/
COPY common-framework/common-idempotent/pom.xml common-framework/common-idempotent/
COPY common-framework/common-job/pom.xml common-framework/common-job/
COPY common-framework/common-json/pom.xml common-framework/common-json/
COPY common-framework/common-log/pom.xml common-framework/common-log/
COPY common-framework/common-mail/pom.xml common-framework/common-mail/
COPY common-framework/common-mybatis/pom.xml common-framework/common-mybatis/
COPY common-framework/common-oss/pom.xml common-framework/common-oss/
COPY common-framework/common-ratelimiter/pom.xml common-framework/common-ratelimiter/
COPY common-framework/common-redis/pom.xml common-framework/common-redis/
COPY common-framework/common-satoken/pom.xml common-framework/common-satoken/
COPY common-framework/common-security/pom.xml common-framework/common-security/
COPY common-framework/common-sensitive/pom.xml common-framework/common-sensitive/
COPY common-framework/common-sms/pom.xml common-framework/common-sms/
COPY common-framework/common-social/pom.xml common-framework/common-social/
COPY common-framework/common-sse/pom.xml common-framework/common-sse/
COPY common-framework/common-tenant/pom.xml common-framework/common-tenant/
COPY common-framework/common-translation/pom.xml common-framework/common-translation/
COPY common-framework/common-web/pom.xml common-framework/common-web/
COPY common-framework/common-websocket/pom.xml common-framework/common-websocket/

# 复制 extend-app 子模块的 pom 文件
COPY extend-app/monitor-admin/pom.xml extend-app/monitor-admin/
COPY extend-app/snailjob-server/pom.xml extend-app/snailjob-server/

# 复制 modules 子模块的 pom 文件
COPY modules/demo/pom.xml modules/demo/
COPY modules/generator/pom.xml modules/generator/
COPY modules/job/pom.xml modules/job/
COPY modules/system/pom.xml modules/system/

# 下载依赖（利用 Docker 缓存）
RUN mvn dependency:go-offline -B

# 复制源代码
COPY . .

# 构建项目
RUN mvn clean package -DskipTests

# 运行阶段
FROM bellsoft/liberica-openjdk-rocky:17.0.16-cds

WORKDIR /app

# 复制构建好的 JAR 文件
COPY --from=builder /app/admin-web/target/*.jar app.jar

# 创建日志目录
RUN mkdir -p /app/logs

# 健康检查 - 使用wget (通常在最小化镜像中可用) 或简单的端口检查
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/actuator/health || \
      (echo > /dev/tcp/localhost/8080) 2>/dev/null || exit 1

# 暴露端口
EXPOSE 8080

# 启动应用
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:-dev}", "app.jar"]
