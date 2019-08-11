<%--
  Created by IntelliJ IDEA.
  User: ls
  Date: 19-7-2
  Time: 下午11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ls" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <%
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
    %>
</head>
<body>
<form method="post" action="updateT" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">

        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">ID</th>
                <th >名字</th>
                <th>密码</th>
                <th>手机号</th>
                <th>email</th>
                <th>学院</th>
                <th width="310">操作</th>
            </tr>
            <volist name="list" id="vo">
                <ls:forEach var="ss" items="${requestScope.findAllt}" varStatus="tl">
                    <tr>
                        <td>${ss.id}</td>
                        <td>${ss.name}</td>
                        <td>${ss.password}</td>
                        <td>${ss.phone}</td>
                        <td>${ss.email}</td>
                        <td>${ss.college}</td>
                        <td><div class="button-group"> <a class="button border-main" href="updatet.jsp?id=${ss.id}"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="deletet?id=${ss.id}" onclick="return del(1,1,1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
                    </tr>
                </ls:forEach>
            </volist>
        </table>
        <div class="button-group"> <a class="button border-main" href="findAllt?operation=-"><span class="icon"></span> 上一页</a> <a class="button border-red" href="findAllt?operation=+" ><span class="icon"></span> 下一页</a> </div></td>
    </div>
</form>
<script type="text/javascript">

    //搜索
    function changesearch(){

    }

    //单个删除
    function del(id,mid,iscid){
        if(confirm("您确定要删除吗?")){

        }
    }

    //全选
    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })



</script>
</body>
</html>
