# Como funciona a correção automática do trabalho

Quando você faz um push com o seu código, o GitHub roda os testes automaticamente e mostra se cada parte está certa ou errada. Você não precisa configurar nada — só precisa saber como ver o resultado.

---

## 1. Aceitando o trabalho

Você vai receber um link do professor. Ao abrir o link e clicar em **Accept this assignment**, o GitHub vai criar um repositório só seu com o código inicial do projeto.

Clone esse repositório na sua máquina:

```bash
git clone https://github.com/nome-da-turma/animal-project-seuusuario
```

---

## 2. O que você precisa implementar

Esta atividade tem dois arquivos para completar:

**`enums/FurColor.java`** — o enum de cor de pelo do gato, seguindo o mesmo modelo do `TrainingLevel` que foi feito para o cachorro.

**`model/Cat.java`** — a classe do gato, seguindo o mesmo modelo da classe `Dog` que já está pronta para você estudar.

Leia os comentários dentro de cada arquivo — eles explicam exatamente o que criar.

---

## 3. Enviando o trabalho

Quando quiser enviar, execute no terminal dentro da pasta do projeto:

```bash
git add .
git commit -m "implementando Cat e FurColor"
git push
```

Você pode fazer isso quantas vezes quiser. A cada push os testes rodam de novo.

---

## 4. Vendo o resultado dos testes

Depois do push, vá até o seu repositório no GitHub e clique em **Actions** no menu superior.

Você vai ver uma linha com o nome do seu commit. O ícone ao lado indica o resultado:

- Círculo amarelo — ainda está rodando, aguarde
- Check verde — todos os testes passaram
- X vermelho — algum teste falhou

Clique na linha para ver os detalhes.

---

## 5. Entendendo o que falhou

Dentro do Actions, clique em **grade** e depois em **Run tests**. Você vai ver a lista de todos os testes com o resultado de cada um. Por exemplo:

```text
✔ FurColor deve ter as 7 constantes definidas
✔ FurColor.getDisplayName() deve retornar o nome correto para cada constante
✔ Cat deve estender Animal
✘ Cat.makeSound() deve conter 'Meow' na saída
✘ Cat.sleep() deve ser sobrescrito em Cat
```

Cada teste tem um nome descrevendo exatamente o que está sendo verificado. Se falhou, é porque aquele ponto ainda não foi implementado corretamente.

---

## 6. Ordem sugerida para implementar

Implemente nessa ordem para evitar que testes dependentes falhem por motivos errados:

1. Complete o enum `FurColor` (constantes, campos, construtor, getters, `fromCode`)
2. Depois implemente a classe `Cat` (herança, construtor, overrides, sobrecargas, métodos extras)

Os testes de Cat que criam instâncias dependem do `FurColor` estar implementado. Se o `FurColor` estiver vazio, esses testes vão indicar isso com uma mensagem clara.

---

## 7. Corrigindo e reenviando

Corrija o que estiver faltando, salve, e faça um novo push:

```bash
git add .
git commit -m "corrigindo makeSound do Cat"
git push
```

Os testes vão rodar de novo automaticamente.

---

## Dúvidas frequentes

**Posso fazer push várias vezes?**
Sim, sem problema. Cada push roda os testes do zero.

**O teste passou mas meu código está errado?**
Os testes verificam os pontos principais, mas não cobrem tudo. Revise o seu código mesmo que os testes estejam verdes.

**O teste está falhando mas eu acho que implementei certo.**
Releia o nome do teste com atenção — ele descreve exatamente o que é esperado. Verifique o nome do método, os parâmetros e o que está sendo impresso.

**Não consigo fazer push.**
Verifique se você clonou o repositório certo — o que foi criado para você pelo Classroom, não o repositório original do professor.
