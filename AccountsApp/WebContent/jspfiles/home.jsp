<html>
 <head>
  <title>My Title</title>
 </head>
 <body>
  <p>Hello 
  <% out.write(""+session.getAttribute("myemail")); %>
  </p>
    <a href="../Home">
        <button type="button" >logout </button></a>
   
 </body>
</html>