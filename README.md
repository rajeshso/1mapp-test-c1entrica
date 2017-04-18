# mapp-test
This code challenge should be completed using akka actors and tested using the akka test actor test kit

There is only one actor in this systemThere is a build.sbt ready to use

As a client of the bean counter actor given I have 0 beans when I request a count of those beans from the bean counter actor then I receive a count with the value 0 from the bean counter actor

As a client of the bean counter actor given I have n > 0 beans when I request a count of those beans from the bean counter actor then I receive a count with the value n from the bean counter actor

As a client of the bean counter actor given I have 5 tomatoes when I request a count of those tomatoes from the bean counter actor then I receive a message with the value "Can't count, won't count tomatoes. i only count beans"
