### 0X00 用户登录
#### method post
#### url api/User/login

#### get

* field:name  
    + 用户名
* field:password  
    + 密码

#### return

```
{
    "status": "success",
    "name": "小智e",
    "id": "8"
}

{
    "status": "faile"
}

```



### 0X01 用户注册
#### method post
#### url api/User

#### get

* field:name  
    + 用户名
* field:password  
    + 密码
* field:phone  
    + 电话号码
* field:level  
    + 用户类型

#### return
```
{
    "id": 8,
    "name": "小智e",
    "password": "asdfghjkl",
    "phone": "13098765432",
    "level": 1,
    "status": 1
}
```

### 0X02 用户信息修改
#### method put
#### url api/User

#### get
* field:id  
    + 用户id
* field:name  
    + 用户名
* field:password  
    + 密码
* field:phone  
    + 电话号码
* field:level  
    + 用户类型

#### return
```
{
    "id": 8,
    "name": "小智e",
    "password": "asdfghjkl",
    "phone": "13098765432",
    "level": 1,
    "status": 1
}
```
### 0X03 删除用户
#### method DELETE
#### url api/User/{id}

#### get
* field:id  
    + 用户id



### 0X04 获取特定用户信息
#### method get
#### url api/User/{id}

#### get
* field:id  
    + 用户id

#### return 

```
{
    "id": 2,
    "name": "维尼熊",
    "password": "wuduozhi",
    "phone": "12345678901",
    "level": 1,
    "status": 1
}
```

### 0X05 获取用户列表
#### method get
#### url api/User

#### get
* field:page
    + 页码数(default 0)
* field:size
    + 用户个数(defult 10)
    

#### return 

```
[
    {
        "id": 2,
        "name": "维尼熊",
        "password": "wuduozhi",
        "phone": "12345678901",
        "level": 1,
        "status": 1
    },
    {
        "id": 3,
        "name": "吴多智e",
        "password": "wuduozhi",
        "phone": "13098921645",
        "level": 3,
        "status": 1
    },
    {
        "id": 4,
        "name": "维尼熊",
        "password": "wuduozhi",
        "phone": "12345678901",
        "level": 1,
        "status": 1
    },
    {
        "id": 8,
        "name": "小智e",
        "password": "asdfghjkl",
        "phone": "13098765432",
        "level": 1,
        "status": 1
    }
]
```


### 0X06 报修添加
#### method post
#### url api/Report

#### get

* field:kind  
    + 种类
* field:area  
    + 报修人地区
* field:name  
    + 报修人姓名
* field:company  
    + 报修人单位
* field:department 
    + 报修人部门
* field:phone 
    + 报修人电话
* field:address  
    + 报修人地址
* field:staff  
    + 选择的维修人
* field:description 
    + 描述


#### return
```
{
    "id": 5,
    "kind": "笔记本",
    "area": "海南省",
    "name": "小智",
    "company": "小鱼科技",
    "department": "技术部",
    "phone": "1234876509",
    "address": "馃子街后巷天桥附近",
    "staff": "李国",
    "description": "不能联网",
    "status": 1
}
```

### 0X07 报修修改
#### method put
#### url api/Report

#### get
* field：id
    + id
* field:kind  
    + 种类
* field:area  
    + 报修人地区
* field:name  
    + 报修人姓名
* field:company  
    + 报修人单位
* field:department 
    + 报修人部门
* field:phone 
    + 报修人电话
* field:address  
    + 报修人地址
* field:staff  
    + 选择的维修人
* field:description 
    + 描述


#### return
```
{
    "id": 5,
    "kind": "笔记本",
    "area": "海南省",
    "name": "小智",
    "company": "小鱼科技",
    "department": "技术部",
    "phone": "1234876509",
    "address": "馃子街后巷天桥附近",
    "staff": "李国",
    "description": "不能联网",
    "status": 1
}
```

### 0X08 报修删除
#### method DELETE
#### url api/Report/{id}

#### get
* field:id  
    + 报修信息id
    

### 0X09 获取特定报修信息
#### method get
#### url api/Report/{id}

#### get
* field:id  
    + 报修id

#### return 

```
{
    "id": 7,
    "kind": "笔记本",
    "area": "海南省",
    "name": "小智",
    "company": "小鱼科技",
    "department": "技术部",
    "phone": "1234876509",
    "address": "馃子街后巷天桥附近",
    "staff": "李国",
    "description": "不能联网",
    "status": 1
}
```

### 0X0A 获取报修列表
#### method get
#### url api/Report

#### get
* field:page
    + 页码数(default 0)
* field:size
    + 用户个数(defult 10)
    

#### return 

