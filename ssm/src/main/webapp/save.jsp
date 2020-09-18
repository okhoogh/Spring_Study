<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>账户</title>
</head>
<body>
	<h1>添加账户信息表单</h1>
	<form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
		<label for="name">账户名称</label>
		<input type="text" id="name" name="name" placeholder="请输入账户名称"><br/>
		<label for="money">账户名称</label>
		<input type="text" id="money" name="money" placeholder="请输入金额"><br/>
		<input type="submit" value="保存">
	</form>
</body>
</html>
