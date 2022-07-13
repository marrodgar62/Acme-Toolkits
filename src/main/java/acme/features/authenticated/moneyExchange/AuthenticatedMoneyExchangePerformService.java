/*
 * AdministratorDashboardShowService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.moneyExchange;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.ExchangeService;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractPerformService;

@Service
public class AuthenticatedMoneyExchangePerformService implements AbstractPerformService<Authenticated, MoneyExchange> {

	// AbstractPerformService<Authenticated, ExchangeRecord> interface ---------


	@Autowired
	protected AuthenticatedMoneyExchangeRepository repository;
	
	@Autowired
	protected ExchangeService exchangeService;
	
	@Override
	public boolean authorise(final Request<MoneyExchange> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<MoneyExchange> request, final MoneyExchange entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "source", "targetCurrency", "target");
	}

	@Override
	public void unbind(final Request<MoneyExchange> request, final MoneyExchange entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "source", "targetCurrency", "target");
	}

	@Override
	public MoneyExchange instantiate(final Request<MoneyExchange> request) {
		assert request != null;

		MoneyExchange result;

		result = new MoneyExchange();

		return result;
	}

	@Override
	public void validate(final Request<MoneyExchange> request, final MoneyExchange entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		final SystemConfiguration systemConfiguration = this.repository.getSystemConfiguration();
		
	
		if(!errors.hasErrors("targetCurrency")) {
			final String[] s = systemConfiguration.getCurrencies().split(" ");
			errors.state(request,	Arrays.asList(s).contains(entity.targetCurrency), "targetCurrency", "authenticated.money-exchange.error");
		}
		
	}

	@Override
	public void perform(final Request<MoneyExchange> request, final MoneyExchange entity, final Errors errors) {
		assert request != null;
		assert entity != null;

		Money source;
		String targetCurrency;
		Money exchange;
		source = request.getModel().getAttribute("source", Money.class);
		targetCurrency = request.getModel().getAttribute("targetCurrency", String.class);
		exchange = this.exchangeService.exchangeMoneyToTarget(source, targetCurrency);
		errors.state(request, exchange != null, "*", "authenticated.money-exchange.form.label.api-error");
		entity.setTarget(exchange);
	}


}
