<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Getting Started: Handling Form Submission</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   </head>
   <body>
      <h1>Form</h1>
      <form method="POST" action="/user/${user.id}/update">
         <div class="form-row">
            <h2>
            You can update email and phone
            <h2>
            <div class="form-group col-md-2">
               <input type="email" class="form-control" name="email" placeholder=${user.email}>
            </div>
            <div class="form-group col-md-2">
               <input type="phone" class="form-control" name="phone"
                  placeholder=${user.phone}>
            </div>
         </div>
         <button type="submit" class="btn btn-primary">Update user</button>
      </form>
   </body>