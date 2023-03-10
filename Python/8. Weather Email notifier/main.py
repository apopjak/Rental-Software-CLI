import requests
from datetime import datetime
import smtplib
import os



email = "EMAIL"
password = "PWD"
recipient = "apopjak@gmail.com"
api_key = "API_KEY_ENV"
api_endpoint = "https://api.openweathermap.org/data/3.0/onecall"
parameters = {
    "exclude": "current,daily,minutely",
    "lat": 48.148598,
    "lon": 17.107748,
    "appid": api_key
}

exclude = "current", "minutely"
weather = requests.get(api_endpoint, params=parameters)
weather.raise_for_status()  ### important ### if there is a problem this will raise an exception

weather_data = weather.json()
hourly_data = weather_data["hourly"][:12]


def send_email():
    """Funcion is sending emails automatically to person set in the variable called: recipient on the top of the project
    """

    with smtplib.SMTP_SSL("smtp.gmail.com", 465) as my_email:
        my_email.login(user=email, password=password)
        my_email.sendmail(from_addr=email,
                          to_addrs=recipient,
                          msg=(f"Subject:Predpoveď zrážok na dnes\n\nPredpokladaný čas zrážok: {hours}\n"
                               f"Predpovedaná teplota v dobe zrážok: {temperature}°C \n"
                               f"Poveternostné podmienky: {weather_condition}").encode("utf-8"))


for loop in hourly_data:
    time = datetime.fromtimestamp(loop["dt"])
    h = str(time).split(" ")[1]
    hours = h[0:5]
    temperature = round(loop["temp"] - 273.15, 2)
    weather_id = loop["weather"][0]["id"]
    weather_condition = loop["weather"][0]["description"].title()

    if weather_id < 700:
        send_email()

        break
