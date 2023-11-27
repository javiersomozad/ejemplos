package es.anaya.spring.basic.s01.advancedqualifiers;

import org.springframework.stereotype.Component;

@Component
public class ImportantCustomer implements Customer {

    @Override
    public String profile() {
        return "ImportantCustomer";
    }

	@Override
	public Double discount() {
		return 0.20d;
	}
}
