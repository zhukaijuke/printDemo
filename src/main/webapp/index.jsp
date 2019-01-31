<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--<jsp:plugin code="com.zhukai.controller.PrintApplet.class" height="0" width="0" codebase="/printDemo/applet/" type="applet">

</jsp:plugin>--%>
<html>
<head>
    <meta http-equiv="content-type" content="txt/html; charset=utf-8" />
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
<div id="print"></div>
<h2><a href="/print/test2">click1</a></h2>
<h2><a href="javascript:print()">click3</a></h2>
<h2><button onclick="testPrint()">测试本地打印1</button></h2>
</body>
<script type="text/javascript">
    function print() {

        var print = document.getElementById("print");
        var url = "http://localhost/print/test2";

        var appletStr = '<APPLET ID="JrPrt" CODE="com.zhukai.controller.PrintApplet.class" CODEBASE="./" ARCHIVE="applet/xerces-2.9.0.jar, applet/batik-all-1.5.1.jar,applet/batik-dom-1.6-1.jar,applet/batik-svg-dom-1.6-1.jar,applet/commons-digester-2.1.jar,applet/batik-1.1.1.jar,applet/batik-bridge-1.6-1.jar,applet/jasperreports-5.6.0.jar,applet/print.jar,applet/commons-logging-1.1.1.jar,applet/commons-collections-3.2.1.jar" WIDTH="0" HEIGHT="0"><PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.2"><PARAM NAME="scriptable" VALUE="false"><PARAM NAME="REPORT_URL" VALUE="' + url + '"></APPLET>';


        print.innerHTML = appletStr;

    }
    print();

    function testPrint() {
        console.log("inter");
        $.ajax({
            url: 'http://localhost:8086/',
            type: 'post',
            data: {
                name: "xu",
                foo: 'bar',
                url: 'http://localhost/print/test2'
            },
            cache: false,
            success: function(res){
                console.log(res);
            }
        });
    }
</script>
</html>
