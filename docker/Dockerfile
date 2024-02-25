# 使用轻量级的基础镜像
FROM openjdk:8-jre-alpine

# 安装字体，否则获取验证码报错
run sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
run apk add --update ttf-dejavu fontconfig

# 设置工作目录
WORKDIR /xiaofei/project-management-admin

# 复制jar文件到路径
COPY project-management-admin.jar .

# 设置Java虚拟机参数
ENV JAVA_OPTS="-Xmx128m -Duser.timezone=GMT+08"

# 启动应用程序【--spring.profiles.active=prod,pub / --spring.profiles.active=dev,pub】
CMD ["java", "-jar", "project-management-admin.jar", "--jasypt.encryptor.password=123", "--spring.profiles.active=prod,pub"]