<%@ page  contentType="text/html; charset=UTF-8" isELIgnored="false"   %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>



  <h1 style="color:red;text-align:center"><spring:message  code="customer.title"/> </h1>
  
  <form:form modelAttribute="cust">
    <table border="1"  bgcolor="cyan" align="center">
        <tr>
           <td><spring:message code="customer.name"/>  </td>
           <td><form:input path="cname"/>  </td>
        </tr>
         <tr>
           <td><spring:message code="customer.addrs"/>  </td>
           <td><form:input path="cadd"/>  </td>
        </tr>
        <tr>
           <td><spring:message code="customer.billAmt"/>  </td>
           <td><form:input path="billAmt"/>  </td>
        </tr>
        <tr>
           <td colspan="2"><input type="submit" value="<spring:message code="customer.submit"/>" /></td>
        </tr>
    </table>
  </form:form>
  <br><br>
    <a href="?lang=de_De">German</a>  &nbsp;&nbsp;
    <a href="?lang=hi_IN">हिन्दी< </a>  &nbsp;&nbsp;
    <a href="?lang=en_US">English</a>  &nbsp;&nbsp;
    <a href="?lang=zh_CN">China</a>  &nbsp;&nbsp;
    <br><br>
      
      <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
      
      <b> current Locale is :: ${pageContext.response.locale} </b>
      
      <fmt:setLocale value="${pageContext.response.locale}"/>
       <fmt:formatNumber  var="fsalary" value="${salary}" type="currency" />
      <h1>Salary  is  ::  ${fsalary }  </h1>
      <br>
      
      <fmt:formatDate var="fdate" value="${sysDate}"  type="both"/>
      <h1> SysDate  is  ::  ${fdate }  </h1>
  
  


  
