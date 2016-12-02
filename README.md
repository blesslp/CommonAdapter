# CommonAdapter
尝试做一个万能适配器方案,做到一处编写,处处使用,无论AbsListView还是RecyclerView,让你的代码最大化复用.

说明:
```
1.实现了控件无关的Adapter
2.提供多视图解决方案
3.默认多视图以数据源的Class为区分,提供自定义转换接口来定制符合你的所有情况.
```


演示:
#界面分三种viewType,每种type对应一个相应的Adapter,这个adapter就是该项目核心要实现的目标
![](http://ww3.sinaimg.cn/large/006y8lVagw1fack54rkjej31kw0d00vx.jpg)

#这是adapter直接拿到RecyclerView里面的情况,由于RecyclerView与ListView的区别,所以我提供了RecyclerAdapter和ListViewAdapter两种管理器,这个跟视图和逻辑均无关联
![](http://ww1.sinaimg.cn/large/006y8lVajw1fack4voq8sj31kw0gfjvb.jpg)


#SimpleAdapterItem,SimpleAdapterItem2,SimpleAdapterItem3是我们要实现的适配器
![](http://ww1.sinaimg.cn/large/006y8lVagw1fackbt4untj30zk0nw787.jpg)

#程序运行图
![](http://ww3.sinaimg.cn/large/006y8lVagw1fackeo9c1qj30u01hcq8u.jpg)
