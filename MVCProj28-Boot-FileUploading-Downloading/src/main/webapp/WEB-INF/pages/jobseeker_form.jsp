<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<h1 style="color:red;text-align:center"> File Uploading</h1>

 <form:form  modelAttribute="jsForm" enctype="multipart/form-data">
   <table border="1" align="center" bgcolor="cyan">
          <tr>
             <td>JobSeeker name ::  </td>
             <td><form:input path="jsName"/> </td>
          </tr>
          <tr>
             <td>JobSeeker Qualification ::  </td>
             <td><form:input path="jsQlfy"/> </td>
          </tr>
          <tr>
             <td>JobSeeker Photo ::  </td>
             <td><input type="file" name="photo"/>(max size ::20kb) </td>
          </tr>
          <tr>
             <td>JobSeeker resume ::  </td>
             <td><input type="file" name="resume"/>( max size:20kb) </td>
          </tr>
          
          <tr>
             <td colspan="2"><input type="submit" value="Upload & register"> </td>
          </tr>
   </table>
 
 </form:form>