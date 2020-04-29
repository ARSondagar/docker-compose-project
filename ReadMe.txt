
#MY PROJECT

Here,i have created back-end structure project

Title:connect redis to Postgres database using jdbc

As you know redis is an in-memory database & ridiculously fast about 110000SETs/sec & 81000GETs/sec.But because of in-memory databse,we can store limited data.
on the other hand Postgres database provide data storage and SQL.So i have connnect redis database server to Postgres database using java database connectivity topic as my project.
i have use a docker-compose so with single command line your whole back-end structure will be running.
i have use 3 container for this system:
1]redis:In-memory database, used for accepting data from your data collection front-end app
2]Worker:jdbc service, used to fetch votes from Redis and store in Postres database.
3]db:PostgreSQL database, used as database.

Here is link of my project:
 

requirenment:docker/docker-compose  & redis image & postgres:9.4 image
-be sure to connect with internet
To run system clone project directory ..run command:docker-compose up 
then After lots of “Pull complete”, hundreds of megabytes and few minutes..Voila, we have the system up and running.
note:i have create only back-end system so to keep connection i have use print func in while loop..bt you can use SQL queries to fetch data from your front-end app & store it on Postgres database.
