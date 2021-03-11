<%@ page  isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:choose>
  <c:when test="${!empty empsList}">
    <table  border="1" bgcolor="pink" align="center">
       <tr>
          <th>ENO</th><th>ENAME</th><th>EADD</th><th>EMPSALARY</th><th>Operations </th>  
       </tr>
       <c:forEach  var="emp" items="${empsList}">
          <tr>
              <td>${emp.eno}  </td>
              <td>${emp.ename}  </td>
              <td>${emp.eadd}  </td>
              <td>${emp.esalary}  </td>
              <td>
               <a href="edit?no=${emp.eno}"><img src="images/edit.jpg" width="50px;" height="50px;"> </a>
               <a href="delete?no=${emp.eno}" onclick="return confirm(' Do u want to delete?')"><img src="images/delete.jfif" width="50px;" height="50px;"> </a>
                </td>
          </tr>
       </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
         <h1 style="color:red;text-align:center">No Records found </h1>
  </c:otherwise>
</c:choose>
    <blink><h1 style="color:red;text-align:center">${resultMsg}</h1> </blink>