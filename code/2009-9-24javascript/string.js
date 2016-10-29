String.prototype.trim = function(){
	var str = this.toString();
	var leng = str.length;
	var index = str.indexOf(" ");
	if(index == 0){
		str = str.substr(index + 1,leng - 1);
						
		if(str.indexOf(" ") == 0){
			str = trim(str);
		}
	}
	while(str.lastIndexOf(" ") != -1){
		str = str.substr(0,str.length - 1);
	}
					
	return str;
}
