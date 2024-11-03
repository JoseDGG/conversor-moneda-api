package com.jdgg.conversor.modelos;

import java.util.Map;

public record Monedas(Map<String, Double> conversion_rates) {
}
