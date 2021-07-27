<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Regis</title>
</head>
<body>
<form action="regsucceed" method="post">
    <div>
        账号：<label>
        <input type="text" name="username" placeholder="请设置账号">
    </label>
    </div>
    <div>
        密码：<label>
        <input type="password" name="password" placeholder="请设置密码">
    </label>
    </div>
    <div>
        <span>${msg }</span>
    </div>
    <div>
        <input type="submit" value="确认">
    </div>
</form>

</body>
</html>