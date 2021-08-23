<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*"%>

<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/style.css" />

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
	<script>
		$(function () {
			$("#form").submit(function () {
                $.ajax({
                    type:"POST",
                    // data:{username:$("#username").val(),password:$("#password").val()},
					data:$("#form").serialize(),
                    url:"${pageContext.request.contextPath}/user/userLogin",
                    dataType:"JSON",
                    success:function (res){
                        if(res.success){
							location.href="${pageContext.request.contextPath}/emp/showAll"
                        }else{
                            $("#msg").html("<font color='red'>" + res.msg + "</font>")
                        }
                    }
                })
				return false;
            })

        })
    </script>

	</head>

	<body>
	<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(d);
	%>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%=now%>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						login
					</h1>
					<form method="post" id="form">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="left">
									<span id="msg"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" id="username" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" id="password"/>
								</td>
							</tr>


							<tr>
								<td valign="middle" align="right">
									验证码:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="code" />

									<img src="commom/authImg" id="img" style="float: right;height: 25px;width: 30%;valign:middle"/>
								</td>
							</tr>

						</table>
						<p>
							<input id="submit" type="submit" class="button" value="Submit &raquo;"  />
							<input type="button" class="button" onclick="location.href='regist.jsp'" value="Regist &raquo;"/>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
<script>
	$(function(){
		$("#img").click(function () {
			var src  = "${pageContext.request.contextPath}/commom/authImg?"+(new Date()).getTime();
			$(this).attr("src",src);

		});
	})
</script>
