# HerokuAppTest
http://the-internet.herokuapp.com/
Автоматизировать тесты для приложения: http://the-internet.herokuapp.com/ Каждая страница - отдельный класс и тест. Pull request в GIT и ментор в Reviewers.
Add/Remove Elements - добавить 2 элемента, удалить элемент, проверить количество элементов
Локаторы xpath:
By.xpath(“//button[text()=’Add Element’]”)
By.xpath(“//*[text()=’Add Element’]”)
By.xpath(“//*[@onclick=’addElement()’]”)
Checkboxes - проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked. Проверить, что второй чекбокс checked, сделать unсheck, проверить, что он unchecked
Dropdown - Взять все элементы дроп-дауна и проверить их наличие. Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран
Hovers - Сделать цепочку из действий: наведение на профиль, проверка имени, клик по ссылке, проверка 404 ошибки. Повторить для каждого из профилей. Использовать класс Actions и https://stackoverflow.com/questions/17293914/how-to-perform-mouseover-function-in-selenium-webdriver-using-java 
Inputs - Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP  И Keys.ARROW_DOWN 
Notification Messages - кликнуть на кнопку, дождаться появления нотификации, проверить соответствие текста ожиданиям
Sortable Data Tables - Проверить содержимое всех ячеек таблицы. Использовать xpath типа //table//tr[1]//td[1] - получение первой ячейки из первого ряда первой таблицы и так далее
Typos - Проверить соответствие параграфа орфографии 
