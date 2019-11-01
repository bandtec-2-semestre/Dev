package slackLib;


public class Testando {
    
    public static void main(String[] args) {
        SlackMessage sl = new SlackMessage();
        
        String title = "Atenção seu HD está a caminho de sobrecarregar";
        String content = "Mensagem detalhada do erro que está acontecendo.";
        
        sl.sendMessage(title, content, SlackEmoji.EmojiDoubleAttention());
       // sl.sendMessage("Alerta seu sistema X está *OFFLINE*", "fancy", SlackEmoji.EmojiWarning());
       // sl.sendMessage("Atenção segundo seu histórico de uso a CPU do sistema X vai sobrecarregar esta semana", "fancy", SlackEmoji.EmojiDoubleAttention());
        
    }
    
}
