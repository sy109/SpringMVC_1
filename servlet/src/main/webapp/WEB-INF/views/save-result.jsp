<%--
  Created by IntelliJ IDEA.
  User: sang
  Date: 2021/09/08
  Time: 11:14 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
<%--    프로퍼티 접근법으로 오브젝트.프로퍼티 네임으로 접근 가능
값을 넣으면 setter 아니면 getter 가 호출됨--%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
