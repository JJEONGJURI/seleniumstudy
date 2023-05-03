package seleniumstudy;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEx1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty //시스템 환경 설정 => 크롬 드라이버 파일로 설정
		("webdriver.chrome.driver", "D:/setup/chromedriver_win32/chromedriver.exe");
			WebDriver driver = new ChromeDriver(); // 드라이버 하나 뜸(새창)
			driver.get("http://www.naver.com"); // url 로드
			System.out.println(driver.getPageSource()); //네이버가 전달해준 모든 소스들을 화면에 출력
			WebElement element = null; //webElement : 태그들을 선택하기 위한거
			element = driver.findElement //cssSelector로 태그를 찾아라
			//id가 account이고 class 이름이 sc_login인 태그를 찾고 / 하위에 a 태그 class 이름인 link_login인 태그를 찾아라 
					(By.cssSelector("#account.sc_login a.link_login"));
			element.click(); // 그것을 클릭해	
			//로그인 하기
			/*
			 * findElement(By.함수) : 한개의 태그 찾기
			 * findElements(By.함수) : 여러개의 태그 찾기 (리턴타입은 listElement)
			 * By.함수 : 태그 찾는 방식 설정
			 * By.name() : name 속성으로 태그 찾기
			 * By.id()	 : id 속성 태그 찾기
			 * By.cssSelector  : css에서 사용되는 선택자 방식으로 태그 찾기
			 * 		#account.sc_login : id="account" 이고 class= "sc_login" 인 한개의 태그 선택
			 * 		a.link_login      : class="link_login" 인 a 태그 선택
			 * 		#account.sc_login a.link_login : id="account"인 태그의 하위 태그 중
			 * 										 class="link_login"인 a 태그 선택
			 * By.xpath : xml에서 태그 선택 하는 방식
			 * 		/  : root 노드. 문서 노드
			 * 		// : 모든 위치 (위치 상관 없다)
			 * //*[@id='log.login'] : @는 속성 표시 
			 * 	모든 문서에서 id="log.login"인 태그를 선택해서 그 태그를 가지고 와
			 * By.linkText(문자열) : 태그의 text 값으로 태그 찾기
			 * By.partialLinkText(문자열) : 태그의 text 값이 포함된 태그 찾기
			 */
			Scanner scan = new Scanner(System.in);
			element = driver.findElement(By.name("id")); //name을 id 로 바꿔도됨 그 태그의 속성에 둘다 있음
			System.out.println("네이버 아이디를 입력하세요");
			String id = scan.nextLine();
			//sendKeys(값) : 찾아놓은 태그에 값 입력
			element.sendKeys(id);
			element = driver.findElement(By.name("pw")); //name 태그가 pw 인것을 찾는다
			System.out.println("네이버 비밀번호를 입력하세요");
			String pw = scan.nextLine();
			element.sendKeys(pw);			
			element = driver.findElement(By.xpath("//*[@id='log.login']"));
			element.click();
			Thread.sleep(1000);
	}
}
