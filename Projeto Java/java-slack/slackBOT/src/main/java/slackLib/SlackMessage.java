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

    // CLASSE UTILIZANDO BIBLIOTECA JSLACK - LINK PARA DOCUMENTAÇÃO ABAIXO
    // https://github.com/seratch/jslack
    
    // LINK CRIADO PELO SLACK AO CRIAR UM "SLACK APP"
   private final String URL = "https://hooks.slack.com/services/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";
   private Slack slack;
   private Payload payload;
   private String message;
   private String title;
   private String buttonText;
   private WebhookResponse response;
   private String emoji;
   
   private void simplePayload( ) {
           
        payload = Payload.builder()
            .text(this.message)
            .build();
   }
   
   public void blockPayload() {
        SectionBlock section = SectionBlock.builder()
                .text(MarkdownTextObject.builder().verbatim(Boolean.FALSE).text(this.message).build())
                .build();

        List<LayoutBlock> blocks = Arrays.asList(section);

        payload = Payload.builder().blocks(blocks).build();
   }
   
    public void blockTitlePayload() {
        SectionBlock sectionTitle = SectionBlock.builder()
                .text(MarkdownTextObject.builder().verbatim(Boolean.FALSE).text(this.title).build())
                .build();
        
        SectionBlock section = SectionBlock.builder()
                .text(MarkdownTextObject.builder().verbatim(Boolean.FALSE).text(this.message).build())
                .build();
        
        DividerBlock divider = DividerBlock.builder()
                .build();
        
        List<LayoutBlock> blocks = Arrays.asList(divider, sectionTitle, divider, section);

        payload = Payload.builder().blocks(blocks).build();


   }

      public void blockCompletePayload() {
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
        
        // List<LayoutBlock> blocks = Arrays.asList(block, section);
         List<LayoutBlock> blocks = Arrays.asList(section);

        payload = Payload.builder().blocks(blocks).build();


   }
   
    public void sendMessage(String message, String emoji) {
        this.message = emoji + "  " + message;
        
        blockPayload();
        sendPayload();
    }
    
    public void sendMessage(String title, String message, String emoji) {
        this.message = message;
        this.title = emoji + "  " + title + "  " + emoji;
        
        blockTitlePayload();
        sendPayload();
    }
    
     public void sendMessage(String title, String message, String buttonText, String emoji) {
        this.message = message;
        this.title = emoji + "  " + title;
        this.buttonText = buttonText;
        
        blockCompletePayload();
        sendPayload();
    }
    
//    public void sendMessage(String message, String emoji) {
//        this.message = message;
//        this.emoji = emoji;
//        if(typeOfMessage.equalsIgnoreCase("fancy")) {
//             this.message = emoji + "  " + message;
//             blockPayload();
//        } else {
//            simplePayload();
//        }
//       
//        sendPayload();
//   }
   
   public void sendPayload() {

        slack = Slack.getInstance();

        try{
               response = slack.send(URL, payload);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        // response.code, response.message, response.body
 
   }
   
}
