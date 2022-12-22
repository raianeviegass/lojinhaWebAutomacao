package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.misc.FormattedFloatingDecimal;

public class FormularioDeAdicaoDeProdutoPage {

    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioDeAdicaoDeProdutoPage informarNomeDoProduto (String nomeProduto) {
        navegador.findElement(By.cssSelector("input[id='produtonome']")).sendKeys(nomeProduto);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarValorDoProduto (String valorProduto) {
        navegador.findElement(By.cssSelector("input[id='produtovalor']")).sendKeys(valorProduto);

        return this;

    }

    public FormularioDeAdicaoDeProdutoPage informarCoresDoProduto (String corProduto) {
        navegador.findElement(By.cssSelector("input[id='produtocores']")).sendKeys(corProduto);

        return this;

    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);

    }

    public FormularioDeEdicaoDeProdutoPage submeterFormularioDeAdicaoComSucesso() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new FormularioDeEdicaoDeProdutoPage(navegador);

    }

}