```
[
    {
        "id": 1,
        "kind": "计算机",
        "area": "海南省",
        "name": "吴多智",
        "company": "湖南大学",
        "department": "信科院",
        "phone": "13098921645",
        "address": "海南省海口市",
        "staff": "张三",
        "description": "装系统配环境",
        "status": 1
    },
    {
        "id": 4,
        "kind": "笔记本",
        "area": "海南省",
        "name": "小智",
        "company": "小鱼科技",
        "department": "技术部",
        "phone": "1234876509",
        "address": "馃子街后巷",
        "staff": "李国",
        "description": "不能联网",
        "status": 1
    },
    {
        "id": 5,
        "kind": "笔记本",
        "area": "海南省",
        "name": "小智",
        "company": "小鱼科技",
        "department": "技术部",
        "phone": "1234876509",
        "address": "馃子街后巷天桥附近",
        "staff": "李国",
        "description": "不能联网",
        "status": 1
    },
    {
        "id": 6,
        "kind": "笔记本",
        "area": "海南省",
        "name": "小智",
        "company": "小鱼科技",
        "department": "技术部",
        "phone": "1234876509",
        "address": "馃子街后巷天桥附近",
        "staff": "李国",
        "description": "不能联网",
        "status": 1
    },
    {
        "id": 7,
        "kind": "笔记本",
        "area": "海南省",
        "name": "小智",
        "company": "小鱼科技",
        "department": "技术部",
        "phone": "1234876509",
        "address": "馃子街后巷天桥附近",
        "staff": "李国",
        "description": "不能联网",
        "status": 1
    }
]

```

### 0X0B 维修添加
#### method post
#### url api/Repair

#### get

* field:good  
    + 维修对象
* field:operation  
    + 操作描述
* field:do_time
    + Date类型 
    + 维修时间
* field:time
    + Date类型  
    + 报修时间

#### return
```
{
    "id": 8,
    "number": "123456789",
    "good": "计算机",
    "operation": "装系统配环境帮忙联网",
    "status": 1,
    "do_time": "2018-02-19",
    "time": "2018-02-19"
}
```
### 0X0C 维修修改
#### method put
#### url api/Repair

#### get
* field:id
    + id
* field:good  
    + 维修对象
* field:operation  
    + 操作描述
* field:do_time
    + Date类型 
    + 维修时间
* field:time
    + Date类型  
    + 报修时间

#### return
```
{
    "id": 8,
    "number": "123456789",
    "good": "计算机",
    "operation": "装系统配环境帮忙联网",
    "status": 1,
    "do_time": "2018-02-19",
    "time": "2018-02-19"
}
```


### 0X0D 维修删除
#### method DELETE
#### url api/Repair/{id}

#### get
* field:id  
    + 报修信息id

### 0X0E 获取特定维修信息
#### method get
#### url api/Repair/{id}

#### get
* field:id  
    + 报修id

#### return 

```
{
    "id": 8,
    "number": "123456789",
    "good": "计算机",
    "operation": "装系统配环境帮忙联网",
    "status": 1,
    "do_time": "2018-02-19",
    "time": "2018-02-19"
}
```

### 0X0E 获取维修列表
#### method get
#### url api/Repair

#### get
* field:page
    + 页码数(default 0)
* field:size
    + 用户个数(defult 10)
    

#### return 

```
[
    {
        "id": 1,
        "number": "123456789",
        "good": "计算机",
        "operation": "装系统配环境",
        "status": 1,
        "do_time": "2019-12-02",
        "time": "2017-12-08"
    },
    {
        "id": 3,
        "number": "123456789",
        "good": "计算机",
        "operation": "装系统、配环境",
        "status": 1,
        "do_time": "1970-01-02",
        "time": "2017-12-08"
    },
    {
        "id": 4,
        "number": "123456789",
        "good": "计算机",
        "operation": "装系统、配环境",
        "status": 1,
        "do_time": "1970-01-02",
        "time": "2018-02-27"
    },
    {
        "id": 5,
        "number": "123456789",
        "good": "计算机",
        "operation": "装系统、配环境",
        "status": 1,
        "do_time": "1970-01-02",
        "time": "1970-01-02"
    },
    {
        "id": 6,
        "number": "123456789",
        "good": "计算机",
        "operation": "装系统、配环境",
        "status": 1,
        "do_time": "1970-01-02",
        "time": "1970-01-02"
    },
    {
        "id": 8,
        "number": "123456789",
        "good": "计算机",
        "operation": "装系统配环境帮忙联网",
        "status": 1,
        "do_time": "2018-02-19",
        "time": "2018-02-19"
    }
]
```



