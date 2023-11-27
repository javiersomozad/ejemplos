var stompClient = null;

$(function () {
    $( "#connect" ).click(function() { 
      connect(); 
    });
    
    $( "#disconnect" ).click(function() { 
      disconnect(); 
    });
    
    $( "#send" ).click(function() { 
      sendMessage($("#nickname").val(),$("#message").val(),'/app/chat'); 
    });
});

function connect() {
    var socket = new SockJS('/anaya-ws');
    stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function () {
        setConnected(true);
        console.log('Connected with websockets server.');
        
        stompClient.subscribe('/chat/messages', function (message) {
          console.log('Received from server: ' + message);
            appendMessage(JSON.parse(message.body));
        });
        
        stompClient.subscribe('/chat/notifications', function (message) {
          console.log('Received notifications from server: ' + message);
            appendNotification(JSON.parse(message.body));
            if (JSON.parse(message.body).text === 'DISCONNECT') {
              setDisconnect();
            }            
        });
        
      sendMessage($("#nickname").val(),'User entered','/app/enter'); 
    });
}

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    $("#nickname").prop('disabled', connected);
    $("#send").prop('disabled', !connected);
}


function disconnect() {  
    if (stompClient !== null) {
      sendMessage($("#nickname").val(),'DISCONNECT','/app/enter'); 
    }
    setConnected(false);
}

function setDisconnect() {  
  stompClient.disconnect();
    setConnected(false);
}

function sendMessage(who, text, wsEndPoint) {
  let message = {'text': text, 'channel': 'general','who': who};
    stompClient.send(wsEndPoint, {}, JSON.stringify(message));
    $("#message").val('');
}

function appendMessage(message) {
    $("#messages").append("<div><b>" + message.who + "</b>&gt; " + message.text + "</div>");
}

function appendNotification(message) {
    $("#messages").append("<div><i>" + message.who + " " + message.text + "</i></div>");
}

