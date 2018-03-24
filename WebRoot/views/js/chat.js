
window.WSK;
var backurl="/webtest/views/friendslist.jsp";
initsocket();

function goback(){
	load(backurl);
}
function chat(admine,name) {
    load("/webtest/views/chatview.jsp?toadmine="+admine+"&toname="+name);
}

function add(admine,name) {
    load("/webtest/AddFriend?addadmine="+admine+"&addname="+name);
}

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

function find(){
	var findvalue=document.getElementById("findvalue").value;
	var url="/webtest/SearchUser?searchwho="+findvalue;
	load(url);
}

function recivemsg(data){
	var jsondata=JSON.parse(data);
	var msg=jsondata.message;
	try{
		var formadmine=jsondata.fromadmine;
		var admine=document.getElementById("admine").innerHTML;
		console.log("chatadmine:"+admine+",fromadmine:"+formadmine)
		var msgarea=document.getElementById('msg');
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
	}catch(err){
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
	var index=url.indexOf("?");
	if(index>1){
		var urls=url.substring(0,url.indexOf("?"));
		var data=url.substring(url.indexOf("?")+1,url.length)
		console.log(urls);
		console.log(data);
		xmlhttp.open("post", urls);
		xmlhttp.setRequestHeader('content-type','application/x-www-form-urlencoded');
		xmlhttp.send(data);
		
	}else{
		xmlhttp.open("get", url);
		xmlhttp.send();
	}
	
}


function sendmsg(toadmine) {
    try{
        var msgarea=document.getElementById('msg');
        var msg=msgarea.value;
        var msgjson = {
            message: msg,
            toadmine: toadmine
        };
        try {
        	WSK.send(JSON.stringify(msgjson));
        }catch (err){
            alert(err);
        }
        var div=document.createElement('div');
        var img=document.createElement('img');
        var msgcontenddiv=document.createElement('div');
        div.appendChild(img);
        div.appendChild(msgcontenddiv);
        img.className='rchathead';
        msgcontenddiv.className='rmsgcontentdiv';
        div.className='rmsgdiv';
        img.src='../file/timg.jpg'
        msgcontenddiv.innerHTML=msg;
        var br=document.createElement('br');
        var chatdiv=document.getElementById('chat');
        chatdiv.appendChild(div);
        chatdiv.appendChild(br);
        console.log(msgarea.value);
        msgarea.value='';
        msgarea.focus();
    }catch (err){
        alert(err);
    }
}

function entersend(toadmine) {
    if(event.keyCode==13){
        sendmsg(toadmine);
    }
}