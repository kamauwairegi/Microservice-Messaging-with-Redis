# Microservice-Messaging-with-Redis
How two micro services can communicate using redis
Microservice implementation of Monolithic blog app here >>  https://github.com/kamauwairegi/Monolithic-Messaging-With-Redis

This is an simulated implementation of how Redis can be used to solve such scenario assuming we have 1000s of bloggers and millions of subscribers. Sending emails needs queuing.

Posting and actual emails sending omitted for brevity.

# Requirement
Install redis https://redis.io/ from here
Checkout the code and run the two applications.

1. Publisher will run at port 8081 , http://localhost:8081
2. Receiver will run at port 8080, http://localhost:8080

# Simulation
To view the reults once redis is running, visit http://localhost:8081/simulate-post-blog
Logs will be displayed from reciver http://localhost:8080 console showing the recived message
