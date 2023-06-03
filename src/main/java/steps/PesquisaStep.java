package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PesquisaPages;

public class PesquisaStep {
    WebDriver driver;
    PesquisaPages pesquisaPage;


    @Dado("que o usuario esta em {string}")
    public void que_o_usuario_esta_em(String url) {
        driver = new ChromeDriver();
        driver.get(url);

    }
    @Quando("pesquisar por {string}")
    public void pesquisar_por(String palavraDaPesquisa) {
          pesquisaPage = new PesquisaPages();
          driver.findElement(By.id(pesquisaPage.barraDePesquisa)).sendKeys(palavraDaPesquisa);
          driver.findElement(By.id(pesquisaPage.barraDePesquisa)).sendKeys(Keys.ENTER);
    }
    @Entao("retornar um link relacionado a pesquisa")
    public void retornar_um_link_relacionado_a_pesquisa() {
    driver.findElement(By.xpath(pesquisaPage.linkCasasBahia)).isDisplayed();
    driver.findElement(By.xpath(pesquisaPage.linkCasasBahia)).click();


    }
}
