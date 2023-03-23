Program uses 2 different APIs.  
1. weather API, it checks for sunsets to make sure there is dawn outside.  (https://api.sunrise-sunset.org/json) 
2. NASA ISS live location API.   (http://api.open-notify.org/iss-now.json)

Program keeps checking the location of ISS in space station. 
The data for live location is being downloaded from NASA API. 
Program should be running on cloud and notified you via email when conditions are met 
 - its after sunset
 - nasa is close +/-5 degrees from your LAT and LONG