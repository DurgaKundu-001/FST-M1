from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    action = ActionChains(driver)
    wait = WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/ajax")
    print("Page title is: ", driver.title)
    driver.find_element(By.CLASS_NAME, "violet").click()
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h1"), "HELLO!"))
    print("The message is: "+driver.find_element(By.TAG_NAME, "h1").text)
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    print("The next message is: "+driver.find_element(By.TAG_NAME, "h3").text)
