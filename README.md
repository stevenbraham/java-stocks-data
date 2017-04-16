# About
A small project to brush off my Java skills. This program allow you to input a stock symbol eg GOOG or AAPL and retrieve information about the company and the current stock price.

This project follows the [Maven project guidelines](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).

After building the jar, you can run the program like this: `java -jar java-stock-data.jar AAPL`.

This will output something similair to:

```
Apple Inc
NASDAQ
141.05
```

My repo also includes JUnit unit tests. Exectute `mvn test` to run them.
