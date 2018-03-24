
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