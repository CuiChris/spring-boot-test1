package chris.spring.test1.service;

import chris.spring.test1.model.Guy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GuyService {
    private Map<String, Guy> guys = new HashMap<>();
    public GuyService() {
        this.guys.put("Tom", new Guy("Tom", 25));
        this.guys.put("Jerry", new Guy("Jerry", 27));
    }

    public List<Guy> getAll() {
        return new ArrayList<>(guys.values());
    }

    public Guy get(String name) {
        return guys.get(name);
    }

    public Guy getExact(Guy guy) {
        Guy result = guys.get(guy.getName());
        return result.getAge() == guy.getAge() ? result : null;
    }

    public Guy upsert(Guy guy) {
        guys.put(guy.getName(), guy);
        return guys.get(guy.getName());
    }

    public List<Guy> remove(String name) {
        if (guys.containsKey(name)) {
            guys.remove(name);
        }
        return getAll();
    }


}

