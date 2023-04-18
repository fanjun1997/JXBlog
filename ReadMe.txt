JXBlog为父模块，在下面创建子模块
    1> 在该pom文件下引入的包只是对版本的一个锁定，并不是真正的引入了
    2> 父工程pom文件中的会继承到子模块中


JXBlog
  |- jinxin-framework 公共子模块
  |- jinxin-admin 博客后台模块
  |- jinxin-blog博客前台模块