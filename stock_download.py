import yfinance as yf
import pandas as pd

ticker_names = ["AAPL", "MSFT", "GOOG", "AMZN", "TSLA", 
                "BRK-B", "UNH", "JNJ", "XOM", "V", "META",
                "WMT", "CVX", "JPM", "LLY", "NVDA", "PG",
                "HD", "MA", "BAC", "ABBV", "PFE", "KO", "PEP", "MRK",
                "COST", "TMO", "AVGO", "DHR", "ABT", "DIS", "MCD",
                "ORCL", "CSCO", "ACN", "WFC", "VZ", "COP", "NEE", "CRM",
                "BMY", "TXN", "SCHW", "UPS", "NKE", "LIN", "QCOM", "MS",
                "ADBE", "PM"]
data_num = []
data_sum = 0
for ticker in ticker_names:
    data = yf.download(ticker,"2012-01-01","2022-10-10")
    data_num.append((ticker, len(data)))
    data_sum += len(data)
    path = "/Users/yiming/Desktop/easy-invest/stocks_data/"
    data.to_csv(path + ticker + ".csv")

print(data_num)
print(data_sum)