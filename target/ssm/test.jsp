<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Form Test</title>
    <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        //ajax提交form表单的方式
        function addUser() {
            alert("---submit()函数执行了---");
            var url = "http://xmyyzw.club:8080/xiaoyuanbbb/user/add";
            var jsonStr = {
                username: $("#username").val(),
                password: $("#password").val(),
                gender: $("#gender").val(),
                wx_name: $("#wx_name").val(),
                wx_img: $("#wx_img").val(),
                type: $("#type").val(),
                identified: $("#identified").val(),
                number: $("#number").val(),
                introduction: $("#introduction").val()
            };
            $.ajax({
                type: "POST",
                // ContentType: "application/json;charset=utf-8",
                dataType: "json",
                url: url,
                data: jsonStr,
                success: function (data) {
                    // var json = JSON.stringify(data);
                    // alert(json);
                    alert(data)
                },
                error: function (data) {
                    alert(data);
                }
            });
        }
    </script>
</head>
<body>
<form>
    用户名：<input type="text" id="username" name="username"/><br/>
    密码：<input type="password" id="password" name="password"/><br/>
    性别：<input type="text" id="gender" name="gender"/><br/>
    微信名：<input type="text" id="wx_name" name="wx_name"/><br/>
    微信头像：<input type="text" id="wx_img" name="wx_img"/><br/>
    用户类型：<input type="text" id="type" name="type"/><br/>
    是否认证：<input type="text" id="identified" name="identified"/><br/>
    学号/教工号：<input type="text" id="number" name="number"/><br/>
    用户简介：<input type="text" id="introduction" name="introduction"/><br/>
    <input type="button" value="提交" id="submitBtn" onclick="addUser();"/>
</form>
</body>
</html>