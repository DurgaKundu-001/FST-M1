from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    wait = WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Page title is: ", driver.title)
    check1=driver.find_element(By.XPATH, "//div[3]/div/div[1]/div[1]/input")
    print("The check box is displayed : " , check1.is_displayed())
    driver.find_element(By.ID, "toggleCheckbox").click()
    toggle = driver.find_element(By.CLASS_NAME, "willDisappear")
    wait.until(expected_conditions.invisibility_of_element(toggle))
    print("After clicking on the toggle button, The check box is displayed : ", check1.is_displayed())