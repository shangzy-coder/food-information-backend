FROM bellsoft/liberica-openjdk-rocky:17.0.16-cds

WORKDIR /app

# 复制应用JAR文件
COPY target/*.jar app.jar

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
