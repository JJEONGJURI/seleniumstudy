package seleniumstudy;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * jspstudy2의 로그인 창 띄우기
 */
public class Exam1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty
		("webdriver.chrome.driver", "D:/setup/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/jspstudy2/member/loginForm#");
		WebElement element = null;
		element = driver.findElement(By.name("id"));
		String id = "admin";
		element.sendKeys(id); //admin입력
		element = driver.findElement(By.name("pass"));
		String pass = "1234";
		element.sendKeys(pass); //1234입력
		element = driver.findElement(By.xpath("//*[@id='login']"));
//		element = driver.findElement(By.cssSelector(".btn.btn-dark"));	//강사님이 한거
		//btn btn-dark가 3갠데 로그인이 되는 이유 : findElement 라서 한개만 찾는데 그 중 제일 첫번째 있는거 찾아감
//		element = driver.findElement(By.name("f"));	//form 태그
//		element.submit(); //form submit
		element.click(); //로그인클릭
		driver.switchTo().alert().accept(); //alert창 클릭해줌
		Thread.sleep(1000); //3초 쉬기		
		//Jsoup으로 분석하기
		driver.get("http://localhost:8080/jspstudy2/member/list"); //url 가져오기
		//driver.getPageSource() : 브라우저에서 제공되는 html 페이지.
		Document doc = Jsoup.parse(driver.getPageSource());
		Elements div = doc.select("table"); //table들 다 가져옴
		for(Element e : div) { //table중 하나만 가져옴
			for(Element tr : e.select("tr")) { //tr가져옴
				Elements tds = tr.select("td"); //사용자 이름 가져오기//tr중 td가져옴
				if(tds.size() > 3) {//td가 3보다 크면
					//tds.get(2) : 회원이름의 값을 가져와
					System.out.println(tds.get(2).html());
				}
			}
		}
		Thread.sleep(1000);
		driver.quit();
		driver.close();//브라우저 닫기
	}

}
