<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="/WEB-INF/views/common/commoncss.jsp" %>

</head>
<body>
<!-- topMenu (상단 메뉴) -->
<%@ include file="/WEB-INF/views/common/topMenu.jsp" %>

<br><br><br><br>



<div class="col-md-4 col-sm-12" style="left: 38%;">
    <div class="contact-form bottom">
        <h2>로그인을 해주세요!</h2>
        <form id="main-contact-form" name="contact-form" method="post" action="sendemail.php">
            <div class="form-group">
                <input type="text" name="name" class="form-control"  placeholder="ID">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control"  placeholder="비밀번호">
            </div>

            <div class="form-group">
                <input type="button" class="btn btn-submit" value="Login" onclick="location.href='#'">
                <button style="border-color: white" onclick="location.href='${google_url}'" >
                    <img src="/commons/images/loginImages/btn_google_signin_dark_normal_web.png"/>
                </button>
                <button style="border-color: white"  onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=4c6dceb5eb1855fff0a634bdb04459aa&redirect_uri=http://localhost:8080/login/oauth&response_type=code'">
                    <img src="/commons/images/loginImages/kakao_account_login_btn_medium_narrow.png" style="height: 43px; width: 182px;"/>
                </button>

            </div>
        </form>
    </div>
</div>

<!--footer (하단) -->
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

<!-- 공통 js-->
<%@ include file="/WEB-INF/views/common/commonjs.jsp" %>


</body>
</html>