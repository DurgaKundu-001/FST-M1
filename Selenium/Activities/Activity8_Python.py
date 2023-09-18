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
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Page title is: ", driver.title)
    toggle = driver.find_element(By.ID, "toggleCheckbox")
    checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    toggle.click()
    wait.until(expected_conditions.invisibility_of_element(checkbox))
    toggle.click()
    wait.until(expected_conditions.visibility_of(checkbox))
    driver.find_element(By.XPATH, "/html/body/div[3]/div/div[1]/div[1]/input").click()
