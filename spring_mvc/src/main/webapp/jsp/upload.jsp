<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>文件上传</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/user/quick24" method="post" enctype="multipart/form-data">
		<label for="username">姓名:</label>
		<input type="text" id="username" name="username" placeholder="请输入姓名"> <br/>
		<label for="file1">文件1:</label>
		<input type="file" id="file1" name="uploadFiles"> <br/>
		<label for="file2">文件2:</label>
		<input type="file" id="file2" name="uploadFiles"> <br/>
		<label for="file3">文件3:</label>
		<input type="file" id="file3" name="uploadFiles"> <br/>
		<input type="submit" value="提交">
	</form>

<%--<form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">--%>
<%--	<label for="username">姓名:</label>--%>
<%--	<input type="text" id="username" name="username" placeholder="请输入姓名"> <br/>--%>
<%--	<label for="file1">文件1:</label>--%>
<%--	<input type="file" id="file1" name="uploadFile1"> <br/>--%>
<%--	<label for="file2">文件2:</label>--%>
<%--	<input type="file" id="file2" name="uploadFile2"> <br/>--%>
<%--	<input type="submit" value="提交">--%>
<%--</form>--%>

<%--<form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">--%>
<%--	<label for="username">姓名:</label>--%>
<%--	<input type="text" id="username" name="username" placeholder="请输入姓名"> <br/>--%>
<%--	<label for="password">密码:</label>--%>
<%--	<input type="password" id="password" name="password" placeholder="请输入密码"> <br/>--%>
<%--	<label for="file">文件:</label>--%>
<%--	<input type="file" id="file" name="uploadFile"> <br/>--%>
<%--</form>--%>
</body>
</html>
