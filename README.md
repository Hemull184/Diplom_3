# Diplom_3

> A curated list of Diplom_3 Project


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#How-to-run-allure-report">How to run allure report</a>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Third project of the Diplom

selenium

Themes used:
* selenium
* allure


### Built With

* Java 11
* JUnit                   4.13.2
* maven-surefire-plugin   2.22.2
* allure-maven            2.10.0
* maven-compiler-plugin   3.10.1
* Allure                  2.20.1




<p align="right">(<a href="#readme-top">back to top</a>)</p>




<!-- USAGE EXAMPLES -->
## How to run jacoco report

To run the report with browser Chrome, enter this command in the console

> mvn clean verify

To run the report with browser Yandex, enter this command in the console

> mvn clean test -Dbrowser_type=yandex

## How to run Allure report

To run the report, open Docker Desktop, then enter this command in the console

> docker-compose up

Then type 

> http://localhost:8081/

in your browser and create your Allure report


## How to run Allure report in local IDEA

To run the report , enter this command in the console after you build jacoco report

> mvn allure:serve

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Konstantin Adianov  -  Adianovkonstantin@yandex.ru

Project Link: [https://github.com/Hemull184/Diplom_3](https://github.com/Hemull184/Diplom_3/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
