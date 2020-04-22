# 考勤管理系统
一个简单的考勤管理系统。

## 框架
- 服务器: apache tomcat
- 数据库: mysql
- 后端: spring-boot+mybatis
- 前端: bootstrap+vue.js

## 访问地址
[访问地址](http://localhost:8080/login)

## 测试账户
用户名：`root` 密码：`root` 权限：超级管理员
## 说明
用户名即邮箱，可以通过增加员工来增加账户。不同权限开放不能功能，进入软件后查看。

## 配置
- 通过终端进入mysql `./mysql -u用户名 -p`
- 建立mysql数据库`luda`
- `source /path/to/luda.sql` (sql文件在项目里)
## 部署方式(需要Maven插件)
- cd 到 deploy 目录下
- 输入./build.sh 参数对应不同的环境
- 访问localhost的8888端口运行
- 如果是本地测试，注意将数据库用户名改为root，密码改为root