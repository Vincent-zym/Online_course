<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.demo.bean.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>在线选课系统</title>
	<title>学生</title>
	<link type="text/css" rel="stylesheet" href="css/index1.css" />
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="layui/css/layui.css"/>
	<script src="layui/layui.js"></script>

</head>
<body>
	<% Student student = (Student)request.getSession().getAttribute("student"); %>  
	<div class="top1">
			<div class="top1_1">
				<img src="img/选课.png" height="100%" />
			</div>
			<div class="top1_2">
				当前用户：<%=student.getStu_id() %>
			</div>
		</div>	
			<!--轮播图，引入的是layui模块-->
			<div class="layui-carousel" id="test1" style="width:90%;height:300px;margin:0 auto" >
				  <div carousel-item>
				    <div>
				    <!--<div style="background-image: url(img/admin.jpg); ">-->
				    <img src="img/student.jpg" style="width: 100%;"/>	
				    </div>
				    <div>
				    	<img src="img/stu1.jpg" style="width: 100%;"/>	
				    </div>
				    <div>
				    	<img src="img/stu2.jpg" style="width: 100%;"/>	
				    </div>
				  </div>
			</div>
				<!-- 条目中可以是任意内容，如：<img src=""> -->
			<div style="height: 40px; text-align: center;">
				<span style="font-size: 30px; ">学&nbsp;&nbsp;&nbsp;生&nbsp;&nbsp;&nbsp;选&nbsp;&nbsp;&nbsp;课&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;面</span>
			</div>
			
        <div class="container">
            <div class="col-md-8 col-md-offset-2" style="width: 100%;margin: 0 auto">
                <h2>学生操作</h2><br>
				
                <button class="btn btn-success" onclick="window.location.href='/listStudent.jsp'" style="margin-right:50px;margin-bottom: 30px">我的信息</button>
                <button class="btn btn-info" onclick="window.location.href='/updateStu?stu_id=<%=student.getStu_id() %>'" style="margin-right:50px;margin-bottom: 30px">更新信息</button>
                <%-- <a class="btn btn-info btn-sm" href="/updateStu?stu_id=<%=student.getStu_id() %>">更 新</a> --%>
                
                <button class="btn btn-success" onclick="window.location.href='/selectCourse'" style="margin-right:50px;margin-bottom: 30px">在线选课</button>
                <button class="btn btn-info" onclick="window.location.href='/selectPreview'" style="margin-bottom: 30px">选课预览</button>
                
                 <table class="table">
                    <tr>
                        <td>学号：<%=student.getStu_id() %> </td>
                        <td>姓名：<%=student.getStu_name() %></td>
                    </tr>
                    <tr>
                        <td>密码：<%=student.getStu_pwd() %></td>
                        <td>性别：<%=student.getStu_sex() %></td>
                    </tr>
                    <tr>
                        <td>年级：<%=student.getStu_grade() %></td>
                        <td>手机：<%=student.getStu_tel() %></td>
                    </tr>
                    <tr>
                        <td>专业：<%=student.getStu_major() %></td>
                        <td>籍贯：<%=student.getStu_place() %></td>
                    </tr>
                    <tr>
                        <td>民族：<%=student.getStu_nation() %></td>
                    </tr>
                </table>
               
               </div>
               </div>     
				
		 		<div style="height: 100px; width:100%; background-color: #F6F6F6; text-align: center;">
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