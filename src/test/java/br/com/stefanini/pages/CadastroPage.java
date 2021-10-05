package br.com.stefanini.pages;

import br.com.stefanini.core.Driver;
import br.com.stefanini.maps.CadastroMap;
import org.openqa.selenium.support.PageFactory;

public class CadastroPage {
    CadastroMap cadastroMap;
    public CadastroPage(){
        cadastroMap = new CadastroMap();
        PageFactory.initElements(Driver.getDriver(), cadastroMap);
    }

    public String getNome(){
        return cadastroMap.inpNome.getAttribute("value");
    }
    public boolean isEmail(){
        try {
            return cadastroMap.textEmail.isDisplayed();
        }catch (Exception e){
            return false;
        }

    }
    public String getEmail(){
        return cadastroMap.inpEmail.getAttribute("value");

    }
    public String getSenha(){
        return cadastroMap.inpSenha.getAttribute("value");
    }

    public CadastroPage setNome(String nome){
        if (nome != null)
            cadastroMap.inpNome.sendKeys(nome);
        return this;
    }
    public CadastroPage setEmail(String email){
        if (email != null)
            cadastroMap.inpEmail.sendKeys(email);
        return this;
    }
    public CadastroPage setSenha(String senha){
        if (senha != null)
            cadastroMap.inpSenha.sendKeys(senha);
        return this;
    }
    public CadastroPage clickCadastrar(){
        cadastroMap.btnCadastrar.click();
        return this;
    }
    public String getTextId(String id){
        if (id.equals("1")){
            return cadastroMap.textId.getText();
        }
        return cadastroMap.textId2.getText();
    }

    public String getTextNome(String id){
        if (id.equals("1")){
            return cadastroMap.textNome.getText();
        }
        return cadastroMap.textNome2.getText();
    }
    public String getTextEmail(String id){
        if (id.equals("1")){
            return cadastroMap.textEmail.getText();
        }
        return cadastroMap.textEmail2.getText();
    }

    public boolean isExcluir(String id){
        try {
            if (id.equals("1")){
                return cadastroMap.linkExcluir.isDisplayed();
            }
            return cadastroMap.linkExcluir2.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }


    public CadastroPage clickExcluir(){
        cadastroMap.linkExcluir.click();
        return this;
    }

    public CadastroPage clickExcluir2(){
        cadastroMap.linkExcluir2.click();
        return this;
    }
    public String getError(){
        return cadastroMap.textError.getText();
    }

}


