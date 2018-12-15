package com.uun.gobah.springbootmicroserviceforexservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ForexController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to){
        ExchangeValue exchangeValue = repository.findByFromAndTo(from,to);

        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }

    @PostMapping(value = "/currency-exchange/to-and-status")
    public List<ExchangeValue> toAndStatus(@RequestBody ExchangeValue exchangeValue){

        List<ExchangeValue> listExchangeValue = repository.findByToAndStatus(exchangeValue.getTo(),exchangeValue.getStatus());
        for (ExchangeValue e : listExchangeValue){
            e.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        }
        return listExchangeValue;
    }
}
