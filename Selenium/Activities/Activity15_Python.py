from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support import expected_conditions

service = FirefoxService(GeckoDriverManager().install())
with (webdriver.Firefox(service=service) as driver):
    wait = WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    print("Page title is: ", driver.title)
    driver.find_element(By.XPATH, "//input[starts-with(@class, 'username-')]").send_keys("admin")
    driver.find_element(By.XPATH, "//input[starts-with(@class, 'password-')]").send_keys("password")
    driver.find_element(By.XPATH, "//div[2]/div/div[1]/div/div/button").click()
    wait.until(expected_conditions.visibility_of_element_located((By.ID, "action-confirmation")))
    msg= driver.find_element(By.ID, "action-confirmation")
    print(msg.text)