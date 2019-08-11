<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title>登录</title>
  <link rel="stylesheet" href="css/pintuer.css">
  <link rel="stylesheet" href="css/admin.css">
  <script src="js/jquery.js"></script>
  <script src="js/pintuer.js"></script>
  <style>
    #manager{`
      float: left;
      width: 100px;
    }
    #teacher{
      right: 70px;
      float:right;
    }

  </style>
  <script>
      $(function(){
          //点击图片切换验证码
          $("#vcodeImg").click(function(){
              this.src="Loginservlet?method=GetVCode&t="+new Date().getTime();
          });

      })

      function login() {
          var name=document.getElementById("name").value
          var password=document.getElementById("password").value
          var vcode=document.getElementById("vcode").value.trim()
          if(name==""|| name==null || password=="" || password==null){
              alert("用户名或密码不能为空！！！")
              window.location.herf="index.jsp"
              return false
          }
          alert(vcode)
          var data = $("#aaa").serialize();
          $.ajax({
              type: "post",
              url: "Loginservlet?method=Login",
              data: data,
              dataType: "text", //返回数据类型
              success: function(msg){
                  if(vcode != msg.toString().trim()){
                      alert("消息提醒 验证码错误!!!");
                  } else {
                      var radio = document.getElementsByName("radio");
                      for(var i = 0;i<radio.length;i++)
                      {
                          if(radio[i].checked==true)
                          {valuee = radio[i].value;
                              aaa.action=valuee
                              aaa.submit()
                              break;}
                      }
                      return true
                  }
              }
          });

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
      <form id="aaa" method="post" onsubmit="return login()">
        <div class="panel loginbox">
          <div class="text-center margin-big padding-big-top"><h1>天津职业技术师范大学宿舍管理中心</h1></div>
          <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
            <div class="form-group">
              <div class="field field-icon-right">
                <input type="text" class="input input-big" name="name" id="name" placeholder="登录账号" data-validate="required:请填写账号" />
                <span class="icon icon-user margin-small"></span>
              </div>
            </div>
            <div class="form-group">
              <div class="field field-icon-right">
                <input type="password" class="input input-big" name="password" id="password" placeholder="登录密码" data-validate="required:请填写密码" />
                <span class="icon icon-key margin-small"></span>
              </div>
            </div>
            <div class="form-group">
              <div class="field">
                <input class="input-text size-L" id="vcode" name="vcode" type="text" placeholder="请输入验证码" style="width: 200px">
                <img title="点击图片切换验证码" id="vcodeImg" src="capchaServlet?method=GetVCode" >
              </div>
            </div>
          </div>
          <div style="padding:60px; padding-bottom:10px; padding-top:10px;" class="row">
            <div id="manager">
              <input type="radio" name="radio" value="dLoginServlet" checked ="checked">管&nbsp理&nbsp员
            </div>
            <div id="teacher">
              <input type="radio" name="radio" value="tLoginServlet">
              老师
            </div>
          </div>
          <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录" id="submitBtn"></div>
          <div style="padding:150px; padding-bottom:10px; padding-top:10px;size: 200px" >
            <a href="sendemail.jsp" >忘记密码</a>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

</body>
</html>