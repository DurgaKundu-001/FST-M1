from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with (webdriver.Firefox(service=service) as driver):
    wait = WebDriverWait(driver, 10)
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Page title is: ", driver.title)
    row= driver.find_elements(By.XPATH, "//div[3]/div[2]/table/tbody/tr")
    print("The no of rows in the second table is : "+str(len(row)))
    col= driver.find_elements(By.XPATH, "//div[3]/div[2]/table/tbody/tr[1]/td")
    print("The no of rows in the second table is : "+str(len(col)))
    cell22= driver.find_element(By.XPATH, "//div[3]/div[2]/table/tbody/tr[2]/td[2]")
    print("The cell value at the second row second column is : "+cell22.text)
    driver.find_element(By.XPATH, "//div[3]/div[2]/table/thead/tr/th[1]").click()
    cell2= driver.find_element(By.XPATH, "//div[3]/div[2]/table/tbody/tr[2]/td[2]")
    print("The cell value at the second row second column after sort is : "+cell2.text)
    footer= driver.find_elements(By.XPATH, "//div[2]/div/div[3]/div[2]/table/tfoot/tr/th")
    print("The cell values of the table footer are: ");
    for value in footer:
        print(value.text)
