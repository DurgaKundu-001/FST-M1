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
    driver.get("https://v1.training-support.net/selenium/drag-drop")
    print("Page title is: ", driver.title)
    Football = driver.find_element(By.ID, "draggable")
    drop1 = driver.find_element(By.ID, "droppable")
    drop2 = driver.find_element(By.ID, "dropzone2")
    action.click_and_hold(Football).move_to_element(drop1).pause(5).release().perform()
    action.drag_and_drop(Football, drop2).perform()
    if drop1.text.find("Dropped!"):
        print("Dropzone 1 was activated!")
    action.drag_and_drop(Football, drop2).perform()
    check2 = driver.find_element(By.XPATH, "//*[@id=\"dropzone2\"]/p").text
    if drop2.text.find("Dropped!"):
        print("Dropzone 2 was activated!")
