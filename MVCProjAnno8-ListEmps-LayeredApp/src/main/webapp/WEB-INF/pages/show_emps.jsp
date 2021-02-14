<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<head>
  <link  rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<div class="container">
                 <h1> Result page</h1>
                 <c:choose>
     <c:when  test="${!empty listDTO }">
           <table  class="table-bordered  table-hover" >
               <tr class="danger">
                 <th>SrNo</th><th>EmpNo </th> <th> EmpName </th> <th>Desg</th> <th>Salary</th> 
               </tr>
               <c:forEach var="dto" items="${listDTO}">
                 <tr class="bg-success  text-danger">
                    <td>${dto.srNo}  </td>
                    <td>${dto.empNo}  </td>
                    <td>${dto.ename}  </td>
                    <td>${dto.job}  </td>
                    <td>${dto.sal}  </td>
                 </tr>
               </c:forEach>
           </table>
     </c:when>
     <c:otherwise>
         <h1 class="bg-warning text-white">No Records found</h1>
     </c:otherwise>
  </c:choose>
  <br><br>
     <h3 > <a href="welcome">home</a></h3> 
</div>




<%-- <%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

  <c:choose>
     <c:when  test="${!empty listDTO }">
           <table  border="1" bgcolor="cyan" align="center" >
               <tr bgcolor="blue">
                 <th>SrNo</th><th>EmpNo </th> <th> EmpName </th> <th>Desg</th> <th>Salary</th> 
               </tr>
               <c:forEach var="dto" items="${listDTO}">
                 <tr bgcolor="yellow">
                    <td>${dto.srNo}  </td>
                    <td>${dto.empNo}  </td>
                    <td>${dto.ename}  </td>
                    <td>${dto.job}  </td>
                    <td>${dto.sal}  </td>
                 </tr>
               </c:forEach>
           </table>
     </c:when>
     <c:otherwise>
         <h1 style="color:red;text-align:center">No Records found</h1>
     </c:otherwise>
  </c:choose>
  <br><br>
     <h3> <a href="welcome">home</a></h3> --%>
     
     
