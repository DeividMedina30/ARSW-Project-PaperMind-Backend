package edu.eci.arsw.PaperMind.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

        @Controller
        public class STOMPMessagesHandler {
                @Autowired
                SimpMessagingTemplate msgt;

                @MessageMapping("/recargarBiblioteca")
                public void recargarBiblioteca() throws Exception {
                        System.out.println("Llegoooooooooooooooooooooooooooooooooooooooooooooooooooo al webSocket");

                        msgt.convertAndSend("/topic/recargarBiblioteca", "");
                }
        }
}