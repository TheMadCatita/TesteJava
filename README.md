# TesteJava

Projeto para selecao de candidato Behoh.

pre-requesitos:
1. Java 8 ou superior
2. Usar H2 como banco

Baixando e instalando a aplicacao:

1. baixe a aplicaco no GitHub.
2. crie um novo spring starter project com os seguintes starters: Spring DevTools, H2 Database  e Spring Web
3. inicie a aplicacao usando o Boot Dashboard para a aplicacao comecar a rodar de forma local (http://localhost:8080)

Usando o aplicativo:

Usuarios:
http://localhost:8080/usuarios/adicionar          // adiciona um usuario
http://localhost:8080/usuarios/listar             // lista todos os usuarios
http://localhost:8080/usuarios/listarId/id        //lista um usuario
http://localhost:8080/usuarios/deleteUsuarioId/id // deleta um usuario
http://localhost:8080/usuarios/updateUsuarioId/id // upadade um usuario

Evento:
http://localhost:8080/eventos/adicionar         // adicionar um evento
http://localhost:8080/eventos/listar            // lstar todos os eventos
http://localhost:8080/eventos/listarId/id       // listar um evento 
http://localhost:8080/eventos/deleteEventoId/id // deletar um evento 
http://localhost:8080/eventos/updateEventoId/id // update um evento

Inscricoes:
http://localhost:8080/inscricoes/adicionar
http://localhost:8080/inscricoes/listar
http://localhost:8080/inscricoes/
http://localhost:8080/inscricoes/
http://localhost:8080/inscricoes/
