<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.demo.bean.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>在线选课系统</title>
	<title>管理员</title>
	<link type="text/css" rel="stylesheet" href="css/index1.css" />
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="layui/css/layui.css"/>
	<script src="layui/layui.js"></script>

</head>
<body>
	<% Student student = (Student) request.getSession().getAttribute("student"); %>
	<div class="top1">
			<div class="top1_1">
				<img src="img/选课.png" height="100%" />
			</div>
			<!-- <div class="top1_2">
				当前用户：
			</div> -->
		</div>	
			<!--轮播图，引入的是layui模块-->
			<div class="layui-carousel" id="test1" style="width:90%;height:300px;margin:0 auto" >
				  <div carousel-item>
				    <div>
				    <!--<div style="background-image: url(img/admin.jpg); ">-->
				    <img src="img/admin.jpg" style="width: 100%;"/>	
				    </div>
				    <div>
				    	<img src="img/adm1.jpg" style="width: 100%;"/>	
				    </div>
				    <div>
				    	<img src="img/adm2.jpg" style="width: 100%;"/>	
				    </div>
				  </div>
			</div>
				<!-- 条目中可以是任意内容，如：<img src=""> -->
			<div style="height: 40px; text-align: center;">
				<span style="font-size: 25px; ">学&nbsp;&nbsp;&nbsp;生&nbsp;&nbsp;&nbsp;选&nbsp;&nbsp;&nbsp;课&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;面</span>
			</div>
			
			<div class="container">
            <div class="col-md-8 col-md-offset-2">
                <h1>更新信息</h1><br>
                <form action="/updateStu" method="post">
                    <div class="form-group">
                        	学号:
                        <input type="text" class="form-control" name="stu_id" value="<%=student.getStu_id() %>" readonly="true">	
                       
                    </div>
                    <div class="form-group">
                        <label>姓名</label>
                        <input type="text" class="form-control" name="stu_name" value="<%=student.getStu_name() %>">
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input type="text" class="form-control" name="stu_pwd" value="<%=student.getStu_pwd() %>">
                    </div>
                    <div class="form-group">
                        <label>性别</label>
						<input type="text" class="form-control" name="stu_sex" value="<%=student.getStu_sex() %>">
						</label>
                    </div>
                    <div class="form-group">
                        <label>年级</label>
                        <select class="form-control" name="stu_grade" value="<%=student.getStu_grade() %>">
						  <option>大一</option>
						  <option>大二</option>
						  <option>大三</option>
						  <option>大四</option>
						</select>
                    </div>
                    <div class="form-group">
                        <label>手机</label>
                        <input type="text" class="form-control" name="stu_tel" value="<%=student.getStu_tel() %>">
                    </div>
                    <div class="form-group">
                        <label>专业</label>
                        <select class="form-control" name="stu_major" value="<%=student.getStu_major() %>">
						  <option>信息工程学院</option>
						  <option>智能制造与控制技术学院</option>
						  <option>语言文化传播学院</option>
						  <option>经济与管理学院</option>
						  <option>艺术与设计学院</option>
						</select>
                    </div>
                    <div class="form-group">
                        <label>籍贯</label>
                        <input type="text" class="form-control" name="stu_place" value="<%=student.getStu_place() %>">
                    </div>
                    <div class="form-group">
                        <label>民族</label>
                        <input type="text" class="form-control" name="stu_nation" value="<%=student.getStu_nation() %>">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-info">更新信息</button>
                    </div>
                </form>
            </div>
        </div>
				
		 		<div style="height: 100px; background-color: #F6F6F6; text-align: center;">
		 		<div style="padding-top: 20px; letter-spacing: 2px;">西北工业大学明德学院</div>
		 		<div style="padding-top: 10px; ">© 2019 npumd.edu.cn</div>
		 		</div>
		<script>
		//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
		layui.use(['element','form','laydate','carousel'], function(){
		  var element = layui.element;//tab切换
		  
		  
		  var form = layui.form;//表单
		  /* form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  }); */
		  
		  var laydate = layui.laydate;//日期选择
		  laydate.render({
			  elem: '#course_time'
			  ,range: true
			});
		
			//建造实例
			var carousel = layui.carousel;//轮播图
			  carousel.render({
			    elem: '#test1'
			    ,width: '100%' //设置容器宽度
			    ,arrow: 'always' //始终显示箭头
			    //,anim: 'updown' //切换动画方式
			  });
		  //…
		});
		</script>
	
</body>
</html>