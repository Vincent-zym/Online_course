<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
<title>选课</title>
</head>
<body>
	 
		<table class="layui-hide" id="test"></table>
		              
		          
		<script src="layui/layui.js" charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
		 
		<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  table.render({
		    elem: '#test'
		    ,url:'/list'
		    ,cols: [[
		      {field:'id', width:80, title: 'ID', sort: true}
		      ,{field:'username', width:80, title: '用户名'}
		      ,{field:'sex', width:80, title: '性别', sort: true}
		      ,{field:'city', width:80, title: '城市'}
		      ,{field:'sign', title: '签名', minWidth: 150}
		      ,{field:'experience', width:80, title: '积分', sort: true}
		      ,{field:'score', width:80, title: '评分', sort: true}
		      ,{field:'classify', width:80, title: '职业'}
		      ,{field:'wealth', width:135, title: '财富', sort: true}
		    ]]
		    ,page: true
		  });
		});
		</script>
	
</body>
</html>