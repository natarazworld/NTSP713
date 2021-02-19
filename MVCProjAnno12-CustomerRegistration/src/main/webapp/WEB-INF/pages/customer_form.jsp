<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

 <h1 style="color:green;text-align:center">Customer Registration Form </h1>
<form:form   modelAttribute="cust">
   <table align="center" bgcolor="cyan">
     <tr>
        <td>Customer name::       </td>
        <td><form:input path="cname"/>  </td>
     </tr>
     <tr>
        <td>Customer address::       </td>
        <td><form:input path="cadd"/>  </td>
     </tr>
     <tr>
        <td>Customer billAmt::       </td>
        <td><form:input path="billAmt"/>  </td>
     </tr>
     <tr>
        <td colspan="2"><input type="submit" value="register">  </td>
     </tr>
     
     
     
   </table>
</form:form>
