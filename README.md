# Jokenpô Pro Android ✊✋✌️

Um jogo completo de Pedra, Papel ou Tesoura desenvolvido em Java para Android. O projeto evoluiu de um protótipo simples contra a CPU para um simulador competitivo local com múltiplas funcionalidades.

---

## 🚀 Funcionalidades Atuais

### 👤 Modo Single Player
* Jogue contra o Android com escolha aleatória.
* Feedback instantâneo de vitória, derrota ou empate.

### 👥 Modo Multiplayer Local (Novo!)
* **Sistema de Turnos:** Lógica de alternância entre Player 1 e Player 2.
* **Interface Dinâmica:** A tela muda de cor conforme o jogador da vez (Azul para P1, Vermelho para P2).
* **Privacidade:** As jogadas são ocultas até que ambos os jogadores confirmem sua escolha.

### ⚙️ Customização e Ajustes
* **Definição de Nomes:** Personalize o nome dos competidores antes de iniciar.
* **Configuração de Partida:** Escolha jogar em 1, 3 ou 5 rodadas.
* **Placar em Tempo Real:** Acompanhamento de pontuação durante toda a partida.

---

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem:** Java (Android SDK).
* **Interface:** Layouts XML dinâmicos.
* **Navegação:** Transferência de dados entre Activities via `Intent.putExtra`.
* **UX (Experiência do Usuário):** * Uso de `AlertDialog` para exibição de resultados finais.
    * Uso de `Handler` para criar pausas dramáticas antes de mostrar o campeão.
    * Limpeza de pilha de navegação com `Intent Flags` para evitar loops de telas de setup.

---

## 📄 Como Jogar

1. No menu principal, escolha o modo de jogo.
2. Defina o número de rodadas e os nomes dos competidores.
3. No modo 2 jogadores, cada um faz sua escolha em segredo quando a tela exibir sua cor e nome.
4. Após o último round, o sistema exibirá o placar final e o grande vencedor.

---

## 📝 Licença
Este projeto foi desenvolvido para fins de estudo e aprendizado de desenvolvimento mobile Android.

---
*Desenvolvido com ☕ e código!*
