<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>在线选课系统</title>
<link rel="stylesheet" href="css/stuLogin.css" />
</head>
<body>
	<!--上面-->
		<div class="top1">
			<div class="top1_1">
				<img src="img/登录上.png" height="100%" />
			</div>
			<div class="top1_2">
				<button class="top1_2_1"><a href="adminLogin.jsp">管理员登录</a></button>
			</div>
		</div>
		<!--中间主体-->
		<div class="middle">
			<div class="stu1">
				学生端登录
			</div>
			<div class="middle1">
				<div class="login1_1"></div>
				<div class="login1_2">
					<img src="img/logo.png" height="100%" />
				</div>
				
				<div class="login2_2" id="denglu">
					<form method="post" action="/login">
						<div class="login1_2_2">学&nbsp;&nbsp;&nbsp;号：</div>
						<input class="text1" type="text" name="stu_id" placeholder="六位学号" />
						<div class="login1_2_2">密&nbsp;&nbsp;&nbsp;码：</div>
						<input class="text1" type="password" name="stu_pwd" placeholder="密码" />
						<input class="reset" type="reset" value="重置" />
						<input class="submit" type="submit" value="登录" />
					</form>
				</div>
				<!--<div class="login1" id="zhuce">
					<form method="post" action="/register" >
						<div class="login1_1_1">手机号：</div>
						<input class="text" type="text" name="stu_tel" placeholder="86+" />
						<div class="login1_1_1">学&nbsp;&nbsp;&nbsp;号：</div>
						<input class="text" type="text" name="stu_id" placeholder="6位有效学号" />
						<div class="login1_1_1">密&nbsp;&nbsp;&nbsp;码：</div>
						<input class="text" type="password" name="stu_pwd" placeholder="至少6个字符" />
						<input class="reset" type="reset" value="重置" />
						<input class="submit" type="submit" value="提交" />
					</form>
				</div>-->
				<!--<div class="login3">
					没有账号
					<a href="javascript:void(0);"  onclick="showdiv('zhuce','denglu')" id="denglucolor">注册</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击返回			
					<a href="javascript:void(0);" onclick="showdiv('denglu','zhuce')" id="denglucolor">登录</a>
				</div>-->
			</div>
		</div>
		<!--最下面-->
		<div class="xia1_1"></div>
		<div class="xia1_2">
			<div class="xia1_2_1">
				<a href="javascript:void(0);">简体</a>
				<a>|</a>
				<a href="javascript:void(0);">繁体</a>
				<a>|</a>
				<a href="javascript:void(0);">English</a>
				<a>|</a>
				<a href="javascript:void(0);">常见问题</a>
				<a>|</a>
				<a href="javascript:void(0);">隐私政策</a>
				<a>|</a>
			</div>
		</div>
		<div class="xia1_3">
			<div class="xia1_3_1">
				© 2019 Online course.com 版权所有
			</div>
		</div>
</body>
</html>