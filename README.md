# SoftplanDesafioUnic

## Exercício 01

- A classe legada fere alguns principios do **SOLID**, além de possuir mais de uma responsabilidade (Tratamento de plural e Separar os objetos) também não é nada adaptavel mantendo um prefixo da observação fixo e funcionando apenas com listas de **Integer** sem ao menos definir na assinatura do método, levando o desenvolvedor ao erro.
Também temos a implementação da separação que é feita de uma forma não intuitiva, necessitando de comentários no código para seu entendimento, assim como é possível ver diversos textos jogados no código sem qualquer explicação da sua funcionalidade (variável com nome adequado ou constantes).
Outro problema é utilização do "isEmpty" antes de verificar se a lista é null podendo lançar um **NullPointerException** não esperado. 

- Para simplificar o código, aumentar o reaproveitamento e a flexibilidade, foi criado duas novas classes chamadas **AdaptadorPlural** e **DelimitadorPadrao**.

- O **AdaptadorPlural** foi desenvolvido utilizando o MessageFormat com a funcionalidade do "choice" onde irá formatar todo texto singular escolhendo a opção 0 e plural 1. Através desse "template" padrão do **Java** a classe fica preparada para qualquer mudança de prefixo da observação que venha ser necessária.

Exemplos de usos com um choice ou mais: 
```
    "Fatura {0,choice,0#da nota fiscal|1#das notas fiscais} de simples remessa: "
    "Fatura da{0,choice,0#|1#s} nota{0,choice,0#|1#s} fisca{0,choice,0#l|1#is} de simples remessa: "
```
REF: https://docs.oracle.com/javase/7/docs/api/java/text/MessageFormat.html

- Além disso foi criado a classe **DelimitadorPadrao** que implementa uma interface chamada **Delimitador**, essa classe funciona exclusivamente para separação de listas, aceitando qualquer extenção de um **Object** e pode ser reaproveitada para qualquer outro modulo do sistema. Também foi alterado a forma como é feito a separação utilizando métodos comuns do **Java8** como **map**, **Collectors.joining** e **replace** para facilitar entendimento da implementação.

O **GeradorObservacao** agora possuí um construtor padrão que irá instanciar as classes mencionadas acima, assim como o prefixo padrão, porém também possuí construtor pronto para receber diferentes implementações das clases acima ou somente um novo texto do prefixo seguindo o template com **choice**.

Obs: Para simular as implementações necessárias foi criado uma classe **Item** que representaria os dados vindo do banco de dados.

- A funcionalidade original pode ser vista no método **ServicoExemplo.exemploOriginal** e podemos ver que é necessário apenas converter a lista de **Item** em uma lista de **Integer** com os valores necessários conforme era a implementação original mantendo a compatiblidade.

- Já a nova funcionalidade pode ser vista em **ServicoExemplo.exemploNovo** onde foi criado uma classe **TemplateComValor** que recebe no construtor um **Item** e implementa a formatação necessária para esse cliente.

Obs: Qualquer outra nova formatação pode ser implementada sem novas alterações em **GeradorObservacao**, como podemos ver em **ServicoExemplo.exemploComMudancaDoPrefixo** e **ServicoExemplo.exemploComMudancaNoDelimitador**.

Obs: A execução do código pode ser feito através do método **exercicio01.ServicoExemplo.main**

## Exercício 02

- Para eses exercício foi criado uma classe **ItemComposicao** que representa cada objeto do JSON, uma classe **FileUtils** com métodos necessários para leitura e transformação do JSON em objetos utilizando a lib [GSON](https://github.com/google/gson) e também a classe **CurrencyUtils** para auxilar a conversão de números em **String** para **BigDecimal** e vice-versa conforme as formatações necessárias.

- Foi desenvolvido uma classe chamada **ModeloCalculoComposicao** no qual irá receber uma lista de **ItemComposicao** atravez do método **calcular** retornando uma lista de **Composicao** com todos os insumos/composições necessárias, valor calculado, código e únidade, além do método **toString** com a formatação necessária para o output do console.

Obs: A execução do código  pode ser feito através do **método exercicio02.ServicoExemplo.main**

