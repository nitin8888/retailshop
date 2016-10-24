Retail Shop functionality to add shop and retrieve closest shop to the customer location.

Prerequisite:
Java 1.8
Git
Chrome Postman

Setup:
The software is stored in the git hub repository location.
http://github.com/nitin8888/retailshop

Create a clone of the above link using command.
git clone http://github.com/nitin8888/retailshop


Build and unit test:
Use the command to build and perform unit tests from folder ../retailshop:
./gradlew build

Run:
To build and start the application
./gradlew build && java -jar build/libs/gs-spring-boot-0.1.0.jar


Test:

1. Create 3 Tesco shops using Chrome Postman to post the json files. The json files are also available in the ../retailshop/src/test/resource/json location.
The URL to post json file is: localhost:8080/shop

a. Tesco (Old Street) json file
{
	"name": "Tesco Old Street",
	"addressNumber": "1",
	"postCode": "EC1Y 1AG"
}

b. Tesco (Bank) json file
{
	"name": "Tesco Bank",
	"addressNumber": "120",
	"postCode": "EC2N 1AR"
}


c. Tesco (Morden) json file
{
	"name": "Tesco Morden",
	"addressNumber": "365",
	"postCode": "SW20 8JX"
}

2. Assume the customer is near Monument station i.e. the closest shop will be Tesco (Bank)
The URL to get closest shop:
localhost:8080/closestShop/?latitude=51.510143&longitude=-0.0881307

The result should be Tesco Bank and screen shot is uploaded in the git repository ../retailshop/Test result.png
