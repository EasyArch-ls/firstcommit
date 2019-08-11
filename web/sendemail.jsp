<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <style>
        #manager {
            float: left;
            width: 100px;
        }

        #teacher {
            right: 70px;
            float: right;
        }

    </style>
    <script>
        var valuee;
        var varifyx;
        // $(function() {

        //点击图片切换验证码
        // $("#submitBtn").click(function () {
        function x() {
            var radio = document.getElementsByName("radio");
            var email = document.getElementById("email").value
            if (email == "" || email == null) {
                alert("email不能为空！！！")
                window.location.herf = "login.jsp"
            }
            for (var i = 0; i < radio.length; i++) {
                if (radio[i].checked == true) {
                    valuee = radio[i].value;
                    break;
                }
            }
            var data = "email=" + email
            alert(data)

            alert("ee")
            $.ajax({
                type: "get",
                url: 'http://localhost:8080/' + valuee,
                contentType: 'application/text;charset=utf-8',
                data: data,
                //返回数据类型
                success: function (msg) {
                    // alert(msg)
                    varifyx = msg
                    console.log(varifyx)
                    // window.location.href="sendemail.jsp"
                }
            });

        }

        // })

        function send() {
            var varify = document.getElementById("varify").value
            var aa = varifyx.split("-");

            if (varify != aa[0]) {
                alert("消息提醒 验证码错误!!!");
                return false
            } else {
                if (valuee == "findemail") {
                    aaa.action = "dLoginServlet?name=" + aa[1] + "&password=" + aa[2];
                    aaa.submit()
                } else {
                    aaa.action = "tLoginServlet?name=" + aa[1] + "&password=" + aa[2];
                    aaa.submit()
                }
                return true
            }

        }

    </script>


</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">
            </div>
            <form id="aaa" method="post" onsubmit="return send()">
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top"><h1>天津职业技术师范大学宿舍管理中心</h1></div>
                    <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="email" id="email" placeholder="email帐号"
                                       data-validate="required:请填写email"/>
                                <span class="icon icon-user margin-small"></span>
                            </div>
                        </div>
                        <div>
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="varify" id="varify" placeholder="验证码"
                                       data-validate="required:"/>
                                <span class="icon icon-user margin-small"></span>
                            </div>
                        </div>

                    </div>
                    <div style="padding:60px; padding-bottom:10px; padding-top:10px;" class="row">
                        <div id="manager">
                            <input type="radio" name="radio" value="findemail" checked="checked">管&nbsp理&nbsp员
                        </div>
                        <div id="teacher">
                            <input type="radio" name="radio" value="findemailt">
                            老师
                        </div>
                    </div>
                    <div style="padding:30px;">
                        <input type="button" onclick="x()" class="button button-block bg-main text-big input-big"
                               value="发送">
                    </div>
                    <div style="padding:30px;"><input type="submit"
                                                      class="button button-block bg-main text-big input-big" value="登录"
                                                      id="submitB"></div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>