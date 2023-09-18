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
    driver.find_element(By.XPATH, "//input[contains(@class, '-username')]").send_keys("DurgaK")
    driver.find_element(By.XPATH, "//input[contains(@class, '-password')]").send_keys("password")
    driver.find_element(By.XPATH, "//label[text() = 'Confirm Password']/following-sibling::input").send_Keys("password")
    driver.find_element(By.XPATH,"//input[contains(@class, 'email-')]").send_Keys("dk@gmail.com")
    driver.find_element(By.XPATH,"//div[2]/div/div[3]/div/div/button").click()
    mes= driver.find_element(By.ID, "action-confirmation")
    print("The success message is : " + mes.text)