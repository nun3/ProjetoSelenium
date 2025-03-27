package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private WebDriver browser;

    public LoginPage() {
        // Configura o WebDriver e inicializa o ChromeDriver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.manage().window().maximize();
        this.browser.navigate().to("http://localhost:8080/leiloes"); // URL inicial
    }

    public void Logar() {
        // Localiza e interage com elementos de login na página
        WebElement linkEntrar = browser.findElement(By.linkText("Entrar"));
        linkEntrar.click();

        WebElement inputUsuario = browser.findElement(By.name("username"));
        inputUsuario.sendKeys("fulano");

        WebElement inputSenha = browser.findElement(By.name("password"));
        inputSenha.sendKeys("pass");

        WebElement botaoLogin = browser.findElement(By.id("login-form"));
        botaoLogin.submit();
    }

    public boolean verificarSeUsuarioEstaLogado() {
        // Verifica se o elemento do usuário logado está presente
        try {
            WebElement usuarioLogado = browser.findElement(By.id("usuario-logado"));
            return usuarioLogado != null && !usuarioLogado.getText().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public void Fechar() {
        if (browser != null) {
            browser.quit();
        }
    }
}