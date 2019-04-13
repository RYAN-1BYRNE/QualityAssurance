# QualityAssurance
This repository describe how unit tests can be used to find bugs.

Let's start with explaining the scenario.

There is system of bikes where you can find different kinds of
bikes with different features. Also there are some common features
that each bike may have. In this scenario, a bike can be a mountain
bike or a road bike and each have some common features as well as 
some unique features. A garage need to keep track of the bikes that it
contains and wish to have a program to make their lives easy.

**What you should focus on the program?**

There are two main methods that does some calculations and printing.
    
    1. calculateServiceInterval method
    2. toString method
    
The sub classes overrides these methods of the super class
and each bike have unique approach in calculating the service interval 
and also with printing the object as a string.

The class BikeSystem can be treated as the operator of the above three mentioned 
classes. The BikeSystem class contains five important methods that keeps and stores 
details about the bikes.

    1. insertBike
    2. bikeExists
    3. printSystem
    4. closeGarage
    5. printServiceIntervals
    
The program keeps a list of a given length to keep track of the maximum
number of bikes that can be kept in the garage at once.

The method 'insertBike' will allow a bike to be inserted into the garage if there
empty space and if not a duplicate bike.

The method 'bikeExists' will check for duplicates in the list of bikes. For that the
method will need only the owner and the model number.

The method 'printSystem' will print details of each bike in the garage.

The method 'closeShop' will remove all the bikes in the garage.

The method 'printServiceIntervals' will print all the calculated service intervals of each bike.

The bikeStrings will be given in the following formats : 

    `BIKE|<owner>|<model>|<wheelDiameter>|<gears>|<kmsRidden>`
    `MTB|<owner>|<model>|<wheelDiameter>|<gears>|<kmsRidden>|<suspensionDepth>`
    `RB|<owner>|<model>|<wheelDiameter>|<gears>|<kmsRidden>|<reflectorsFitted>`