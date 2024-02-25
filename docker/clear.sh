#!/bin/bash
# 删除容器和镜像
docker rm -f project-management-admin
docker rmi project-management-admin

# 删除老的jar包和依赖
rm -rf project-management-admin.jar
rm -rf ./jar/*
