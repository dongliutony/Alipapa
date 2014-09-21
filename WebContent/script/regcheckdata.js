function checkdata() {
	var ssn=form.username.value.toLowerCase();
	
	if (!checkUserName(ssn)) return false;  //username check
	
	if( strlen(form.password.value)<6 || strlen(form.password.value)>16 ) {
		alert("\A valid password must be 6~16 characters with algibet and digit")
		form.password.focus()
		return false;
	}
	
	if( strlen2(form.password.value) ) {
		alert("\Your password includes invalid character!")
		form.password.focus()
		return false;
	}
	if( form.password.value == form.username.value ) {
		alert("\Username and password cannot be the same")
		form.password.focus()
		return false;
	}
	if( form.password2.value =="" ) {
		alert("\Please re-input password")
		form.password2.focus()
		return false;
	}
	if( form.password2.value != form.password.value ) {
		alert("\Passwords are not consistant")
		form.password.focus()
		return false;
	}	
	if( form.phone.value =="" ) {
		alert("\Please input phone number")
		form.phone.focus()
		return false;
	}
	form.addr.value = form.addr.value.replace(/(^\s*)|(\s*$)/g, "");
	if( form.addr.value =="" ) {
		alert("\Please input a valid address")
		form.addr.focus()
		return false;
	}
	return true;
}

function checkUserName(ssn){
	if( ssn.length<3 || ssn.length>18 ) {
		alert("\please input a valid username, including 3-18 characters")
		//document.getElementById("usernameErr").innerHTML = "<font color='red'>��������ȷ���û���,�û����Ϊ3-18λ��</font>";
		form.username.focus()
		return false;
	}
	if (isWhiteWpace(ssn)){
		alert("\please input a valid username, without space")
		form.username.focus()
		return false;
	}
	if (!isSsnString(ssn)){
		alert("The username you input is used, please choose another one.")
		form.username.focus()
		return false;
	}
	return true;
}

function strlen(str){
	var len;
	var i;
	len = 0;
	for (i=0;i<str.length;i++){
		if (str.charCodeAt(i)>255) len+=2; else len++;
	}
	return len;
}

function strlen2(str){
	var len;
	var i;
	len = 0;
	for (i=0;i<str.length;i++){
		if (str.charCodeAt(i)>255) return true;
	}
	return false;
}

function isWhiteWpace (s)
{
	var whitespace = " \t\n\r";
	var i;
	for (i = 0; i < s.length; i++){   
		var c = s.charAt(i);
		if (whitespace.indexOf(c) >= 0) {
		  	return true;
		}
	}
	return false;
}

function isSsnString (ssn)
{
	var re=/^[0-9a-z][\w-.]*[0-9a-z]$/i;
	if(re.test(ssn))
		return true;
	else
		return false;
}

function checkssn(gotoURL) {
   var ssn=form.username.value.toLowerCase();
   if (checkUserName(ssn)){
	   var open_url = gotoURL + "?username=" + ssn;
	   window.open(open_url,'','status=0,directories=0,resizable=0,toolbar=0,location=0,scrollbars=0,width=322,height=200');
	}
}
