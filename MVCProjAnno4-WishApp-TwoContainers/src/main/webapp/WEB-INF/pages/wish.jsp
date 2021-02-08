<%@ page  isELIgnored="false" %>

<h1 style="color:red;text-align:center">Result page(wish.jsp)  </h1>

<h2 style="color:red;text-align:center">  system date and  time ::  ${requestScope.sysDate } , <%=request.getAttribute("sysDate") %>  </h2>
<br>
<h2 style="color:red;text-align:center">  WishMessage ::  ${requestScope.wMsg}  , <%=request.getAttribute("wMsg") %> </h2>
<br>
<a href="welcome.htm">home</a>
