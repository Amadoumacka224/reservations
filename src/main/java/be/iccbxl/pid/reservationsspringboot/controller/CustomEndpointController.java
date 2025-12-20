package be.iccbxl.pid.reservationsspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.stream.Collectors;

@Controller
public class CustomEndpointController {

    @Qualifier("requestMappingHandlerMapping")
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @GetMapping("/endpoints")
    @ResponseBody
    public String listCustomEndpoints() {
        // Filtre pour afficher uniquement vos endpoints custom
        return handlerMapping.getHandlerMethods().entrySet().stream()
                .filter(entry -> entry.getValue().getBeanType().getPackageName().startsWith(" be.iccbxl.pid.reservationsspringboot.controller"))
                .map(entry -> entry.getKey().toString())
                .collect(Collectors.joining("\n"));
    }
}
