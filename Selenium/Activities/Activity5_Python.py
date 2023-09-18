from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    actions = ActionChains(driver)
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Page title is: ", driver.title)
    actions.click().pause(10).perform()
    activeSide = driver.find_element(By.CLASS_NAME, "active")
    print("The side in the front is : " + activeSide.text)
    actions.double_click().perform()
    activeSide1= driver.find_element(By.CLASS_NAME, "active")
    print("The side in the front after double click is : " + activeSide1.text)
    actions.context_click().perform()
    activeSide2= driver.find_element(By.CLASS_NAME, "active")
    print("The side in the front after right click is : " + activeSide2.text)