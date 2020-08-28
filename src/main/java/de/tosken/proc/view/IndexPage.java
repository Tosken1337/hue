package de.tosken.proc.view;

import de.tosken.proc.service.HueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "view")
public class IndexPage {

    private final HueService hueService;

    @Autowired
    public IndexPage(HueService hueService) {
        this.hueService = hueService;
    }

    public void onInit() {

    }

}
