<%--
  Created by IntelliJ IDEA.
  User: ls
  Date: 19-7-2
  Time: 上午9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>网站信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <style>
        .body-content {
            position: absolute;
            width: 100%;
        }

        #con{
            position: relative;
            left: 30%;
        }
    </style>
    <%
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
    %>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 宿舍信息</strong></div>
    <div class="body-content">
        <div id="con">
            <form method="post" class="form-x" action="update">
                <div class="form-group">
                    <div class="label">
                        <label>id：</label>
                    </div>
                    <div class="field">
                        <input type="text" unselectable="on" id="id" name="id" class="input tips" style="width:25%; float:left;"
                               value="${param.id}" data-toggle="hover" data-place="right"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>楼号 ： </label>
                    </div>
                    <div class="field">
                        <select name="bid" id="bid" class="input w50">
                            <option value="7A">7A</option>
                            <option value="7C">7C</option>
                            <option value="7E">7E</option>
                            <option value="8A">8A</option>
                            <option value="8C">8C</option>
                            <option value="8E">8E</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>宿舍号：</label>
                    </div>
                    <div class="field">
                        <input type="text" id="sid" name="sid" class="input tips" style="width:25%; float:left;"
                               value="" data-toggle="hover" data-place="right"/>

                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>床位号：</label>
                    </div>
                    <div class="field">
                        <input type="text" id="cid" name="cid" class="input tips" style="width:25%; float:left;"
                               value="" data-toggle="hover" data-place="right"/>

                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>名字：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="name" value="" style="width:25%; float:left;"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>性别：</label>
                    </div>
                    <div class="field">
                        <select name="sex" class="input w50">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>电话号码 ：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="phone" value="" style="width:25%; float:left;"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>学号：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="number" style="width:25%; float:left;"></textarea>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>学院：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="college" value="" style="width:25%; float:left;"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>备注：</label>
                    </div>
                    <div class="field">
                        <textarea name="other" class="input" style="width:25%; float:left;"></textarea>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
