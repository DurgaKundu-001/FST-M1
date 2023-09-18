from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with (webdriver.Firefox(service=service) as driver):
    wait = WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Page title is: ", driver.title)
    rows= driver.find_elements(By.XPATH, "//div[2]/div[2]/table/tbody/tr")
    print("The number of rows are : " + str(len(rows)))
    columns = driver.find_elements(By.XPATH, "//div[2]/div[2]/table/tbody/tr[1]/td")
    print("The number of columns  are : "+str(len(columns)))
    thirdrow=driver.find_elements(By.XPATH, "//div[2]/div[2]/table/tbody/tr[3]")
    print("The cell values in the third row of the table are: ")
    for row3 in thirdrow:
        print(row3.text)
    cell22=driver.find_element(By.XPATH, "//div[2]/div[2]/table/tbody/tr[2]/td[2]").text
    print("The cell value at the second row second column is : "+cell22)
