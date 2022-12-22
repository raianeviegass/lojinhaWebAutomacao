package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;
import java.time.Duration;

@DisplayName("Testes Web do módulo de Produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver108\\chromedriver.exe");
        this.navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

    @Test
    @DisplayName("Não é permitido registar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {

        String mensagemApresentada =new LoginPage(navegador)
                        .informarOUsuario("admin")
                        .informarSenha("admin")
                        .submeterFormularioDeLogin()
                        .acessarFormularioAdicaoNovoProduto()
                        .informarNomeDoProduto("Iphone")
                        .informarValorDoProduto("000")
                        .informarCoresDoProduto("Preto, Verde")
                        .submeterFormularioDeAdicaoComErro()
                        .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Não é permitido registar um produto com maior que R$ 7.000,00")
    public void testNaoEPermitidoRegistrarProdutoComValorMaiorSeteMil() {

        String mensagemApresentada =new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Iphone")
                .informarValorDoProduto("700001")
                .informarCoresDoProduto("Preto, Verde")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar um produto com valores na faixa de R$ 0,01 a R$ 7.000,00")
    public void testPossoAdicionarProdutosComValorDeUmCentavoASeteMilReais() {

        String mensagemApresentada =new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Iphone")
                .informarValorDoProduto("30000")
                .informarCoresDoProduto("Preto, Verde")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar produtos com valor limite de R$ 0,01")
    public void testPossoAdicionarProdutosComValorLimiteDeUmCentava() {

        String mensagemApresentada =new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Iphone 13")
                .informarValorDoProduto("001")
                .informarCoresDoProduto("Preto, Verde")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar produtos com valor limite de R$ 7.000,00")
    public void testPossoAdicionarProdutosComValorLimiteDeSeteMilReais() {

        String mensagemApresentada =new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Iphone 14")
                .informarValorDoProduto("700000")
                .informarCoresDoProduto("Preto, Verde")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);

    }

    @AfterEach
    public void afterEach() {
        navegador.quit();

    }


}
