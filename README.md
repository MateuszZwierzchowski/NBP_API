To run the server use the following command in a terminal:
java -jar {Path to place where the project is located}/NBP_API/out/artifacts/NBP_API_jar/NBP_API.jar fully.qualified.package.Application

 {date} in format YYYY-MM-DD

Endpoint to get average exchange rate of a certain currency at a certain date:
http://localhost:8080/AvgExchange?date={date}&currencyCode={currency_code}
 
Endpoint to get the max and min average value of a certain currency from a certain number of last quotations: 
http://localhost:8080/MinMaxExchange?lastQuotations={number_of_last_quotations}&currencyCode={currency_code}
 
Endpoint to get the major difference between the buy and ask rate of a certain currency from a certain number of last quotations: 
http://localhost:8080/DifferenceBuyAsk?lastQuotations={number_of_last_quotations}&currencyCode={currency_code}
