from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with (webdriver.Firefox(service=service) as driver):
    wait = WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/selects")
    print("Page title is: ", driver.title)
    selectElement = driver.find_element(By.ID, "multi-select")
    multiSelect = Select(selectElement)
    multiSelect.select_by_visible_text("Javascript")
    for i in (4,6):
        multiSelect.select_by_index(i)
    multiSelect.select_by_value("node")
    multiSelect.deselect_by_index(5)