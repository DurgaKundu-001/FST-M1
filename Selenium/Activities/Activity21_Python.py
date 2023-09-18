from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support import expected_conditions

service = FirefoxService(GeckoDriverManager().install())
with (webdriver.Firefox(service=service) as driver):
    wait = WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/tab-opener")
    print("Page title is: ", driver.title)
    wait = WebDriverWait(driver, 10)
    print("The title of the page is : " + driver.title)
    print("Current tab: " + driver.current_window_handle)
    driver.find_element(By.ID, "launcher").click()
    wait.until(expected_conditions.number_of_windows_to_be(2))
    print("All window handles: ", driver.window_handles)
    print("Current tab: " + driver.current_window_handle)
    print("Page title: " + driver.title)
    pageHeading = driver.find_element(By.CLASS_NAME, "content").text
    print("Page Heading: " + pageHeading)
    driver.find_element(By.XPATH, "//*[@id='actionButton']").click()
    wait.until(expected_conditions.number_of_windows_to_be(3))
    driver.switch_to.window(driver.window_handles[2])
    print("Current tab: " + driver.current_window_handle)
    print("Page title: " + driver.title)
    pageHeading = driver.find_element(By.CLASS_NAME, "content").text
    print("Page Heading: " + pageHeading)