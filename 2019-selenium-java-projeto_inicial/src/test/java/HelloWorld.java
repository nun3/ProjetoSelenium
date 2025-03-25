import org.junit.jupiter.api.Assertions;  // Alterado para Assertions do JUnit 5
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {
    @Test
    public void hello() {
        // Ajustando a propriedade do WebDriver com o caminho correto do driver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver(); // Instanciando o navegador
        browser.navigate().to("http://localhost:8080/leiloes"); // Navegando até a página

        // Encontrando o link "Entrar" e clicando
        WebElement linkEntrar = browser.findElement(By.linkText("Entrar"));
        linkEntrar.click();

        // Verificando se a URL não permaneceu a mesma (indicando que houve redirecionamento)
        Assertions.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/leiloes"));

        // Encontrando o campo de usuário e inserindo um valor
        WebElement inputUsuario = browser.findElement(By.name("username")); // Localiza o campo de entrada pelo atributo "name"
        inputUsuario.sendKeys("fulano"); // Insere o valor "fulano" no campo

        // Encontrando o campo de senha e inserindo um valor
        WebElement inputSenha = browser.findElement(By.name("password")); // Localiza o campo de entrada pelo atributo "name"
        inputSenha.sendKeys("pass"); // Insere o valor "pass" no campo

        WebElement submitLogin = browser.findElement(By.id("login-form"));
        submitLogin.submit();

        // Verificando se a URL não permaneceu a mesma (indicando que houve redirecionamento)
        Assertions.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/Login"));

        // Verificando se o usuário logado é "fulano"
        String usuarioLogado = browser.findElement(By.id("usuario-logado")).getText();
        Assertions.assertEquals("fulano", usuarioLogado);

        // Fechando o navegador após o teste (caso necessário)
        browser.quit();
    }
}