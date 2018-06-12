# Spring-Cloud-Sample
Sample REST based micro-services developed using netflix oss (eureka,ribbon,zuul,hystrix etc.).
## Architecture Overview

![micro-service 1](https://user-images.githubusercontent.com/12646868/41308911-d1ed7d98-6e9a-11e8-955f-0590c06553dd.jpg)

## Description

Following are the urls where the services are running:

eureka-sever -- http://localhost:8761

sample-recommendations -- http://localhost:8000/recommend (Though this should not be revealed to the outside world.It will be accessed via Zuul)

sample-inventory -- http://localhost:8003/buy (Though this should not be revealed to the outside world.It will be accessed via Zuul).

sample-zuul-proxy -- http://localhost:8999/api/recommendations/recommend (To access the sample recommendations service)

sample-hystrix-dashboard -- http://localhost:9000/hystrix


Happy Coding.Cheers!!!
