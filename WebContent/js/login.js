function showdiv(obj1,obj2){//获取登录、注册按钮中的定义的对象
	//根据标签定义的id进行设置熟悉，开始时注册模块是block,登录时none,
	//当点击onclick后，两者属性进行切换，从而实现同一地方显示一个模块
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
}