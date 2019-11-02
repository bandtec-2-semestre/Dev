package slackLib;

import com.github.seratch.jslack.*;
import com.github.seratch.jslack.api.model.block.*;
import com.github.seratch.jslack.api.model.block.composition.*;
import com.github.seratch.jslack.api.model.block.element.*;
import com.github.seratch.jslack.api.webhook.*;
import java.util.Arrays;
import java.io.IOException;
import java.util.List;

public class SlackMessage {

    /*
     CLASSE UTILIZANDO BIBLIOTECA JSLACK - LINK PARA DOCUMENTAÇÃO ABAIXO
     https://github.com/seratch/jslack
    
     PARA QUE ESTA CLASSE FUNCIONA É NECESSÁRIO A URL DO WEBHOOK DESTE SLACKAPP
     COMO O SLACK IDENTIFICA QUE O LINK ESTÁ PUBLICO NO GIT E O DESATIVA 
     SEMPRE QUANDO FOR USAR/TESTAR ADICIONE O URL DO WEBHOOK
   */
    
    private String URL;
    private Slack slack;
    private Payload payload;
    private String message;
    private String title;
    private String buttonText;
    private WebhookResponse response;
    private String emoji;
   
    public SlackMessage(String webhookUrl) {
       this.URL = webhookUrl;
    }    
    
    private void simplePayload( ) {       
        payload = Payload.builder()
            .text(this.message)
            .build();
    }
   
    public List<LayoutBlock> blockPayload() {
        SectionBlock section = SectionBlock.builder()
            .text( 
                    MarkdownTextObject.builder().verbatim(Boolean.FALSE)
                            .text(this.message).build())
            .build();

        return Arrays.asList(section);
    }
   
    public List<LayoutBlock> blockTitlePayload() {
        SectionBlock sectionTitle = SectionBlock.builder()
                .text(MarkdownTextObject.builder().verbatim(Boolean.FALSE).text(this.title).build())
                .build();
        
        SectionBlock section = SectionBlock.builder()
                .text(MarkdownTextObject.builder().verbatim(Boolean.FALSE).text(this.message).build())
                .build();
        
        DividerBlock divider = DividerBlock.builder()
                .build();
        
        return Arrays.asList(divider, sectionTitle, divider, section);
    }

    public List<LayoutBlock> blockCompletePayload() {
        ButtonElement button = ButtonElement.builder()
            .text(PlainTextObject.builder().emoji(true).text(this.emoji).build())
            .build();
        
        
        SectionBlock section = SectionBlock.builder()
                .text(MarkdownTextObject.builder().verbatim(Boolean.FALSE).text(this.message).build())
                .build();

        LayoutBlock block = ActionsBlock.builder()
                .elements(Arrays.asList(button))
                .build();
        
        DividerBlock divider = DividerBlock.builder()
                .build();
        
       return Arrays.asList(section);
   }
   
         
   public void sendPayload(List<LayoutBlock> blocks) {
        payload = Payload.builder().blocks(blocks).build();
        slack = Slack.getInstance();

        try{
               response = slack.send(URL, payload);
              // response.code, response.message, response.body
        }
        catch (IOException e){
            e.printStackTrace();
        }
   }
   
    public void sendMessage(String message, String emoji) {
        this.message = emoji + "  " + message;
        
        sendPayload(blockPayload());
    }
    
    public void sendMessage(String title, String message, String emoji) {
        this.message = message;
        this.title = emoji + "  " + title + "  " + emoji;
        sendPayload(blockTitlePayload());
    }
    
     public void sendMessage(String title, String message, String buttonText, String emoji) {
        this.message = message;
        this.title = emoji + "  " + title;
        this.buttonText = buttonText;
        
        sendPayload(blockCompletePayload());
    }
}
