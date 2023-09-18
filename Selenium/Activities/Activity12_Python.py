from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with (webdriver.Firefox(service=service) as driver):
    wait = WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Page title is: ", driver.title)
    Text1 = driver.find_element(By.ID, "input-text")
    print("Check if the textbox is enabled  : "+ str(Text1.is_enabled()))
    driver.find_element(By.ID, "toggleInput").click()
    print("Check if the textbox is enabled after click on the toggle button : " + str(Text1.is_enabled()))
