package br.com.alura.coinconverter.record;

import java.util.Map;

public record ExchangeRates(Map<String, Double> conversion_rates) {}
