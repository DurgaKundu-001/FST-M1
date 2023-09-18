from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("Page title is: ", driver.title)
    Third = driver.find_element(By.XPATH, "//*[@id='third-header']")
    print("The text of the 3rd header is : " + Third.text)
    fifth= driver.find_element(By.XPATH, "//*[@class='ui green header']")
    print("The color of the 5th header is : " + fifth.value_of_css_property("color"))
    Violet= driver.find_element(By.CLASS_NAME, "violet")
    print("The classes of the Violet button is : " + Violet.get_attribute("class"))
    Grey= driver.find_element(By.CLASS_NAME, "grey")
    print("The text of the Grey button is : " + Grey.text)