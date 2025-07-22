<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.html">登录</a>
    </div>
    <form id="reg-form" action="/cscase/registerServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs" style="width: 300px;">
                    <input name="username" type="text" id="username">
                    <br>
                    <!-- 仅显示用户名相关错误 -->
                    <span id="username_err" class="err_msg text-red-500"
                    ${not empty uesrname_register_msg && fn:contains(uesrname_register_msg, '用户名') ? '' : 'style="display: none"'}>
                        ${uesrname_register_msg}
                    </span>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td class="inputs" style="width: 300px;">
                    <input name="password" type="password" id="password">
                    <br>
                    <!-- 仅显示密码相关错误 -->
                    <span id="password_err" class="err_msg text-red-500" style="padding-right: 75px;"
                    ${not empty password_register_msg && fn:contains(password_register_msg, '密码') ? '' : 'style="display: none"'}>
                        ${password_register_msg}
                    </span>
                </td>
            </tr>
            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/cscase/checkCodeServlet" style="vertical-align: middle;margin: 3px -4px 5px 0px;" >
                    <a href="#" id="changeImg" >看不清？</a>
                    <span id="checkCode_err" style="padding-right: 215px;" class="err_msg text-red-500"
                    ${not empty checkCode_msg && fn:contains(checkCode_msg, '验证码') ? '' : 'style="display: none"'}>
                        ${checkCode_msg}
                    </span>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <span class="err_msg text-red-500" style="padding-right: 75px;"
                    ${not empty register_msg && fn:contains(register_msg, '失败') ? '' : 'style="display: none"'}>
                        ${register_msg}
                    </span>
                </td>
            </tr>
        </table>
        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>

<script>
    document.getElementById("changeImg").onclick = function () {
        document.getElementById("checkCodeImg").src = "/cscase/checkCodeServlet?"+new Date().getMilliseconds();
    }

    document.getElementById("checkCodeImg").onclick = function (){
        this.src =  "/cscase/checkCodeServlet?"+new Date().getMilliseconds();
    }
</script>

</body>
</html>