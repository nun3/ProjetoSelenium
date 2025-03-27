package Login;

import org.junit.jupiter.api.*;

public class LoginTeste {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach() {
        // Inicializa a página de login antes de cada teste
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        // Fecha o navegador após cada teste
        this.paginaDeLogin.Fechar();
    }

    @Test
    public void deveriaEfetuarLogin() {
        paginaDeLogin.Logar();
        Assertions.assertTrue(paginaDeLogin.verificarSeUsuarioEstaLogado(), "O usuário não está logado.");
    }

}