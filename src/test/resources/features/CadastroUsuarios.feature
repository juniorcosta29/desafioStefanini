#language:pt
@CadastroUsuario
Funcionalidade: CadastroUsuario

  Cenario: Validar dados em branco
    Dado que esteja na pagina cadastro usuario
    Entao valido que todos os campos estejam em branco
    E nao exista nenhum cadastro efetuado

  Esquema do Cenario: Validar msg erro para <cenario>
    Dado que esteja na pagina cadastro usuario
    Quando prencho os campos de cadastro com
      | nome  | <nome>  |
      | email | <email> |
      | senha | <senha> |
    E efetuo o clique no botao cadastrar
    Entao recebo a mensagem de erro "<msg>"
    E nao exista nenhum cadastro efetuado
    Exemplos:
      | cenario                 | nome          | email            | senha         | msg                                        |
      | nome em branco          |               | eraldo@email.com | eraldojurnior | O campo Nome é obrigatório.                |
      | e-mail em branco        | Eraldo Junior |                  | eraldojurnior | O campo E-mail é obrigatório.              |
      | senha em branco         | Eraldo Junior | eraldo@email.com |               | O campo Senha é obrigatório.               |
      | nome incompleto         | Eraldo        | eraldo@email.com | eraldojurnior | Por favor, insira um nome completo.        |
      | email inválido          | Eraldo Junior | eraldo           | eraldojurnior | Por favor, insira um e-mail válido.        |
      | senha quantidade minima | Eraldo Junior | eraldo@email.com | eraldo        | A senha deve conter ao menos 8 caracteres. |

  Cenario: Realizar Cadastro com sucesso
    Dado que esteja na pagina cadastro usuario
    Quando prencho os campos de cadastro com
      | nome  | Eraldo Junior    |
      | email | eraldo@email.com |
      | senha | eraldojurnior    |
    E efetuo o clique no botao cadastrar
    Entao valido que os valores cadastrados sao exibidos com o id "1"
    Quando prencho os campos de cadastro com
      | nome  | Eraldo Junior2    |
      | email | eraldo2@email.com |
      | senha | eraldojurnior     |
    E efetuo o clique no botao cadastrar
    Entao valido que os valores cadastrados sao exibidos com o id "2"

  Cenario: Realizar Exclusao com sucesso
    Dado que esteja na pagina cadastro usuario
    Quando prencho os campos de cadastro com
      | nome  | Eraldo Junior    |
      | email | eraldo@email.com |
      | senha | eraldojurnior    |
    E efetuo o clique no botao cadastrar
    Entao valido que os valores cadastrados sao exibidos com o id "1"
    Quando efetuo o clique no botao excluir
    Entao nao exista nenhum cadastro efetuado