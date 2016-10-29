test1:
	测试如何处理DWR的返回值（可以定义多种处理返回值的函数）
	
test2:
	测试如何处向方法传递参数
	
test3：
	测试如何处理返回数组
	
test4：
	测试如何处理返回List
	
test5：
	测试如何处理返回Map
	
test6:
	测试如何处理返回二维数组
	
	----------------------------------------------------------------
	
test7：
	测试如何通过$("")方法获得页面元素的值(注意${}是JSTL表达式)
	
test8:
	测试页面扩展元素的属性
	
test9:
	DWR默认是以异步的方式向后台传输数据，可以通过dwr.engine.setAsync(false)设置为同步方式。
	
test10:
	测试处理返回List，List中封装的为自定义类的对象
	
test10_1:
	测试把List中的数据，显式在Select下拉列表框中
	DWRUtil.addOptions('stu',data,"id","name");
	
	第一个参数“stu”，为页面控件Select的Id
	第二个参数data，为用DWR从服务器接收的List集合
	第三个参数为List集合中Student对象的id字段，作为Select下拉列表的Option的value值
	第四个参数为List集合中Student对象的name字段，作为Select下拉列表的显式值
	
test10_2:
	测试把List中的数据，显式在Table中
	