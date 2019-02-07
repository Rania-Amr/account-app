 <!-- Button to open the modal -->
 <html>
     <head>
            <link rel="stylesheet" href="style.css">
            <script src="myscripts.js"></script> 
           
     </head>
     <body>
 <!-- The Modal (contains the Sign Up form) -->

   <form class="modal-content" action="SignUp" form name="myForm"  onsubmit="return validateForm()" method="post" >
     <div class="container">
       <h1>Sign Up</h1>
       <p>Please fill in this form to create an account.</p>
       <hr>
       <label for="Fname"><b> First Name</b></label>
       <input type="text" placeholder="Enter your first name " name="Fname" required>
 
       <label for="Lname"><b> Last Name</b></label>
       <input type="text" placeholder="Enter your last name " name="Lname" required>
 
       <label for="Phone"><b>Phone</b></label>
       <input type="text" placeholder="Enter your phone "   pattern="[0-9]+" name="Phone" required>

       <label for="Birthday"><b>Birthday</b></label>
       <input type="date" name="Birthday" required>
 
       <label for="email"><b>Email</b></label>
       <input type="email" placeholder="Enter Email" name="Email" required>
 
       <label for="psw"><b>Password</b></label>
       <input type="password" placeholder="Enter Password" name="Psw" required>
 
       <label for="psw-repeat"><b>Repeat Password</b></label>
       <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
       <label for="department"><b>Department</b></label>
       <select name="Department">
        <option value="CS">CS</option>
        <option value="Math">Math</option>
        <option value="Statistics">Statistics</option>
        <option value="Chemistry">Chemistry</option>
        <option value="Physics">Physics</option>
        <option value="Physiology">Physiology</option>
      </select>
       <div class="clearfix">

         <button type="submit" class="signup">Sign Up</button>
       </div>
       
      <a href="SignUp">
        <button type="button">Login</button>  
		</a>
      </div> 
   </form>
 


</body>
 </html>