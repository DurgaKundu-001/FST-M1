from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support import expected_conditions

service = FirefoxService(GeckoDriverManager().install())
with (webdriver.Firefox(service=service) as driver):
    wait = WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/popups")
    print("Page title is: ", driver.title)
    wait = WebDriverWait(driver, 10)
    print("The title of the page is : " + driver.title)
    button=driver.find_element(By.CLASS_NAME, "orange")
    ActionChains(driver).move_to_element(button).perform()
    print("The tooltip message is: "+button.get_attribute("data-tooltip"))
    button.click()
    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    driver.find_element(By.XPATH, "//button[text()='Log in']").click()
    print("The message on the page after logging in is: "+driver.find_element(By.ID,"action-confirmation").text)