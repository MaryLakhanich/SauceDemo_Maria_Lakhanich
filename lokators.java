public class selectors {
    By.id("header_container")
    By.name("viewport")
    By.className("header_container")
    By.tagname("footer")
    By.LinkText("Accepted usernames are:")
    ByPartialLinkText("Password for")
    By.xpath("//input[@data-test]")//Поиск по атрибуту
    By.xpath("//title[text()='Swag Labs']")//Поиск по тексту
    By.xpath("//input[contains(@class,'error')]")//Поиск по частичному совпадению атрибута
    By.xpath("//noscript[contains(text(),'need to')]")//Поиск по частичному совпадению текста
    By.xpath("//*[text()='2022']//ancestor::div[3]")//Поиск по предку
    By.xpath("//*[@id='menu_button_container']//descendant::a[4]")//Поиск по наследнику
    By.xpath("//*[@type='text']//following::input[2]")
    By.xpath("//*[@id='password']//parent::div")
    By.xpath("//input//preceding-sibling::div[3]")
    By.xpath(" //input[@placeholder='Password' and @type='password']")

    By.cssSelector(".login_logo")
    By.cssSelector(".bm-menu .bm-item-list ")
    By.cssSelector("#header_container")
    By.cssSelector("noscript")
    By.cssSelector("div.bm-burger-button")
    By.cssSelector("input[type=text]")
    By.cssSelector("meta[content~=Sauce]")
    By.cssSelector("div[class|=primary_header]")
    By.cssSelector("a[href^="http"]")
    By.cssSelector("a[href$="saucelabs"]")
    By.cssSelector("meta[name*="cript"]")
}
