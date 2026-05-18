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

## 2. Fazendo o trabalho

Implemente os arquivos pedidos normalmente na sua IDE. Quando quiser enviar:

```bash
git add .
git commit -m "implementando Dog e TrainingLevel"
git push
```

Você pode fazer isso quantas vezes quiser. A cada push os testes rodam de novo.

---

## 3. Vendo o resultado dos testes

Depois do push, vá até o seu repositório no GitHub e clique em **Actions** no menu superior.

Você vai ver uma linha com o nome do seu commit. O ícone ao lado indica o resultado:

- Circulo amarelo — ainda está rodando, aguarde
- Check verde — todos os testes passaram
- X vermelho — algum teste falhou

Clique na linha para ver os detalhes.

---

## 4. Entendendo o que falhou

Dentro do Actions, clique em **grade** e depois em **Run tests**. Você vai ver a lista de todos os testes com o resultado de cada um. Por exemplo:

```text
✔ TrainingLevel deve ter as 4 constantes definidas
✔ Dog deve estender Animal
✘ Dog.makeSound() deve conter 'barks' na saída
✘ Dog.sleep() deve ser sobrescrito em Dog
```

Cada teste tem um nome descrevendo exatamente o que está sendo verificado. Se falhou, é porque aquele ponto ainda não foi implementado corretamente.

---

## 5. Corrigindo e reenviando

Corrija o que estiver faltando, salve, e faça um novo push:

```bash
git add .
git commit -m "corrigindo makeSound do Dog"
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
