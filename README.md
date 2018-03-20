### 写在前面
* User level  1-admin  2-staff(维修员工) 3-user
* Report(报修) status 1-为修理  2-已经修理


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


### 0X06 报修分派
#### method post
#### url api/Report/staff


* field:id
    + 未处理报修id
* field:staff_id
    + 选择的维修人id


#### return
```
{
    "id": 16,
    "kind": "计算机",
    "area": "海南海口",
    "name": "小智e",
    "company": "湖南大学",
    "department": "天马",
    "phone": "1156",
    "address": "天马",
    "description": "电脑蓝屏了",
    "judge": null,
    "status": 1,
    "user": {
        "id": 172,
        "name": "用户1",
        "password": "123456",
        "phone": "13098921645",
        "level": 3,
        "status": 1
    },
    "staff": {     ||为该报修添加的维修人员
        "id": 173,
        "name": "修理工1",
        "password": "123456",
        "phone": "13098921645",
        "level": 2,
        "status": 1
    },
    "repair": null
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
    "case_id": 5,
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
* field:case_id
    + 报修信息case_id
    

### 0X09 获取特定报修信息
#### method get
#### url api/Report/{id}

#### get
* field:case_id
    + 报修case_id

#### return 

```
{
    "id": 15,
    "kind": "笔记本",
    "area": "长沙",
    "name": "小智e",
    "company": "湖南大学",
    "department": "学工部",
    "phone": "13098921645",
    "address": "天马",
    "description": "不能上网啦",
    "judge": "挺棒的，很好很好",
    "status": 1,
    "user": {
        "id": 1,
        "name": "吴多智e",
        "password": "wuduozhi",
        "phone": "13098921645",
        "level": 3,
        "status": 1
    },
    "staff": {     ||维修人员
        "id": 169,
        "name": "修理工",
        "password": "123456",
        "phone": "13098921645",
        "level": 2,
        "status": 1
    },
    "repair": {    || 对应的维修信息   还未维修为null
        "id": 16,
        "number": "123456789",
        "good": "计算机",
        "operation": "帮忙插网线",
        "remark": "网线都不连，怎么上网啊？？？？",
        "status": 1,
        "do_time": "2018-02-19",
        "time": "2018-02-19",
        "user": {
            "id": 169,
            "name": "修理工",
            "password": "123456",
            "phone": "13098921645",
            "level": 2,
            "status": 1
        },
        "report": null
    }
}
```

### 0X0A 获取报修列表
#### method get
####这个也要改一那个status
#### url api/Report

* field:page
    + 页码数(default 0)
* field:size
    + 用户个数(defult 10)
    

#### return 

```
[
    {
        "id": 16,
        "kind": "计算机",
        "area": "海南海口",
        "name": "小智e",
        "company": "湖南大学",
        "department": "天马",
        "phone": "1156",
        "address": "天马",
        "description": "电脑蓝屏了",
        "judge": null,
        "status": 1,
        "user": {
            "id": 172,
            "name": "用户1",
            "password": "123456",
            "phone": "13098921645",
            "level": 3,
            "status": 1
        },
        "staff": {
            "id": 173,
            "name": "修理工1",
            "password": "123456",
            "phone": "13098921645",
            "level": 2,
            "status": 1
        },
        "repair": null
    },
    {
        "id": 17,
        "kind": "计算机",
        "area": "海南海口",
        "name": "小智e",
        "company": "湖南大学",
        "department": "天马",
        "phone": "13098921645",
        "address": "天马",
        "description": "电脑死机了，蓝屏了，不能上网了",
        "judge": null,
        "status": 1,
        "user": {
            "id": 172,
            "name": "用户1",
            "password": "123456",
            "phone": "13098921645",
            "level": 3,
            "status": 1
        },
        "staff": null,
        "repair": null
    }
]

