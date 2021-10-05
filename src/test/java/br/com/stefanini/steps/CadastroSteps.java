package br.com.stefanini.steps;

import br.com.stefanini.core.Driver;
import br.com.stefanini.enums.Browser;
import br.com.stefanini.pages.CadastroPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;

import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class CadastroSteps {

    CadastroPage cadastroPage;
    Map<String, String> mapDados;

    @Before
    public void iniciaDriver(Scenario cenario){
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void finalizaDriver(Scenario cenario) throws IOException {
        if (cenario.isFailed()){
            Driver.printScreen("erro no cenario");
        }

        Driver.getDriver().quit();
    }

    @Dado("que esteja na pagina cadastro usuario")
    public void queEstejaNaPaginaCadastroUsuario() {
        Driver.getDriver().get("http://prova.stefanini-jgr.com.br/teste/qa/");
        cadastroPage = new CadastroPage();
    }
    @Entao("valido que todos os campos estejam em branco")
    public void validoQueTodosOsCamposEstejamEmBranco() throws IOException {
        Assert.assertEquals("", cadastroPage.getNome());
        Assert.assertEquals("", cadastroPage.getEmail());
        Assert.assertEquals("", cadastroPage.getSenha());
        Driver.printScreen("todos campos em branco");
    }
    @Entao("nao exista nenhum cadastro efetuado")
    public void naoExistaNenhumCadastroEfetuado() throws IOException {
        Assert.assertFalse(cadastroPage.isEmail());
        Driver.printScreen("Sem cadastro");
    }

    @Quando("prencho os campos de cadastro com")
    public void prenchoOsCamposDeCadastroCom(Map<String, String> map) throws IOException {
        mapDados = map;
        cadastroPage.setNome(map.get("nome"))
                .setEmail(map.get("email"))
                .setSenha(map.get("senha"));
        Driver.printScreen("Todos os campos preenchidos");
    }
    @E("efetuo o clique no botao cadastrar")
    public void efetuoOCliqueNoBotaoCadastrar() {
        cadastroPage.clickCadastrar();
    }



    @Entao("recebo a mensagem de erro {string}")
    public void receboAMensagemDeErro(String msg) throws IOException {
        Assert.assertEquals(msg, cadastroPage.getError());
        Driver.printScreen("Mensagem de erro exibida");
    }

    @Entao("valido que os valores cadastrados sao exibidos com o id {string}")
    public void validoQueOsValoresCadastradosSaoExibidosComOId(String id) throws IOException {
        Assert.assertEquals(id, cadastroPage.getTextId(id));
        Assert.assertEquals(mapDados.get("nome"), cadastroPage.getTextNome(id));
        Assert.assertEquals(mapDados.get("email"), cadastroPage.getTextEmail(id));
        Assert.assertTrue(cadastroPage.isExcluir(id));
        Driver.printScreen("Dados cadastrados");
    }

    @Quando("efetuo o clique no botao excluir")
    public void efetuoOCliqueNoBotaoExcluir() {
        cadastroPage.clickExcluir();
    }
}
