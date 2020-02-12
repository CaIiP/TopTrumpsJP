<html>

	<head>
		<!-- Web page title -->
    	<title>Top Trumps</title>
    	
    	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

		<!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
		<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/TREC_IS/bootstrap.min.css">
    	<script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
    	<script>vex.defaultOptions.className = 'vex-theme-os';</script>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex.css"/>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex-theme-os.css"/>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

</head>

    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
    <div class="header"><center><h1 style="background-color:#000FFF; font-size:40px; color:#FFFFFF; text-align:center; padding:20px">Top Trumps Game</h1></center>
 
    
	</div>

<body>
        <style>
        	
            .footer {
            position: absolute;
            right: 0;
            bottom: 0;
            left: 0;
            width: 100%;
            padding: 2rem;
            background-color: #4d4d4d;
            color: #ffffff;
            font-family: Arial;
            font-size: 14px;
        }

    </style>	
    	<div class="container">
<div class="container">
        			<p class="lead" id="p1"><h2><center>Please select below:</h2></center></p>
      			</div>

    
	<center><div class="container">
  <div class="row">
    <div class="col-sm-3">
    New Game
    <div class="row">
    
    <div class="col-3 col-sm-3">
    <a class="btn btn-lg btn-primary text-white text-center" href="/toptrumps/game" id="startGameBtn">New Top Trumps Game</a></center>
    </div>
    </div>
  </div>
  </div>
  </div>
  
  
  <div class="container">
  <div class="row">
    <div class="col-sm-9">
    Game Statistics
    <div class="row">
    
    <div class="col-8 col-sm-6">
    <a class="btn btn-lg btn-primary text-white text-center" href="/toptrumps/stats" id="statsBtn">Previous Games Statistics</a>
    </div>
    </div>
  </div>
  </div>
  </div>
		
		</div>
		
<body>
        <style>

            .footer {
            position: absolute;
            right: 0;
            bottom: 0;
            left: 0;
            width: 100%;
            padding: 2rem;
            background-color: #4d4d4d;
            color: #ffffff;
            font-family: Arial;
            font-size: 14px;
        }

    </style>

<div class="footer"><center>
            Presented by Javamir Putin </br>Shannen Harper 2095119H - Calum Paterson 2040455P - Fara Stringfellow 2131715S - Rija Fatima 2229772F </center>
        </div>
		
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			
				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------
				
				// For example, lets call our sample methods
				helloJSONList();
				helloWord("Student");
				
			}
			
			// -----------------------------------------
			// Add your other Javascript methods Here
			// -----------------------------------------
		
			// This is a reusable method for creating a CORS request. Do not edit this.
			function createCORSRequest(method, url) {
  				var xhr = new XMLHttpRequest();
  				if ("withCredentials" in xhr) {

    				// Check if the XMLHttpRequest object has a "withCredentials" property.
    				// "withCredentials" only exists on XMLHTTPRequest2 objects.
    				xhr.open(method, url, true);

  				} else if (typeof XDomainRequest != "undefined") {

    				// Otherwise, check if XDomainRequest.
    				// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    				xhr = new XDomainRequest();
    				xhr.open(method, url);

 				 } else {

    				// Otherwise, CORS is not supported by the browser.
    				xhr = null;

  				 }
  				 return xhr;
			}
		
		</script>
		
		<!-- Here are examples of how to call REST API Methods -->
		<script type="text/javascript">
		
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloJSONList() {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloJSONList"); // Request type and URL
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}
			
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloWord(word) {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloWord?Word="+word); // Request type and URL+parameters
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}

		</script>
		
		</body>
</html>