```

### 0X0B 获取待维修列表
#### method get
#### url api/Repair/manage
####给分配给维修人员之后，维修人员查看自己的待维修项目。直接按照报修的列表的格式返回就行，但是只返回repair_staff对应的报修项目，别人的项目就不要返回了。

#### return
```
[
    {
        "id": 16,
        "kind": "计算机",
        "area": "海南海口",
        "name": "小智e",
        "company": "湖南大学",
        "department": "天马",
        "phone": "1156",
        "address": "天马",
        "description": "电脑蓝屏了",
        "judge": null,
        "status": 1,
        "user": {
            "id": 172,
            "name": "用户1",
            "password": "123456",
            "phone": "13098921645",
            "level": 3,
            "status": 1
        },
        "staff": {
            "id": 173,
            "name": "修理工1",
            "password": "123456",
            "phone": "13098921645",
            "level": 2,
            "status": 1
        },
        "repair": null
    },
    {
        "id": 17,
        "kind": "计算机",
        "area": "海南海口",
        "name": "小智e",
        "company": "湖南大学",
        "department": "天马",
        "phone": "13098921645",
        "address": "天马",
        "description": "电脑死机了，蓝屏了，不能上网了",
        "judge": null,
        "status": 1,
        "user": {
            "id": 172,
            "name": "用户1",
            "password": "123456",
            "phone": "13098921645",
            "level": 3,
            "status": 1
        },
        "staff": {
            "id": 173,
            "name": "修理工1",
            "password": "123456",
            "phone": "13098921645",
            "level": 2,
            "status": 1
        },
        "repair": null
    }
]
```

### 0X0C 编辑维修状态
#### method post
#### url api/Repair
#### 维修人员根据分配给自己的待维修报修添加自己的维修

#### get
* field:report_id
    + 待维修报修id
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
* field:remark
    + 维修人员报告
#### return
```
{
    "id": 18,
    "number": "123456789",
    "good": "计算机",
    "operation": "帮忙插网线、清灰",
    "remark": "网线都不连，怎么上网啊？？？？",
    "status": 1,
    "do_time": "2018-02-19",
    "time": "2018-02-19",
    "user": {
        "id": 173,
        "name": "修理工1",
        "password": "123456",
        "phone": "13098921645",
        "level": 2,
        "status": 1
    },
    "report": null
}
```


### 0X0D 维修删除
#### method DELETE
#### url api/Repair/{case_id}

#### get
* field:case_id  
    + 报修信息case_id

### 0X0E 获取特定维修信息
#### method get
#### url api/Repair/{case_id}

#### get
* field:case_id  
    + 报修case_id

#### return 

```
{
    "id": 18,
    "number": "123456789",
    "good": "计算机",
    "operation": "帮忙插网线、清灰",
    "remark": "网线都不连，怎么上网啊？？？？",
    "status": 1,
    "do_time": "2018-02-19",
    "time": "2018-02-19",
    "user": {
        "id": 173,
        "name": "修理工1",
        "password": "123456",
        "phone": "13098921645",
        "level": 2,
        "status": 1
    },
    "report": {
        "id": 16,
        "kind": "计算机",
        "area": "海南海口",
        "name": "小智e",
        "company": "湖南大学",
        "department": "天马",
        "phone": "1156",
        "address": "天马",
        "description": "电脑蓝屏了",
        "judge": null,
        "status": 1,
        "user": {
            "id": 172,
            "name": "用户1",
            "password": "123456",
            "phone": "13098921645",
            "level": 3,
            "status": 1
        },
        "staff": null,
        "repair": null
    }
}
```

### 0X0E 获取报修列表
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
        "id": 18,
        "number": "123456789",
        "good": "计算机",
        "operation": "帮忙插网线、清灰",
        "remark": "网线都不连，怎么上网啊？？？？",
        "status": 1,
        "do_time": "2018-02-19",
        "time": "2018-02-19",
        "user": {
            "id": 173,
            "name": "修理工1",
            "password": "123456",
            "phone": "13098921645",
            "level": 2,
            "status": 1
        },
        "report": {
            "id": 16,
            "kind": "计算机",
            "area": "海南海口",
            "name": "小智e",
            "company": "湖南大学",
            "department": "天马",
            "phone": "1156",
            "address": "天马",
            "description": "电脑蓝屏了",
            "judge": null,
            "status": 1,
            "user": {
                "id": 172,
                "name": "用户1",
                "password": "123456",
                "phone": "13098921645",
                "level": 3,
                "status": 1
            },
            "staff": null,
            "repair": null
        }
    },
    {
        "id": 19,
        "number": "123456789",
        "good": "计算机",
        "operation": "帮忙插网线、清灰",
        "remark": "网线都不连，怎么上网啊？？？？",
        "status": 1,
        "do_time": "2018-02-19",
        "time": "2018-02-19",
        "user": {
            "id": 173,
            "name": "修理工1",
            "password": "123456",
            "phone": "13098921645",
            "level": 2,
            "status": 1
        },
        "report": {
            "id": 17,
            "kind": "计算机",
            "area": "海南海口",
            "name": "小智e",
            "company": "湖南大学",
            "department": "天马",
            "phone": "13098921645",
            "address": "天马",
            "description": "电脑死机了，蓝屏了，不能上网了",
            "judge": null,
            "status": 1,
            "user": {
                "id": 172,
                "name": "用户1",
                "password": "123456",
                "phone": "13098921645",
                "level": 3,
                "status": 1
            },
            "staff": null,
            "repair": null
        }
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


### 0X14 统计数据
#### method get
#### url api/Statistic

#### get
* field:start_time
    + 起始时间 按照报修时间算
* field:end_time
    + 结束时间
* field:kind
    + 类型
* field:area
    + 地点

#### return 
[{
	"id": 16,
	"kind": "计算机",
	"area": "海南海口",
	"name": "小智e",
	"company": "湖南大学",
	"department": "天马",
	"phone": "1156",
	"address": "天马",
	"description": "电脑蓝屏了",
	"judge": null,
	"status": 1,
	"user": {
		"id": 172,
		"name": "用户1",
		"password": "123456",
		"phone": "13098921645",
		"level": 3,
		"status": 1
	},
	"staff": {
		"id": 173,
		"name": "修理工1",
		"password": "123456",
		"phone": "13098921645",
		"level": 2,
		"status": 0
	},
	"repair": {
		"id": 18,
		"number": "123456789",
		"good": "计算机",
		"operation": "帮忙插网线、清灰",
		"remark": "网线都不连，怎么上网啊？？？？",
		"status": 1,
		"do_time": "2018-02-19",
		"time": "2018-02-19",
		"user": {
			"id": 173,
			"name": "修理工1",
			"password": "123456",
			"phone": "13098921645",
			"level": 2,
			"status": 0
		},
		"report": null
	}
}, {
	"id": 17,
	"kind": "计算机",
	"area": "海南海口",
	"name": "小智e",
	"company": "湖南大学",
	"department": "天马",
	"phone": "13098921645",
	"address": "天马",
	"description": "电脑死机了，蓝屏了，不能上网了",
	"judge": "这个人不行啊",
	"status": 1,
	"user": {
		"id": 172,
		"name": "用户1",
		"password": "123456",
		"phone": "13098921645",
		"level": 3,
		"status": 1
	},
	"staff": {
		"id": 173,
		"name": "修理工1",
		"password": "123456",
		"phone": "13098921645",
		"level": 2,
		"status": 0
	},
	"repair": {
		"id": 19,
		"number": "123456789",
		"good": "计算机",
		"operation": "帮忙插网线、清灰",
		"remark": "网线都不连，怎么上网啊？？？？",
		"status": 1,
		"do_time": "2018-02-19",
		"time": "2018-02-19",
		"user": {
			"id": 173,
			"name": "修理工1",
			"password": "123456",
			"phone": "13098921645",
			"level": 2,
			"status": 0
		},
		"report": null
	}
}]
```

