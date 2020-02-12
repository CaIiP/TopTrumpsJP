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

	
          
    </div>

 
   <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
<header>
    <div class="header">
        <center><h1 style="background-color:#000FFF; font-size:40px; color:#FFFFFF; text-align:center; padding:20px">Top Trumps Game</h1></center>
    </header>
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
            <body>
    	         <style>

                       .categoryButtons {
                        position: absolute;
                        center: 100;
                        font: bold;
                        text-align: center;
                    }

                    #nextButton {
                        position: absolute;
                        right: 0;
                        bottom: 100;
                        left: 1100;
                        font: bold;
                        text-align: center;
                    }
         </style>
  
  </div>
  <div class = "container">

                    <div class="mx-auto" style="width: 200px;">
        <div class="card border-danger mb-3" style="width: 18rem;">
                <div class="card-header text-center text-white bg-danger mb-3" style="max-width: 18rem;">
                    <h5 id="activePlayer"></h5>
                    <p id="communalPile"></p>
                    <p id="roundNumber"></p>
                </div>
                <div class="card-body text-center">
                        <h5 id="ann1"></h5><br/>
                        <p id="ann2"></p>
                    </div>
                  </div><br/><br/>
    </div>
    
    <div class="container">	
		<div id="playing-cards" class="container">
    <div class="card-deck">
    <div  class="card border-success" id="card1" style="width: 18rem;">
            <div class="card-header text-white text-center bg-success mb-3" style="max-width: 18rem;">
                <h5>Player 1</h5>
                <p id="numberCard1"></p>
            </div>
            <div class="card-name text-center">
                    <h5 id="cardName1"></h5>
                </div>
                
                <div class="card-body">
                  
                  <p class="card-attributes">
                    <ul>
                        <li id="attribute1"></li>
                        <li id="attribute2"></li>
                        <li id="attribute3"></li>
                        <li id="attribute4"></li>
                        <li id="attribute5"></li>
                      </ul>
                  </p>
                </div>
              </div>
		
              <div class="card border-warning" id="card2" style="width: 18rem;">
                    <div class="card-header text-center text-white bg-warning mb-3" style="max-width: 18rem;">
                        <h5>Player 2</h5>
                        <p id="numberCard2"></p>
                    </div>
                    <div class="card-name text-center">
                        <h5 id="cardName2"></h5>
       
                        </div>
                        <div class="card-body">
                          
                          <p class="card-attributes">
                              <ul>
                                  <li id="attributeB1"></li>
                        <li id="attribute6"></li>
                        <li id="attribute7"></li>
                        <li id="attribute8"></li>
                        <li id="attribute9"></li>
                              </ul>
                          </p>
                        </div>
                      </div>

                      <div class="card border-warning" style="width: 18rem;">
                            <div class="card-header text-center text-white bg-warning mb-2" id="card3" style="max-width: 18rem;">
                                <h5>Player 3</h5>
                                <p id="numberCard3"></p>
                            </div>
                            <div class="card-name text-center">
                                <h5 id="cardName3"></h5>
                                </div>
                                <div class="card-body">
                                  
                                  <p class="card-attributes">
                                      <ul>
                                         <li id="attributeC1"></li>
                        <li id="attribute10"></li>
                        <li id="attribute11"></li>
                        <li id="attribute12"></li>
                        <li id="attribute13"></li>
                                      </ul>
                                  </p>
                                </div>
                              </div>

                              <div class="card border-warning" style="width: 18rem;">
                                    <div class="card-header text-center text-white bg-warning mb-3" id="card4" style="max-width: 18rem;">
                                        <h5>Player 4</h5>
                                        <p id="numberCard4"></p>
                                    </div>
                                    <div class="card-name text-center">
                                        <h5 id="cardName4"></h5>
                                        </div>
                                        <div class="card-body">
                                          
                                          <p class="card-attributes">
                                              <ul>
                                                <li id="attributeD1"></li>
                        <li id="attribute14"></li>
                        <li id="attribute15"></li>
                        <li id="attribute16"></li>
                        <li id="attribute17"></li>
                                              </ul>
                                          </p>
                                        </div>
                                      </div>

                                      <div class="card border-warning" style="width: 18rem;">
                                            <div class="card-header text-center text-white bg-warning mb-3"  style="max-width: 18rem;">
                                                <h5>Player 5</h5>
                                                <p id="numCard5"></p>
                                            </div>
                                            <div class="card-name text-center">
                                                    <h5 id="cardName5"></h5>
                                                </div>
                                                <div class="card-body">
                                                  
                                                  <p class="card-attributes">
                                                      <ul>
                                                          <li id="attributeE1"></li>
                        <li id="attribute18"></li>
                        <li id="attribute19"></li>
                        <li id="attribute20"></li>
                        <li id="attribute21"></li>
                                                      </ul>
                                                  </p>
                                                </div>
                                              </div>
  </div>  
  
<button type="button" id="nextButton" onclick="updateGame();" class="btn btn-primary btn-lg">Next</button><h:form style="display: block; text-align: center; margin: auto; width: 200px"> 
      <center>  <div  class="categoryButtons" id="categoryButtons">                                      
        <button id="sizeButton" onclick="response(0); Category();">Size</button>
        <button id="speedButton" onclick="response(1); Categoty();">Speed</button>
        <button id="rangeButton" onclick="response(2); Category();">Range</button>
        <button id="firePower" onclick="response(3); Category();">Firepower</button>
        <button id="cargoButton" onclick="response(4); Category();">Cargo</button>
        </center>
    </div></h: form>  </div><br/><br/>

      
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