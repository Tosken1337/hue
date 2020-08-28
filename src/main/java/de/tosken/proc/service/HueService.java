package de.tosken.proc.service;

import io.github.zeroone3010.yahueapi.Hue;
import io.github.zeroone3010.yahueapi.Room;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HueService {
    @Value("${hue.bridgeIp:null}")
    private String bridgeIp;

    @Value("${hue.user:anonymous}")
    private String user;

    public Hue connect() {
        return new Hue(bridgeIp, user);
    }

    public void getLights() {
        final Hue hue = new Hue(bridgeIp, user);
        for (Room room : hue.getRooms()) {
            System.out.println(room);
        }
    }
}