### 0X0F 公告添加
#### method post
#### url api/Notice

#### get
* field:message
    + 公告内容

#### return
```
{
    "id": 6,
    "repair_id": null,
    "user_id": null,
    "message": "众所周知，Java是面向对象的世界，但数据库不是，现在的主流数据库大多都是关系型数据库。Java的对象想要进入数据库，就必须遵守数据库的“关系”规范，变成一条条的“记录”，数据库中的记录要变成Java中的对象，也同样需要有一个变身的过程—-繁琐的过程。通过SQL这个关系世界的魔法，我们建立起了“面向世界的世界”和“面向关系的世界”的桥梁。",
    "status": 1,
    "time": "2018-03-01"
}
```

### 0X10 公告修改
#### method put
#### url api/Notice

#### get
* field:message
    + 公告内容
* field:id
    + 公告id


#### return
```
{
    "id": 6,
    "repair_id": null,
    "user_id": null,
    "message": "众所周知，Java是面向对象的世界，但数据库不是，现在的主流数据库大多都是关系型数据库。Java的对象想要进入数据库，就必须遵守数据库的“关系”规范，变成一条条的“记录”，数据库中的记录要变成Java中的对象，也同样需要有一个变身的过程—-繁琐的过程。通过SQL这个关系世界的魔法，我们建立起了“面向世界的世界”和“面向关系的世界”的桥梁。",
    "status": 1,
    "time": "2018-03-01"
}
```


### 0X11 公告删除
#### method delete
#### url api/Notice

#### get
* field:id
    + 公告id

### 0X12 获取特定公告信息
#### method get
#### url api/Notice/{id}

#### get
* field:id  
    + 公告id

#### return 

```
{
    "id": 6,
    "repair_id": null,
    "user_id": null,
    "message": "众所周知，Java是面向对象的世界，但数据库不是，现在的主流数据库大多都是关系型数据库。Java的对象想要进入数据库，就必须遵守数据库的“关系”规范，变成一条条的“记录”，数据库中的记录要变成Java中的对象，也同样需要有一个变身的过程—-繁琐的过程。通过SQL这个关系世界的魔法，我们建立起了“面向世界的世界”和“面向关系的世界”的桥梁。",
    "status": 1,
    "time": "2018-03-01"
}
```


### 0X13 获取公告列表
#### method get
#### url api/Notice

#### get
* field:page
    + 页码数(default 0)
* field:size
    + 用户个数(defult 10)

#### return
```
[
    {
        "id": 2,
        "repair_id": null,
        "user_id": null,
        "message": "哈哈，简单点说，就是我们只需要找到我们想要操作的文件的路径，就能定位到它，就能对其进行一些列的操作，比如查看、复制、删除…这些操作，Java都已经为我们准备好了，需要用的时候查看文档就好了，最主要的是要记住步骤。",
        "status": 1,
        "time": "2017-09-02"
    },
    {
        "id": 3,
        "repair_id": null,
        "user_id": null,
        "message": "哈哈，简单点说，就是我们只需要找到我们想要操作的文件的路径，就能定位到它，就能对其进行一些列的操作，比如查看、复制、删除…",
        "status": 1,
        "time": "2017-09-02"
    },
    {
        "id": 4,
        "repair_id": null,
        "user_id": null,
        "message": "哈哈，简单点说，就是我们只需要找到我们想要操作的文件的路径，就能定位到它，就能对其进行一些列的操作，比如查看、复制、删除…",
        "status": 1,
        "time": "2017-09-02"
    },
    {
        "id": 5,
        "repair_id": null,
        "user_id": null,
        "message": "众所周知，Java是面向对象的世界，但数据库不是，现在的主流数据库大多都是关系型数据库。Java的对象想要进入数据库，就必须遵守数据库的“关系”规范，变成一条条的“记录”，数据库中的记录要变成Java中的对象，也同样需要有一个变身的过程—-繁琐的过程。通过SQL这个关系世界的魔法，我们建立起了“面向世界的世界”和“面向关系的世界”的桥梁。",
        "status": 1,
        "time": "2017-09-02"
    },
    {
        "id": 6,
        "repair_id": null,
        "user_id": null,
        "message": "众所周知，Java是面向对象的世界，但数据库不是，现在的主流数据库大多都是关系型数据库。Java的对象想要进入数据库，就必须遵守数据库的“关系”规范，变成一条条的“记录”，数据库中的记录要变成Java中的对象，也同样需要有一个变身的过程—-繁琐的过程。通过SQL这个关系世界的魔法，我们建立起了“面向世界的世界”和“面向关系的世界”的桥梁。",
        "status": 1,
        "time": "2018-03-01"
    }
]
```
