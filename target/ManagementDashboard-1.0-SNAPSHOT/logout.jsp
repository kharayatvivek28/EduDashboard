<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // Invalidate the session to log the user out
  session.invalidate();
  // Redirect to index.jsp
  response.sendRedirect("index.jsp");
%>
