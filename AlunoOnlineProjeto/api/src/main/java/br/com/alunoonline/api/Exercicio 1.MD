
# Sistema de Gerenciamento de Alunos

Este projeto é uma API RESTful desenvolvida com **Spring Boot**, que permite a criação e o gerenciamento de alunos. A API oferece uma funcionalidade básica para cadastrar alunos com informações como nome, e-mail e CPF, seguindo o padrão de arquitetura MVC (Model-View-Controller).

## Componentes do Projeto

### 1. Controller - `AlunoController.java`

O **controller** é responsável por receber as requisições HTTP e coordenar a comunicação com o service.

**Explicação:**

- **@RestController**: Define a classe como um controlador REST.
- **@RequestMapping("/alunos")**: Define a rota base `/alunos`.
- **@PostMapping**: Mapeia requisições HTTP POST para o método `criarAluno()`.
- **@RequestBody**: Converte o corpo da requisição para um objeto `Aluno`.
- **@ResponseStatus(HttpStatus.CREATED)**: Retorna o status 201 (Created) após a criação do aluno.

### 2. Model - `Aluno.java`

O **model** representa a entidade `Aluno` que será armazenada no banco de dados.

**Explicação:**

- **@Entity**: Marca a classe como uma entidade JPA.
- **@Id**: Define o campo `id` como chave primária.
- **@GeneratedValue(strategy = GenerationType.IDENTITY)**: Define que o `id` será gerado automaticamente.
- **@Data**: Lombok gera getters, setters e outros métodos úteis.
- **@NoArgsConstructor** e **@AllArgsConstructor**: Lombok gera construtores padrão e completo.

### 3. Service - `AlunoService.java`

O **service** contém a lógica de negócios e interage com o repositório.


**Explicação:**

- **@Service**: Define a classe como um serviço.
- **@Autowired**: Injeta uma instância de `AlunoRepository`.
- **criarAluno(Aluno aluno)**: Salva o aluno no banco de dados.

### 4. Repository - `AlunoRepository.java`

O **repository** é a camada de persistência que interage com o banco de dados.

**Explicação:**

- **@Repository**: Marca a interface como um repositório.
- **extends JpaRepository<Aluno, Long>**: Fornece métodos CRUD para a entidade `Aluno`.

## Testando a API com Insomnia

### Passo 1: Configurar a requisição

- **Método HTTP**: POST
- **URL**: `http://localhost:8080/alunos`
- **Body**: Tipo **JSON** com o seguinte exemplo:

```json
{
  "nome": "Miguel Rodrigues Craneiro",
  "email": "miguelrodriguescrn@gmail.com",
  "cpf": "123.123.123-12"
}
```

![Captura de Tela (35)](https://github.com/user-attachments/assets/a2f459a1-6274-4455-ab0c-a75717ce57c1)

### Passo 2: Enviar a requisição

Após enviar a requisição, a API deverá retornar o status **201 Created** se o aluno for criado com sucesso. O aluno será armazenado no banco de dados.

## Banco de Dados

O banco de dados está sendo criado em **PostgreSQL** na porta **5432**. Utilizamos **DBeaver** para administrar e gerenciar o banco de dados.

- **URL do Banco de Dados**: `jdbc:postgresql://localhost:5432/aluno_online_projeto`

