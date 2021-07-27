<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form action="helloworld" method="post">
    <div>
        账号：<label>
        <input type="text" name="username" placeholder="请输入账号">
    </label>
    </div>
    <div>
        密码：<label>
        <input type="password" name="password" placeholder="请输入密码">
    </label>
    </div>
    <div>
        <span>${msg }</span>
    </div>
    <div>
        <input type="submit" value="登录">
    </div>
</form>
</body>
</html>
