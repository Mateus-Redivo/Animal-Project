package enums;

/*
 * ATIVIDADE — Enum FurColor
 *
 * Crie o enum FurColor seguindo o mesmo modelo do enum TrainingLevel,
 * que foi criado para o cachorro.
 *
 * ------------------------------------------------------------
 * 1. CAMPOS
 *    Declare dois campos privados e finais:
 *      - code        (int)
 *      - displayName (String)
 *
 * ------------------------------------------------------------
 * 2. CONSTANTES
 *    Defina as 7 constantes abaixo, cada uma com seu código e
 *    nome de exibição correspondente:
 *
 *      BLACK        → código 1, nome "Black"
 *      WHITE        → código 2, nome "White"
 *      ORANGE_TABBY → código 3, nome "Orange Tabby"
 *      GRAY         → código 4, nome "Gray"
 *      BROWN        → código 5, nome "Brown"
 *      CALICO       → código 6, nome "Calico"
 *      SPOTTED      → código 7, nome "Spotted"
 *
 * ------------------------------------------------------------
 * 3. CONSTRUTOR
 *    Crie o construtor do enum recebendo (int code, String displayName)
 *    e atribua os valores aos campos correspondentes.
 *
 * ------------------------------------------------------------
 * 4. GETTERS
 *    Implemente:
 *      - getCode()        → retorna o campo code
 *      - getDisplayName() → retorna o campo displayName
 *
 * ------------------------------------------------------------
 * 5. MÉTODO ESTÁTICO fromCode
 *    Implemente o método estático fromCode(int code) que:
 *      - Percorre todas as constantes do enum com um for
 *      - Retorna a constante cujo code seja igual ao parâmetro
 *      - Lança IllegalArgumentException se nenhuma for encontrada
 *        (mensagem sugerida: "Invalid FurColor: " + code)
 */

public enum FurColor {

}
