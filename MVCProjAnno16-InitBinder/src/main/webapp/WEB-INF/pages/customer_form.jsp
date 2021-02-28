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
       <p style="color:red;text-align:center"><form:errors path="*"/>  </p>  
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
        <td>Gender   </td>
        <td><form:radiobuttons path="gender"  items="${gendersList}"/> </td>
     </tr>
     
     <tr>
        <td>Hobies   </td>
        <td><form:checkboxes items="${hobiesList}" path="hobies"/> </td>
     </tr>
     
     <tr>
        <td>Select country   </td>
        <td><form:select path="country">
                     <form:options items="${countriesList}"/> 
              </form:select>
        </td>
     </tr>
     
       <tr>
        <td>Select known languages   </td>
        <td><form:select path="langs" multiple="multiple">
                     <form:options items="${languagesList}"/> 
              </form:select>
        </td>
     </tr>
     
       <tr>
        <td>DOB::  </td>
        <td><form:input   type="date"  path="dob"/> </td>
     </tr>
      <tr>
        <td>DOJ::  </td>
        <td><form:input type="date"  path="doj"/> </td>
     </tr>
     
      <tr>
        <td>Salary range  </td>
        <td><form:input type="range"  min="10000" max="1000000" path="salary"/> </td>
     </tr>
     
     
     
     
     <tr>
        <td colspan="2"><input type="submit" value="register">  </td>
     </tr>
   </table>
   <form:hidden  path="vflag"  />
</form:form>
