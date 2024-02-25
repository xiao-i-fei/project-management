# 系统部署验证码报错

## 服务器运行jar包字体安装

http://doc.ruoyi.vip/ruoyi/other/faq.html#linux%E7%B3%BB%E7%BB%9F%E9%AA%8C%E8%AF%81%E7%A0%81%E4%B9%B1%E7%A0%81%E8%A7%A3%E5%86%B3%E6%96%B9%E6%B3%95

## docker部署安装字体

> Dockerfile文件中添加下面两行，安装字体

```dockerfile
run sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
run apk add --update ttf-dejavu fontconfig
```