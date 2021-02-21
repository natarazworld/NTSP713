<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

   <script language="JavaScript"  src="<c:url value="/myresources/js/validation.js"/>">
  </script>
  
  <noscript >
     <h1 style="color:red;text-align:center"> Enable Java script </h1>
  </noscript> 
  
     <style>
       span{
          color:blue;
       }
   </style>
 <h1 style="color:green;text-align:center">Customer Registration Form </h1>
<form:form   modelAttribute="cust"  onsubmit="return validate(this)">
  <%--     <p style="color:red;text-align:center"><form:errors path="*"/>  </p>  --%>
     <table align="center" bgcolor="cyan">
     <tr>
        <td>Customer name::       </td>
        <td><form:input path="cname"/><span id="cnameErr"></span> <form:errors cssStyle="color:red"  path="cname"/>  </td>
     </tr>
     <tr>
        <td>Customer address::       </td>
        <td><form:input path="cadd"/><span id="caddErr"></span> <form:errors cssStyle="color:red"  path="cadd"/> </td>
     </tr>
     <tr>
        <td>Customer billAmt::       </td>
        <td><form:input path="billAmt"/><span id="billAmtErr"></span><form:errors cssStyle="color:red"  path="billAmt"/>  </td>
     </tr>
     <tr>
        <td colspan="2"><input type="submit" value="register">  </td>
     </tr>
   </table>
   <form:hidden  path="vflag"  />
</form:form>
