import requests
import lxml
from bs4 import BeautifulSoup
import os

email = "ENV EMAIL"
password = "ENV EMAIL"
recipient = "ENV EMAIL"

url = "YOUR AMAZON LINK"
header = {
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36",
    "Accept-Language": "en-GB,en-US;q=0.9,en;q=0.8"
}

response = requests.get(url, headers=header)

soup = BeautifulSoup(response.content, "lxml")
print(soup.prettify())

price = soup.find(id="priceblock_ourprice").get_text()
price_without_currency = price.split("$")[1]
price_as_float = float(price_without_currency)
print(price_as_float)

import smtplib

title = soup.find(id="productTitle").get_text().strip()
print(title)

BUY_PRICE = 200 # SET YOUR OWN PRICE HERE

if price_as_float < BUY_PRICE:
    message = f"{title} is now {price}"

    with smtplib.SMTP_SSL("smtp.gmail.com", 465) as my_email:
        my_email.login(user=email, password=password)
        my_email.sendmail(
            from_addr=YOUR_EMAIL,
            to_addrs=YOUR_EMAIL,
            msg=f"Subject:Amazon Price Alert!\n\n{message}\n{url}"
        )