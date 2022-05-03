# Ctf
ctf prepared for 561, System Defense and Test

Name of the challenge : EncryptTheFlag
Category : Web, database and encryption based challenge


Flag : EncrpyptP@sswordsAlwAYs

Score Total : 100 points

Hint 1 (-15 points) : Notice that the password and username are being passed directly in url and are not encrypted. We can see the ip and port where the service is running clearly as well. We have notices one API that stores the user, are there other APIs that are also there on the server. Checkout the ways developers use to document their APIs.


Hint 2 (-30 points) : The Swagger for the challenge is open, the link for Swagger is http://localhost:9090/swagger-ui.html#/. Try the config API!
 