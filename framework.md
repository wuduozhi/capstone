### 后端框架说明

* Jersey 
    - 负责http请求部分，及接受请求，返回相应
* Hibernate
    - 数据库ORM框架，负责项目的数据库部分

### 后端项目目录说明

* controller
    - 请求处理的类，负责处理前端发来的请求，处理相应的业务逻辑，返回相应
* model
    - 项目的model类，也就是数据库的表的对应的类，里面也包含了Hibernate的配置文件
* dao
    - 项目的数据库类，负责数据库的增删改查，给controller调用或service调用
* service
    - 一些比较负责的业务逻辑在这里实现，给controller调用
* app
    - jersey框架的配置类，负责请求的分发

### 一些重要的文件
* hibernate.cfg.xml
    - 数据库的配置文件，数据库的用户名、密码...




