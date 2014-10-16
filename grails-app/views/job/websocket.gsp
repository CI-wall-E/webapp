<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="main"/>
  <asset:javascript src="jquery" />
  <asset:javascript src="spring-websocket" />

  <script type="text/javascript">
    $(function() {
      var socket = new SockJS("${createLink(uri: '/stomp')}");
      var client = Stomp.over(socket);

      client.connect({}, function() {
        client.subscribe("/topic/job", function(message) {
          $("#helloDiv").append(JSON.parse(message.body));
        });
      });

      $("#helloButton").click(function() {
        client.send("/app/job", {}, JSON.stringify("world"));
      });
    });
  </script>
</head>
<body>
<button id="helloButton">hello</button>
<div id="helloDiv"></div>
</body>
</html>