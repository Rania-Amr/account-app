<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <link rel="stylesheet" href="style.css">
  <script src="myscripts.js"></script>
</head>

<body>

  <!-- The Modal (contains the Sign Up form) -->


  <form class="modal-content" action="../Login" form name="myForm2" onsubmit="return validatelogin()" method="post">
    <div class="container">
      <h1>Login</h1>
      <p>Please fill in this form to create an account.</p>
      <hr>

      <label for="email"><b>Email</b></label>
      <input type="email" placeholder="Enter Email" name="email" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>

      <div class="clearfix">

        <button type="submit" class="login">Login</button>
      </div>
      <a href="../Login">
        <button type="button" >Create Account </button></a>
    </div>
   
  </form>
  

</body>

</html>