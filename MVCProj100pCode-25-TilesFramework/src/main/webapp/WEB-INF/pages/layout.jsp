<%@page isELIgnored="true" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles" %>
<head>
  <title><tiles:insertAttribute name="title"  ignore="true"/>   </title>
</head>

<table border="1" width="100%" height="100%">
  <tr height="30%" bgcolor="yellow">
     <td colspan="2"><tiles:insertAttribute name="header"/>     </td>
  </tr>
  <tr height="60%">
     <td width="30%" bgcolor="orange"><tiles:insertAttribute name="menu"/>       </td>
     <td width="70%"  bgcolor="cyan"><tiles:insertAttribute name="body"/>       </td>
  </tr>
  <tr  height="10%" bgcolor="pink">
      <td colspan="2"><tiles:insertAttribute name="footer"/>  </td>
  </tr>
</table>


