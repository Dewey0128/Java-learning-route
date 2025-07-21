<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 2025/7/22
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>删除品牌</title>
</head>
<body>
<h3>删除品牌</h3>
<form action="/demo/deleteServlet" method="post" id="deleteForm">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${brand.id}">

    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description} </textarea><br>
    状态：
    <c:if test="${brand.status == 0}">
        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>
    <c:if test="${brand.status == 1}">
        <input type="radio" name="status" value="0" >禁用
        <input type="radio" name="status" value="1" checked>启用<br>
    </c:if>

    <input type="hidden" name="isConfirmed" id="isConfirmedInput" value="false">
    <input type="submit" value="提交" id="delete">
</form>

<script>
    document.getElementById("delete").onclick = function () {
        const isConfirmed = confirm("你确定要执行此操作吗？");
        if (isConfirmed) {
            // 用户点击了"确定"
            console.log("操作已确认");
            document.getElementById("isConfirmedInput").value = "true";
            document.getElementById("deleteForm").submit();
        } else {
            // 用户点击了"取消"
            console.log("操作已取消");
            return false;
        }
    }
</script>
</body>
</html>
