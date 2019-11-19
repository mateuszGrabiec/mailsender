package net.usermd.grabiecm.mailsender;

import net.usermd.grabiecm.mailsender.model.CatFact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    private ApiService apiService;

    @Autowired
    public MailServiceImpl(ApiService apiService) {
        this.apiService=apiService;
    }

    @Override
    public String getContent() {
        CatFact catFact= apiService.getCatFact();
        return catFact.getText();
    }

    @Override
    public String getTopic() {
        CatFact catFact= apiService.getCatFact();
        return catFact.getType();
    }
}
