<% request.setAttribute("base",request.getContextPath());%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>粉丝</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>


    <link rel="stylesheet" href="${base}/css/dpl-min.css" type="text/css"/>
    <link rel="stylesheet" href="${base}/css/bui-min.css" type="text/css"/>
    <link rel="stylesheet" href="${base}/css/main.css" type="text/css"/>
    <script type="text/javascript" src="${base}/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="${base}/js/seed-min.js"></script>
    <script type="text/javascript" src="${base}/js/config.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${base}/js/main.js"></script>
    <script type="text/javascript" src="${base}/js/bo.js"></script>
    <script type="text/javascript">
        if (!app) var app = {};
        if (!(app.config)) app.config = {};
        app.config.imageHomeUrl = "http://bonn.qiniudn.com/";
        app.config.qiniuIsOpen = "Y";
    </script>
</head>
<body>
<div class="header" id="header">
    <div class="header-left">
        <div class="dl-title">
            <div class="dl-logo"><img src=""></div>
        </div>
    </div>
    <div class="header-right">
        <ul class="dl-links">
            <li>
                <div class="dl-log-dwrap">
                    <div style="padding-top: 21px;min-width: 120px;text-align: center;"></div>
                </div>
            </li>
            <li>
                <div class="dl-log-ddwrap"><a class="dl-link-item dl-link-mobile"
                                              href="http&#58;&#47;&#47;test1.weimain.com&#47;mm&#47;control&#47;main&#63;psid&#61;10001"
                                              target="_blank" title="手机商城">手机商城</a>
                    <span class="dl-log-dd"></span>
                </div>
            </li>
            <li>
                <div class="dl-log-dwrap">
                    <a id="logUser" class="dl-link-item dl-link-user" href="#">jianlaifu<b></b></a>
                    <ul class="dl-hide-box">
                        <li><a href="/merchant/control/logout">退出</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </div>
</div>

<div class="content">
    <div class="dl-main-nav">
        <ul id="J_Nav" class="nav-list ks-clear">
            <li class="nav-item">
                <div class="nav-item-inner">微信</div>
            </li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-content"></ul>
</div>

<script type="text/javascript">
    BUI.use('common/main', function () {
        var config = [{
            "id": "INDEX",
            "homePage": "INDEX_INDEX",
            "menu": [{
                "text": "微信",
                "items": [{"id": "INDEX_INDEX", "text": "粉丝列表", "href": "user/redPackage"}]
            }]
        }];
        new PageUtil.MainPage({
            modulesConfig: config
        });
    });

    function updatePassword() {
        app.page.open({
            id: 'updatePassword'
        });
    }
</script>
<div id="messageContainer">
</div>
<script type="text/javascript">
    function showMessage(message, clazz) {
        var messageContainer = $("#messageContainer");
        messageContainer.html('');

        var html = $('<div class="outpop ' + clazz + '" ><div class="ico-img"></div><div class="title">' + message + '</div></div>');
        html.appendTo(messageContainer);

        setTimeout(function () {
            html.remove()
        }, 2000);
    }

    function showSuccess(message) {
        showMessage(message, 'ico1');
    }

    function showError(message) {
        showMessage(message, 'ico2');
    }

    function showWarning(message) {
        showMessage(message, 'ico3');
    }
</script>
</body>
</html>