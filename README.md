# ShortenUrl
To create a shorter url and present that to the user instead of a very large url

# Statement
You have given a (typically) long URL, how would you design service that would generate a shorter and unique alias for it?

# Test Cases
- The test cases are written in the code for each part which can be used to check the working of the code.
  ## Steps to run
  - Since its a maven build so we can do a mvn clean install and thus the whole code will run and along with the test cases 

# Assumptions
- the traffic will be low so that the number of urls which this code can generate does not exceed that.

# Future 
- The code can futhur be improved by adding clusters or more logic such that there are more instances such that the uniqueness can be maintained.
- Also something like a validity can be added to the code so that the data (shorten url) is not always valid and the space in the DB is optimally used.
