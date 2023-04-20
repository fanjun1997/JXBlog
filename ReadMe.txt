JXBlog为父模块，在下面创建子模块
    1> 在该pom文件下引入的包只是对版本的一个锁定，并不是真正的引入了
    2> 父工程pom文件中的会继承到子模块中


JXBlog
  |- jinxin-framework 公共子模块
    |-config：一些配置，例如解决跨域请求
    |-constants： 代码中使用的一些常量
    |-domain： 其中包含了一些要使用的类
    |-enums
    |-mapper
    |-service： 服务接口
        |-impl 接口实现类
  |- jinxin-admin 博客后台模块
  |- jinxin-blog博客前台模块