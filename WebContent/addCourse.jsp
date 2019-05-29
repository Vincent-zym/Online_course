<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
				<span style="font-size: 25px; ">管&nbsp;&nbsp;&nbsp;理&nbsp;&nbsp;&nbsp;员&nbsp;&nbsp;&nbsp;操&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;面</span>
			</div>
			
			<div class="container">
            <div class="col-md-8 col-md-offset-2">
                <h1>添加课程</h1><br>
                
                <form method="post" action="add" >
                    <div class="form-group">
                        <label>课程编号</label>
                        <input type="text" class="form-control" name="course_id">
                    </div>
                    <div class="form-group">
                        <label>课程名字</label>
                        <input type="text" class="form-control" name="course_name">
                    </div>
                    <div class="form-group">
                        <label>授课老师</label>
                        <input type="text" class="form-control" name="course_tea">
                    </div>
                    <div class="form-group">
                        <label>学时</label>
                        <input type="text" class="form-control" name="course_hour">
                    </div>
                    <div class="form-group">
                        <label>学分</label>
                        <select class="form-control" name="course_mark">
						  <option>0.5</option>
						  <option>1</option>
						  <option>1.5</option>
						  <option>2</option>
						  <option>2.5</option>
						  <option>3</option>
						</select>
                    </div>
                    <div class="form-group">
                        <label>学期</label>
                        <select class="form-control" name="course_term">
						  <option>第一学期</option>
						  <option>第二学期</option>
						  <option>第三学期</option>
						</select>
                    </div>
                    <div class="form-group">
                        <label>节次</label>
                        <select class="form-control" name="course_node">
						  <option>一二节</option>
						  <option>三四节</option>
						  <option>五六节</option>
						  <option>七八节</option>
						</select>
                    </div>
                     <div class="form-group">
                        <label>周次</label>
                        <input type="text" class="form-control" name="course_week">
                    </div>
                    <!-- <div class="form-group">
                        <label>上课时间</label>
                        <input type="text" class="form-control" name="course_time" id="course_time">
                    </div> -->
                    <div class="form-group">
                        <label>上课时间</label>
                        <select class="form-control" name="course_time">
						  <option>星期一</option>
						  <option>星期二</option>
						  <option>星期三</option>
						  <option>星期四</option>
						  <option>星期五</option>
						</select>
                    </div>
                    <div class="form-group">
                        <label>上课地点</label>
                        <input type="text" class="form-control" name="course_place">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-info">添加课程</button>
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