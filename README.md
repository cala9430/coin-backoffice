# coin-backoffice

####Download image from docker-hub
`docker pull cala9430/coin-backoffice:<version>`

####Run image on container
`docker run --rm -p 8080:8080 cala9430/coin-backoffice:<version>`

####Build Angular and serve with Spring-Boot
`ng build --prod`
`mv dist/coin-front/* ../src/main/resources/static/`