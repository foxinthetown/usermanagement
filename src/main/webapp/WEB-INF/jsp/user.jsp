<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <h1 id="header">Manage users page</h1>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
      <style>
         table {
         border-collapse: collapse;
         }
         table, td, th {
         border: 1px solid black;
         }
         .center {
         text-align: center;
         }
         .button {
         display: inline-block;
         text-align: center;
         margin-top: 10px;
         margin-bottom: 10px;
         margin-right: 10px;
         margin-left: 10px;
         }
      </style>
   </head>
   <body>
      <h2>Add/update user</h2>
      <form method="POST" name="add_user" action="user" autocomplete="on">
         First name:<input type="text" name="firstName"><br>
         Last name: <input type="text" name="lastName"><br>
         Date of birth: <input type="date" name="dob"><br>
         E-mail: <input type="email" name="email"><br>
         Phone: <input type="text" name="phone" maxlength="10"><br>
         <button type="submit">Add user</button>
      </form>
      <h2>All users</h2>
      <table class="table table-striped">
         <thead>
            <tr>
               <th>#ID</th>
               <th>First Name</th>
               <th>Last Name</th>
               <th>DOB</th>
               <th>Email</th>
               <th>Phone</th>
               <th>Action</th>
            </tr>
         </thead>
         <c:forEach var="user" items="${users}">
            <tr>
               <td>
                  ${user.id}
               </td>
               <td>${user.userId.firstName}</td>
               <td>${user.userId.lastName}</td>
               <td>${user.userId.dob}</td>
               <td>${user.email}</td>
               <td>${user.phone}</td>
               <td>
                  <div>
                     <form method="POST" class="button" action="/user/${user.id}/delete">
                        <button type="submit">Delete</button>
                     </form>
                     <form method="GET" class="button" action="/user/${user.id}/update">
                        <button type="submit">Update</button>
                     </form>
                  </div>
               </td>
            </tr>
         </c:forEach>
      </table>
   </body>
</html>