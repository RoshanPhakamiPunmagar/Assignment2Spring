package com.Assignment2Spring.utils.helper;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Slf4j
public class SessionHelper {
    //this method is used to handle messages show to users and remove message when refresh the page.
    public static void removeMessage(){
        try{
            log.info("[SessionHelper][removeMessage] remove message from session");
            HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            session.removeAttribute("message");
        }catch (Exception e){
            log.error("[SessionHelper][removeMessage] Error in session helper: "+e);
            e.printStackTrace();
        }
    }
}