### 0X15 报修人评价
#### method post
#### url api/Report/judge
#### 对一项报修进行评价
* field:id
    + 报修id
* field:judge
    + 对维修人员的评价

#### return 
```
{
    "id": 17,
    "kind": "计算机",
    "area": "海南海口",
    "name": "小智e",
    "company": "湖南大学",
    "department": "天马",
    "phone": "13098921645",
    "address": "天马",
    "description": "电脑死机了，蓝屏了，不能上网了",
    "judge": "这个人不行啊",
    "status": 1,
    "user": {
        "id": 172,
        "name": "用户1",
        "password": "123456",
        "phone": "13098921645",
        "level": 3,
        "status": 1
    },
    "staff": {
        "id": 173,
        "name": "修理工1",
        "password": "123456",
        "phone": "13098921645",
        "level": 2,
        "status": 1
    },
    "repair": null
}
```

### 0X16 超级管理员提升权限
#### method post
#### url api/level

* field:id
    + id
* field:level
    + level

#### return 
```
{
    "status": "success",
    "reason": ""
}

```


### 0X17 总数
#### method get
#### url api/User/count  | api/Repair/count | api/Report/count | api/Notice/count

#### return

```
{
    "status": "success",
    "kind": "User",
    "count": 6
}
```


### 0X18 获取维修工的列表
#### method get
#### url api/User/staff

#### return

```
[
    {
        "id": 169,
        "name": "修理工",
        "password": "123456",
        "phone": "13098921645",
        "level": 2,
        "status": 1
    },
    {
        "id": 173,
        "name": "修理工1",
        "password": "123456",
        "phone": "13098921645",
        "level": 2,
        "status": 1
    }
]
```
### 0X19 报修提交
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
* field:description 
    + 描述



#### return
```
{
    "id": 18,
    "kind": "计算机",
    "area": "海南海口",
    "name": "小智",
    "company": "国企",
    "department": "私营",
    "phone": "123455",
    "address": "天马山东",
    "description": "不能上网、蓝屏",
    "judge": null,
    "status": 1,
    "user": {
        "id": 172,
        "name": "用户1",
        "password": "admin",
        "phone": "13098921645",
        "level": 3,
        "status": 1
    },
    "staff": null,
    "repair": null
}
```