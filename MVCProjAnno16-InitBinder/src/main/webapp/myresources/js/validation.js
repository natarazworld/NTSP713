
function validate(frm){
   // empty the form validation error messages
   document.getElementById("cnameErr").innerHTML="";
   document.getElementById("caddErr").innerHTML="";
   document.getElementById("billAmtErr").innerHTML="";
   //read from data
   let name=frm.cname.value;
    let addrs=frm.cadd.value;
    let bamt=frm.billAmt.value;
    //form validation logic  (client side)
    let  flag=true;
    if(name==""){
	     document.getElementById("cnameErr").innerHTML="Customer name is required";
         flag=false;
    }
   else if(name.length<5){
	 document.getElementById("cnameErr").innerHTML="Customer name must have minimum 5 chars";
         flag=false;
   }

   if(addrs==""){
	     document.getElementById("caddErr").innerHTML="Customer address is required";
         flag=false;
    }
   else if(addrs.length<8){
	 document.getElementById("caddErr").innerHTML="Customer address must have minimum 8 chars";
       flag=false;
   }

    if(bamt==""){
	     document.getElementById("billAmtErr").innerHTML="Customer BillAmt is required";
         flag=false;
    }
else if(isNaN(bamt)){
	     document.getElementById("billAmtErr").innerHTML="Customer BillAmt be numberic value";
         flag=false;
}
  else if(bamt<=0){
	     document.getElementById("billAmtErr").innerHTML="Customer billAmt must be positive number";
         flag=false;
   }
    // change vflag (hidden box) value to "yes" from "no"  to indicate client side form validations are done
      frm.vflag.value="yes";
  return flag;

}