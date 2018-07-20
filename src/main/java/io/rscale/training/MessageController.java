package io.rscale.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${message:This is the default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return "\n" + this.message + "\n\n";
    }
}
