FROM bellsoft/liberica-openjdk-rocky:17.0.16-cds

WORKDIR /app

# 安装必要工具
RUN yum update -y && yum install -y curl && yum clean all

# 复制应用JAR文件
COPY target/*.jar app.jar

# 创建日志目录
RUN mkdir -p /app/logs

# 健康检查
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# 暴露端口
EXPOSE 8080

# 启动应用
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:-dev}", "app.jar"]
