<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>在线选课系统</title>
<link rel="stylesheet" href="css/login.css" />
		<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<!--上面-->
		<div class="top1">
			<div class="top1_1">
				<img src="img/登录上.png" height="100%" />
			</div>
		</div>
		<!--中间主体-->
		<div class="middle">
			<div class="middle1">
				<div class="login1_1"></div>
				<div class="login1_2">
					<img src="img/logo.png" height="100%" />
				</div>
				<div class="login1" id="zhuce">
					<form method="post" action="RegisterServlet" >
						<div class="login1_1_1">手机号：</div>
						<input class="text" type="text" name="stu_tel" placeholder="86+" />
						<div class="login1_1_1">学&nbsp;&nbsp;&nbsp;号：</div>
						<input class="text" type="text" name="stu_id" placeholder="6位有效学号" />
						<div class="login1_1_1">密&nbsp;&nbsp;&nbsp;码：</div>
						<input class="text" type="password" name="stu_pwd" placeholder="至少6个字符" />
						<input class="reset" type="reset" value="重置" />
						<input class="submit" type="submit" value="提交" />
					</form>
				</div>
				<div class="login2_2" id="denglu">
					<form method="post" action="LoginServlet">
						<input class="text1" type="text" name="stu_id" placeholder="学号" />
						<input class="text1" type="password" name="stu_pwd" placeholder="密码" />
						<input class="reset" type="reset" value="重置" />
						<input class="submit" type="submit" value="登录" />
					</form>
				</div>
				<div class="login3">
					没有账号?
					<a href="javascript:void(0);" class="yanse" onclick="showdiv('zhuce','denglu')" id="denglucolor">注册</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已有账号?				
					<a href="javascript:void(0);" class="yanse" onclick="showdiv('denglu','zhuce')" id="denglucolor">登录</a>
				</div>
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