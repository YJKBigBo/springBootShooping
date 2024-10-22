package springbootmvcshopping.service;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;

@Service
public class SMSMessageService {

    final DefaultMessageService messageService;
    public SMSMessageService() {
        this.messageService = NurigoApp.INSTANCE.initialize(
                "NCSS1WJQZAXJTOU3"
                ,"WN5E66CV7FMOEVUA52T0H0UQUZU0VQOY"
                ,"http://api.coolsms.co.kr");

    }
    public void smsSend(String _to,String _content) {
        Message msg = new Message();
        msg.setTo(_to);
        msg.setFrom("01071461970");
        msg.setText(_content);

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(msg));
        System.out.println(response);
    }
}
