
var emails=['a@com','b.com'];
var password=['a','b']
function validateForm() {
  var name = document.forms["myForm"]["name"].value
  console.log(name);
  
  var email = document.forms["myForm"]["email"].value;
  var pass2 = document.forms["myForm"]["psw-repeat"].value;
  var pass = document.forms["myForm"]["psw"].value;
  console.log(email);
  if(pass != pass2){
    alert("Invliad user  password");
    return false;
  }
emails.push(email);
password.push(pass);
 
}

function validatelogin() {
var flag=1;
    
   var em = String(document.forms["myForm2"]["email"].value);
    var pass = document.forms["myForm2"]["psw"].value;
    console.log("java script");
    console.log(em);
    console.log("java script");
  // window.location.href = home.html;
   //document.location = "home.html";
    // Simulate an HTTP redirect:
//window.location.replace();
  /*  for( var i=0;i<emails.length;i++){
       if(em==emails[i] && pass==password[i]){
          flag=1;
          break; 
          
        }
    }
    if(flag==1){
      alert("Invliad user name or password");
        return true;
       
    }else{
        console.log("enter vailid data");
        return true;
    }*/
   
    return true;
   
  }