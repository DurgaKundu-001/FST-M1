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
    dropdown = driver.find_element(By.ID, "single-select")
    singleSelect = Select(dropdown)
    singleSelect.select_by_visible_text("Option 2")
    print("Second option: " + singleSelect.first_selected_option.text)
    singleSelect.select_by_index(3)
    print("Third option: " + singleSelect.first_selected_option.text)
    singleSelect.select_by_value("4")
    print("Forth option: " + singleSelect.first_selected_option.text)
    allOptions = singleSelect.options
    print("Options in the dropdown: ")
    for option in allOptions:
        print(option.text)
