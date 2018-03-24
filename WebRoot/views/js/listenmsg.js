
window.WSK;
initsocket();
function initsocket() {
	if(window.WebSocket!=undefined){
			window.WSK=new WebSocket('ws://localhost:8080/webtest/websocket');
	    	WSK.onopen=function (evevt) {
	            console.log("连接成功")
	        }

	    	WSK.onmessage=function (event) {
	    		recivemsg(event.data);
	            
	        }
	    	WSK.onerror=function (event) {
	            alert('连接失败');
	            alert("Error:"+event.data);
	        }
			
    }else {
        alert('不支持聊天功能')
    }
}

function recivemsg(data){
	var jsondata=JSON.parse(data);
	var msg=jsondata.message;
	var formadmine=jsondata.fromadmine;
	var admine=document.getElementById("admine").innerHTML;
	if(admine==formadmine){
		var div=document.createElement('div');
	    var img=document.createElement('img');
	    var msgcontenddiv=document.createElement('div');
	    div.appendChild(img);
	    div.appendChild(msgcontenddiv);
	    img.className='lchathead';
	    msgcontenddiv.className='lmsgcontentdiv';
	    div.className='lmsgdiv';
	    img.src='../file/timg.jpg'
	    msgcontenddiv.innerHTML=msg;
	    var br=document.createElement('br');
	    var chatdiv=document.getElementById('chat');
	    chatdiv.appendChild(div);
	    chatdiv.appendChild(br);
	    console.log(msgarea.value);
	    msgarea.value='';
	    msgarea.focus();
	}else{
		alert(formadmine+"："+msg);
	}
}

function load(url){
	var body=document.getElementById("bd");
	var xmlhttp;
	if(window.XMLHttpRequest){
		 xmlhttp=new XMLHttpRequest();
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function(){
		body.innerHTML=xmlhttp.responseText;	
	}
	xmlhttp.open("get", url);
	xmlhttp.send();
}