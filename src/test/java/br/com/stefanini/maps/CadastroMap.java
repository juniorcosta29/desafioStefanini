package br.com.stefanini.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroMap {
    @FindBy(id = "name")
    public WebElement inpNome;
    @FindBy(css = "#email")
    public WebElement inpEmail;
    @FindBy(css = "#password")
    public WebElement inpSenha;
    @FindBy(css = "#register")
    public WebElement btnCadastrar;
    @FindBy(css = "#tdUserId1")
    public WebElement textId;
    @FindBy(css = "#tdUserName1")
    public WebElement textNome;
    @FindBy(css = "#tdUserEmail1")
    public WebElement textEmail;
    @FindBy(css = "#removeUser1")
    public WebElement linkExcluir;
    @FindBy(css = "#tdUserId2")
    public WebElement textId2;
    @FindBy(css = "#tdUserName2")
    public WebElement textNome2;
    @FindBy(css = "#tdUserEmail2")
    public WebElement textEmail2;
    @FindBy(css = "#removeUser1")
    public WebElement linkExcluir2;
    @FindBy(css = ".error")
    public WebElement textError;

}
