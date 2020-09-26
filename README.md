# ShortenUrl
To create a shorter url and present that to the user instead of a very large url

# Statement
You have given a (typically) long URL, how would you design service that would generate a shorter and unique alias for it?

# Infomation Cases
- The application will run on local machine and will connect to the H2 database so that the data is saved in that itself.
- The test cases are written in the code for each part which can be used to check the working of the code.
  ## Steps to run the test
  - Since its a maven build so we can do a mvn clean install and thus the whole code will run and along with the test cases 

# Assumptions
- the domain to which the shortened url will be present such that when the call is made it will hit that domain with the shortened Url to get the data(currently this application is confirgured to run on local system so localhost:8080)
- the traffic will be low so that the number of urls which this code can generate does not exceed that.
- For handling huge traffic Db would be provided such that the data the saved our there(Currently its using the H2 database ).

# Future 
- The performance can futhur be improved by adding clusters with load balancers such that there are more instances such that the uniqueness can be maintained and also for handling huge amount of traffic.
- Also something like a validity can be added to the code so that the data (shorten url) is not always valid and the space in the DB is optimally used.
