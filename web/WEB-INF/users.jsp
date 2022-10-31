<%-- 
    Document   : users
    Created on : Oct 25, 2022, 9:28:27 AM
    Author     : Allan T
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
      <h1>Manage Users</h1>
        <form action="User" method="post">
            <table border ="1">
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <c:choose>
                                <c:when test="${user.getRole() == 1}">
                                    <td>system admin</td>
                                </c:when>
                                <c:otherwise>
                                    <td>regular user</td>
                                </c:otherwise>
                            </c:choose>
                        <a href="notes?action=view&amp;noteId=${note.noteId}">${note.title}</a><br></li>
                        <td> <a href="user?action=edit&amp;email=${user.email}">Edit</a>
                                   
                                   
                        <td> <a href="<c:url value='User?action=delete&amp;userEmail=${user.email}' />">Delete</a> </td>
                    </tr>
                </c:forEach>   
            </table> 
        </form>
        <c:if test="${selectedUser eq null}">
            <h2>Add User</h2>
            <form  action=" " method = "post">
                Email: <input type="test" name="email"  required ><br>
                First Name: <input type="test" name="firstName"  required><br>
                Last Name: <input type="test" name="lastName"  required><br>
                Password: <input type="test" name="password"  required><br>
                Role:
                <select name="role">
                            <c:forEach var="role" items="${roles}" >
                                <c:choose>
                                    <c:when test="${role.getId() == 1}">
                                        <option>system admin</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>regular user</option>
                                    </c:otherwise>
                                </c:choose>
                          </c:forEach>
                      </select>
                <input type="hidden" name="action" value="add" >
                <input type="submit" value="Add user">

            </form>
        </c:if>
          <c:if test="${selectedUser ne null}">
            <h2>Edit User</h2>
            <form  action="" method = "post">
                Email:    <input type="hidden" name="email" value="${selectedUser.email}"><br>
              
                First Name: <input type="test" name="firstName" value=${selectedUser.firstName}><br>
                Last Name: <input type="test" name="lastName" value=${selectedUser.lastName}><br>
                Password: <input type="test" name="password" value=${selectedUser.password}><br>
                 Role: <select name="role">
                            <c:choose>
                                <c:when test="${selectedUser.getRole() == 1}">
                                   
                                    <option>regular user</option>                              
                                </c:when>
                                <c:otherwise>
                                  
                                    <option>system admin</option>
                                </c:otherwise>
                            </c:choose>
                    </select><br>
                <input type="hidden" name="action" value="edit" >
                <input type="submit" value="update"> 

            </form>
                 <form action="UserServlet" method="post">
                     <input type="hidden" name="action" value="delete" >
                <input type="submit" value="Delete"> 
                 </form>
          </c:if>
    </body>
</html>
